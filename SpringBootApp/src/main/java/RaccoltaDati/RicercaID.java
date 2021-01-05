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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RicercaID {
	Scanner input = new Scanner(System.in);
	JSONParser parser = new JSONParser();
	
	private int Id = 0;

//costruttore	
	public RicercaID() {
		
	}
	
//getter
	public int lettura(String nome) {
		
		try {
			
			
			
			//FileReader reader = new FileReader("CityIdJSON.json");
			//JSONObject obj = (JSONObject) parser.parse(reader);
			 
			//BufferedReader in = new BufferedReader(new InputStreamReader(null, "CityIdJSON.json"));
			
			//Scanner input = new Scanner(new BufferedReader(new FileReader("CityIdJSON.json")));
			
			/*-----JSONObject obj = (JSONObject) parser.parse(new FileReader("/Users/utente/git/repository/SpringBootApp/CityIdJSON.json"));
			
			//String stringa;
			//while( (stringa = in.readLine()) != null ) {
			for(int i = 0; i < obj.size(); i++) {	
				
				//JSONObject citta = (JSONObject) input.get(nome);
				
				JSONObject citta = (JSONObject) obj.get(nome);
				
				
				Id = (int) citta.get("Id");
				
				System.out.println(Id); ------*/
				
				/*JSONObject citta = (JSONObject) parser.parse(stringa);
				
				JSONObject name= (JSONObject) citta.get(nome);
				
				Id = (int) name.get("Id"); 
				System.out.println(Id);*/
				
			
			
				//LETTURA PRESO DA FILE MASSIMO
				
				/*ObjectInputStream file_input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("CityIdJSON.json")));
				
				this.jo = (JSONObject) file_input.readObject(); 
				
				JSONObject citta = (JSONObject) jo.get(nome);
				
				Id = (int) citta.get("Id");
				
				file_input.close(); */
			
			
				//PRIMO METODO CHE COMPARE IN RETE
				
				Object obj = parser.parse(new FileReader("CityIdJSON.json"));
				
				JSONObject JsonObject = (JSONObject) obj;
				
				System.out.println(JsonObject);
				
				JSONObject citta = (JSONObject) JsonObject.get(nome);
				
				System.out.println(citta);
				Id = (int) citta.get("Id");
				
				//Id = (int) JsonObject.get("Ancona");
				System.out.println("Citta ID: " + Id);
				
				
				/*Id = (int) citta.get("Id");
				System.out.println(Id); */
				
				
		
		/*}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} */
			
		
		
		
		
			
			
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
