package GestioneDati;
import java.util.Vector;

public class Media implements OperazionisuVett{
	private double media;
	
	public Media() {
		
	}
	
	//setter
	public void OpsuVett(Vector<Double>v1){
		int lunghezza= v1.size();
		int somma=0;
		for(int i=0;i<lunghezza; i++) {
			somma+=v1.get(i);
		}
		media=somma/lunghezza;
	}
	
	public double GetMedia() {
		return media;
	}

}
