package com.weten.hospital.repositories;

import com.weten.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
