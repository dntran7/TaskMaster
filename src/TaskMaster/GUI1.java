package TaskMaster;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import javafx.geometry.Pos;

public class GUI1 extends BorderPane{
	private ArrayList<Task> taskList;
	private ListView<Task> listView;
	private GUI1ButtonsandListPane a;
	public GUI1(ArrayList<Task> list)
	{
		this.taskList = list;
		a = new GUI1ButtonsandListPane(list);
		this.setCenter(a);
		this.setTop(new Label("hey"));
	}
	
	//Missing Listeners
}
