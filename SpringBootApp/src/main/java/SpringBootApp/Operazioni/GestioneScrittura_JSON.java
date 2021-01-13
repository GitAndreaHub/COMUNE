package SpringBootApp.Operazioni;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import org.json.simple.JSONObject;

import SpringBootApp.Controller.Main;

/**
 * Classe per la scrittura dei dati metereologici giornalieri su file JSON.
 * 
 * @author Andrea Tassi
 *
 */

public class GestioneScrittura_JSON {
	
	Vector<String> citta = new Vector<String>();
	JSONObject DatiCitta = new JSONObject();
	
	/**
	 * 
	 * Costruttore si inizializza il vettore citta.
	 * 
	 */
	
	public GestioneScrittura_JSON() {
		
		citta.add(0, "Ancona");
		citta.add(1, "Pesaro");
		citta.add(2, "Fano");
		citta.add(3, "Ascoli Piceno");
		citta.add(4, "San Benedetto del Tronto");
		citta.add(5, "Senigallia");
		citta.add(6, "Civitanova Marche");
		citta.add(7, "Macerata");
		citta.add(8, "Jesi");
		citta.add(9, "Fermo");
		
	}
	
	/**
	 * 
	 * Metodo GetJSONObject che richiama la classe main, untilizzando il metodo RitornoDatiActualy, 
	 * e salva i dati in un JSONObject.
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public void GetJSONObject() {
		
		for(int i = 0; i < citta.size(); i++) {
			
			Main main = new Main(0, 0, citta.get(i));
			
			DatiCitta.putAll(main.RitornoDatiActualy(citta.get(i)));
			
		}
		System.out.println(DatiCitta);
		
	}
	
	/**
	 * 
	 * Metodo Scrittura si occupa della scrittura del JSONObject "DatiCitta" all'interno del 
	 * JSON file "Dati_giornalieri.json".
	 * 
	 */
	
	public void Scrittura() {
		
		try {
	           
            ObjectOutputStream file_output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Dati_giornalieri.json", true))) {
                
            	protected void writeStreamHeader() throws IOException {
                   
                    reset();
                } 
               
            };
           
            file_output.writeObject(DatiCitta);
            file_output.close();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
