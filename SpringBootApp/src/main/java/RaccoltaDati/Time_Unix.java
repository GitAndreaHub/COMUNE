package RaccoltaDati;


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
