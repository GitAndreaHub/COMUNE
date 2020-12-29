package SpringBootApp.Operazioni;
import RaccoltaDati.*;
import java.util.Vector;

public class GiornoCasuale {
	
	Ricerca_WeeklyTemp ricerca= new Ricerca_WeeklyTemp();
	private Vector<Double> temp=new Vector<Double>();
	
	public GiornoCasuale() {
		
	}
	
	public double TempGiornoCasuale(int n, String nome) {
		temp.addAll(ricerca.WeeklyTemp(nome));
		return temp.get(n);
	}
	
	
	
}
