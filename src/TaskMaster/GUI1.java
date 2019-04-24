package TaskMaster;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class GUI1 extends BorderPane{
	private ArrayList<Task> taskList;
	private ListView<Task> listView;
	private GUI1ButtonsandListPane a;
	final ComboBox<String> priorityComboBox;
	private Button print;
	private Button export;
	private Label error;
	private TextField b;
	Stage st;
	Scene sc;
	public GUI1(ArrayList<Task> list,Stage stage, Scene scene)
	{
		this.taskList = list;
		a = new GUI1ButtonsandListPane(taskList,stage,scene);
		this.setCenter(a);
		
		//Top part of the GUI
		
		BorderPane top = new BorderPane();
		
		
		Button m = new Button("Import: ");
		m.setOnAction(new importButton());
		
		b = new TextField();
		TilePane mb = new TilePane(2,1);
		
		/*MenuItem m1 = new MenuItem("New");
		MenuItem m2 = new MenuItem("Import"); 
		
		m.getItems().add(m1);
		m.getItems().add(m2);
		MenuBar mb = new MenuBar();
		mb.getMenus().add(m);*/
		
		mb.getChildren().addAll(b);
		top.setPadding(new Insets(10));
		top.setLeft(m);
		top.setCenter(mb);
		
		
		//mb.setOnAction(value);
		
		priorityComboBox = new ComboBox();
        priorityComboBox.getItems().addAll(
    		  "Display by: Priority",
		       "Display by: Description",
		       "Display by: Status",
		       "Display by: Start Date",
		       "Display by: End Date"
        
        );   
        
		priorityComboBox.setOnAction(new sortComboBox());//connect lsitener so that you can sort the list

		top.setRight(priorityComboBox);
		
		this.setTop(top);
		
		export = new Button("Export Save File");
		export.setOnAction(new exportButton());
		//Bottom part of the GUI
		print = new Button("Print Report");
		
		
		print.setOnAction((e)->
		{
			ExportGUI export = new ExportGUI();
			export.ExportGUI(a.getTaskList(),a.getCompletedTaskList(), stage, scene);
		});
		
		
		error = new Label();
		
		error.setText("Error message is here");
		error.setTextFill(Color.RED);

		TilePane temp = new TilePane();
		temp.getChildren().addAll(export,print);
		BorderPane bottom = new BorderPane();
		bottom.setPadding(new Insets(15));
		bottom.setRight(temp);
		bottom.setLeft(error);
		
		
		this.setBottom(bottom);
		
	
		
		
		
		
		
		
		
		  
	}
	private class sortComboBox implements EventHandler<ActionEvent> 
	{
		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String result = priorityComboBox.getValue();
			if(result.equals("Display by: Priority" ))
			{
				a.sortTaskList(1);
			}
			else if(result.equals("Display by: Description" ))
			{
				a.sortTaskList(2);
			}
			else if(result.equals("Display by: Status" ))
			{
				a.sortTaskList(3);
			}
			else if(result.equals("Display by: Start Date" ))
			{
				a.sortTaskList(4);
			}
			else if(result.equals("Display by: End Date" ))
			{
				a.sortTaskList(5);
			}
			a.setFocusTraversable(false);
	}
	}
	//Missing Listeners

	
	/*** This will read in a saved data file
	 * first line is an int - number of tasks
	 * next lines are each tasks (each task's line is in this order: desc, priority, status, start date (each line is month, day year)
	 * , end date 
	 * ***/
	 private class importButton implements EventHandler<ActionEvent> 
		{	
		//Missing Listeners

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			String filename = b.getText();
			if(filename!="")
			{
				ArrayList<Task> loaded = new ArrayList<Task>();
				try {
					File file = new File(filename+".txt");
					BufferedReader br = new BufferedReader(new FileReader(file));  
					 int numberofTasks = Integer.parseInt(br.readLine());
					 for(int i = 0; i<numberofTasks;i++)
					 {
						 String desc = br.readLine();
						 int prior = Integer.parseInt(br.readLine());
						 String status = br.readLine();
						 int stMonth = Integer.parseInt(br.readLine());
						 int stDay = Integer.parseInt(br.readLine());
						 int stYear = Integer.parseInt(br.readLine());

						 int enMonth = Integer.parseInt(br.readLine());
						 int enDay = Integer.parseInt(br.readLine());
						 int enYear = Integer.parseInt(br.readLine());
						 Task newTask = new Task(desc,prior,stMonth,stDay,stYear,enMonth,enDay,enYear, status);
						 loaded.add(newTask);
						 
					 }
					 if(loaded!=null)
					 {
						 taskList = loaded;
						 a = new GUI1ButtonsandListPane(taskList,st,sc);
					 }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					error.setText("Cannot find file with that name!");
					
				}
				
			}
					
		}
		}
	 private class exportButton implements EventHandler<ActionEvent> 
		{	
		//Missing Listeners

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			TextInputDialog dialog = new TextInputDialog("Export Save File");
			dialog.setTitle("Export Save File");
			dialog.setHeaderText("Enter name of save file:");
			dialog.setContentText("Name:");
			 
			Optional<String> result = dialog.showAndWait();
			System.out.println(result.get());
			ArrayList<Task> savingList = a.getTaskList();
			String savingString =savingList.size()+"\n";
			for(int i =0;i<savingList.size();i++)
			{
				savingString = savingString+savingList.get(i).getDescription()+"\n";
				savingString = savingString+savingList.get(i).getPriority()+"\n";
				savingString = savingString+savingList.get(i).getStatus()+"\n";
				savingString = savingString+savingList.get(i).getstMonth()+"\n";
				savingString = savingString+savingList.get(i).getstDay()+"\n";
				savingString = savingString+savingList.get(i).getstYear()+"\n";
				savingString = savingString+savingList.get(i).getenMonth()+"\n";
				savingString = savingString+savingList.get(i).getenDay()+"\n";
				savingString = savingString+savingList.get(i).getenYear()+"\n";
			}
			try {

	    		File tempFile = new File(result.get()+".txt" );
	    		if(!tempFile.exists())
	    		{
				FileWriter writer = new FileWriter(result.get()+".txt", true);
				
					BufferedWriter bufferWritter = new BufferedWriter(writer);
					bufferWritter.write(savingString);
					bufferWritter.close();
					Alert alert = new Alert(AlertType.CONFIRMATION,"Your export file was successfully saved.");
		    		alert.showAndWait();
	    		}
	    		else
	    		{
	    			Alert alert = new Alert(AlertType.ERROR,"There was an issue saving your file.Please try again with a different name");
		    		alert.showAndWait();
	    		}

	    	}
	    	catch (IOException ex) {
	    		Alert alert = new Alert(AlertType.ERROR,"There was an issue saving your file.Please try again with a different name");
	    		alert.showAndWait();
			}
				
			}
					
		}

}
