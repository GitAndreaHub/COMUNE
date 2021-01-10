package SpringBootApp.Operazioni;
import RaccoltaDati.ChiamataAPI_Actualy;

import java.util.Vector;

import GestioneDati.Varianza;
/**
 * Classe per gestire e ritornare la temperatura attuale di una città.
 * 
 * @author Stefano Martelli
 *
 */
public class GestioneDatiActualy {
	
	private double Temp;
	private double Min;
	private double Max;
	private double Varianza;
	Vector<Double> appoggio=new Vector<Double>();
	
	
	/**
	 * Costruttore per Inizializzare i dati.
	 * 
	 * @param Temp Temperatura riportata in double
	 * @param Max Valore di temperatura massima 
	 * @param Min Valore di temperatura minima
	 * @param Varianza Differenza fra minimo e massimo
	 */
	public GestioneDatiActualy(){
		
	}
	
	/**
	 * Metodo che trova la temperatura attuale, la Min, Max e la Varianza richiamando la classe ChiamataAPI_Actualy.
	 * 
	 * @param Nome nome della città di cui si vuole sapere la temperatura attuale
	 */
	public void TemperaturaCorrente(String Nome) {
		ChiamataAPI_Actualy chiamata= new ChiamataAPI_Actualy(appoggio);
		Varianza Var= new Varianza();
		chiamata.RaccoltaTemperature(Nome);
		appoggio=chiamata.GetDati();
		Temp=appoggio.get(0);
		Min=appoggio.get(1);
		Max=appoggio.get(2);
		Varianza=Var.CalcoloVarianza(Min, Max);
	}
	
	/**
	 * Metodo che riporta la temperatura attuale.
	 * 
	 * @return Temp Temperatura riportata in double
	 */
	public double GetTemp() {
		return Temp;
	}
	
	/**
	 * Metodo che riporta la temperatura massima.
	 * 
	 * @return Max Valore di temperatura massima
	 */
	public double GetMax() {
		return Max;
	}
	
	/**
	 * Metodo che riporta la temperatura minima.
	 * 
	 * @return Min Valore di temperatura minima
	 */
	public double GetMin() {
		return Min;
	}
	
	/**
	 * Metodo che riporta la varianza.
	 * 
	 * @return Varianza Differenza fra minimo e massimo
	 */
	public double GetVar() {
		return Varianza;
	}
	

}
