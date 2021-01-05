package SpringBootApp.Operazioni;
import RaccoltaDati.*;
import java.util.Vector;

/**
 * Classe per gestire e ritornare i dati delle temperature attuali di una città.
 * 
 * @author Stefano Martelli
 *
 */
public class GiornoCasuale {
	
	Ricerca_WeeklyTemp ricerca= new Ricerca_WeeklyTemp(null);
	private Vector<Double> temp=new Vector<Double>();
	/**
	 * Costruttore Vuoto.
	 */
	public GiornoCasuale() {
		
	}
	
	public double TempGiornoCasuale(int n, String nome) {
		ricerca.RaccoltaTemperature(nome);
		temp.addAll(ricerca.GetDati());
		return temp.get(n);
	}
	
	
	
}
