package JUnit_Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import RaccoltaDati.*;
import GestioneDati.*;
import SpringBootApp.Operazioni.Range_AllCity;

class ClassTest {

	/*@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	*/
	@Test
	public void TestRicercaID() {
		
		//Arrange
		RicercaID ClassRicerca = new RicercaID();
		
		//Assert
		assertEquals(3183089, ClassRicerca.lettura("Ancona"));
		
	}
	
	@Test
	public void Test_RicercaWeeklyTemp() {
		
		Vector<Double> Test = new Vector<Double>();
		Double appoggio;
		
		//Arrange
		Ricerca_WeeklyTemp weekly = new Ricerca_WeeklyTemp();
		weekly.RaccoltaTemperature("Pesaro");
		weekly.Stampa();
		Test.addAll(weekly.GetDati());
		appoggio = Test.get(0);
		
		//Assert
		assertEquals(280.65, appoggio);
		
	}
	
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
	
	@Test
	public void Test_RangeAllCity() {
		
		int n1 = 2;
		int n2 = 9;
		
		Range_AllCity City = new Range_AllCity();
		
		City.AllCity(n1, n2);
		
		assertEquals(275.35, City.Minimi());
		assertEquals(289.76, City.Massimi());
		
	}

}
