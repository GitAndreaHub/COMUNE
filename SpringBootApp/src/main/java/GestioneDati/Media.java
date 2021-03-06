package GestioneDati;
import java.util.Vector;
/**
 * Classe che ci permette di calcolare la media; è una classe legata all'interfaccia OperazionesuVett.
 * 
 * @author Stefano Martelli
 *
 */
public class Media implements OperazionisuVett{
	private double media;
	/**
	 * Costruttore Vuoto.
	 */
	public Media() {
		
	}
	
	/**
	 * Metodo che ti permette, dato un vettore, di calcolare la media.
	 * 
	 * @param v1 Vettore con dati di tipo double
	 */
	public void OpsuVett(Vector<Double>v1){
		int lunghezza= v1.size();
		int somma=0;
		for(int i=0;i<lunghezza; i++) {
			somma+=v1.get(i);
		}
		media=somma/lunghezza;
	}
	/**
	 * Metodo che riporta il valore della media.
	 * 
	 * @return media Valore medio relativo al vettore prima inserito
	 */
	public double GetMedia() {
		return media;
	}

}
