package controller;

import java.io.File;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Image;
import model.Member;
import model.MemberContainer;

public class ImageController {
	@FXML private Label name, author, price, draw, year, type, info, liked;
	@FXML private ImageView ivImage;
	@FXML private JFXButton like, bag;
	
	private Stage dialogStage;
	private Image image;
	private Member member;
	private MemberContainer members;
	private File file;

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
//	    ivImage.fitWidthProperty().bind(dialogStage.widthProperty());
//	    ivImage.fitHeightProperty().bind(dialogStage.heightProperty());
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
		
		if(member.findLiked(image))
			like.setText("Таалагдсангүй");
		else 
			like.setText("Таалагдлаа");
		
		if(member.findFromBag(image))
			bag.setText("Сагснаас гаргах");
		else
			bag.setText("Сагсанд хйих");
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		
		name.setText(image.getName());
		author.setText(image.getAuthor());
		draw.setText(image.getDraw());
		type.setText(image.getType());
		info.setText(image.getInfo());
		price.setText(Integer.toString(image.getPrice()));
		year.setText(Integer.toString(image.getYear()));
		liked.setText(Integer.toString(image.getLiked()));
		
		file = new File(image.getPath());
		ivImage.setImage(new javafx.scene.image.Image(file.toURI().toString()));
	}
	
	@FXML
	void initialize() {
		members = new MemberContainer();
	}

	@FXML
	void Like() {
		if(member.findLiked(image)) {
			members.deleteLiked(member, image);
			image.decLiked();
			like.setText("Таалагдлаа");
		} else {
			members.addLiked(member, image);
			image.incLiked();
			like.setText("Таалагдсангүй");
		}
		liked.setText(Integer.toString(image.getLiked()));
	}
	
	@FXML
	void Bag() {
		if(member.findFromBag(image)) {
			member.deleteFromBag(image);
			bag.setText("Сагсанд хйих");
		} else {
			member.addToBag(image);
			bag.setText("Сагснаас гаргах");
		}
	}
	
	@FXML
	void Close() {
		dialogStage.close();
	}
		
}
