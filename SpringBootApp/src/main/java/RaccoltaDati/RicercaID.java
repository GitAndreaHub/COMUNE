package RaccoltaDati;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.lang.ProcessHandle.Info;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RicercaID {
	Scanner input = new Scanner(System.in);
	JSONParser parser = new JSONParser();
	
	private Object ID = null;
	private int Id;

//costruttore	
	public RicercaID() {
		
	}
	
//getter
	public Integer lettura(String nome) {
		
		try {
				
				Object obj = parser.parse(new FileReader("CityIdJSON.json"));
				
				JSONObject JsonObject = (JSONObject) obj;
				
				JSONObject citta = (JSONObject) JsonObject.get(nome);
				
				Id = Integer.parseInt(citta.get("Id").toString()); 
					
		} catch(FileNotFoundException e) {
			System.out.println("Errore lettura file JSON");
			System.out.println(e);
		}  catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
        	
        }
		
		return Id;
		
	}
	
}
