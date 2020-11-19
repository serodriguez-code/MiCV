package dad.nombre.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.nombre.model.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

	Model model=new Model();
	
	//View
	@FXML
	private VBox view;//Si el elemento del que extiende el FXML es diferente a VBox hay que cambiarlo aquí también
	
	public Controller() throws IOException{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
		//Todo lo que iría normalmente en el contructor ahora se implementa en initialize	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public VBox getView() {//Si el elemento del que extiende el FXML es diferente a VBox hay que cambiarlo aquí también
		return this.view;
	}
}
