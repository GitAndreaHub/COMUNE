package RaccoltaDati;
import java.util.Scanner;

import java.io.BufferedReader;
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
	
	Vector<Double> temp = new Vector<Double>();
	
	private Long Temp;
	
	/**
	 * Costruttore che prende in ingresso il vettore "dati" di tipo Double, 
	 * definito come "Dati".
	 *  
	 * @param Dati Vettore con dati di tipo Double
	 * 
	 */
	public Ricerca_WeeklyTemp(Vector<Double> Dati) {
		super(Dati);
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
				//Scanner input = new Scanner(new BufferedReader(new FileReader("WeeklyTemp_File.json")));
				
				//------String lettura = null;
				/*while( (input.hasNext()) ) {
					
					JSONObject temperature = (JSONObject) parser.parse(lettura);
					JSONObject citta = (JSONObject) temperature.get(nome);
					
					int conta = 1;
					for(int i=0; i < 5; i++) {
						
					    if(citta.get("temp" + conta) instanceof Double) temp.set(i, Double.parseDouble(citta.get("temp" + conta).toString()));
					    else {
					    	Temp = Long.parseLong(citta.get("temp" + conta).toString()); 
					    	temp.set(i, Temp.doubleValue()); 
					    }
						Temp = null;
						conta++;
					}
					
				} */
				
				//JSONObject temperature = (JSONObject) parser.parse(lettura);
				JSONObject temperature = (JSONObject) obj;
				JSONObject citta = (JSONObject) temperature.get(nome);
				
				int conta = 1;
				for(int i=0; i < 20; i++) {
					System.out.println(temp);
					Double get;
					get = Double.parseDouble(citta.get("temp1" + conta).toString());
				    if(citta.get("temp" + conta) instanceof Double) temp.set(i, get);
				    else {
				    	Temp = Long.parseLong(citta.get("temp" + conta).toString()); 
				    	temp.set(i, Temp.doubleValue()); 
				    }
					Temp = null;
					conta++;
				}
				
				
				
				
		} catch(FileNotFoundException e) {
			System.out.println("Errore lettura file JSON");
			System.out.println(e);
		} catch (ParseException e) {
           e.printStackTrace();
        } catch (IOException e) {
        	
        }
	}

}
