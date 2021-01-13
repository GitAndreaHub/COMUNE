package GestioneDati;
import java.util.Vector;

/**
 * Classe che ci permette di calcolare il minimo, il massimo e la loro posizione nel vettore;
 * è una classe legata all'interfaccia OperazionesuVett.
 * 
 * @author Stefano Martelli
 *
 */


public class MinMax implements OperazionisuVett{
	private double Min,Max;
	private int PosMin, PosMax;
	
	
	
	/**
	 * Costruttore vuoto
	 */
	public MinMax() {
		
	}
	
	/**
	 * Metodo che ti permette, dato un vettore, di calcolare il minimo, il massimo e la loro posizione nel vettore.
	 * 
	 * @param v1 Vettore con dati di tipo double
	 */
	public void OpsuVett(Vector<Double>v1) {
		int lunghezza= v1.size();
		Min=v1.get(0);
		Max=v1.get(0);
		for(int i=0; i<lunghezza; i++) {
			if(v1.get(i)<Min) {
				Min=v1.get(i);
				PosMin=i;
			}
			if(v1.get(i)>Max) {
				Max=v1.get(i);
				PosMax=i;
			}
		}
		
	}
	
	/**
	 * Metodo che riporta il valore del minimo.
	 * 
	 * @return Min Valore più basso all'interno del vettore
	 */
	public double GetMin() {
		return Min;
	}
	
	/**
	 * Metodo che riporta il valore del massimo.
	 * 
	 * @return Max Valore più alto all'interno del vettore
	 */
	public double GetMax() {
		return Max;
	}
	
	/**
	 * Metodo che riporta il valore PosMax.
	 * 
	 * @return PasMax Valore della posizione di Max
	 */
	public int GetPosMax() {
		return PosMax;
	}
	
	/**
	 * Metodo che riporta il valore PosMin.
	 * 
	 * @return PasMin Valore della posizione di Min
	 */
	public int GetPosMin() {
		return PosMin;
	}
	

}
