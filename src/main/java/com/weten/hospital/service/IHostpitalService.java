package com.weten.hospital.service;

import com.weten.hospital.entities.Consultation;
import com.weten.hospital.entities.Medecin;
import com.weten.hospital.entities.Patient;
import com.weten.hospital.entities.RendezVous;

public interface IHostpitalService {

    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);

    RendezVous saveRendezVous(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);
}
