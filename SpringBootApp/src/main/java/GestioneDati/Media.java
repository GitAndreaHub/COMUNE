package GestioneDati;
import java.util.Vector;

public class Media {
	private double media;
	
	public Media() {
		
	}
	
	//setter
	public double MediaNumeri(Vector<Integer>v1){
		int lunghezza= v1.size();
		int somma=0;
		for(int i=0;i<lunghezza; i++) {
			somma+=v1.get(i);
		}
		media=somma/lunghezza;
		return media;
	}

}
