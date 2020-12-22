package RaccoltaDati;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Vector;

public class Ricerca_WeeklyTemp {
	Scanner input = new Scanner(System.in);
	JSONParser parser = new JSONParser();
	
	Vector<Double> temp = new Vector<Double>();
	
//Costruttore	
	public Ricerca_WeeklyTemp() {
		
	}
	/**
	 * 
	 * @param nome
	 * @return
	 */
	
	public Vector<Double> WeeklyTemp(String nome) {
		
		try {
			
				Scanner input = new Scanner(new BufferedReader(new FileReader("JSON_WeeklyTemp.json")));
				
				String lettura = null;
				while( (input.hasNext()) ) {
					
					JSONObject temperature = (JSONObject) parser.parse(lettura);
					JSONObject citta = (JSONObject) temperature.get(nome);
					
					int conta = 1;
					for(int i=0; i < 5; i++) {
						temp.set(i, (Double)citta.get("temp" + conta));
						conta++;
					}
					
				}
				
		} catch(FileNotFoundException e) {
			System.out.println("Errore lettura file JSON");
			System.out.println(e);
		} catch (ParseException e) {
           e.printStackTrace();
        }
		
		return temp;
	}

}
