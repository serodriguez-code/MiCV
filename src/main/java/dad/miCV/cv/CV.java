package dad.miCV.cv;

import dad.miCV.conocimiento.Conocimiento;
import dad.miCV.experiencia.Experiencia;
import dad.miCV.formacion.Formacion;
import dad.miCV.personal.Personal;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {
	
	private ObjectProperty<Personal> personal=new SimpleObjectProperty<Personal>(new Personal());
	private ListProperty <Formacion> formaciones=new SimpleListProperty<Formacion>(FXCollections.observableArrayList());
//	private ListProperty <Conocimiento> conocimiento=new SimpleListProperty<Conocimiento>(FXCollections.observableArrayList()); ????
	private ListProperty<Experiencia> experiencia=new SimpleListProperty<Experiencia>(FXCollections.observableArrayList());


	//TODO Contacto titulo experiencia conocimiento
	
	
	public final ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}
	

	public final Personal getPersonal() {
		return this.personalProperty().get();
	}
	

	public final void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}


	public final ListProperty<Formacion> formacionesProperty() {
		return this.formaciones;
	}
	


	public final ObservableList<Formacion> getFormaciones() {
		return this.formacionesProperty().get();
	}
	


	public final void setFormaciones(final ObservableList<Formacion> formaciones) {
		this.formacionesProperty().set(formaciones);
	}


	public final ListProperty<Experiencia> experienciaProperty() {
		return this.experiencia;
	}
	


	public final ObservableList<Experiencia> getExperiencia() {
		return this.experienciaProperty().get();
	}
	


	public final void setExperiencia(final ObservableList<Experiencia> experiencia) {
		this.experienciaProperty().set(experiencia);
	}
	


	
	

	
}
