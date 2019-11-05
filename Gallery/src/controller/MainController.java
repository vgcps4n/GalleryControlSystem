package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXToggleButton;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Admin;
import model.Company;
import model.Employee;
import model.Image;
import model.ImageContainer;
import model.Member;
import model.User;
import view.Dialog;

public class MainController {
	@FXML private BorderPane pane;
	@FXML private TableView<Image> table;
	@FXML private TableColumn<Image, String> colName, colAuthor, colInfo, colType;
	@FXML private TableColumn<Image, Integer> colPrice, colLiked;
	
	@FXML private TableView<Image> bag;
	@FXML private TableColumn<Image, String> colBag;

	@FXML private ChoiceBox<String> cbType;
	@FXML private TextField search;
	@FXML private JFXToggleButton liked;
	@FXML private JFXButton login, order;
	@FXML private Label username;
	
    private Stage Stage;
    private boolean isLogged;
    private User user;
    private ImageContainer images;
    private FilteredList<Image> filter;
    
    public void setStage(Stage stage){
        this.Stage = stage;
    } 
    
    public Stage getStage (Stage stage) {
    	return Stage;
    }

    @FXML
    void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colInfo.setCellValueFactory(new PropertyValueFactory<>("info"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colLiked.setCellValueFactory(new PropertyValueFactory<>("liked"));

        colBag.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        isLogged = false;
        images = new ImageContainer();
        table.setPlaceholder(new Label("Таны хайсан зураг олдсонгүй."));
        bag.setPlaceholder(new Label("Хоосон."));
        
        table.setRowFactory(tv -> {
        	TableRow<Image> row = new TableRow<>();
        	row.setOnMouseClicked(event -> {
        		if(event.getClickCount() == 2 && !row.isEmpty()) {
        			if(!isLogged) {
                		new Dialog(pane, Stage, "Зураг үзэх боломжгүй.", "Та эхлээд нэвтэрнэ үү.", 700, 400);
                		return;
                	}
        			OpenImageWindow(row.getItem());
        		}
        	});
            return row;
        });
        
        bag.setRowFactory(tv -> {
        	TableRow<Image> row = new TableRow<>();
        	row.setOnMouseClicked(event -> {
        		if(event.getClickCount() == 2 && !row.isEmpty()) {
        			if(!isLogged) {
                		new Dialog(pane, Stage, "Зураг үзэх боломжгүй.", "Та эхлээд нэвтэрнэ үү.", 700, 400);
                		return;
                	}
        			OpenImageWindow(row.getItem());
        		}
        	});
            return row;
        });
        
        filter = new FilteredList<>(images.getImages(), p -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
        	filter.setPredicate(image -> {
        		
        		if(newValue == null || newValue.isEmpty())
            		return true;
        		String lower = newValue.toLowerCase();
        		if(image.getName().toLowerCase().contains(lower))
        			return true;
        		if(image.getAuthor().toLowerCase().contains(lower))
        			return true;
        		if(image.getInfo().toLowerCase().contains(lower))
        			return true;
        		if(Integer.toString(image.getPrice()).toLowerCase().contains(lower))
        			return true;
        		return false;
        	});
        });
        SortedList<Image> sorted = new SortedList<>(filter);
        sorted.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sorted);
        
        table.getOnDragDetected();
        
        liked.selectedProperty().addListener(e -> {
        	if(isLogged) {
        		if(liked.isSelected())
        			table.setItems(((Member) user).getLiked());
        		else
        			table.setItems(sorted);
        	}
        });
        
        cbType.getItems().addAll("Бусад", "Өвөл", "photo", "photograph");

    }
    
    @FXML
    void Login() {
    	if(!isLogged) {
    		OpenLoginWindow();
    	} else {
    		isLogged = false;
    		bag.setDisable(true);
    		bag.setItems(null);
    		order.setDisable(true);
        	this.login.textProperty().setValue("Нэвтрэх");
        	username.setText("");
        	user = null;
        	OpenLoginWindow();
    	}
    		
    }
    
    @FXML
    void Order() {
    	if(((Member) user).getBag().isEmpty()) {
    		new Dialog(pane, Stage, "Захиалах боломжгүй.", "Сагс хоосон байна.", 700, 400);
    		return;
    	}
    	OpenOrderWindow((Member) user);
    }
    
    @FXML
    void Exit() {
    	JFXDialogLayout content = new JFXDialogLayout();
	    content.setHeading(new Text("Гарах"));
	    content.setBody(new Text("Та гарахдаа итгэлтэй байна уу?"));
	    StackPane sp = new StackPane();
	    sp.getChildren().add(pane);
	    JFXDialog dialog = new JFXDialog(sp, content, JFXDialog.DialogTransition.CENTER);
	    dialog.setMaxWidth(700);
	    JFXButton yes = new JFXButton("Тийм");
	    JFXButton no = new JFXButton("Санамсаргүй дарчлаа");
	    no.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            dialog.close();
	        }
	    });
	    yes.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	System.out.println("bye.");
	        	Stage.close();
	        }
	    });
	    content.setActions(yes, no);
	    Scene scene = new Scene(sp, 700, 400);
	    Stage.setScene(scene);
	    dialog.show();
    }
    
    private void OpenImageWindow(Image image) {
    	try {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(Main.class.getResource("/view/Image.fxml"));
			BorderPane img = (BorderPane) loader.load();
			
			Stage imageWindow = new Stage();
            imageWindow.initModality(Modality.WINDOW_MODAL);
			imageWindow.initOwner(Stage);
			Scene scene = new Scene(img);
			imageWindow.setScene(scene);
			
			ImageController controller = loader.getController();
			imageWindow.setTitle(image.getName());
			controller.setDialogStage(imageWindow);
			controller.setImage(image);
			controller.setMember((Member) user);
			
			imageWindow.showAndWait();
			table.refresh();
		} catch (IOException e) {
			System.out.println("sad");
			e.printStackTrace();
		}
    	
    }
    
    private void OpenLoginWindow() {
    	try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Login.fxml"));
            AnchorPane login = (AnchorPane) loader.load();
            
            Stage loginWindow = new Stage();
            loginWindow.initModality(Modality.WINDOW_MODAL);
            loginWindow.initOwner(Stage);
            Scene scene = new Scene(login);
            loginWindow.setScene(scene);
            
            LoginController controller = loader.getController();
            loginWindow.setTitle("Нэвтрэх");
            controller.setDialogStage(loginWindow);
            
            loginWindow.showAndWait();
            
            if(controller.getAuth() != null) {
            	user = controller.getAuth().getUser();
	        	if(user instanceof Member) {
	            	isLogged = true;
	        		bag.setDisable(false);
	        		bag.setItems(((Member) user).getBag());
	        		order.setDisable(false);
	            	username.setText(((Member) user).getName().getFirst() + " та тавтай морилно уу.");
	            	this.login.textProperty().setValue("Өөр хэрэглэгчээр нэвтрэх");
	        	} else if(user instanceof Employee) {
	        		SwitchEmployeeWindow((Employee) user);
	        	} else if(user instanceof Company) {
	        		SwitchCompanyWindow((Company) user);
	        	} else if(user instanceof Admin) {
	        		SwitchAdminWindow();
	        	}
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void SwitchAdminWindow() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Admin.fxml"));
            BorderPane admin = (BorderPane) loader.load();

            Scene adminWindow = new Scene(admin);
            
            AdminController controller = loader.getController();
            controller.setStage(Stage);
            controller.setRoot(Stage.getScene());
            Stage.setTitle("Админ");
    	    Stage.setScene(adminWindow);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void SwitchCompanyWindow(Company company) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Company.fxml"));
            BorderPane comp = (BorderPane) loader.load();

            Scene companyWindow = new Scene(comp);
            
            CompanyController controller = loader.getController();
            controller.setStage(Stage);
            controller.setRoot(Stage.getScene());
            controller.setCompany(company);
            Stage.setTitle("Компани");
    	    Stage.setScene(companyWindow);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void SwitchEmployeeWindow(Employee employee) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Employee.fxml"));
            BorderPane emp = (BorderPane) loader.load();

            Scene employeeWindow = new Scene(emp);
            
            EmployeeController controller = loader.getController();
            controller.setStage(Stage);
            controller.setRoot(Stage.getScene());
            controller.setEmployee(employee);
            Stage.setTitle("Ажилтан");
    	    Stage.setScene(employeeWindow);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void OpenOrderWindow(Member member) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Order.fxml"));
            BorderPane order = (BorderPane) loader.load();

            Stage orderWindow = new Stage();
            orderWindow.initModality(Modality.WINDOW_MODAL);
            orderWindow.initOwner(Stage);
            Scene scene = new Scene(order);
            orderWindow.setScene(scene);
            
            OrderController controller = loader.getController();
            orderWindow.setTitle("Захиалах");
            controller.setDialogStage(orderWindow);
            controller.setMember(member);
            
            orderWindow.showAndWait();
            
            if(controller.isConfirmed())
        		new Dialog(pane, Stage, "Захиалага амжилттай.", "Танд баяр хүргэе!", 700, 400);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
