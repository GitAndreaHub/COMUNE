package GestioneDati;
import java.util.Vector;

public class MinMax {
	private double Min,Max;
	
	public MinMax() {
		
	}
	
	//setter
	public void CalcolaMinMax(Vector<Double>v1) {
		int lunghezza= v1.size();
		Min=v1.get(0);
		Max=v1.get(0);
		for(int i=0; i<lunghezza; i++) {
			if(v1.get(i)<Min) Min=v1.get(i);
			if(v1.get(i)>Max) Max=v1.get(i);
		}
	}
	
	//getter
	public double GetMin() {
		return Min;
	}
	
	public double GetMax() {
		return Max;
	}

}
