module gallery {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires java.sql;
	requires com.jfoenix;
	requires java.desktop;
	
	opens controller to javafx.fxml, javafx.graphics;
	exports controller;
	
	opens model to javafx.fxml;
	exports model;
}