package GestioneDati;

/**
 * Classe che ci permetti di calcolare la Varianza.
 * @author Stefano Martelli
 *
 */
public class Varianza {
	
	private double Var;
	
	/**
	 * Costruttore Vuoto.
	 */
	public Varianza() {
		
	}
	
	
	/**
	 * Metodo che calcola e riporta la varianza, dati in input due valori Int.
	 * 
	 * @param n1 Valore Int
	 * @param n2 Valore Int
	 * @return Var Varianza dei due interi inseriti
	 */
	public double CalcoloVarianza(double n1, double n2) {
		if(n1>=n2) Var=n1-n2;
		else Var=n2-n1;
		return Var;
	}
	

}
