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
	
	private int PosizioneMin;
	private int PosizioneMax; 
	private int PosMassimaVarianza;
	
	/**
	 * Costruttore vuoto
	 * 
	 */
	
	public Range_AllCity() {
		
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
		
		RangeP.Range(n1, n2, "Ancona");
		
		VettoreDati.add(0, RangeP.GetMedia());
		VettoreDati.add(1, RangeP.GetMin());
		VettoreDati.add(2, RangeP.GetMax());
		VettoreDati.add(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Pesaro");
		VettoreDati.add(4, RangeP.GetMedia());
		VettoreDati.add(5, RangeP.GetMin());
		VettoreDati.add(6, RangeP.GetMax());
		VettoreDati.add(7, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Fano");
		VettoreDati.add(8, RangeP.GetMedia());
		VettoreDati.add(9, RangeP.GetMin());
		VettoreDati.add(10, RangeP.GetMax());
		VettoreDati.add(11, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Ascoli Piceno");
		VettoreDati.add(12, RangeP.GetMedia());
		VettoreDati.add(13, RangeP.GetMin());
		VettoreDati.add(14, RangeP.GetMax());
		VettoreDati.add(15, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "San Benedetto del Tronto");
		VettoreDati.add(16, RangeP.GetMedia());
		VettoreDati.add(17, RangeP.GetMin());
		VettoreDati.add(18, RangeP.GetMax());
		VettoreDati.add(19, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Senigallia");
		VettoreDati.add(20, RangeP.GetMedia());
		VettoreDati.add(21, RangeP.GetMin());
		VettoreDati.add(22, RangeP.GetMax());
		VettoreDati.add(23, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Civitanova Marche");
		VettoreDati.add(24, RangeP.GetMedia());
		VettoreDati.add(25, RangeP.GetMin());
		VettoreDati.add(26, RangeP.GetMax());
		VettoreDati.add(27, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Macerata");
		VettoreDati.add(28, RangeP.GetMedia());
		VettoreDati.add(29, RangeP.GetMin());
		VettoreDati.add(30, RangeP.GetMax());
		VettoreDati.add(31, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Jesi");
		VettoreDati.add(32, RangeP.GetMedia());
		VettoreDati.add(33, RangeP.GetMin());
		VettoreDati.add(34, RangeP.GetMax());
		VettoreDati.add(35, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Fermo");
		VettoreDati.add(36, RangeP.GetMedia());
		VettoreDati.add(37, RangeP.GetMin());
		VettoreDati.add(38, RangeP.GetMax());
		VettoreDati.add(39, RangeP.GetVarianza());
		
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
		
		int u = 0;
		for(int i = 1; i < 39; i = i + 4) {
			VettoreMinimi.add(u, VettoreDati.get(i));
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
		}
		
		minmax.OpsuVett(VettoreMinimi);
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
		
		int w = 0;
		for(int i = 2; i < 39; i = i + 4) {
			VettoreVarianze.add(w, VettoreDati.get(i));
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
