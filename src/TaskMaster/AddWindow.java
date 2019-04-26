package TaskMaster;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
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
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;	//**Need to import to handle event
import javafx.event.EventHandler;	//**Need to import to handle event

/*
 * Description: Builds AddWindow scene and implements some functionality
*/
public class AddWindow{
	
	private Scene addScene;
	private TextField priorityInput;
	private int priority;
	private ArrayList<Task> newList;
	
	
	/*
	 * Add window, the gui for the add function and edit function.
	 * takes in parameters for arraylist of task, the stage, scene and the index of what the current list is editiinng
	 */
	public AddWindow(ArrayList<Task> list, Stage mainWindow, Scene scene1, int index) {
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
		ComboBox<String> months1 = new ComboBox<String>();
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
		ComboBox<Integer> day1Input = new ComboBox<Integer>();
		ObservableList<Integer> day1Array = arrayOfNums(30);
		day1Input.getItems().addAll(day1Array);
		
	//Listener for month editor
		
		months1.setOnAction(new EventHandler<ActionEvent>() { //Changes days based on month selection
			@Override
			public void handle(ActionEvent event) {
				if(months1.getValue().toString()=="January" || months1.getValue().toString()=="March" || months1.getValue().toString()=="May" ||
						months1.getValue().toString()=="July"|| months1.getValue().toString()=="August"|| months1.getValue().toString()=="October"|| months1.getValue().toString()=="December") {
					ObservableList<Integer> day1Array = arrayOfNums(31);
					day1Input.getItems().clear();
					day1Input.getItems().addAll(day1Array);
				}
				else if(months1.getValue().toString()=="February") {
					ObservableList<Integer> day1Array = arrayOfNums(28);
					day1Input.getItems().clear();
					day1Input.getItems().addAll(day1Array);
				}
				else {
					ObservableList<Integer> day1Array = arrayOfNums(30);
					day1Input.getItems().clear();
					day1Input.getItems().addAll(day1Array);
				}
					
			}
		});
	
		//label for year
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
		ComboBox<String> months2 = new ComboBox<String>();
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
		ComboBox<Integer> day2Input = new ComboBox<Integer>();
		ObservableList<Integer> day2Array = arrayOfNums(30);
		day2Input.getItems().addAll(day2Array);
	
		//listener for month or end month
		months2.setOnAction(new EventHandler<ActionEvent>() { //Back button functionality
			@Override
			public void handle(ActionEvent event) {
				if(months2.getValue().toString()=="January" || months2.getValue().toString()=="March" || months2.getValue().toString()=="May" ||
						months2.getValue().toString()=="July"|| months2.getValue().toString()=="August"|| months2.getValue().toString()=="October"|| months2.getValue().toString()=="December") {
					ObservableList<Integer> day2Array = arrayOfNums(31);
					day2Input.getItems().clear();
					day2Input.getItems().addAll(day2Array);
				}
				else if(months2.getValue().toString()=="February") {
					ObservableList<Integer> day2Array = arrayOfNums(28);
					day2Input.getItems().clear();
					day2Input.getItems().addAll(day2Array);
				}
				else {
					ObservableList<Integer> day2Array = arrayOfNums(30);
					day2Input.getItems().clear();
					day2Input.getItems().addAll(day2Array);
				}
					
			}
		});
		
		//label for year
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
		ComboBox<String> progressInput = new ComboBox<String>();
		
		//progress drop down menu
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
		
		//save button
		Button save = new Button("Save");
		save.setStyle(("-fx-font: 24 arial"));
		save.setPrefWidth(110);
		save.setPrefHeight(60);
		buttonLayout.setAlignment(Pos.CENTER);
		buttonLayout.getChildren().addAll(back, save);
		
	//if index is index = -1 that means we are adding new instnace to the list thus update gui accordingly
	//if index is index != -1 that means we editing an instnace of the list thus update gui to set the values
		if(index!=-1) {
			layout.getChildren().addAll(grid, descriptionInput, prioLayout);
		}
		if(index==-1) {
			layout.getChildren().addAll(grid, descriptionInput);
		}
		layout.getChildren().addAll(startDate, date1Layout, endDate, date2Layout, progressLayout, buttonLayout); //Sets main vbox layout
		
	
		//error label to showcase what error 
		Label error = new Label();
		error.setText("");
		error.setTextFill(Color.RED);
		
		BorderPane bottom = new BorderPane();
		bottom.setPadding(new Insets(15));
		
		bottom.setCenter(error);
		
		layout.getChildren().add(bottom);
		
		
		//get the values from the list and put it into the current add window since it is an edit
		addScene = new Scene(layout, 800, 550);
		if(index!=-1) { //Set edit parameters to task values
			Task temp= GUI1ButtonsandListPane.displayedList.get(index);
			priorityInput.setText(Integer.toString(temp.getPriority()));
			descriptionInput.setText(temp.getDescription());
			months1.setValue(temp.convertString(temp.getstMonth()));
			months2.setValue(temp.convertString(temp.getenMonth()));
			day1Input.setValue(temp.getstDay());
			day2Input.setValue(temp.getenDay());
			year1Input.setText(Integer.toString(temp.getstYear()));
			year2Input.setText(Integer.toString(temp.getenYear()));
			progressInput.setValue(temp.getStatus());
		}
		
		//automatically put not started for a new state
		
		if (index  == -1)
		{

			
			progressInput.setValue("Not Started");
		}
	
		
		
		
		
		mainWindow.setScene(addScene); //Sets addScene to window
		
		back.setOnAction(new EventHandler<ActionEvent>() { //Back button functionality
			@Override
			public void handle(ActionEvent event) {
				mainWindow.setScene(scene1);
			}
		});
		
		save.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			public void handle(ActionEvent event) {
				
				
				boolean checkUniqueDescription = true;
				
				//force progess to be not started if adding a new item to list
				if (index  == -1)
				{
					progressInput.setValue("Not Started");
				}
			
				
				
				//checking if descrption is an unique value
				
				for (int i =0 ; i < list.size(); i++ )
				{
					Task item = list.get(i);
					
					
					
					if (index!= i &&item.getDescription().toLowerCase().equals(descriptionInput.getText().toLowerCase()))
					{
						checkUniqueDescription = false;
					}
				}
				//check if anything is empty
				if(!(months1.getSelectionModel().isEmpty() || months2.getSelectionModel().isEmpty()  || year1Input.getText().trim().equals("")|| 
						year2Input.getText().trim().equals("") || day1Input.getSelectionModel().isEmpty() || 
						day2Input.getSelectionModel().isEmpty() || descriptionInput.getText().trim().equals("") || 
						progressInput.getSelectionModel().isEmpty()))
				{
					
					if (checkUniqueDescription)
					{
						
					
					//check if start date is before the finish date
					
					if(checkInt(year1Input) && checkInt(year2Input)) {
						//parse all input and make a new instance of task and add it to the list
						if(index==-1) {
							int monthIndex1 = getMonthNum(months1);
							int monthIndex2 = getMonthNum(months2);
							
							Task newTask = new Task(descriptionInput.getText(), GUI1ButtonsandListPane.displayedList.size()+1, monthIndex1, day1Input.getValue(),
								     Integer.parseInt(year1Input.getText()), monthIndex2, day2Input.getValue(), Integer.parseInt(year2Input.getText()), progressInput.getValue());
							if(newTask.checkDate()) {
							   GUI1ButtonsandListPane.displayedList.add(newTask);
							   mainWindow.setScene(scene1);
							}
							else
							{
								error.setText("Start date is after end date!");
							}
						}
						else 
						{
							int monthIndex1 = getMonthNum(months1);
							int monthIndex2 = getMonthNum(months2);
							
								//make sure the prority dont equal to each other and that it is an integer
							//parse all edited data from add window and add it to the task list
							if(checkInt(priorityInput) && !priorityInput.getText().trim().equals("")) {
									if(Integer.parseInt(priorityInput.getText())<=GUI1ButtonsandListPane.displayedList.size() && Integer.parseInt(priorityInput.getText())>0) {
										Task newTask = new Task(descriptionInput.getText(), Integer.parseInt(priorityInput.getText()), monthIndex1, day1Input.getValue(),
									    Integer.parseInt(year1Input.getText()), monthIndex2, day2Input.getValue(), Integer.parseInt(year2Input.getText()), progressInput.getValue());
										if(newTask.checkDate()) {	
												
												for(int inc=0;inc<GUI1ButtonsandListPane.displayedList.size(); inc++) {
													if(GUI1ButtonsandListPane.displayedList.get(index).getPriority()<Integer.parseInt(priorityInput.getText())){
														if(GUI1ButtonsandListPane.displayedList.get(inc).getPriority()<= Integer.parseInt(priorityInput.getText())
														&& GUI1ButtonsandListPane.displayedList.get(inc).getPriority() > GUI1ButtonsandListPane.displayedList.get(index).getPriority()) {
															
															Task temp1 = GUI1ButtonsandListPane.displayedList.get(inc);
															temp1.setPriority(temp1.getPriority()-1);
															GUI1ButtonsandListPane.displayedList.remove(inc);
															GUI1ButtonsandListPane.displayedList.add(inc, temp1);
														}
													}if(GUI1ButtonsandListPane.displayedList.get(index).getPriority()>Integer.parseInt(priorityInput.getText())) {
														if(GUI1ButtonsandListPane.displayedList.get(inc).getPriority()>= Integer.parseInt(priorityInput.getText())
																&& GUI1ButtonsandListPane.displayedList.get(inc).getPriority() < GUI1ButtonsandListPane.displayedList.get(index).getPriority()) {
															Task temp1 = GUI1ButtonsandListPane.displayedList.get(inc);
															temp1.setPriority(temp1.getPriority()+1);
															GUI1ButtonsandListPane.displayedList.remove(inc);
															GUI1ButtonsandListPane.displayedList.add(inc, temp1);
														}
													}
										
												}
												//refresh the code the main list
												GUI1ButtonsandListPane.displayedList.remove(index);
												GUI1ButtonsandListPane.displayedList.add(index, newTask);
												GUI1ButtonsandListPane.listView.setFocusTraversable(true);
												GUI1ButtonsandListPane.listView.refresh();
												GUI1ButtonsandListPane.listView.setItems(GUI1ButtonsandListPane.displayedList);
									
												System.out.println(GUI1ButtonsandListPane.displayedList.toString());
										
											
											mainWindow.setScene(scene1);
										}else {
											error.setText("Start date is after end date!");
										}
									}else {
										error.setText("Priority out of bounds!");
									 }
								}
							else
							{
								error.setText("Please make sure correct fields are integers");
							}
						
						}
					
							
					
						}else {
							error.setText("Please make sure correct fields are integers");
						}
						
						}
					else
					{
						error.setText("Make sure Descritpion is unique");
					}
				}else{
					error.setText("Please make sure all fields are filled");
					
			}
			}
		});
		}
	
	/*
	 * checks if the string is a number
	 */
	private boolean checkInt(TextField field) { //Checks if textfield entry is an integer 
			
			try {
				int value = Integer.parseInt(field.getText());
				return true;
			} catch(NumberFormatException e){
				return false;
			}
	}
	/*
	 * returns array of ints
	 */
	private ObservableList<Integer> arrayOfNums(int size){
		ObservableList<Integer> array = FXCollections.observableArrayList();
		for(int inc=0;inc<size;inc++) {
			array.add(inc+1);
		}
		return array;
	}
	/*
	 * returns scene
	 */
	public Scene getScene() {
		return addScene;
	}
	/*
	 * return new list
	 */
	public ArrayList<Task> getNewList(){
		return newList;
	}
	
	/*
	 * util function that returns sspecifc number of month from the combo box
	 */
	private int getMonthNum(ComboBox monthBox)
	{
		int result = 0;
		String month=monthBox.getValue().toString();
		
		if (month.equals("January"))
		{
			result = 1;
			
		}
		else if (month.equals("February"))
		{
			result =2;
			
		}
		else if (month.equals("March"))
		{
			result =3; 
			
		}
		else if (month.equals("April"))
		{
			result =4;
		}
		else if (month.equals("May"))
		{
			result = 5;
			
		}
		else if (month.equals("June"))
		{
			result = 6;
			
		}
		else if (month.equals("July"))
		{
			result =7;
		}
		else if (month.equals("August"))
		{
			result = 8;
			
		}
		else if (month.equals("September"))
		{
			result = 9;
			
		}
		else if (month.equals("October"))
		{
			result = 10;
		}
		else if (month.equals("November"))
		{
			result = 11;
			
		}
		else if (month.equals("December"))
		{
			result = 12;
			
		}
		
		return result;
		

	}
}