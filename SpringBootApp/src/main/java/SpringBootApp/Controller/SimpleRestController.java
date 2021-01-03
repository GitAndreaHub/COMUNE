package SpringBootApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GestioneDati.SelezioneCitta;
import SpringBootApp.Operazioni.GestioneDatiActualy;
import SpringBootApp.Operazioni.GiornoCasuale;
import SpringBootApp.Operazioni.RangePersonalizzabile;
import SpringBootApp.Operazioni.Range_AllCity;

@RestController
public class SimpleRestController {
	
	@GetMapping("/actualy")
    public String SinlgeCity(@RequestParam(name = "city", defaultValue = "Nessuna_Citta")String nome) {
		
		GestioneDatiActualy actualy = new GestioneDatiActualy(0, 0, 0, 0);
		actualy.TemperaturaCorrente(nome);
		return "La temperatura attuale e' di " + actualy.GetTemp() + " gradi fahrenheit." + "/n" +
				"La temperatura massima registrata e' di " + actualy.GetMax() + " gradi fahrenheit." + "/n" +
				"La temperatura minima registrata e' di " + actualy.GetMin() + " gradi fahrenheit." + "/n" +
				"La varianza massima e' di " + actualy.GetVar() + " gradi fahrenheit.";
	}
	
	@PostMapping("/singolo_giorno_casuale")
	public String SingleCity2(@RequestBody GiornoCasuale GC) {
		return "La temperatura media e': " + GC.TempGiornoCasuale(0, null) + " gradi fahrenheit.";
	}
	
	@PostMapping("/range_personalizzabile_singola")
	public String SingleCity3(@RequestBody RangePersonalizzabile RP) {
		RP.Range(0, 0, null);
		return "La media delle temperature e': " + RP.GetMedia() + "/n" + " gradi fahrenheit." + 
				"La temperatura minima e': " + RP.GetMin() + "/n" + " gradi fahrenheit." +
				"La temperatura massima e': " + RP.GetMax() + "/n" + " gradi fahrenheit." +
				"La varianza e': " + RP.GetVarianza() + " gradi fahrenheit.";
	}
	
	@PostMapping("/range_personalizzabile_totale")
	public String TotalCity(@RequestBody Range_AllCity RCT, SelezioneCitta SC) {
		
		return "La media di tutte le temperature e' di: " + RCT.MediaMedie() + "/n" + " gradi fahrenheit." +
				"La temperatura piu bassa rispetto a tutte le citta appartiene alla citta di " + 
				SC.Citta(RCT.GetPosMin()) + " e vale: " + RCT.Minimi() + "/n" + " gradi fahrenheit." + 
				"La temperatura piu alta rispetto a tutte le citta appartiene alla citta di + " +
				SC.Citta(RCT.GetPosMax()) + " e vale: " + RCT.Massimi() + "/n" + " gradi fahrenheit." +
				"La varianza massima rispetto a tutte le citta appartiene alla citta di " + 
				SC.Citta(RCT.GetPosMaxVar()) + " e vale: " + RCT.Varianze() + " gradi fahrenheit.";
	}
}
