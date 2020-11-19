package dad.miCV.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.miCV.model.MainModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

	MainModel model=new MainModel();
	
	@FXML
	private BorderPane view;

	@FXML
	private Tab personalTab,contactoTab,formacionTab,experienciaTab,conocimientosTab;

	    
	public MainController() throws IOException{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
	public BorderPane getView() {
		return this.view;
	}
    @FXML
    void onAbrirAction(ActionEvent event) {

    }

    @FXML
    void onAcercaDeAction(ActionEvent event) {

    }

    @FXML
    void onGuardarAction(ActionEvent event) {

    }

    @FXML
    void onGuardarComoAction(ActionEvent event) {

    }

    @FXML
    void onNuevoAction(ActionEvent event) {

    }

    @FXML
    void onSalirAction(ActionEvent event) {
		Platform.exit();
    }
}
