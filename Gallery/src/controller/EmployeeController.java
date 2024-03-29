package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Employee;
import model.EmployeeContainer;
import model.Image;
import model.ImageContainer;
import model.User;
import view.Dialog;

public class EmployeeController {
	@FXML private BorderPane pane;
	@FXML private Text username;
	@FXML private Text imagename;
	@FXML private TextField name, price, draw, year;
	@FXML private TextArea info;
	@FXML private ChoiceBox<String> type;
	@FXML private TableView<Image> table;
	@FXML private TableColumn<Image, Integer> colLiked;
	@FXML private TableColumn<Image, String> colName, colPrice;
	
	private Stage stage;
    private Scene root;
    private Employee employee;
    private EmployeeContainer employees;
    private ImageContainer images;
    private FileChooser fc;
    private File file;
    private String path;
    private BufferedImage bi;

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setRoot(Scene root) {
		this.root = root;
	}
	
	public void setEmployee(User employee) {
		this.employee = (Employee) employee;
		username.setText(this.employee.getName().getFirst() + " та амжилттай нэвтэрлээ.");
		table.setItems(this.employee.getImages());
        path = "src/data/images/" + employee.getAuth().getUsername();
        File dir = new File(path);
        if(!dir.exists())
        	dir.mkdir();
	}

	@FXML
	void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colLiked.setCellValueFactory(new PropertyValueFactory<>("liked"));
        
        type.getItems().addAll("Бусад", "Өвөл");
        
        fc = new FileChooser();
        images = new ImageContainer();
        employees = new EmployeeContainer();
	}
	
	@FXML
	void Choose() {
		fc.setTitle("Зураг сонгох");
		file = fc.showOpenDialog(stage);
		if(file != null) {
			try {
				bi = ImageIO.read(file);
				imagename.setText(file.getName());
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else imagename.setText("");
	}
	
	@FXML
	void Create() {
		if(name.getText().toString().equals("") ||
			info.getText().toString().equals("") ||
			price.getText().toString().equals("") ||
			type.getSelectionModel().getSelectedItem().toString().equals("") ||
			type.getSelectionModel().getSelectedItem() == null ||
			draw.getText().toString().equals("") ||
			year.getText().toString().equals("") ||
			imagename.getText().toString().equals("")) {
			new Dialog(pane, stage, "Талбар дутуу байна.", "Бүх талбрыг бөглөнө үү.", 680, 290);
			return;
		}
		try {
			if(!price.getText().toString().matches("[0-9]*")) {
				new Dialog(pane, stage, "Үнэ буруу байна.", "Үнийг зөвхөн тоогоор оруулна уу.", 680, 290);
				return;
			}
			if(!year.getText().toString().matches("[0-9]*")) {
				new Dialog(pane, stage, "Жил буруу байна.", "Үнэн зөв жил оруулна уу.", 680, 290);
				return;
			}
			Image image = images.createImage(name.getText().toString(),
					employee.getName().getFirst(), info.getText().toString(),
					Integer.parseInt(price.getText().toString()), draw.getText().toString(), 
					type.getSelectionModel().getSelectedItem().toString(),
					Integer.parseInt(year.getText().toString()), path + "/" + imagename.getText());
			if(image == null)
				new Dialog(pane, stage, "Зураг бүртгэгдсэн байна.", "Өөр зураг оруулна уу.", 680, 290);
			ImageIO.write(bi, "jpg", new File(path + "/" + file.getName()));
			employees.addImage(employee, image);
			new Dialog(pane, stage, "Амжилттай.", "Зураг амжилттай бүртгэгдлээ.", 680, 290);
			table.refresh();
			clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void clear() {
		name.setText("");
		price.setText("");
		draw.setText("");
		year.setText("");
		info.setText("");
		imagename.setText("");
	}
	
	@FXML
	void Logout() {
		stage.setTitle("Gallery Control System");
		stage.setScene(root);
	}
}
