package SpringBootApp.Operazioni;

import java.util.Vector;

public class Range_AllCity {
	
	RangePersonalizzabile RangeP = new RangePersonalizzabile();
	
	Vector<Double> AnconaVett = new Vector<Double>();
	Vector<Double> PesaroVett = new Vector<Double>();
	Vector<Double> FanoVett = new Vector<Double>();
	Vector<Double> AscoliVett = new Vector<Double>();
	Vector<Double> SambaVett = new Vector<Double>();
	Vector<Double> SenigalliaVett = new Vector<Double>();
	Vector<Double> CivitanovaVett = new Vector<Double>();
	Vector<Double> MacerataVett = new Vector<Double>();
	Vector<Double> JesiVett = new Vector<Double>();
	Vector<Double> FermoVett = new Vector<Double>();
	
//Costruttore	
	public Range_AllCity() {
		
	}
	
	public void AllCity(int n1, int n2) {
		
		RangeP.Range(n1, n2, "Ancona");
		
		AnconaVett.set(0, RangeP.GetMedia());
		AnconaVett.set(1, RangeP.GetMin());
		AnconaVett.set(2, RangeP.GetMax());
		AnconaVett.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Pesaro");
		PesaroVett.set(0, RangeP.GetMedia());
		PesaroVett.set(1, RangeP.GetMin());
		PesaroVett.set(2, RangeP.GetMax());
		PesaroVett.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Fano");
		FanoVett.set(0, RangeP.GetMedia());
		FanoVett.set(1, RangeP.GetMin());
		FanoVett.set(2, RangeP.GetMax());
		FanoVett.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Ascoli Piceno");
		AscoliVett.set(0, RangeP.GetMedia());
		AscoliVett.set(1, RangeP.GetMin());
		AscoliVett.set(2, RangeP.GetMax());
		AscoliVett.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "San Benedetto del Tronto");
		SambaVett.set(0, RangeP.GetMedia());
		SambaVett.set(1, RangeP.GetMin());
		SambaVett.set(2, RangeP.GetMax());
		SambaVett.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Senigallia");
		SenigalliaVett.set(0, RangeP.GetMedia());
		SenigalliaVett.set(1, RangeP.GetMin());
		SenigalliaVett.set(2, RangeP.GetMax());
		SenigalliaVett.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Civitanova Marche");
		CivitanovaVett.set(0, RangeP.GetMedia());
		CivitanovaVett.set(1, RangeP.GetMin());
		CivitanovaVett.set(2, RangeP.GetMax());
		CivitanovaVett.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Macerata");
		MacerataVett.set(0, RangeP.GetMedia());
		MacerataVett.set(1, RangeP.GetMin());
		MacerataVett.set(2, RangeP.GetMax());
		MacerataVett.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Jesi");
		JesiVett.set(0, RangeP.GetMedia());
		JesiVett.set(1, RangeP.GetMin());
		JesiVett.set(2, RangeP.GetMax());
		JesiVett.set(3, RangeP.GetVarianza());
		
		RangeP.Range(n1, n2, "Fermo");
		FermoVett.set(0, RangeP.GetMedia());
		FermoVett.set(1, RangeP.GetMin());
		FermoVett.set(2, RangeP.GetMax());
		FermoVett.set(3, RangeP.GetVarianza());
		
	}

}
