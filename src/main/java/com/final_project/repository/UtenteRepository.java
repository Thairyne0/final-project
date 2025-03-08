package com.final_project.repository;

import com.final_project.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String> {
    Optional<Utente> findById(Long id);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<Utente> findByEmail(String email);
}
