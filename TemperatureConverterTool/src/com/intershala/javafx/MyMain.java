package com.intershala.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class MyMain extends Application {
	public static void main(String[] args){

		  launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar;
		menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}
	private MenuBar createMenu(){
		Menu fileMenu=new Menu("File");
		MenuItem newMenuItem=new MenuItem("New");
		newMenuItem.setOnAction(event -> {
			System.out.println("New Menu Item Clicked");
		});
		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitMenuItem =new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);

		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		Menu helpMenu=new Menu("Help");
        MenuItem aboutApp=new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;

	}

	private void aboutApp() {
		Alert alertDialog =new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop Application");
		alertDialog.setHeaderText("Learning JavaFx");
		alertDialog.setContentText("I am Just a Beginner soon I will become a pro and start developing aewsome Java apps");

		ButtonType yesBtn=new ButtonType("Yes");
		ButtonType noBtn=new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

		Optional<ButtonType> clickButn=alertDialog.showAndWait();

		if(clickButn.isPresent() && clickButn.get() == yesBtn){
			System.out.println("Yes Button is Clicked");
		}else{
			System.out.println("No Button is Clicked");
		}

	}
}
