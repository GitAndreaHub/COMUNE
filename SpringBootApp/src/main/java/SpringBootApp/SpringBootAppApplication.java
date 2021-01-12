package SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import SpringBootApp.Controller.*;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}
	
	/*@Scheduled(fixedRate = 30000L)
	void TempAttuale() {
		
		Main main = new Main(0, 0, null);
		
	} */

}
