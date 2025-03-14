package com.final_project.repository;

import com.final_project.entity.Professionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionistaRepository extends JpaRepository<Professionista, Long>{
    List<Professionista> findByNomeContainingIgnoreCaseOrCittaContainingIgnoreCaseOrCapContainingIgnoreCase(
            String nome, String citta, String cap
    );
}
