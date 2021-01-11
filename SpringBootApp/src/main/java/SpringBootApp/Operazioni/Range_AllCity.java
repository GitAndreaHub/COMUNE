package SpringBootApp.Operazioni;

import java.util.Vector;
import GestioneDati.*;

/**
 * Classe Range_AllCity si occupa della gestione del range scelto dall'utente relativa
 * a tutte le città.
 * 
 * @author Andrea Tassi & Stefano Martelli
 *
 */

public class Range_AllCity {
	
	RangePersonalizzabile RangeP = new RangePersonalizzabile();
	Media media=new Media();
	MinMax minmax = new MinMax();
	
	Vector<Double> VettoreDati = new Vector<Double>();
	Vector<Double> VettoreMedie = new Vector<Double>();
	Vector<Double> VettoreMinimi = new Vector<Double>();
	Vector<Double> VettoreMassimi = new Vector<Double>();
	Vector<Double> VettoreVarianze = new Vector<Double>();
	
	private Vector<String> citta = new Vector<String>();
	
	private int PosizioneMin;
	private int PosizioneMax; 
	private int PosMassimaVarianza;
	
	/**
	 * Costruttore vuoto
	 * 
	 */
	
	public Range_AllCity() {
		
		citta.add("Ancona");
		citta.add("Pesaro");
		citta.add("Fano");
		citta.add("Ascoli Piceno");
		citta.add("San Benedetto del Tronto");
		citta.add("Senigallia");
		citta.add("Civitanova Marche");
		citta.add("Macerata");
		citta.add("Jesi");
		citta.add("Fermo");
		
	}
	
	/**
	 * Metodo AllCity che prende due valori, n1 e n2, entrambi di tipo Integer, utilizzati
	 * per definire il renge scelto dall'utente. 
	 * Vengono richiamati ppoi i vettori per ogni citta con il rispettivo range e vengono
	 * poi estrapolati i dati metereologici.
	 * 
	 * @param n1 Dal giorno n1
	 * @param n2 Al giorno n2
	 */
	
	public void AllCity(int n1, int n2) {
		
		int conta = 0;
		
		for(int i = 0; i < citta.size(); i++) {
			
			RangeP.Range(n1, n2, citta.get(i));
			
			VettoreDati.add(conta, RangeP.GetMedia());
			VettoreDati.add(conta + 1, RangeP.GetMin());
			VettoreDati.add(conta + 2, RangeP.GetMax());
			VettoreDati.add(conta + 3, RangeP.GetVarianza());
			
			conta = conta + 4;
		}
	
		System.out.println(VettoreDati);
		
		
	}
	
	/**
	 * Metodo MediaMedie che richiama la classe Media.java e esegue la media
	 * delle temperature di tutte le citta'.
	 * 
	 * @return media.GetMedia() ritorna il valore medio
	 */
	
	public double MediaMedie() {
		
		int u = 0;
		for(int i = 0; i < 39; i = i + 4) {
			VettoreMedie.add(u, VettoreDati.get(i));
			u++;
		}
		media.OpsuVett(VettoreMedie);
		
		return media.GetMedia();
	}
	
	/**
	 * Metodo Minimi che richima la classe MinMax.java e calcola il valore minimo 
	 * tra tutti i minimi di tutte le citta'. Viene poi associata la citta' relativa 
	 * al valore minimo.
	 * 
	 * 
	 * @return minmax.GetMin() ritorna il valore minimo
	 */
	
	public double Minimi() {
		
		int j = 0;
		for(int i = 1; i < 39; i = i + 4) {
			VettoreMinimi.add(j, VettoreDati.get(i));
			j++;
		}
		
		
		minmax.OpsuVett(VettoreMinimi);
		PosizioneMin=minmax.GetPosMin();
		return minmax.GetMin();
	}
	
	/**
	 * Metodo Massimi che richiama la classe MinMax.java e calcola in valore massimo
	 * tra i valori massimi di tutte le citta'. Viene poi associata la citta' relativa 
	 * al valore massimo.
	 * 
	 * @return minmax.GetMax() ritorna il valore massimo
	 */
	
	public double Massimi() {
		
		int g = 0;
		for(int i = 2; i < 39; i = i + 4) {
			VettoreMassimi.add(g, VettoreDati.get(i));
			g++;
		}
		
		minmax.OpsuVett(VettoreMassimi);
		PosizioneMax=minmax.GetPosMax();
		return minmax.GetMax();
	}
	
	/**
	 * Metodo Varianze che richiama la classe MinMax.java e trova la varianza massima
	 * tra le varianze massime di tutte le citta'. Viene poi associata la citta' relativa 
	 * alla varianza massima.
	 * 
	 * @return minmax.GetMax()
	 */
	
	public double Varianze() {
		
		int v = 0;
		for(int i = 3; i < 39; i = i + 4) {
			VettoreVarianze.add(v, VettoreDati.get(i));
			v++;
		}
		
		minmax.OpsuVett(VettoreVarianze);
		PosMassimaVarianza=minmax.GetPosMax();
		return minmax.GetMax();
	}
	
	/**
	 * Metodo GetPosMin viene ritornata la posizione relativa alla temperatura minima
	 * utilizzata poi nella classe SelezioneCitta'.java.
	 * 
	 * @return PosizioneMin
	 */
	
	public int GetPosMin() {
		return PosizioneMin;
	}
	
	/**
	 * Metodo GetPosMax viene ritornata la posizione relativa alla temperatura massima
	 * utilizzata poi nella classe SelezioneCitta'.java.
	 * 
	 * @return PosizioneMax
	 */
	
	public int GetPosMax() {
		return PosizioneMax;
	}
	
	/**
	 * Metodo GetPosMaxVar viene ritornata la posizione relativa alla varianza massima
	 * utilizzata poi nella classe SelezioneCitta'.java.
	 * 
	 * @return PosMassimaVarianza
	 */
	
	public int GetPosMaxVar() {
		return PosMassimaVarianza;
	}

}
