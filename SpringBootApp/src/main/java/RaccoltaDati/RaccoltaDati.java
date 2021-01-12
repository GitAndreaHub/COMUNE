package RaccoltaDati;
import java.util.Vector;

/**
 * Classe astratta estesa alle classi con compito di raccogliere le temperature, da API o da file JSON.
 * 
 * @author Stefano Martelli
 *
 */
public abstract class RaccoltaDati {
	protected Vector<Double> dati = new Vector<Double>();
	
	
	/**
	 * Costruttore per inizializzare il vettore che conterrà i dati richiesti.
	 * 
	 * @param Dati Vettore con dati di tipo Double
	 */
	public RaccoltaDati() {
		
	}
	
	/**
	 * Metodo Astratto, che verrà riscritto nelle classi in cui viene estesta questa classe, e servirà per racccogliere
	 * le temperature della città richiesta.
	 * 
	 * @param nome Nome della città di cui si richiedono i dati
	 */
	public abstract void RaccoltaTemperature(String nome);
	
	/**
	 * Metodo Getter che ritorno il vettore "Dati" di tipo double.
	 * 
	 * @return Dati Vettore con dati di tipo Double
	 */
	public Vector<Double> GetDati(){
		return dati;
	}
	

}
