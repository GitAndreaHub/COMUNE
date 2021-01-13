package SpringBootApp.Controller;

import org.json.simple.JSONObject;

import GestioneDati.SelezioneCitta;
import SpringBootApp.Operazioni.GestioneDatiActualy;
import SpringBootApp.Operazioni.GiornoCasuale;
import SpringBootApp.Operazioni.RangePersonalizzabile;
import SpringBootApp.Operazioni.Range_AllCity;

/**
 * Classe Main si occupa di gestire i dati metereologici in uscita, inserendoli nei corrispondenti JSONObject.
 * 
 * @author Andrea Tassi.
 *
 */

public class Main {
	
	GestioneDatiActualy actualy = new GestioneDatiActualy();
	GiornoCasuale GC = new GiornoCasuale();
	RangePersonalizzabile RP = new RangePersonalizzabile();
	Range_AllCity RAC = new Range_AllCity();
	SelezioneCitta SC = new SelezioneCitta();
	
	private int SingoloGiorno;
	private String Nome;
	private int FinoAl;
	
	/**
	 * Costruttore.
	 * 
	 * @param n1 Dal Giorno.
	 * @param n2 Al Giorno.
	 * @param nome Nome della citta inserita dall'utente.
	 */
	
	public Main(int n1, int n2, String nome){
		
		this.Nome = nome;
		this.SingoloGiorno = n1;
		this.FinoAl = n2;
		
	}
	
	/**
	 * Metodo RitornoDatiActualy che richiamando la classe "GestioneDatiActualy" inserisce tutti i dati in 
	 * un JSONObject.
	 * 
	 * @param nome Nme della citta.
	 * @return Dati JSONObject con all'interno i dati metereologici giornalieri.
	 */
	
	@SuppressWarnings("unchecked")
	public JSONObject RitornoDatiActualy(String nome) {
		
		actualy.TemperaturaCorrente(nome);
		
		JSONObject Dati = new JSONObject();

		Dati.put("La temperatura attuale di " + nome, actualy.GetTemp());
		Dati.put("La temperatura massima di " + nome, actualy.GetMax());
		Dati.put("La temperatura minima di " + nome, actualy.GetMin());
		Dati.put("La varianza massima di " + nome, actualy.GetVar()); 
		
		return Dati;
		
	} 
	
	/**
	 * Metodo SingleDay che inserisce all'interno di un JSONObject "casuale" i dati metereologici relativi ad
	 * un citta in un giorno scelti dall'atente.
	 * 
	 * @return casuale JSONObject con all'interno i dati metereologici di una citta in un giorno tra i 20.
	 */
	
	@SuppressWarnings("unchecked")
	public JSONObject SingleDay() {
		
		JSONObject casuale = new JSONObject();
		
		casuale.put("La temperatura media", GC.TempGiornoCasuale(SingoloGiorno, Nome));
		
		return casuale;
		
	}
	
	/**
	 * Metodo Range_PersSingle che inserisce all'interno del JSONObject "Range" i dati metereologici
	 * relativi ad una citta' in un determinato range scelti dall'utente.
	 * 
	 * @return Range JSONObject con all'interno i dati metereologici di una citta 
	 * in un range personalizzabile di max 20 giorni.
	 */
	
	@SuppressWarnings("unchecked")
	public JSONObject Range_PersSingle() {
		
		RP.Range(SingoloGiorno, FinoAl, Nome);
		
		JSONObject Range = new JSONObject();
		
		Range.put("La media delle temperature", RP.GetMedia());
		Range.put("La temeratura minima", RP.GetMin());
		Range.put("La temperatura massima", RP.GetMax());
		Range.put("La varianza massima", RP.GetVarianza());
		
		return Range;
		
	}
	
	/**
	 * Metodo Range_PersTotal che inserisce all'interno del JSONObject "Total" i dati metereologici
	 * relativi a tutte e 10 le citta marchigiane in un determinato range scelto dall'utente.
	 * 
	 * @return Total JSONObject con all'interno i dati metereologici di tutte e 10 le citta marchigiane 
	 * in un range personalizzabile di max 20 giorni.
	 */
	
	@SuppressWarnings("unchecked")
	public JSONObject Range_PersTotal() {
		
		RAC.AllCity(SingoloGiorno, FinoAl);
		
		JSONObject Total = new JSONObject();
		
		Total.put("1-La media di tutte le temperature", RAC.MediaMedie());
		Total.put("2-Temperatura piu' bassa", RAC.Minimi());
		Total.put("2--Appartiene a", SC.Citta(RAC.GetPosMin()));
		Total.put("3-La temperatura piu alta", RAC.Massimi());
		Total.put("3--Appartiene a", SC.Citta(RAC.GetPosMax()));
		Total.put("4-La varianza massima", RAC.Varianze());
		Total.put("4--Appartiene a", SC.Citta(RAC.GetPosMaxVar()));
		
		return Total;
		
	}

}
