package com.weten.hospital.entities;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING) // transformer en string
    private StatusRDV status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezVous")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Consultation consultation;

    public RendezVous() {
    }

    public RendezVous(Long id, Date date, StatusRDV status, Patient patient, Medecin medecin, Consultation consultation) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.patient = patient;
        this.medecin = medecin;
        this.consultation = consultation;
    }

    public RendezVous(Date date, StatusRDV status, Patient patient, Medecin medecin, Consultation consultation) {
        this.date = date;
        this.status = status;
        this.patient = patient;
        this.medecin = medecin;
        this.consultation = consultation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StatusRDV getStatus() {
        return status;
    }

    public void setStatus(StatusRDV status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
