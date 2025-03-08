package com.final_project.service;

import com.final_project.DTO.UtenteDTO;
import com.final_project.entity.Utente;
import com.final_project.repository.UtenteRepository;
import com.final_project.request.UtenteRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean existsByEmail(String email) {
        return utenteRepository.existsByEmail(email);
    }

    public boolean existsByUsername(String username) {
        return utenteRepository.existsByUsername(username);
    }

    public Utente registerUser(UtenteDTO utenteDTO) {
        if (utenteRepository.existsByEmail(utenteDTO.getEmail())) {
            throw new IllegalStateException("Email già in uso");
        }
        if (utenteRepository.existsByUsername(utenteDTO.getUsername())) {
            throw new IllegalStateException("Username già in uso");
        }

        String hashedPassword = passwordEncoder.encode(utenteDTO.getPassword());
        Utente utente = new Utente();
        utente.setUsername(utenteDTO.getUsername());
        utente.setEmail(utenteDTO.getEmail());
        utente.setPassword(hashedPassword);
        utente.setNome(utenteDTO.getNome());
        utente.setCognome(utenteDTO.getCognome());
        utente.setIsAPro(utenteDTO.getIsAPro());
        return utenteRepository.save(utente);

    }
//
//    @Transactional
//    public Utente creaUtente(UtenteRequest utenteRequest) {
//        if (utenteRepository.existsByEmail(utenteRequest.getEmail())) {
//            throw new IllegalStateException("Email già in uso");
//        }
//        if (utenteRepository.existsByUsername(utenteRequest.getUsername())) {
//            throw new IllegalStateException("Username già in uso");
//        }
//
//        Utente utente = new Utente();
//        utente.setUsername(utenteRequest.getUsername());
//        utente.setEmail(utenteRequest.getEmail());
//        utente.setPassword(passwordEncoder.encode(utenteRequest.getPassword()));
//        utente.setNome(utenteRequest.getNome());
//        utente.setCognome(utenteRequest.getCognome());
//        utente.setIsAPro(utenteRequest.getIsAPro());
//
//        return utenteRepository.save(utente);
//    }
}
