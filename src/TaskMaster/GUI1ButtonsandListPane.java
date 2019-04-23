package TaskMaster;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Date;
import java.time.temporal.ChronoUnit;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class GUI1ButtonsandListPane extends HBox{
	private ArrayList<Task> taskList;
	private ArrayList<Task> log;
	private ListView<Task> listView;
	private Button Add;
	private Button Delete;
	private Button Change;
	private Button Complete;
	public GUI1ButtonsandListPane(ArrayList<Task> list,Stage stage, Scene scene)
	{
		this.taskList = list;
		this.log = taskList;
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

		Change.setOnAction(new editButton());
		
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
		//log.add(new Task( "test", 1, 23, 23, 1999,0,0,0, "sd"));
		ObservableList<Task> aList = FXCollections.observableArrayList(taskList);
		listView = new ListView<Task> (aList);
		listView.setPrefWidth(400);
		this.getChildren().addAll(buttonlist,listView);
	
	}
	
	
	 private class editButton implements EventHandler<ActionEvent> 
		{	
		//Missing Listeners

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
					int index = (listView.getSelectionModel().getSelectedIndex());
					if(index>=0)
					{
					}
		}
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
					listView.getItems().remove(index);
					//taskList.remove(index);
					System.out.println(taskList);
					//log.add(index,copy);
					//log.get(index).setStatus("Deleted");
					/*System.out.println(log);
					System.out.println(taskList);
					System.out.println(listView.getItems());*/
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
					Task copy = listView.getItems().get(index);
					listView.getItems().remove(index);
					taskList.get(index).setStatus("Completed");
					//log.add(index,copy);

					taskList.get(index).setenDay(eday);
					taskList.get(index).setenMonth(emonth);
					taskList.get(index).setenYear(eyear);
					System.out.println(taskList);
				}
	}
	}
 

 
 
 public void addFunct(Button button, Stage stage, Scene scene1) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				AddWindow addW = new AddWindow(taskList, stage, scene1);
			}
		});
	}
 
 
 
		
}
