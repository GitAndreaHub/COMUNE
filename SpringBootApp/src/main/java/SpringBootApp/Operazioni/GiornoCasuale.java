package SpringBootApp.Operazioni;
import RaccoltaDati.*;
import java.util.Vector;

public class GiornoCasuale {
	
	Ricerca_WeeklyTemp ricerca= new Ricerca_WeeklyTemp(null);
	private Vector<Double> temp=new Vector<Double>();
	
	public GiornoCasuale() {
		
	}
	
	public double TempGiornoCasuale(int n, String nome) {
		ricerca.RaccoltaTemperature(nome);
		temp.addAll(ricerca.GetDati());
		return temp.get(n);
	}
	
	
	
}
