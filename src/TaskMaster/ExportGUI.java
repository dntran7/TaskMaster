package TaskMaster;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ExportGUI {
	
	private VBox vBox,vBox_2,vBox_3;
	private HBox hBox;
	private Label notComplete, completed;
	private BorderPane bp;
	private TextArea notCompList,compList;
	private Button saveButton, backButton;
	private String ncListExport,cListExport;
	
	private ExportGUI_window window = new ExportGUI_window();
	
	  private void SaveFile(String content, File file){
	        try {
	            FileWriter fileWriter = null;
	             
	            fileWriter = new FileWriter(file);
	            fileWriter.write(content);
	            fileWriter.close();
	        } catch (IOException ex) {
	            
	        }
	         
	  }
	
    
	public void ExportGUI(ArrayList<Task> list, ArrayList<Task> completedList,ArrayList<Task> deletedList, Stage mainWindow, Scene scene1) {
    	
    	vBox     = new VBox();
    	vBox_2   = new VBox();
    	vBox_3   = new VBox();
    	hBox     = new HBox();
        bp       = new BorderPane();

 
        //Not completed area
        notComplete = new Label("Not completed:");
        notCompList = new TextArea("");
        vBox_2.getChildren().addAll(notComplete,notCompList);
        String tempNotCompletedList = "";
        for(int i = 0;i<list.size();i++)
        {
        	tempNotCompletedList +=list.get(i).toString()+"\r\n\r\n";
        }
        notCompList.setText(tempNotCompletedList);
        cListExport = notCompList.getText();
        notCompList.setEditable(false); //set the Text area to be "untouchable" \
        notCompList.setPrefHeight(350);
        /********************************************/
         
        
        
        //completed Area
        completed   = new Label("Completed");
        compList    = new TextArea("");
        vBox_3.getChildren().addAll(completed,compList);

        String CompletedList = "";
        for(int x = 0;x<completedList.size();x++)
        {
        	CompletedList +=completedList.get(x).toString() + "\r\n\r\n";
        }
        compList.setText(CompletedList);
        ncListExport = compList.getText();
        compList.setEditable(false); //set the Text area to be "untouchable" \
        compList.setPrefHeight(350);
        /********************************************/
   
        //deleted Area
        String DeletedList = "";
        for(int x = 0;x<deletedList.size();x++)
        {
        	DeletedList +=deletedList.get(x).toString() + "\r\n\r\n";
        }
 
        /********************************************/
        
    	saveButton = new Button("SAVE");
    	
    	  
          
           
          final String result = "Not Completed List:\r\n"
        		  + tempNotCompletedList
        		  + "\r\n_________________________________________________________\r\nCompleted List:\r\n"
        		  + CompletedList 
          		  + "\r\n_________________________________________________________\r\nDeleted List:\r\n"
          		  + deletedList ;
          
          Text textSong = TextBuilder.create()
                  .text(result)
                  .build();                
           
    	
    	saveButton.setOnAction((e)->//set the an action for when the user clicks on the save button
    	{ 
    		Stage stage_2 = new Stage();
    		//window.start(stage_2, cListExport, ncListExport);
    		
    		FileChooser fileChooser = new FileChooser();
    		
    		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            
            //Show save file dialog
            File file = fileChooser.showSaveDialog(mainWindow);
            
            if(file != null){
                SaveFile(result, file);
            }
        });
    		
    		
    		
 
    	backButton = new Button("BACK");
    	backButton.setOnAction((e)->
   		{
   			mainWindow.setScene(scene1);
   		});
       	saveButton.setTranslateY(-2); //adjust the save button
       	saveButton.setTranslateX(350);
    	backButton.setTranslateY(-2); //adjust the back button
    	backButton.setTranslateX(350);
    	hBox.getChildren().addAll(saveButton,backButton);//, backButton);
    	//bp.setCenter(hBox); //centers the button
    	
    	vBox.setSpacing(10); 
    	vBox.getChildren().addAll(vBox_2,vBox_3,hBox);
    	Scene scene = new Scene(vBox, 800, 500);
    	

    	mainWindow.setScene(scene);
    	mainWindow.show();	
    	
    }

}