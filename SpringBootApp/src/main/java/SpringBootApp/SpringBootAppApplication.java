package SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import SpringBootApp.Operazioni.GestioneScrittura_JSON;

/**
 * Classe SpringBootAppApplication.
 * 
 * @author Andrea Tassi.
 *
 */

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
		
	}
	
	/**
	 * 
	 * Metodo TempAttuale si occupa di far partire il salvataggio dei dati giornalieri, riguardo tutte 
	 * le citta, ogni ora.
	 * 
	 */
	
	@Scheduled(fixedRate = 3600000)
	void TempAttuale() {
		
		GestioneScrittura_JSON write = new GestioneScrittura_JSON();
		write.GetJSONObject();
		write.Scrittura();
		
	} 

}

/**
 * Configurazione dello Scheduled.
 * 
 */

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration{
	
}
