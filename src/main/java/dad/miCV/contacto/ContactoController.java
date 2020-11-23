package dad.miCV.contacto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ContactoController implements Initializable {

	@FXML
    private SplitPane view;

    @FXML
    private TableView<?> telefonosTable;

    @FXML
    private TableColumn<?, ?> numeroColumn;

    @FXML
    private TableColumn<?, ?> tipoColumn;

    @FXML
    private TableView<?> correoTable;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableView<?> webTable;

    @FXML
    private TableColumn<?, ?> urlColumn;

    
	public ContactoController() throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
		loader.setController(this);
		loader.load();	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public SplitPane getView() {
		return view;
	}

	@FXML
    void onAñadirCorreo(ActionEvent event) {

    }

    @FXML
    void onAñadirTelefono(ActionEvent event) {

    }

    @FXML
    void onAñadirWeb(ActionEvent event) {

    }

    @FXML
    void onEliminarCorreo(ActionEvent event) {

    }

    @FXML
    void onEliminarTelefono(ActionEvent event) {

    }

    @FXML
    void onEliminarWeb(ActionEvent event) {

    }
	
}
