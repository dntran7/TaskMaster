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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event
import javafx.geometry.Insets;
import javafx.geometry.Pos;


/*
 * Main holds the functionality of the main homepage of the gui
 */
public class GUI1 extends BorderPane{
	private ArrayList<Task> taskList;
	private ArrayList<Task> completedList;
	private ListView<Task> listView;
	private GUI1ButtonsandListPane a;
	final ComboBox<String> priorityComboBox;
	private Button print;
	private Button export;
	private Label error;
	private TextField b;
	Stage st;
	Scene sc;
	
	
	
/*
 * save file function
 */
  private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = null;
             
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            
        }
         
  }
	
	/*
	 * Main function for GUI1
	 */
	public GUI1(ArrayList<Task> list,ArrayList<Task> completedList, Stage stage, Scene scene)
	{
		this.taskList = list;
		this.completedList = completedList;
		error = new Label();
		
		//error gui, label that labels if there is an error that a user has done
		error.setText("");
		error.setTextFill(Color.RED);
		a = new GUI1ButtonsandListPane(this.taskList,this.completedList,stage,scene);
		this.setCenter(a);
		
		//Top part of the GUI
		BorderPane top = new BorderPane();
		HBox v = new HBox();
		
		Button m = new Button("Import");
		m.setOnAction(new importButton());
		
		Button newButton = new Button("New");
		
		//new button listener, creates new instnaces for the list
		newButton.setOnAction((e)->
		{
			this.taskList = new ArrayList<Task>();
			this.completedList = new ArrayList<Task>();
			a.setDeletedList(new ArrayList<Task>());
			GUI1ButtonsandListPane.displayedList = FXCollections.observableList(taskList);
			GUI1ButtonsandListPane.listView.setFocusTraversable(true);
			GUI1ButtonsandListPane.listView.refresh();
			GUI1ButtonsandListPane.listView.setItems(GUI1ButtonsandListPane.displayedList);
			
			
		});
		v.getChildren().addAll(newButton,m);
		top.setLeft(v);
		
		
		//priority gui for drop down box
		priorityComboBox = new ComboBox();
        priorityComboBox.getItems().addAll(
    		  "Display by: Priority",
		       "Display by: Description",
		       "Display by: Status",
		       "Display by: Start Date",
		       "Display by: End Date"
        
        );   
        
		priorityComboBox.setOnAction(new sortComboBox());//connect lsitener so that you can sort the list
		priorityComboBox.setValue("Display by: Priority");
		top.setRight(priorityComboBox);
		
		this.setTop(top);
		
		
		//Bottom part of the GUI
		
		//export save listener and gui
		//be able to save the file of the current list
		export = new Button("Export Save File");
		export.setOnAction((e)->
		{
			
			
			//gets total task
			 int numberofTasks = taskList.size();
			 
			 String result = numberofTasks + "\r\n";
			 
			 
			 //parse list and add it to result
			 for(int i = 0; i<numberofTasks;i++)
			 {
				 Task task = taskList.get(i);
				 String desc = task.getDescription();
				 int prior = task.getPriority();
				 String status = task.getStatus();
				 int stMonth = task.getstMonth();
				 int stDay = task.getstDay();
				 int stYear = task.getstYear();

				 int enMonth = task.getenMonth();
				 int enDay = task.getenDay();
				 int enYear = task.getenYear();
				 
				 
				 result += desc + "\r\n" + prior +  "\r\n" + status + "\r\n" + stMonth + "\r\n" + stDay + 
						 "\r\n" + stYear + "\r\n" + enMonth + "\r\n" +enDay+ "\r\n" + enYear + "\r\n";
			 }
			
			//save file
			FileChooser fileChooser = new FileChooser();
			
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	        fileChooser.getExtensionFilters().add(extFilter);
	        
	        //Show save file dialog
	        File file = fileChooser.showSaveDialog(stage);
	        
	        if(file != null){
	            SaveFile(result, file);
	        }
	            
			
			
			
		});
		
		//print gui and print listener
		//when print is pressed open the new classs that holds export functionality
		print = new Button("Print Report");
		print.setOnAction((e)->
		{
			ExportGUI export = new ExportGUI();
			
			for (int i = 0; i < a.getCompletedTaskList().size(); i++)
			{
				String desc = a.getCompletedTaskList().get(i).getDescription();
				System.out.println(desc);
			}
			export.ExportGUI(a.getTaskList(),a.getCompletedTaskList(), a.getDeletedTaskList(),stage, scene);
		});
		

		TilePane temp = new TilePane();
		temp.getChildren().addAll(export,print);
		BorderPane bottom = new BorderPane();
		bottom.setPadding(new Insets(15));
		bottom.setRight(temp);
		bottom.setLeft(error);
		
		this.setBottom(bottom);
		
		  
	}
	
	/*
	 * apply sort algo to approaite combobox index
	 */
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
			FileChooser fileChooser = new FileChooser();

			
			FileChooser.ExtensionFilter extentionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extentionFilter);

			//Set to user directory or go to default if cannot access
			String userDirectoryString = System.getProperty("user.home");
			String path;
			File userDirectory = new File(userDirectoryString);
			if(!userDirectory.canRead()) {
			    userDirectory = new File("c:/");
			}
			fileChooser.setInitialDirectory(userDirectory);

			//Choose the file
			File chosenFile = fileChooser.showOpenDialog(null);
			//Make sure a file was selected, if not return default
			
			if(chosenFile != null) {
			    path = chosenFile.getPath();
			} else {
			    //default return value
			    path = "";
			}	// TODO Auto-generated method stub
		
			if(path!="")
			{
				ArrayList<Task> loaded = new ArrayList<Task>();
				try {
					File file = new File(path);
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
						 System.out.println(loaded);
						/* ArrayList<Task> completedList = new ArrayList<Task>();
						 a = new GUI1ButtonsandListPane(taskList,completedList,st,sc);*/
						 a.displayedList = FXCollections.observableArrayList(taskList);
						 a.listView.setItems(a.displayedList);
						 error.setText("successfully loaded file");
					 }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					error.setText("Cannot find file with that name!");
					
				}
				
			}
					
		}
		}
	
}
