package com.internshala.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class MyMain extends Application {
	public static void main(String[] args){
		launch(args);

	}
	@Override
	public void start(Stage Stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		AnchorPane rootNode = loader.load();

		Scene scene = new Scene((Parent) rootNode, 300, 275);

		Stage.setScene(scene);
		Stage.setTitle("Hello World");
		Stage.show();

	}
}
