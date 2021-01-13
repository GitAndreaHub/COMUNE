package RaccoltaDati;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Vector;

/**
 * Classe Ricerca_WeeklyTemp che ricerca i dati meteo relativi a un certo arco di tempo
 * all'interno di un file .json.
 * 
 * @author Andrea Tassi
 *
 */
public class Ricerca_WeeklyTemp extends RaccoltaDati {
	Scanner input = new Scanner(System.in);
	JSONParser parser = new JSONParser();
	
	
	private Double appoggio;
	protected Vector<Double> temp = new Vector<Double>();
	
	
	/**
	 * Costruttore vuoto.
	 * 
	 */
	public Ricerca_WeeklyTemp() {
		
	}
	
	/**
	 * Metodo RaccoltaTemperature che riceve un nome di tipo String che serve per 
	 * ricercare all'interno del file "WeeklyTemp_File.json" la citta richiesta dall'utente 
	 * per ottenere in vari dati, e sistemarli poi in un vettore "temp".
	 * 
	 * @param nome Nome della citta richiesta dall'utente
	 */
	public void RaccoltaTemperature(String nome) {
		
		try {
			
				Object obj = parser.parse(new FileReader("WeeklyTemp_File.json"));
				
				JSONObject temperature = (JSONObject) obj;
				JSONObject citta = (JSONObject) temperature.get(nome);
				
				int conta = 1;
				for(int i=0; i < 20; i++) {
					
					
					appoggio = Double.parseDouble(citta.get("temp" + conta).toString());
					dati.add(i, appoggio);
					conta++;
					appoggio = 0.0;
					
				}
				
		} catch(FileNotFoundException e) {
			System.out.println("Errore lettura file JSON");
			System.out.println(e);
		} catch (ParseException e) {
           e.printStackTrace();
        } catch (IOException e) {
        	
        }
	}
	
	/**
	 * 
	 * Metodo AzzeramentoDati che pulisce il vettore dati.
	 * 
	 */
	
	public void AzzeramentoDati() {
		dati.clear();
	}
	
	
}
