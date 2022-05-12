package com.weten.hospital.entities;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<RendezVous> rendezVous;

    public Patient() {
    }

    public Patient(Long id, String nom, Date dateNaissance, boolean malade, List<RendezVous> rendezVous) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.malade = malade;
        this.rendezVous = rendezVous;
    }

    public Patient(String nom, Date dateNaissance, boolean malade, List<RendezVous> rendezVous) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.malade = malade;
        this.rendezVous = rendezVous;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public boolean isMalade() {
        return malade;
    }

    public void setMalade(boolean malade) {
        this.malade = malade;
    }

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(List<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }
}
