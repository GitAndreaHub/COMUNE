package RaccoltaDati;

import java.io.BufferedReader;

/**
 * Classe che esegue la chiamata API da OpenWeather.
 * 
 * @author Andrea Tassi
 */


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Scanner;
import java.util.Vector;

public class ChiamataAPI_Actualy extends RaccoltaDati{
	
	Scanner input = new Scanner(System.in);
	
	private int Id;
	
	private double temp_min;
	private double temp_max;
	private double tempo;
	
	private Long tempoLong;
	private Long temp_maxLong;
	private Long temp_minLong;
	
	RicercaID ID = new RicercaID();
	Vector<Double> dati = new Vector<Double>();
	
	/**
	 * Costruttore che prende in ingresso il vettore "dati" di tipo Double, 
	 * definito come "Dati".
	 * 
	 * @param Dati
	 */
		
	public ChiamataAPI_Actualy(Vector<Double> Dati) {
		super(Dati);
	}
	
	/**
	 * Metodo RaccoltaTemperature che riceve un nome di tipo String, utilizzato per 
	 * richiamare la classe RicercaID e ottenere cosi l'Id della citta inserita dall'utente.
	 * Si assegnano poi i dati presi dalla chiamata API all'interno del vettore "dati".
	 * 
	 * @param nome nome della citta di cui si vuole sapere l'Id.
	 */
	
	public void RaccoltaTemperature(String nome) {
		
	
		JSONParser parser = new JSONParser();
		
	
		try {
		
			Id = ID.lettura(nome);
		
			URL oracle = new URL("https://api.openweathermap.org/data/2.5/weather?id=" + Id + "&appid=225a3d7ea81634ed4bb00b4cb10f4397");
		
			HttpsURLConnection link = (HttpsURLConnection) oracle.openConnection();
			link.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		
			BufferedReader input = new BufferedReader(new InputStreamReader(link.getInputStream()));
			
			//JSONObject temp = null;
			String inputLine;
			while((inputLine = input.readLine()) != null) {
			
				JSONObject citta = (JSONObject) parser.parse(inputLine);
			
				JSONObject temp = (JSONObject) citta.get("main");
			
				if(temp.get("temp") instanceof Double) tempo = (double) temp.get("temp");
				else {
					tempoLong = (Long) temp.get("temp"); 
					tempo = tempoLong.doubleValue();
				}
				
				if(temp.get("temp_max") instanceof Double) temp_max = (double) temp.get("temp_max");
				else {
					temp_maxLong = (Long) temp.get("temp_max"); 
					temp_max = temp_maxLong.doubleValue();
				}
				
				if(temp.get("temp_min") instanceof Double) temp_min = (double) temp.get("temp_min");
				else {
					temp_minLong = (Long) temp.get("temp_min");
					temp_min = temp_minLong.doubleValue();
				}
				
			
			}
			
			dati.add(0, tempo);
			dati.add(1, temp_max);
			dati.add(2, temp_min);
			
		
		 } catch (FileNotFoundException e) {
	            e.printStackTrace();
	     } catch (IOException e) {
	            e.printStackTrace();
	     } catch (ParseException e) {
	            e.printStackTrace();
	     } catch (NullPointerException e) {
	    	 	e.printStackTrace();
	     }
		
	}
	
	/**
	 * Metodo Getter.
	 * 
	 * @return dati vettore dati di tipo Double.
	 * 
	 */

	public Vector<Double> GetDati() {
		return dati;
	}	
}


