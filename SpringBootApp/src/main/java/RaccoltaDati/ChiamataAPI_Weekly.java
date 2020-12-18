package RaccoltaDati;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Vector;

public class ChiamataAPI_Weekly {
	
	RicercaID ricerca = new RicercaID();
	Time_Unix Time = new Time_Unix();
	
	private int CurrentTimeUnix;
	private double lon;
	private double lat;
	
	public ChiamataAPI_Weekly() {
		
	}
	
	public Vector<Double> Chiamata_Weekly() {
		
		JSONParser parser = new JSONParser();
		
		Vector<Double> temp = new Vector<Double>();
		
		for(int u=0; u < 5; u++) {
		
			try {
			
				CurrentTimeUnix = Time.Get_TimeUnix();
				CurrentTimeUnix -= 86400; //Si parte dal giorno precedente, altrimente la prima iterazione sara' relativa al giorno stesso e non precedente;
				
				lat = ricerca.GetLatitudine();
				lon = ricerca.GetLongitudine();		
		
				URL oracle = new URL("https://api.openweathermap.org/data/2.5/onecall/timemachine?lat=" + lat + "&lon=" + lon + "&dt=" + CurrentTimeUnix + "&appid=225a3d7ea81634ed4bb00b4cb10f4397");
		
				HttpsURLConnection link = (HttpsURLConnection) oracle.openConnection();
				link.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		
				BufferedReader input = new BufferedReader(new InputStreamReader(link.getInputStream()));
		
			
				String inputLine;
				while((inputLine = input.readLine()) != null) {
			
					JSONObject TotalObject = (JSONObject) parser.parse(inputLine);
				
			
					JSONArray Hourly = (JSONArray) TotalObject.get("hourly");
				
				
					int i=0;
					for(Object o : Hourly) {
					
						JSONObject H = (JSONObject) o;
						temp.set(i, (Double) H.get("temp"));
						i++;
					}
				
				}
			
			} catch (FileNotFoundException e) {
	            	e.printStackTrace();
			} catch (IOException e) {
	            	e.printStackTrace();
			} catch (ParseException e) {
	            	e.printStackTrace();
			}
		
			CurrentTimeUnix -= 86400;
		
		}
		
		return temp;
		
	}
	
}
