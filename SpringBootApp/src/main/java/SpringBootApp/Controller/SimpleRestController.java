package SpringBootApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
	
	@GetMapping("/Main")
	public Main Actualy1(@RequestParam(name = "citta", defaultValue = "default") String nome) {
		
		return new Main("Jesi");
	}
	
	@PostMapping("/Assegno")
	public Main Actualy2(@RequestBody Main body) {
		
		return body;
	}

}
