package com.weten.hospital;

import com.weten.hospital.entities.Patient;
import com.weten.hospital.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	/**
	 * Méthode start(args) return un objet CommandLineRunner
	 * @return un objet 
	 */
	@Bean
	CommandLineRunner start(PatientRepository patientRepository){
		return args -> {
			//patientRepository.save(new Patient(null,"Hassan",new Date(),false,null)); n'est pas pratique, ni visible, ni simple, pas besoin d'utiliser Id
			Stream.of("Ememt","Semet","Memet")
					.forEach(name ->{
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						patientRepository.save(patient);
					});

		};
	}

}
