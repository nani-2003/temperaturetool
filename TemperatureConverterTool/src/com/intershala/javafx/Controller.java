

		package com.intershala.javafx;

		import javafx.beans.value.ChangeListener;
		import javafx.beans.value.ObservableValue;
		import javafx.event.ActionEvent;
		import javafx.event.EventHandler;
		import javafx.fxml.FXML;
		import javafx.fxml.Initializable;
		import javafx.scene.control.*;

		import java.net.URL;
		import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Lable welcomeLable1;
	@FXML
	public TextField userinputL;
	@FXML
	public ChoiceBox<String> choiceboxL;
	@FXML
	public Button converterL;
	private static final String C_TO_F_TEXT="Celsius To Fahrenheit";
	private static final String F_TO_C_TEXT="Fahrenheit To Celsius";
	private boolean isC_TO_F=true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceboxL.getItems().add(C_TO_F_TEXT);
		choiceboxL.getItems().add(F_TO_C_TEXT);
		choiceboxL.setValue(C_TO_F_TEXT);
		choiceboxL.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
			if(newValue.equals(C_TO_F_TEXT)){
				isC_TO_F=true;
			}else{
				isC_TO_F=false;
			}

		});

		converterL.setOnAction(event -> {
			convert();
		});

	}private void convert(){
		String input=userinputL.getText();
		float enteredTemp=0.0f;
		try {
			enteredTemp = Float.parseFloat(input);
		}catch(Exception exception){
			warnUser();
			return;
		}
		float newTemp=0.0f;
		if(isC_TO_F){
			newTemp=(enteredTemp*9/5)+32;
		}else{
			newTemp=(enteredTemp-32)*5/9;
		}
		display(newTemp);
	}

	private void warnUser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temoerature Entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();

	}

	private void display(float newTemp) {
		String unit=isC_TO_F? " F" : " C";
		System.out.println("The new temperature is: "+newTemp +unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new Temperature : "+newTemp +unit);
		alert.show();
	}
}