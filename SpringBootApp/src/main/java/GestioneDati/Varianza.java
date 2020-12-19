package GestioneDati;


public class Varianza {
	
	private double Var;
	
	//costruttore
	public Varianza() {
		
	}
	
	//setter
	
	public double CalcoloVarianza(double n1, double n2) {
		if(n1>=n2) Var=n1-n2;
		else Var=n2-n1;
		return Var;
	}
	

}
