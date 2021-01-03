package RaccoltaDati;
import java.util.Vector;

public abstract class RaccoltaDati {
	Vector<Double> dati = new Vector<Double>();
	
	
	
	public RaccoltaDati(Vector<Double> Dati) {
		this.dati=Dati;
	}
	
	public abstract void RaccoltaTemperature(String nome);
	
	public Vector<Double> GetDati(){
		return dati;
	}

}
