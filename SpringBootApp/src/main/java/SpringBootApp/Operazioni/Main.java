package SpringBootApp.Operazioni;

import RaccoltaDati.ChiamataAPI_Actualy;

public class Main {
	ChiamataAPI_Actualy Actualy = new ChiamataAPI_Actualy();
	
	String nome;
	Double tempo;
	Double temp_max;
	Double temp_min;
	
	public Main(String nome) {
		this.nome = nome;
	}
	
	public void dati() {
		
		Actualy.Chiamata(nome);
		tempo = Actualy.GetTempo();
		temp_max = Actualy.GetTemp_max();
		temp_min = Actualy.GetTemp_min();
		
	}
	
	public Double GetTempo() {
		return tempo;
	}
	
	public Double GetTemp_max() {
		return temp_max;
	}
	
	public Double GetTemp_min() {
		return temp_min;
	}
}
