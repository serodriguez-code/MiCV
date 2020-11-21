package dad.miCV;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import dad.miCV.conocimiento.ConocimientoController;
import dad.miCV.cv.CV;
import dad.miCV.experiencia.ExperienciaController;
import dad.miCV.formacion.FormacionController;
import dad.miCV.personal.PersonalController;
import dad.miCV.utils.JSONUtils;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController implements Initializable {

	File currentCvFile;
	
	//Sub-Controllers
	private PersonalController personalController=new PersonalController();
//	private ContactoController contactoController=new ContactoController();
	private FormacionController formacionController=new FormacionController();
	private ExperienciaController experienciaController=new ExperienciaController();
	private ConocimientoController conocimientoController=new ConocimientoController();
	
	//Model
	
	private ObjectProperty<CV> cv=new SimpleObjectProperty<>();
	
	//View
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

		personalTab.setContent(personalController.getView());
//		contactoTab.setContent(contactoController.getView());
		formacionTab.setContent(formacionController.getView());
		experienciaTab.setContent(experienciaController.getView());
		conocimientosTab.setContent(conocimientoController.getView());
		
		cv.addListener((o, ov,nv)->onCVChanged(o,ov,nv));
		cv.set(new CV());

	}
	
	private void onCVChanged(ObservableValue<? extends CV> o, CV ov, CV nv) {
		
		//Desbindea el personalProperty del modelo antiguo si lo hubiese
		if(ov !=null) {
			personalController.personalProperty().unbind();
		//FALTA DESBINDEAR EL RESTO DE CONTROLADORES
			
		}
		//Hace un bindeo del personalProperty de personalController con un modelo de tipo Personal
		if(nv!=null) { 
			personalController.personalProperty().bind(nv.personalProperty());
		}
	}
	
	public BorderPane getView() {
		return this.view;
	}
    @FXML
    private void onAbrirAction(ActionEvent event) {

    	Stage stage=(Stage)view.getScene().getWindow();
    	FileChooser fileChooser=new FileChooser();
    	fileChooser.setTitle("Abrir un curriculum");
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Curriculum Vitae (*.cv)","*.cv"));
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos","*.*"));
    	currentCvFile=fileChooser.showOpenDialog(stage);
    	
    	if(currentCvFile!=null) {
    		try {
    			cv.set(JSONUtils.fromJson(currentCvFile, CV.class));
    		}catch (JsonSyntaxException|IOException e) {
    			System.out.println("Ha ocurrido un error al abrir " + currentCvFile);
    			e.printStackTrace();
			}
    	}	
    }

    @FXML
    private void onAcercaDeAction(ActionEvent event) {
    	Stage stage=(Stage)view.getScene().getWindow();

    	Alert alert=new Alert(AlertType.INFORMATION);
    	
    	alert.initModality(Modality.APPLICATION_MODAL);
    	alert.initOwner(stage);
    	
    	alert.setTitle("Acerca de MiCV");
    	alert.setHeaderText("Proyecto de Desarrollo de Interfaces, 2ºDAM, 2020");
    	alert.setContentText("Programa que permite guardar curriculums con datos recogidos "
    			+ "por interfaz en formato JSON con extensión customizada");   
    	alert.showAndWait();
    }

    @FXML
    private void onGuardarAction(ActionEvent event) {

    	if(currentCvFile==null) 
    		guardarComo();
    	else {
    		try {
    			JSONUtils.toJson(currentCvFile, cv.get());
			} catch (JsonSyntaxException|IOException e) {
				System.out.println("Ha ocurrido un error al guardar " + currentCvFile);
				e.printStackTrace();
			}
    	}
    }

    @FXML
    private void onGuardarComoAction(ActionEvent event){
    	guardarComo();
    }
    
    private void guardarComo() {
    	Stage stage=(Stage)view.getScene().getWindow();
    	FileChooser fileChooser=new FileChooser();
    	fileChooser.setTitle("Guardar un curriculum");
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Curriculum Vitae (*.cv)",".cv"));
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos","*.*"));
    	currentCvFile=fileChooser.showSaveDialog(stage);
    	
    	if(currentCvFile!=null) {
    		try {
    			JSONUtils.toJson(currentCvFile, cv.get());
			} catch (JsonSyntaxException|IOException e) {
				System.out.println("Ha ocurrido un error al guardar " + currentCvFile);
				e.printStackTrace();
			}
    	}
    }

    @FXML
    /**
     * Muestra una alerta de tipo confirmación.
     * Si el usuario pulsa aceptar crea un nuevo CV
     * @param event
     */
    private void onNuevoAction(ActionEvent event) {
    	Alert alert=nuevoAlerta();
    	Optional<ButtonType>result=alert.showAndWait();
    	if(result.get()==ButtonType.OK)
    		cv.set(new CV());
    }

    @FXML
    private void onSalirAction(ActionEvent event) {
		Platform.exit();
    }
    
    /**
     * Retorna una alerta de tipo confirmación que pregunta al usuario si quiere introducir o no un curriculum
     * @return Alert
     */
    private Alert nuevoAlerta() {
    	
    	Stage stage=(Stage)view.getScene().getWindow();
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	
    	alert.initModality(Modality.APPLICATION_MODAL);
    	alert.initOwner(stage);
    	
    	alert.setTitle("Nuevo curriculum");
    	alert.setHeaderText("¿Quiere crear un nuevo curriculum?");
    	alert.setContentText("Si crea un nuevo curriculum perderá los progresos no guardados en el curriculum actual");
    	
    	return alert;
    }
}
