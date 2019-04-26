/***
*@ClassName:TaskMaster
*@Description: This class runs the main Application that shows the gui for the project
***/
package TaskMaster;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

/***
*@ClassName:TaskMaster
*@Description: This class runs the main Application that shows the gui for the project
***/
public class TaskMaster extends Application
{
    private GUI1 a;
    private ArrayList<Task> taskList;
    private ArrayList<Task> record;
    private ArrayList<Task> tasklist, completedList;

/***
*@MethodName:start
*@param: Stage
*return: void
*@Description: This class runs the application gui by getting the Stage type
***/
    public void start(Stage stage)
    {
        StackPane root = new StackPane();

        //movieList to be used in both createPane & reviewPane
        taskList = new ArrayList<Task>();
        Scene scene = new Scene(root, 800, 550);
        completedList = new ArrayList<Task>();
        a = new GUI1(taskList, completedList,stage, scene);
        root.getChildren().add(a);

        stage.setTitle("TaskMaster");
        stage.setScene(scene);
        stage.show();
    }
/***
*@MethodName:main
*@param: String[] args
*return: void
*@Description: This is the main that launches the application gui
***/
    public static void main(String[] args)
    {
        launch(args);
    }
}
