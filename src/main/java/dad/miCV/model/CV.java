package dad.miCV.model;

import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class CV {
	
	private ObjectProperty<Personal> personal=new SimpleObjectProperty<Personal>(new Personal());

	public final ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}
	

	public final Personal getPersonal() {
		return this.personalProperty().get();
	}
	

	public final void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}
	
//	public static void main(String[] args) {
//		CV cv=new CV();
//		cv.getPersonal().setNombre("Chuck");
//		cv.getPersonal().setApellidos("Norris");
//		cv.getPersonal().getNacionalidades().add(new Nacionalidad("América, Fuck Yeah"));
//		
//		Gson gson =
//			FxGson.fullBuilder()
//			.setPrettyPrinting()
//			.create();
//		
//		String json=gson.toJson(cv);
//		System.out.println(json);
//	}
	

}
