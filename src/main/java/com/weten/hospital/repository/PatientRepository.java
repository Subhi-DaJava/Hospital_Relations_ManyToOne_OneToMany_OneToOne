package com.weten.hospital.repository;

import com.weten.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    //Ici, considéré le nom est unique, sinon List<Patient> est ok
    Patient findByNom(String name);
}
