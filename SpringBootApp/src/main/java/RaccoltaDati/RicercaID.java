package RaccoltaDati;
import java.util.Scanner;


//import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RicercaID {
	Scanner input = new Scanner(System.in);
	JSONParser parser = new JSONParser();
	
	private int Id;

//costruttore	
	public RicercaID() {
		
	}
	
//getter
	public int lettura(String nome) {
		
		
		try {
			
			
			//Scanner input = new Scanner(new BufferedReader(new FileReader("CityIdJSON.json")));
			JSONObject obj = (JSONObject) parser.parse(new FileReader("CityIdJSON.json"));
			
			//String stringa = null;
			while( (input.hasNext())) {
				
				
				JSONObject citta = (JSONObject) obj.get(nome);
				//JSONObject citta = (JSONObject) Jobj.get(nome);
				
				
				Id = (int) citta.get("Id");
				
				System.out.println(Id);
				
				/*JSONObject citta = (JSONObject) parser.parse(stringa);
				
				JSONObject name= (JSONObject) citta.get(nome);
				
				id = (int) name.get("Id"); */
					
			}
			
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
