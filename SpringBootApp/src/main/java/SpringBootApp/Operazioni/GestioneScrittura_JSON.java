package SpringBootApp.Operazioni;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Vector;

import org.json.simple.JSONObject;

import SpringBootApp.Controller.Main;

public class GestioneScrittura_JSON {
	
	Vector<String> citta = new Vector<String>();
	Vector<Double> DATI = new Vector<Double>();
	JSONObject DatiCitta = new JSONObject();
	
	
	public GestioneScrittura_JSON() {
		
		citta.add("Ancona");
		citta.add("Pesaro");
		citta.add("Fano");
		citta.add("Ascoli Piceno");
		citta.add("San Benedetto del Tronto");
		citta.add("Senigallia");
		citta.add("Civitanova Marche");
		citta.add("Macerata");
		citta.add("Jesi");
		citta.add("Fermo");
		
	}
	
	public void GetJSONObject() {
		
		for(int i = 0; i < citta.size(); i++) {
			
			Main main = new Main(0, 0, citta.get(i));
			
			DatiCitta = main.RitornoDatiActualy(citta.get(i));
		
		}
		System.out.println(DatiCitta);
		
	}
	
	public void Scrittura() {
		
		try {
	           
            ObjectOutputStream file_output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("JSON_File_Write.json", true))) {
                
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
