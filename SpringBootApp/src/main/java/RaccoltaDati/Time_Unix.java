package RaccoltaDati;

import java.util.*;
import java.util.Date; // Per avere data in UNIX

public class Time_Unix {
	
	private int CurrentTimeUnix;

	public Time_Unix(){
		
	}
	
	public int Get_TimeUnix() {
		
		long epoch = System.currentTimeMillis()/1000; // In secondi
		CurrentTimeUnix = (int)epoch;
		
		return CurrentTimeUnix;
		
	}
	
	
}
