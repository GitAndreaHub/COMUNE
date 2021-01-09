package JUnit_Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import RaccoltaDati.*;
import RaccoltaDati.*;

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
		Ricerca_WeeklyTemp weekly = new Ricerca_WeeklyTemp(null);
		
		weekly.RaccoltaTemperature("Pesaro");
		Test.addAll(weekly.GetDati());
		appoggio = Test.get(0);
		
		//Assert
		assertEquals(280.65, appoggio);
		
	}

}
