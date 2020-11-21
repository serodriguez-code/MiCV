package dad.miCV.conocimiento;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conocimiento {

	//FALTA IMPLEMENTAR NIVEL E IDIOMA
	StringProperty denominacion=new SimpleStringProperty();
	
	
	public Conocimiento() {
		
	}
	public Conocimiento(String denominacion) {
		this.denominacion.set(denominacion);
	}
	
	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	
	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	
	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	

	
	
}
