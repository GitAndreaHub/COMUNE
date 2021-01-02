package SpringBootApp.Operazioni;
import java.util.Vector;
import RaccoltaDati.Ricerca_WeeklyTemp;
import GestioneDati.*;


public class RangePersonalizzabile {
	
	Ricerca_WeeklyTemp Temp= new Ricerca_WeeklyTemp();
	Vector<Double> temperature = new Vector<Double>();
	Vector<Double> temperaturefinali = new Vector<Double>();
	Media metodomedia=new Media();
	MinMax metodominmax=new MinMax();
	Varianza metodovarianza= new Varianza();
	private double Media;
	private double Min;
	private double Max;
	private double Varianza;
	
	
	//costruttore
	public RangePersonalizzabile() {
		
		
	}
	
	//Setter
	public void Range(int n1, int n2, String nome){
		
		temperature.addAll(Temp.WeeklyTemp(nome)); //unisce i due vettori in temperature, mettendo Temp "sotto" temperature
		int conta=0;
		for(int i=n1-1; i<n2; i++) {
			temperaturefinali.set(conta, temperature.get(i));
			conta++;
		}
		metodomedia.OpsuVett(temperaturefinali);
		Media=metodomedia.GetMedia();
		metodominmax.OpsuVett(temperaturefinali);
		Max=metodominmax.GetMax();
		Min=metodominmax.GetMin();
		Varianza=metodovarianza.CalcoloVarianza(Min, Max);
	}
	
	//Getter
	public double GetMedia() {
		return Media;
	}
	
	public double GetMin() {
		return Min;
	}
	
	public double GetMax() {
		return Max;
	}
	
	public double GetVarianza() {
		return Varianza;
	}

}
