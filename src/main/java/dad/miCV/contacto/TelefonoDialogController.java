package dad.miCV.contacto;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelefonoDialogController extends Dialog<Telefono> implements Initializable {

    @FXML
    private GridPane view;

    @FXML
    private ComboBox<TipoTelefono> añadirCB;

    @FXML
    private TextField NumeroTF;

    Stage stage;
    
    public TelefonoDialogController()throws IOException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/TelefonoDialog.fxml"));
    	loader.setController(this);
    	loader.load();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		stage=(Stage)getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("/images/cv64x64.png"));
		
		añadirCB.getItems().addAll(TipoTelefono.values());
		setTitle("Nuevo teléfono");
		setHeaderText("Introduzca el nuevo número de teléfono.");
		getDialogPane().setContent(view);
		getDialogPane().getButtonTypes().addAll(new ButtonType("Añadir",ButtonData.OK_DONE),ButtonType.CANCEL);
		
		setResultConverter(b->onAñadirTelefonoAction(b));
		
	}

	
	private Telefono onAñadirTelefonoAction(ButtonType b) {
		
		if(b.getButtonData()==ButtonData.OK_DONE) {
			Telefono telefono=new Telefono();
			telefono.setNumero(NumeroTF.textProperty().get());
			telefono.setTipoTelefono(añadirCB.getValue());
			return telefono;
		}else
			return null;
		
		
	}
    
    

}
