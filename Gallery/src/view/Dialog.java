package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dialog {
	public Dialog(Pane root, Stage stage, String head, String body, double width, double height) {
	    JFXDialogLayout content = new JFXDialogLayout();
	    content.setHeading(new Text(head));
	    content.setBody(new Text(body));
	    StackPane sp = new StackPane();
	    
	    JFXDialog dialog = new JFXDialog(sp, content, JFXDialog.DialogTransition.CENTER);
	    dialog.setMaxWidth(width);
	    JFXButton button = new JFXButton("OK");
	    button.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            dialog.close();
	        }
	    });
	    content.setActions(button);
	    Scene scene = new Scene(sp, width, height);
	    sp.getChildren().add(root);
	    stage.setScene(scene);
	    dialog.show();
	}
}
