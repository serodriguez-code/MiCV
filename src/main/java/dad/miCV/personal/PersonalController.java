package dad.miCV.personal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable {

	//model
	
	private ObjectProperty<Personal> personal=new SimpleObjectProperty<>();
	
	//view
	@FXML
	private GridPane view;
	
	@FXML
	private TextField identificacionTF,nombreTF,apellidosTF,codigoPostalTF,localidadTF;
	
	@FXML
	private DatePicker fechaNacimientoDP;
	
	@FXML
	private TextArea direccionTA;
	
	@FXML
	private ComboBox<String> paisCB;
	
	@FXML
	private ListView<Nacionalidad> nacionalidadesLV;
	
	@FXML
	private Button nuevaNacionalidadB,borrarNacionalidadB;
	
	public PersonalController() throws IOException{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/PersonalView.fxml"));
		loader.setController(this);
		loader.load();		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		personal.addListener((o,ov,nv)->onPersonalChanged(o,ov,nv));	
	}
	
    private void onPersonalChanged(ObservableValue<? extends Personal> o, Personal ov, Personal nv) {
		
    	if(ov!=null) {
    		identificacionTF.textProperty().unbindBidirectional(ov.identificacionProperty());
    		nombreTF.textProperty().unbindBidirectional(ov.nombreProperty());
    		apellidosTF.textProperty().unbindBidirectional(ov.apellidosProperty());
    		codigoPostalTF.textProperty().unbindBidirectional(ov.codigoPostalProperty());
    		localidadTF.textProperty().unbindBidirectional(ov.localidadProperty());
    		fechaNacimientoDP.valueProperty().unbindBidirectional(ov.fechaNacimientoProperty());
    		direccionTA.textProperty().unbindBidirectional(ov.direccionProperty());
    		paisCB.valueProperty().unbindBidirectional(ov.paisProperty());
    		nacionalidadesLV.itemsProperty().unbindBidirectional(ov.nacionalidadesProperty());
    	}	
    	if(nv!=null) {
    		identificacionTF.textProperty().bindBidirectional(nv.identificacionProperty());
    		nombreTF.textProperty().bindBidirectional(nv.nombreProperty());
    		apellidosTF.textProperty().bindBidirectional(nv.apellidosProperty());
    		codigoPostalTF.textProperty().bindBidirectional(nv.codigoPostalProperty());
    		localidadTF.textProperty().bindBidirectional(nv.localidadProperty());
    		fechaNacimientoDP.valueProperty().bindBidirectional(nv.fechaNacimientoProperty());
    		direccionTA.textProperty().bindBidirectional(nv.direccionProperty());
    		paisCB.valueProperty().bindBidirectional(nv.paisProperty());
    		nacionalidadesLV.itemsProperty().bindBidirectional(nv.nacionalidadesProperty());
    	}
	}

	@FXML
    private void onBorrarNacionalidadBAction(ActionEvent event) {

    }

    @FXML
    private void onNuevaNacionalidadBAction(ActionEvent event) {

    }
    
    public GridPane getView() {
    	return this.view;
    }   
   
	public final ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}
	
	public final Personal getPersonal() {
		return this.personalProperty().get();
	}
	
	public final void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}
	
    
    

}
