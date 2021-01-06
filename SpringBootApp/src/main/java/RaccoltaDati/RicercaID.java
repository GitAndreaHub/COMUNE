package RaccoltaDati;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Classe che ricerca in un file l'id della città richiesta.
 * 
 * 
 * @author Andrea Tassi
 *
 */
public class RicercaID {
	Scanner input = new Scanner(System.in);
	JSONParser parser = new JSONParser();
	
	private Object ID = null;
	private int Id;

 /**
  * Costruttore Vuoto.
  */
	public RicercaID() {
		
	}
	
	/**
	 * Metodo che legge il file e cerca l'Id correlato al nome inserito.
	 * 
	 * @param nome nome della città di cui vuoi sapere l'id
	 * @return Id Id della città richiesta
	 */
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
