package RaccoltaDati;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ChiamataAPI_Actualy{
	
	private int id;
	private String nome;
	
	private double temp_min;
	private double temp_max;
	private double tempo;
	
	RicercaID dati = new RicercaID();
	
//costruttore	
	public ChiamataAPI_Actualy() {
		
	}
	
	public void Chiamata(String nome) {
		
	
		JSONParser parser = new JSONParser();
	
		try {
		
			dati.lettura(nome);
			id = dati.GetId();
		
			URL oracle = new URL("api.openweathermap.org/data/2.5/weather?id=" + id + "&appid=225a3d7ea81634ed4bb00b4cb10f4397");
		
			HttpsURLConnection link = (HttpsURLConnection) oracle.openConnection();
			link.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		
			BufferedReader input = new BufferedReader(new InputStreamReader(link.getInputStream()));
		
			String inputLine;
			while((inputLine = input.readLine()) != null) {
			
				JSONObject citta = (JSONObject) parser.parse(inputLine);
			
				JSONObject temp = (JSONObject) citta.get("main");
			
				tempo = (double) temp.get("temp");
				temp_max = (double) temp.get("temp_max");
				temp_min = (double) temp.get("temp_min");
			
			}
		
		 } catch (FileNotFoundException e) {
	            e.printStackTrace();
	     } catch (IOException e) {
	            e.printStackTrace();
	     } catch (ParseException e) {
	            e.printStackTrace();
	     }  
	}
	
	public double GetTempo() {
		return tempo;
	}
	
	public double GetTemp_max() {
		return temp_max;
	}
	
	public double GetTemp_min() {
		return temp_min;
	}
}	
//merge Brench1	


