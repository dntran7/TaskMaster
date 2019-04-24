package TaskMaster;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;

//import com.apple.eawt.Application;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExportGUI_window extends Application{

	private Label title;
	private BorderPane bp,bp2,bp3;
	private Export_confirmation window = new Export_confirmation();
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void start(Stage stage, String clist, String nclist) {
    	stage.setTitle("Export");

    	HBox hBox = new HBox();
    	VBox vBox = new VBox();
    	bp = new BorderPane();
    	
    	title = new Label("File name:  ");
    	TextField file = new TextField();
    	Button save = new Button("SAVE");    	
    	
    	save.setOnAction((e)->
    	{
	    	try {
	 
				FileWriter writer = new FileWriter(file.getText(), true);
				
					BufferedWriter bufferWritter = new BufferedWriter(writer);
					bufferWritter.write(clist + "\n\n" + nclist);
					bufferWritter.close();
					window.start(stage, file.getText(),false);
					
				FileOutputStream output = new FileOutputStream(file.getText(), false);

	    	}
	    	catch (IOException ex) {
				//ex.printStackTrace();
	    		ex.getMessage();
	    		
			}
	    	
    	});
    	
    	hBox.getChildren().addAll(title, file);
    	hBox.setTranslateX(20);
    	bp.setCenter(save);
    	bp.setTranslateY(10);
    	//title.setTranslateY(20);
    	vBox.getChildren().addAll(hBox, bp);
    	Scene scene = new Scene(vBox, 300, 70);
    	stage.setScene(scene);
    	stage.show();
	}

	
}
