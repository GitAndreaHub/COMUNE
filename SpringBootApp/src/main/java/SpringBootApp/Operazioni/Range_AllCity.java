package SpringBootApp.Operazioni;

import java.util.Vector;
import GestioneDati.*;

public class Range_AllCity {
	
	RangePersonalizzabile RangeP = new RangePersonalizzabile();
	Media media = new Media();
	MinMax minmax = new MinMax();
	
	Vector<Double> VettoreDati = new Vector<Double>();
	Vector<Double> VettoreMedie = new Vector<Double>();
	Vector<Double> VettoreMinimi = new Vector<Double>();
	Vector<Double> VettoreMassimi = new Vector<Double>();
	Vector<Double> VettoreVarianze = new Vector<Double>();
	
	private int PosizioneMin, PosizioneMax, PosMassimaVarianza;
	
//Costruttore	
	public Range_AllCity() {
		
	}
	
	public void AllCity(int n1, int n2) {
		
		RangeP.Range(n1, n2, "Ancona");
		
		VettoreDati.set(0, RangeP.GetMedia());
		VettoreDati.set(1, RangeP.GetMin());
		VettoreDati.set(2, RangeP.GetMax());
		VettoreDati.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Pesaro");
		VettoreDati.set(4, RangeP.GetMedia());
		VettoreDati.set(5, RangeP.GetMin());
		VettoreDati.set(6, RangeP.GetMax());
		VettoreDati.set(7, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Fano");
		VettoreDati.set(8, RangeP.GetMedia());
		VettoreDati.set(9, RangeP.GetMin());
		VettoreDati.set(10, RangeP.GetMax());
		VettoreDati.set(11, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Ascoli Piceno");
		VettoreDati.set(12, RangeP.GetMedia());
		VettoreDati.set(13, RangeP.GetMin());
		VettoreDati.set(14, RangeP.GetMax());
		VettoreDati.set(15, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "San Benedetto del Tronto");
		VettoreDati.set(16, RangeP.GetMedia());
		VettoreDati.set(17, RangeP.GetMin());
		VettoreDati.set(18, RangeP.GetMax());
		VettoreDati.set(19, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Senigallia");
		VettoreDati.set(20, RangeP.GetMedia());
		VettoreDati.set(21, RangeP.GetMin());
		VettoreDati.set(22, RangeP.GetMax());
		VettoreDati.set(23, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Civitanova Marche");
		VettoreDati.set(24, RangeP.GetMedia());
		VettoreDati.set(25, RangeP.GetMin());
		VettoreDati.set(26, RangeP.GetMax());
		VettoreDati.set(27, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Macerata");
		VettoreDati.set(28, RangeP.GetMedia());
		VettoreDati.set(29, RangeP.GetMin());
		VettoreDati.set(30, RangeP.GetMax());
		VettoreDati.set(31, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Jesi");
		VettoreDati.set(32, RangeP.GetMedia());
		VettoreDati.set(33, RangeP.GetMin());
		VettoreDati.set(34, RangeP.GetMax());
		VettoreDati.set(35, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Fermo");
		VettoreDati.set(36, RangeP.GetMedia());
		VettoreDati.set(37, RangeP.GetMin());
		VettoreDati.set(38, RangeP.GetMax());
		VettoreDati.set(39, RangeP.GetVarianza());
		
	}
	
//Setter
	public double MediaMedie() {
		
		int u = 0;
		for(int i = 0; i < 39; i = i + 4) {
			VettoreMedie.set(u, VettoreDati.get(i));
			u++;
		}
		
		return media.MediaNumeri(VettoreMedie);
	}
	
	public double Minimi() {
		
		int u = 0;
		for(int i = 1; i < 39; i = i + 4) {
			VettoreMinimi.set(u, VettoreDati.get(i));
		}
		
		
		minmax.CalcolaMinMax(VettoreMinimi);
		PosizioneMin=minmax.GetPosMin();
		return minmax.GetMin();
	}
	
	public double Massimi() {
		
		int u = 0;
		for(int i = 2; i < 39; i = i + 4) {
			VettoreMassimi.set(u, VettoreDati.get(i));
		}
		
		minmax.CalcolaMinMax(VettoreMinimi);
		PosizioneMax=minmax.GetPosMax();
		return minmax.GetMax();
	}
	
	public double Varianze() {
		
		int u = 0;
		for(int i = 2; i < 39; i = i + 4) {
			VettoreVarianze.set(u, VettoreDati.get(i));
		}
		
		minmax.CalcolaMinMax(VettoreVarianze);
		PosMassimaVarianza=minmax.GetPosMax();
		return minmax.GetMax();
	}
	
	public int GetPosMin() {
		return PosizioneMin;
	}
	
	public int GetPosMax() {
		return PosizioneMax;
	}
	
	public int GetPosMaxVar() {
		return PosMassimaVarianza;
	}

}
