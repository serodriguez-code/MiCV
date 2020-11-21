package dad.miCV.experiencia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ExperienciaController implements Initializable {

	//view
	@FXML
    private HBox view;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> desdeCol;

    @FXML
    private TableColumn<?, ?> hastaCol;

    @FXML
    private TableColumn<?, ?> denominacionCol;

    @FXML
    private TableColumn<?, ?> empleadorCol;


	public ExperienciaController() throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/ExperienciaView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
    public HBox getView() {
    	return view;
    }
	
	@FXML
    void onAñadir(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

}
