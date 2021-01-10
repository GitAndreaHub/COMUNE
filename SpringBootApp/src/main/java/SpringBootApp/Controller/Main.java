package SpringBootApp.Controller;

import org.json.simple.JSONObject;

import GestioneDati.SelezioneCitta;
import SpringBootApp.Operazioni.GestioneDatiActualy;
import SpringBootApp.Operazioni.GiornoCasuale;
import SpringBootApp.Operazioni.RangePersonalizzabile;
import SpringBootApp.Operazioni.Range_AllCity;

public class Main {
	
	GestioneDatiActualy actualy = new GestioneDatiActualy();
	GiornoCasuale GC = new GiornoCasuale();
	RangePersonalizzabile RP = new RangePersonalizzabile();
	Range_AllCity RAC = new Range_AllCity();
	SelezioneCitta SC = new SelezioneCitta();
	
	private int SingoloGiorno;
	private String Nome;
	private int FinoAl;
	
	public Main(int n1, int n2, String nome){
		
		this.Nome = nome;
		this.SingoloGiorno = n1;
		this.FinoAl = n2;
		
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject RitornoDatiActualy(String nome) {
		
		actualy.TemperaturaCorrente(nome);
		
		JSONObject Dati = new JSONObject();

		Dati.put("Temperatura attuale", actualy.GetTemp());
		Dati.put("La temperatura massima", actualy.GetMax());
		Dati.put("La temperatura minima", actualy.GetMin());
		Dati.put("La varianza massima", actualy.GetVar()); 
		
		return Dati;
		
	} 
	
	@SuppressWarnings("unchecked")
	public JSONObject SingleDay() {
		
		JSONObject casuale = new JSONObject();
		
		casuale.put("La temperatura media", GC.TempGiornoCasuale(SingoloGiorno, Nome));
		
		return casuale;
		
	}
	
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
	
	@SuppressWarnings("unchecked")
	public JSONObject Range_PersTotal() {
		
		RAC.AllCity(SingoloGiorno, FinoAl);
		
		JSONObject Total = new JSONObject();
		
		Total.put("La media di tutte le temperature", RAC.MediaMedie());
		Total.put("Temperaura piu' bassa", RAC.Minimi());
		Total.put("Appartiene a", SC.Citta(RAC.GetPosMin()));
		Total.put("La temperatura piu alta", RAC.Massimi());
		Total.put("Appartiene a", SC.Citta(RAC.GetPosMax()));
		Total.put("La varianza massima", RAC.Varianze());
		Total.put("Appartiene a", SC.Citta(RAC.GetPosMaxVar()));
		
		System.out.println(SC.Citta(RAC.GetPosMax()));
		System.out.println(SC.Citta(RAC.GetPosMaxVar()));
		
		return Total;
		
	}

}
