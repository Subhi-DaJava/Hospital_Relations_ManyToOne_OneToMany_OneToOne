package com.weten.hospital;

import com.weten.hospital.entities.*;
import com.weten.hospital.repositories.MedecinRepository;
import com.weten.hospital.repositories.PatientRepository;
import com.weten.hospital.repositories.RendezVousRepository;
import com.weten.hospital.service.IHospitalService;
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
	CommandLineRunner start(IHospitalService hostpitalService,
							PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository){
		return args -> {
			//patientRepository.save(new Patient(null,"Hassan",new Date(),false,null)); n'est pas pratique, ni visible, ni simple, pas besoin d'utiliser Id
			Stream.of("Emet", "Semet", "Memet")
					.forEach(name ->{
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hostpitalService.savePatient(patient);
					});
			Stream.of("Aygul", "Sare", "Ghunchem")
					.forEach(name ->{
						Medecin medecin= new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random() > 0.6 ?"Dermatologue":"ORL");
						hostpitalService.saveMedecin(medecin);
					});

			Patient patient = patientRepository.findById(1L).orElse(null);
			//Patient patient2 = patientRepository.findById(1L).get();
			Patient patient1 = patientRepository.findByNom("Emet");

			Medecin medecin = medecinRepository.findByNom("Ghunchem");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			//Par défaut : Ordinal est correspond 0,1,2....
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			hostpitalService.saveRendezVous(rendezVous);

			//chercher d'abord le rendez-vous
			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Le rapport de cette consultation ...");
			hostpitalService.saveConsultation(consultation);




		};
	}

}
