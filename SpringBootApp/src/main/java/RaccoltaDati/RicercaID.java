package RaccoltaDati;
import java.util.Scanner;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RicercaID {
	Scanner input = new Scanner(System.in);
	JSONParser parser = new JSONParser();
	
	private int id;

//costruttore	
	public RicercaID() {
		
	}
	
//getter
	public int lettura(String nome) {
		
		
		try {
			
			//BufferedReader reader = new BufferedReader (new FileReader ("CityId.json"));
			Scanner input = new Scanner(new BufferedReader(new FileReader("CityId.json")));
			
			//Object obj = parser.parse(new FileReader("CityId.json"));
			//BufferedReader file_input = new BufferedReader(new InputStreamReader(null,"CityId.json"));
			
			String stringa = null;
			while( (input.hasNext())) {
				
				JSONObject citta = (JSONObject) parser.parse(stringa);
				
				//JSONObject Name = name;
				
				JSONObject name= (JSONObject) citta.get(nome);
				
				//JSONObject id = (JSONObject) nome.get("id");
				
				id = (int) name.get("id");
					
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("Errore lettura file JSON");
			System.out.println(e);
		}  catch (ParseException e) {
            e.printStackTrace();
        }
		
		return id;
		
	}
	
}
