package SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import SpringBootApp.Operazioni.GestioneScrittura_JSON;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
		
	}
	
	@Scheduled(fixedRate = 20000)
	void TempAttuale() {
		
		GestioneScrittura_JSON write = new GestioneScrittura_JSON();
		write.GetJSONObject();
		write.Scrittura();
		
	} 

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration{
	
}
