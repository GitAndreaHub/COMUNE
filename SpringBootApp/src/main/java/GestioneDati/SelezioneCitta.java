package GestioneDati;

public class SelezioneCitta {
	
	private String nomeCitta;
	
	public SelezioneCitta() {
		
	}
	
	public String Citta(int n) {
		switch(n) {
		case 0: 
			nomeCitta="Ancona";
			break;
		case 1: 
			nomeCitta="Pesaro";
			break;
		case 2: 
			nomeCitta="Fano";
			break;
		case 3: 
			nomeCitta="Ascoli Piceno";
			break;
		case 4: 
			nomeCitta="San Benedetto del Tronto";
			break;
		case 5: 
			nomeCitta="Senigallia";
			break;
		case 6: 
			nomeCitta="Civitanova Marche";
			break;
		case 7: 
			nomeCitta="Macerata";
			break;
		case 8: 
			nomeCitta="Jesi";
			break;
		case 9: 
			nomeCitta="Fermo";
			break;
		}
		
		return nomeCitta;
	}

}
