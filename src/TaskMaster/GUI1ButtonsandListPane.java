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

import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;

import java.time.temporal.ChronoUnit;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class GUI1ButtonsandListPane extends HBox{
	private ArrayList<Task> taskList;
	private ArrayList<Task> completedTasks;
	public static ArrayList<Task> deletedTasks = new ArrayList<Task>();
	public static ObservableList<Task> displayedList;
	String taskLog = "";
	public static ListView<Task> listView;
	private Button Add;
	private Button Delete;
	private Button Change;
	private Button Complete;
	public ArrayList<Task> getTaskList()
	{
		return this.taskList;
	}
	public ArrayList<Task> getCompletedTaskList()
	{
		return this.completedTasks;
	}

	public GUI1ButtonsandListPane(ArrayList<Task> list,ArrayList<Task> completed, Stage stage, Scene scene)
	{
		this.taskList = list;
		this.completedTasks = completed;
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
		taskList.add(new Task( "aest", 3, 22, 23, 1992,0,0,0, "sd"));
		//log.add(new Task( "test", 1, 23, 23, 1999,0,0,0, "sd"));
		displayedList = FXCollections.observableArrayList(taskList);
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
				{	
					Task temp = listView.getItems().get(index);
					listView.getItems().get(index).setStatus("Completed");
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
					
					taskList.get(index).setenDay(eday);
					taskList.get(index).setenMonth(emonth);
					taskList.get(index).setenYear(eyear);
					
					Task complete = new Task();
					complete.setDescription(temp.getDescription());
					complete.setenDay(temp.getenDate());
					complete.setstDay(temp.getstDate());
					complete.setenMonth(temp.getenMonth());
					complete.setstMonth(temp.getstMonth());
					complete.setenYear(temp.getenYear());
					complete.setstYear(temp.getstYear());
					complete.setPriority(temp.getPriority());
					complete.setStatus(temp.getStatus());
					taskList.remove(index);
					
					
					
					completedTasks.add(complete);
					taskLog = taskLog + "Completed:\n"+copy.toString() +"\n\n\n";
				}

	}
	}
 


 
 public void addFunct(Button button, Stage stage, Scene scene1) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				AddWindow addW = new AddWindow(taskList, stage, scene1, -1);
				stage.setScene(addW.getScene());
				//displayedList.add(addW.getNewList().get(2));
			}
		});
	}
 public void setTaskList(ArrayList<Task> newList) {
	 displayedList = FXCollections.observableArrayList(newList);
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
			 displayedList = FXCollections.observableArrayList(taskList);
			 listView.setItems(displayedList);
			 break;
		 case 2:
			 tool = new sortingList(taskList,2);
			 taskList = tool.returnSortedList();
			 displayedList = FXCollections.observableArrayList(taskList);
			 listView.setItems(displayedList);
			 break;
		 case 3:
			 tool = new sortingList(taskList,3);
			 taskList = tool.returnSortedList();
			 displayedList = FXCollections.observableArrayList(taskList);
			 listView.setItems(displayedList);
			 break;
		 case 4:
			 tool = new sortingList(taskList,4);
			 taskList = tool.returnSortedList();
			 displayedList = FXCollections.observableArrayList(taskList);
			 break;
		 case 5:
			 tool = new sortingList(taskList,5);
			 taskList = tool.returnSortedList();
			 displayedList = FXCollections.observableArrayList(taskList);
			 listView.setItems(displayedList);
			 break;
	 }
	 setTaskList(taskList);
  
 }
 
		
}