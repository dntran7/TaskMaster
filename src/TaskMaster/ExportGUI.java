package TaskMaster;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    
	public void ExportGUI(ArrayList<Task> list, ArrayList<Task> completedList, Stage mainWindow, Scene scene1) {
    	
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
        	tempNotCompletedList +=list.get(i).toString();
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
        for(int i = 0;i<completedList.size();i++)
        {
        	CompletedList +=completedList.get(i).toString();
        }
        notCompList.setText(tempNotCompletedList);
        ncListExport = compList.getText();
        compList.setEditable(false); //set the Text area to be "untouchable" \
        compList.setPrefHeight(350);
        /********************************************/
   
        
        
    	saveButton = new Button("SAVE");
    	saveButton.setOnAction((e)->//set the an action for when the user clicks on the save button
    	{ 
    		Stage stage_2 = new Stage();
    		window.start(stage_2, cListExport, ncListExport);
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
    	
    	mainWindow.setTitle("Export");
    	mainWindow.setScene(scene);
    	mainWindow.show();	
    	
    }
}