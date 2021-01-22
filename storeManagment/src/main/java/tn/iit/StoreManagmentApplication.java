package tn.iit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import tn.iit.dao.MedicationRepository;
import tn.iit.entity.Medication;

@SpringBootApplication
@EnableJpaAuditing

public class StoreManagmentApplication {
	@Autowired
	MedicationRepository medicationRepository;


	public static void main(String[] args) {
		SpringApplication.run(StoreManagmentApplication.class, args);
	}
@Bean
	CommandLineRunner start(MedicationRepository medicationRepository){
		return args -> {
			medicationRepository.save(new Medication(1,"clororquine"));
			medicationRepository.save(new Medication(2,"panadol"));
			medicationRepository.save(new Medication(3,"dormaclorine"));
		};
	}
}
