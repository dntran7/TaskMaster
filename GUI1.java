package TaskMaster;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;


import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;


public class GUI1 extends BorderPane{
	private ArrayList<Task> taskList;
	private ListView<Task> listView;
	private GUI1ButtonsandListPane a;
	public GUI1(ArrayList<Task> list,Stage stage, Scene scene1)
	{
		this.taskList = list;
		a = new GUI1ButtonsandListPane(list, stage, scene1);
		this.setCenter(a);
		//Top part of the GUI
		
		BorderPane top = new BorderPane();

		
		Menu m = new Menu("File");
		MenuItem m1 = new MenuItem("New");
		MenuItem m2 = new MenuItem("Import");
		
		m.getItems().add(m1);
		m.getItems().add(m2);
		MenuBar mb = new MenuBar();
		mb.getMenus().add(m);
		
		
		top.setPadding(new Insets(10));
		top.setLeft(mb);
		
		
		final ComboBox<String> priorityComboBox = new ComboBox();
        priorityComboBox.getItems().addAll(
    		  "Not-Started",
		        "In-Progress",
		        "Finished"
        
        );   
		top.setRight(priorityComboBox);
		
		this.setTop(top);
		
		
		//Bottom part of the GUI
		Button print = new Button("print");
		print.setOnAction((e)->
		{
			ExportGUI export = new ExportGUI();
			export.ExportGUI(list, stage, scene1);
		});
		
		Label error = new Label();
		
		error.setText("Error message is here");
		error.setTextFill(Color.RED);

		BorderPane bottom = new BorderPane();
		bottom.setPadding(new Insets(15));
		bottom.setRight(print);
		bottom.setLeft(error);
		
		
		this.setBottom(bottom);
	}
	
	//Missing Listeners
}