package TaskMaster;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.Event;
import javafx.event.EventHandler;	//**Need to import to handle event

import java.awt.Panel;
import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class GUI1ButtonsandListPane extends HBox{
	private ArrayList<Task> taskList;
	private ListView<Task> listView;
	private Button Add;
	private Button Delete;
	private Button Change;
	private Button Complete;
	public GUI1ButtonsandListPane(ArrayList<Task> list)
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
		
		Delete.setOnAction(new deleteButton());
		
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
		ObservableList<Task> aList = FXCollections.observableArrayList(taskList);
		listView = new ListView<Task> (aList);
		listView.setPrefWidth(400);
		this.getChildren().addAll(buttonlist,listView);
	
	}
 private class deleteButton implements EventHandler<ActionEvent> 
	{	
	//Missing Listeners

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
				int index = (listView.getSelectionModel().getSelectedIndex());
				if(index>=0)
				{listView.getItems().remove(index);
				taskList.remove(index);
				}
	}
	}
		
}
