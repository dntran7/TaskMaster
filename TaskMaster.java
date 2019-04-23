    
package TaskMaster;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class TaskMaster extends Application
{
    private GUI1 a;
    private ArrayList<Task> taskList;

    public void start(Stage stage)
    {
        StackPane root = new StackPane();

        //movieList to be used in both createPane & reviewPane
        Scene scene = new Scene(root, 800, 550);
        taskList = new ArrayList<Task>();
        a = new GUI1(taskList, stage, scene);
        root.getChildren().add(a);

       
        stage.setTitle("TaskMaster");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
