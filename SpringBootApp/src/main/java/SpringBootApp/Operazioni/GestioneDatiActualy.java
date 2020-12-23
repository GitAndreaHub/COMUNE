package SpringBootApp.Operazioni;
import RaccoltaDati.ChiamataAPI_Actualy;
import GestioneDati.Varianza;

public class GestioneDatiActualy {
	
	private double Temp;
	private double Min;
	private double Max;
	private double Varianza;
	
	
	//costruttore
	public GestioneDatiActualy(double Temp, double Max, double Min, double Varianza){
		this.Temp=Temp;
		this.Max=Max;
		this.Min=Min;
		this.Varianza=Varianza;
	}
	
	//setter
	public void TemperaturaCorrente(String Nome) {
		ChiamataAPI_Actualy chiamata= new ChiamataAPI_Actualy();
		Varianza Var= new Varianza();
		chiamata.Chiamata(Nome);
		Temp=chiamata.GetTempo();
		Min=chiamata.GetTemp_min();
		Max=chiamata.GetTemp_max();
		Varianza=Var.CalcoloVarianza(Min, Max);
	}
	
	//getter
	public double GetTemp() {
		return Temp;
	}
	
	public double GetMax() {
		return Max;
	}
	
	public double GetMin() {
		return Min;
	}
	
	public double GetVar() {
		return Varianza;
	}
	

}
