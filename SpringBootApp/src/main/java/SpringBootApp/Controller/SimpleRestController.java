package SpringBootApp.Controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe SimpleRestController si occupa delle richieste GetMapping e PostMapping del programma.
 * 
 * @author Andrea Tassi
 *
 */

@RestController
public class SimpleRestController {
	
	/**
	 * Metodo SingleDay di tipo GetMapping, restituisce in localHost/8080/actualy i dati metereologici 
	 * giornalieri della citta inserita.
	 * 
	 * @param nome
	 * @return
	 */
	
	@GetMapping("/actualy")
    public JSONObject SingleCity(@RequestParam(name = "city", defaultValue = "Nessuna_Citta")String nome) {
		
		Main main = new Main(0, 0, nome);
		return main.RitornoDatiActualy(nome);
		
	}
	
	/**
	 * Metodo SingleDay2 di tipo PostMapping, restituisce in localHost/8080/singolo_giorno_casuale la temperatura
	 * media del singolo giorno inserito della citta' inserita.
	 * 
	 * @param main classe Main.
	 * @return main.SingleDay().
	 */
	
	@PostMapping("/singolo_giorno_casuale")
	public JSONObject SingleCity2(@RequestBody Main main) {
		
		return main.SingleDay();
		
	}
	
	/**
	 * Metodo SingleDay3 di tipo PostMapping, restituisce in localHost/8080/range_personalizzabile_singola i dati
	 * metereologici della citta inserita in un range scelto dall'utente (da 1mo al 20esimo giorno)
	 * 	 
	 * @param main classe Main.
	 * @return main.Range_PersSingle(). 
	 */
	
	@PostMapping("/range_personalizzabile_singola")
	public JSONObject SingleCity3(@RequestBody Main main) {
		
		return main.Range_PersSingle();
		
	} 
	
	/**
	 * Metodo TotalCity di tipo PostMapping, restituisce in localHost/8080/range_personalizzabile_totale i dati
	 * metereologici di tutte e 10 le citta marchigiane restituendo le corrispondenti statistiche.
	 * 
	 * @param main classe Main.
	 * @return main.Range_PersTotal().
	 */
	
	@PostMapping("/range_personalizzabile_totale")
	public JSONObject TotalCity(@RequestBody Main main) {
		
		return main.Range_PersTotal();
		
	}
	
}
