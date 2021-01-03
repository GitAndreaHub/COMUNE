package SpringBootApp.Operazioni;
import RaccoltaDati.ChiamataAPI_Actualy;

import java.util.Vector;

import GestioneDati.Varianza;

public class GestioneDatiActualy {
	
	private double Temp;
	private double Min;
	private double Max;
	private double Varianza;
	Vector<Double> appoggio=new Vector<Double>();
	
	
	//costruttore
	public GestioneDatiActualy(double Temp, double Max, double Min, double Varianza){
		this.Temp=Temp;
		this.Max=Max;
		this.Min=Min;
		this.Varianza=Varianza;
	}
	
	//setter
	public void TemperaturaCorrente(String Nome) {
		ChiamataAPI_Actualy chiamata= new ChiamataAPI_Actualy(null);
		Varianza Var= new Varianza();
		chiamata.RaccoltaTemperature(Nome);
		appoggio=chiamata.GetDati();
		Temp=appoggio.get(0);
		Min=appoggio.get(1);
		Max=appoggio.get(2);
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
