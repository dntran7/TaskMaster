package TaskMaster;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.geometry.*;

import java.util.ArrayList;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event

/*
 * Description: Builds AddWindow scene and implements some functionality
*/
public class AddWindow{
	private Scene addScene;
	public AddWindow(ArrayList<Task> list, Stage mainWindow, Scene scene1) {
		VBox layout = new VBox(20);
		
		layout.setPadding(new Insets(15,12,15,12));
		layout.setSpacing(15);
		
		
		GridPane grid = new GridPane();
		
	/**************Description layout setup****************/
		
		
		Label descriptionLabel = new Label("Description:");
		descriptionLabel.setStyle("-fx-font: 36 arial");
		GridPane.setConstraints(descriptionLabel, 1, 0);
		grid.getChildren().add(descriptionLabel);
	
		
		TextField descriptionInput = new TextField();
		descriptionInput.setPrefHeight(125);
		descriptionInput.setPrefWidth(175);
	
		
		
   /**************Priority layout setup****************/
		
		HBox prioLayout = new HBox(10);
		Label priorityLabel = new Label("Priority:");
		priorityLabel.setStyle("-fx-font: 24 arial");
		TextField priorityInput = new TextField();
		priorityInput.setPrefHeight(30);
		priorityInput.setPrefWidth(85);
		prioLayout.getChildren().addAll(priorityLabel, priorityInput);
		
		
		
	
		//Start date label
		Label startDate = new Label("Start date:");
		startDate.setStyle("-fx-font: 16 arial");
		
		
		
		
		
	/**************Start date layout setup****************/
		
		
		HBox date1Layout = new HBox(10);
		Label monthLabel1 = new Label("Month:");
		monthLabel1.setStyle("-fx-font: 18 arial");
		ComboBox months1 = new ComboBox();
		months1.getItems().addAll(
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December"
				);
		Label dayLabel1 = new Label("Day:");
		dayLabel1.setStyle("-fx-font: 18 arial");
		TextField day1Input = new TextField();
		day1Input.setPrefHeight(30);
		day1Input.setPrefWidth(85);
		
		Label yearLabel1 = new Label("Year:");
		yearLabel1.setStyle("-fx-font: 18 arial");
		TextField year1Input = new TextField();
		year1Input.setPrefHeight(30);
		year1Input.setPrefWidth(85);
		date1Layout.getChildren().addAll(monthLabel1,months1, dayLabel1, day1Input, yearLabel1, year1Input);

		
		
		//End date label
		Label endDate = new Label("End date:");
		endDate.setStyle("-fx-font: 16 arial");
		
		
 /**************End date layout setup****************/
		

		HBox date2Layout = new HBox();
		date2Layout.setSpacing(10);
		Label monthsLabel2 = new Label("Month:");
		monthsLabel2.setStyle("-fx-font: 18 arial");
		ComboBox months2 = new ComboBox();
		months2.getItems().addAll(
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December"
				);

		Label dayLabel2 = new Label("Day:");
		dayLabel2.setStyle("-fx-font: 18 arial");
		TextField day2Input = new TextField();
		day2Input.setPrefHeight(30);
		day2Input.setPrefWidth(85);

		Label yearLabel2 = new Label("Year:");
		yearLabel2.setStyle("-fx-font: 18 arial");
		TextField year2Input = new TextField();
		year2Input.setPrefHeight(30);
		year2Input.setPrefWidth(85);
		date2Layout.getChildren().addAll(monthsLabel2,months2, dayLabel2, day2Input, yearLabel2, year2Input);
		
		
		
		
	/**************Progress layout setup****************/
		HBox progressLayout = new HBox(10);
		Label progressLabel = new Label("Progress:");
		progressLabel.setStyle("-fx-font: 16 arial");
		ComboBox progressInput = new ComboBox();
		progressInput.getItems().addAll(
				"Not Started",
				"In progress",
				"Finished"
				);
		progressInput.setStyle("-fx-font: 16 arial");
		progressLayout.getChildren().addAll(progressLabel,progressInput);
		
		
		
	/**************Button layout setup****************/
		HBox buttonLayout = new HBox(50);
		Button back = new Button("Back");
		back.setStyle(("-fx-font: 24 arial"));
		back.setPrefWidth(110);
		back.setPrefHeight(60);
		//GridPane.setConstraints(back, 0, 2);
		
		Button save = new Button("Save");
		save.setStyle(("-fx-font: 24 arial"));
		save.setPrefWidth(110);
		save.setPrefHeight(60);
		buttonLayout.setAlignment(Pos.CENTER);
		buttonLayout.getChildren().addAll(back, save);
		
		
		
		layout.getChildren().addAll(grid, descriptionInput, prioLayout, startDate, date1Layout, endDate, date2Layout, progressLayout, buttonLayout); //Sets main vbox layout
		
		
		addScene = new Scene(layout, 800, 550);
		
		
		mainWindow.setScene(addScene); //Sets addScene to window
		
		back.setOnAction(new EventHandler<ActionEvent>() { //Back button functionality
			@Override
			public void handle(ActionEvent event) {
				mainWindow.setScene(scene1);
			}
		});
	}
	
	private boolean checkInt(TextField field) { //Checks if textfield entry is an integer 
			
			try {
				int value = Integer.parseInt(field.getText());
				return true;
			} catch(NumberFormatException e){
				return false;
			}
	}
}