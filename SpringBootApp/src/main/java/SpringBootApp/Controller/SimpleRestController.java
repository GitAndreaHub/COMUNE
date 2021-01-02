package SpringBootApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import RaccoltaDati.ChiamataAPI_Actualy;

@RestController
public class SimpleRestController {
	
	@GetMapping("/actualy")
    public double SinlgeCity(@RequestParam(name = "city", defaultValue = "Nessuna_Citta")String city) {
		
		ChiamataAPI_Actualy actualy = new ChiamataAPI_Actualy();
		actualy.Chiamata(city);
		return actualy.GetTempo();
		
}
}
