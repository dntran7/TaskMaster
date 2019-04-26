package TaskMaster;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Export_confirmation extends Application{

	private Label title;
	private BorderPane bp;

	public void start(Stage primaryStage) throws Exception {
		
	}
	public void start(Stage stage, String name, boolean exist) {
    	
    	bp   = new BorderPane();

    		title = new Label("your file \"" + name + ".txt\" has been exported");
        	bp.setCenter(title);
        	//bp.setTranslateY(10);
        	//title.setTranslateY(20);
        	Scene scene = new Scene(bp, 300, 70);
        	stage.setScene(scene);
        	stage.show();

   
	}



}
