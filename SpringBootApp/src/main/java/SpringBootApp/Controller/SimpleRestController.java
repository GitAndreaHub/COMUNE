package SpringBootApp.Controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
	
	@GetMapping("/actualy")
    public JSONObject SingleCity(@RequestParam(name = "city", defaultValue = "Nessuna_Citta")String nome) {
		
		Main main = new Main(0, 0, nome);
		return main.RitornoDatiActualy(nome);
		
	}
	
	@PostMapping("/singolo_giorno_casuale")
	public JSONObject SingleCity2(@RequestBody Main main) {
		
		//int n = 0;
		//String nome = null;
		return main.SingleDay();
		
	}
	
	@PostMapping("/range_personalizzabile_singola")
	public JSONObject SingleCity3(@RequestBody Main main) {
		
		return main.Range_PersSingle();
		
	}
	
	@PostMapping("/range_personalizzabile_totale")
	public JSONObject TotalCity(@RequestBody Main main) {
		
		return main.Range_PersTotal();
		
	}
	
}
