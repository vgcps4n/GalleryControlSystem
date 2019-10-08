module gallery {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires java.sql;
	
//	opens view to javafx.fxml;
//	exports view;
	
	opens controller to javafx.fxml;
	exports controller;
	
	opens model to javafx.fxml;
	exports model;
	
}