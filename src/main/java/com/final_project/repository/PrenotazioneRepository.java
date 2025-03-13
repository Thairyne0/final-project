package com.final_project.repository;

import com.final_project.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByProfessionista_IdProfessionista(Long idProfessionista);
}
