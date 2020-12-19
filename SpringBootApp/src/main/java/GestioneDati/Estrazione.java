package GestioneDati;
import java.util.Vector;

public class Estrazione {
	
	//costruttore
	public Estrazione() {
		
	}
	
	//setter
	public Double EstraiDato(Vector<Double>v1, int i) {
		double Dato=0;
		Dato=v1.get(i);
		return Dato;
	}

}
