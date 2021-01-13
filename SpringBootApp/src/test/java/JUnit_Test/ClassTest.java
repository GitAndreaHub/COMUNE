package JUnit_Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;
import org.junit.jupiter.api.Test;

import RaccoltaDati.*;
import GestioneDati.*;
import SpringBootApp.Operazioni.Range_AllCity;

/**
 * Classe JUnit Test.
 * 
 * @author Andrea Tassi.
 * 
 * 
 */

class ClassTest {
	
	/**
	 * 
	 * Metodo TestRicercaID si testa La classe "RicercaID".
	 * 
	 */

	@Test
	public void TestRicercaID() {
		
		//Arrange
		RicercaID ClassRicerca = new RicercaID();
		
		//Assert
		assertEquals(3183089, ClassRicerca.lettura("Ancona"));
		
	}
	
	/**
	 * 
	 * Metodo Test_RicercaWeeklyTemp si testa la classe "Ricerca_WeeklyTemp".
	 * 
	 */
	
	@Test
	public void Test_RicercaWeeklyTemp() {
		
		Vector<Double> Test = new Vector<Double>();
		Double appoggio;
		
		//Arrange
		Ricerca_WeeklyTemp weekly = new Ricerca_WeeklyTemp();
		weekly.RaccoltaTemperature("Pesaro");
		Test.addAll(weekly.GetDati());
		appoggio = Test.get(0);
		
		//Assert
		assertEquals(280.65, appoggio);
		
	}
	
	/**
	 * 
	 * Metodo Test_MinMax si testa la classe "MinMax".
	 * 
	 */
	
	@Test
	public void Test_MinMax() {
		
		MinMax minmax = new MinMax();
		
		Vector<Double> vetminmax = new Vector<Double>(4);
		vetminmax.add(0, 3.2);
		vetminmax.add(1, 5.2);
		vetminmax.add(2, 0.7);
		vetminmax.add(3, 9.0);
		
		minmax.OpsuVett(vetminmax);
		
		assertEquals(3, minmax.GetPosMax());
		assertEquals(2, minmax.GetPosMin());
		
		assertEquals(9.0, minmax.GetMax());
		assertEquals(0.7, minmax.GetMin());
		
	}
	
	/**
	 * 
	 * Metodo Test_RangeAllCity si testa la classe Range_AllCity.
	 * 
	 */
	
	@Test
	public void Test_RangeAllCity() {
		
		int n1 = 1;
		int n2 = 2;
		
		Range_AllCity City = new Range_AllCity();
		
		City.AllCity(n1, n2);
		
		assertEquals(279.17, City.Minimi());
		assertEquals(281.53, City.Massimi());
		
	}

}
