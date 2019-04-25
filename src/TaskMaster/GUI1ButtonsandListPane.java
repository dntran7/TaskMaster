package TaskMaster;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.Event;
import javafx.event.EventHandler;	//**Need to import to handle event

import java.awt.Panel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.time.temporal.ChronoUnit;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class GUI1ButtonsandListPane extends HBox{
	private ArrayList<Task> taskList;
	private static ArrayList<Task> completedTasks = new ArrayList<Task>();
	private static ArrayList<Task> deletedTasks = new ArrayList<Task>();
	public static ObservableList<Task> displayedList;
	String taskLog = "";
	public static ListView<Task> listView;
	private Button Add;
	private Button Delete;
	private Button Change;
	private Button Complete;
	public ArrayList<Task> getTaskList()
	{
		return taskList;
	}
	public ArrayList<Task> getCompletedTaskList()
	{
		return completedTasks;
	}

	public GUI1ButtonsandListPane(ArrayList<Task> list,Stage stage, Scene scene)
	{
		this.taskList = list;
		VBox buttonlist = new VBox();
		Add = new Button("Add");
		Delete = new Button("Delete");
		Change = new Button("Change");
		Complete = new Button("Complete");

		Add.setPrefWidth(400);
		Delete.setPrefWidth(400);
		Change.setPrefWidth(400);
		Complete.setPrefWidth(400);

		Add.setPrefHeight(100);
		Delete.setPrefHeight(100);
		Change.setPrefHeight(100);
		Complete.setPrefHeight(100);

		addFunct(Add,stage,scene);
		Delete.setOnAction(new deleteButton());

		Complete.setOnAction(new completeButton());

		editFunct(Change, stage, scene);
		
		Pane addPane = new Pane();
		buttonlist.setPrefWidth(400);
		addPane.getChildren().add(Add);

		Pane deletePane = new Pane();
		deletePane.getChildren().add(Delete);

		Pane changePane = new Pane();
		changePane.getChildren().add(Change);

		Pane completePane = new Pane();
		completePane.getChildren().add(Complete);
		
		
		buttonlist.getChildren().addAll(addPane,deletePane,changePane,completePane);
		taskList.add(new Task( "test", 1, 23, 23, 1999,0,0,0, "sd"));
		taskList.add(new Task( "aest", 2, 22, 23, 1992,0,0,0, "sd"));
		//log.add(new Task( "test", 1, 23, 23, 1999,0,0,0, "sd"));
		displayedList = FXCollections.observableList(taskList);
		listView = new ListView<Task> (displayedList);
		listView.setPrefWidth(400);
		
		this.getChildren().addAll(buttonlist,listView);
	
	
	}
	
	
	public void editFunct(Button button, Stage stage, Scene scene1) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
					int index = (listView.getSelectionModel().getSelectedIndex());
					if(index>=0)
					{
						//sortTaskList(1);
					AddWindow addW = new AddWindow(taskList, stage, scene1, index);
					}
					else {
						
					}
			}
		});
	}
	 private class deleteButton implements EventHandler<ActionEvent> 
		{	
		//Missing Listeners

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
					int index = (listView.getSelectionModel().getSelectedIndex());
					if(index>=0)
					{
						Task copy = listView.getItems().get(index);
						deletedTasks.add(copy);
						listView.getItems().remove(index);
						taskList.remove(index);
						//System.out.println(taskList);
						//System.out.println(deletedTasks);
						taskLog = taskLog + "Deleted:\n"+copy.toString() +"\n\n\n";
					}
		}
		}

 private class completeButton implements EventHandler<ActionEvent> 
	{	
	//Missing Listeners

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
				int index = (listView.getSelectionModel().getSelectedIndex());
				if(index>=0)
				{	listView.getItems().get(index).setStatus("Completed");
				Date date = new Date();
				LocalDate cal = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int eyear = cal.getYear();
				int emonth = cal.getMonthValue();
				int eday = cal.getDayOfMonth();
					listView.getItems().get(index).setenDay(eday);
					listView.getItems().get(index).setenMonth(emonth);
					listView.getItems().get(index).setenYear(eyear);
				//get completed dates
					taskList.get(index).setStatus("Completed");
					Task copy = listView.getItems().get(index);
					listView.getItems().remove(index);
					//log.add(index,copy);

					taskList.get(index).setenDay(eday);
					taskList.get(index).setenMonth(emonth);
					taskList.get(index).setenYear(eyear);
					taskList.remove(index);

					completedTasks.add(copy);
					taskLog = taskLog + "Completed:\n"+copy.toString() +"\n\n\n";
				}

	}
	}
 


 
 public void addFunct(Button button, Stage stage, Scene scene1) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//sortTaskList(1);
				AddWindow addW = new AddWindow(taskList, stage, scene1, -1);
				stage.setScene(addW.getScene());
				//displayedList.add(addW.getNewList().get(2));
			}
		});
	}
 public void setTaskList(ArrayList<Task> newList) {
	 displayedList = FXCollections.observableList(newList);
    /* listView = new ListView<Task> (displayedList);
     listView.refresh();
     listView.setFocusTraversable(true);*/
 }
 
 
 /***
  * @param sortChoice
  * sorts tasklist
  * sortchoice can be: 1, 2, 3, 4, 5
  * corresponding with priority,description,status,start date,end date
  */
 public void sortTaskList(int sortChoice)
 {
	 sortingList tool;
	 switch (sortChoice) {
		 case 1:
			 tool = new sortingList(taskList,1);
			 taskList = tool.returnSortedList();
			 displayedList = FXCollections.observableList(taskList);
			 listView.setItems(displayedList);
			 break;
		 case 2:
			 tool = new sortingList(taskList,2);
			 taskList = tool.returnSortedList();
		     displayedList= FXCollections.observableList(taskList);
			
			 break;
		 case 3:
			 tool = new sortingList(taskList,3);
			 taskList = tool.returnSortedList();
			 displayedList = FXCollections.observableList(taskList);
			 listView.setItems(displayedList);
			 break;
		 case 4:
			 tool = new sortingList(taskList,4);
			 taskList = tool.returnSortedList();
			 displayedList = FXCollections.observableList(taskList);
			 listView.setItems(displayedList);
			 break;
		 case 5:
			 tool = new sortingList(taskList,5);
			 taskList = tool.returnSortedList();
			 displayedList = FXCollections.observableList(taskList);
			 listView.setItems(displayedList);
			 break;
	 }
	 setTaskList(taskList);
	 listView.setItems(displayedList);
  
 }
 
		
}