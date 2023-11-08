module com.example.demo {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.internshala.javafx to javafx.fxml;
	exports com.internshala.javafx;
}