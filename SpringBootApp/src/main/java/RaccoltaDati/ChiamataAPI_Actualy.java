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

import java.util.Scanner;

public class ChiamataAPI_Actualy{
	
	Scanner input = new Scanner(System.in);
	
	private int id;
	
	private double temp_min;
	private double temp_max;
	private double tempo;
	
	private Long tempoLong;
	private Long temp_maxLong;
	private Long temp_minLong;
	
	RicercaID dati = new RicercaID();
	
//costruttore	
	public ChiamataAPI_Actualy() {
		
		
	}
	
	public void Chiamata(String nome) {
		
	
		JSONParser parser = new JSONParser();
		
		JSONObject temp = null;
	
		try {
		
			id = dati.lettura(nome);
			System.out.println(id);
		
			URL oracle = new URL("api.openweathermap.org/data/2.5/weather?id=" + id + "&appid=225a3d7ea81634ed4bb00b4cb10f4397");
		
			HttpsURLConnection link = (HttpsURLConnection) oracle.openConnection();
			link.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		
			BufferedReader input = new BufferedReader(new InputStreamReader(link.getInputStream()));
		
			//JSONObject temp = null;
			String inputLine;
			while((inputLine = input.readLine()) != null) {
			
				JSONObject citta = (JSONObject) parser.parse(inputLine);
			
				temp = (JSONObject) citta.get("main");
			
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
			
			
		
		 } catch (FileNotFoundException e) {
	            e.printStackTrace();
	     } catch (IOException e) {
	            e.printStackTrace();
	     } catch (ParseException e) {
	            e.printStackTrace();
	     }
		 
	}
	
	public double GetTempo() {
		System.out.println(tempo);
		return tempo;
	}
	
	public double GetTemp_max() {
		return temp_max;
	}
	
	public double GetTemp_min() {
		return temp_min;
	}
}


