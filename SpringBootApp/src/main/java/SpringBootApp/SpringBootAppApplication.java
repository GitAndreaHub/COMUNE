package SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import SpringBootApp.Operazioni.GestioneScrittura_JSON;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}
	
	@Scheduled(fixedRate = 30000L)
	void TempAttuale() {
		
		GestioneScrittura_JSON write = new GestioneScrittura_JSON();
		write.GetJSONObject();
		write.Scrittura();
		
	} 

}
