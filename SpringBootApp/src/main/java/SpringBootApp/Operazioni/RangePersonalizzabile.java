package SpringBootApp.Operazioni;
import java.util.Vector;
import RaccoltaDati.Ricerca_WeeklyTemp;
import GestioneDati.*;

/**
 * Classe RangePersonalizzabile che gestisce i dati di una singola citta relative ad un 
 * range personalizzabile.
 * 
 * @author Andrea Tassi 
 *
 */

public class RangePersonalizzabile {
	
	Ricerca_WeeklyTemp DatiTemp= new Ricerca_WeeklyTemp(null);
	Vector<Double> temperature = new Vector<Double>();
	Vector<Double> temperaturefinali = new Vector<Double>();
	Media metodomedia=new Media();
	MinMax metodominmax=new MinMax();
	Varianza metodovarianza= new Varianza();
	private double Media;
	private double Min;
	private double Max;
	private double Varianza;
	
	/**
	 * Costruttore vuoto.
	 * 
	 */
	
	public RangePersonalizzabile() {
		
		
	}
	
	/**
	 * Metodo Range che prende i valori n1, n2 e il nome della citta'. Utilizza poi la 
	 * classe WeeklyTemp.java per raccogliere i dati relativi alla citta' inserita 
	 * dall'utente.
	 * 
	 * @param n1 Dal giorno n1.
	 * @param n2 Al giorno n2.
	 * @param nome Nome della citta richiesta dall'utente.
	 */
	
	public void Range(int n1, int n2, String nome){
		DatiTemp.RaccoltaTemperature(nome);
		temperature.addAll(DatiTemp.GetDati()); //unisce i due vettori in temperature, mettendo Temp "sotto" temperature
		int conta=0;
		for(int i=n1-1; i<n2; i++) {
			temperaturefinali.set(conta, temperature.get(i));
			conta++;
		}
		metodomedia.OpsuVett(temperaturefinali);
		Media=metodomedia.GetMedia();
		metodominmax.OpsuVett(temperaturefinali);
		Max=metodominmax.GetMax();
		Min=metodominmax.GetMin();
		Varianza=metodovarianza.CalcoloVarianza(Min, Max);
	}
	
	/**
	 * Metodo GetMedia che restituisce la media.
	 * 
	 * @return Media media delle temperature nel range di tempo
	 */
	
	public double GetMedia() {
		return Media;
	}
	
	/**
	 * Metodo GetMin che restituisce il valore minimo.
	 * 
	 * @return Min valore minimo tra tutte le temperature della citta' nel range di tempo
	 */
	
	public double GetMin() {
		return Min;
	}
	
	/**
	 * Metodo GetMin che restituisce il valore massimo.
	 * 
	 * @return Max valore massimo tra tutte le temperature della citta' nel range di tempo
	 */
	
	public double GetMax() {
		return Max;
	}
	
	/**
	 * Metodo GetVarianza che restituisce la varianza massima.
	 * 
	 * @return Varianza valore varianza massima
	 */
	
	public double GetVarianza() {
		return Varianza;
	}

}
