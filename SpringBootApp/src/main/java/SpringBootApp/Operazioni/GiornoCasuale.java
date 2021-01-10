package SpringBootApp.Operazioni;
import RaccoltaDati.*;
import java.util.Vector;

/**
 * Classe per gestire e ritornare la temperatura di una città in unn giorno scelto dall'utente.
 * 
 * @author Stefano Martelli
 *
 */
public class GiornoCasuale {
	
	Ricerca_WeeklyTemp ricerca= new Ricerca_WeeklyTemp();
	private Vector<Double> temp=new Vector<Double>();
	
	/**
	 * Costruttore Vuoto.
	 */
	public GiornoCasuale() {
		
	}
	
	/**
	 * Metodo che ricerca la temperatura del giorno richiesto relativo alla città inserita.
	 * 
	 * @param n Int per indicare il numero del giorno
	 * @param nome Nome della città richiesta
	 * @return temp.get(n) La temperatura richiesta 
	 */
	public double TempGiornoCasuale(int n, String nome) {
		ricerca.RaccoltaTemperature(nome);
		temp.addAll(ricerca.GetDati());
		return temp.get(n);
	}
	
	
	
}
