package dad.miCV.conocimiento;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ConocimientoController implements Initializable {

	//Model
	Conocimiento conocimiento=new Conocimiento();
	
	//View
	@FXML
	private HBox view;

	@FXML
	private TableView<?> table;

	@FXML
	private TableColumn<?, ?> denominacionCol;

	@FXML
	private TableColumn<?, ?> nivelCol;

	public ConocimientoController() throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/ConocimientosView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public HBox getView() {
		return view;
	}
	
    @FXML
    void onAñadirConocimiento(ActionEvent event) {

    }

    @FXML
    void onAñadirIdioma(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }
	
	

}
