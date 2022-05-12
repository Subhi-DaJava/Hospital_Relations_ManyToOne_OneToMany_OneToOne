package com.weten.hospital.service;

import com.weten.hospital.model.Consultation;
import com.weten.hospital.model.Medecin;
import com.weten.hospital.model.Patient;
import com.weten.hospital.model.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);

    RendezVous saveRendezVous(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);
}
