package tn.iit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class StoreManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreManagmentApplication.class, args);
	}

}
