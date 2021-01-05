package JUnit_Test;

import RaccoltaDati.RicercaID;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class Test {

	//@Test
	public void TestRicercaID() {
		
		//Arrange
		RicercaID ClassRicerca = new RicercaID();
		
		//Assert
		assertEquals(3183089, ClassRicerca.lettura("Ancona"));
		
		
	}
}
