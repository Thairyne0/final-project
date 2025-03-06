package com.final_project.service;

import com.final_project.entity.Utente;
import com.final_project.repository.UtenteRepository;
import com.final_project.request.UtenteRequest;
import com.epicEnergyServices.responses.CreateResponse;
import com.final_project.request.UtenteRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public Utente creaUtente(UtenteRequest utenteRequest) {
        if (utenteRepository.existsByEmail(utenteRequest.getEmail())) {
            throw new IllegalStateException("Email già in uso");
        }
        if (utenteRepository.existsByUsername(utenteRequest.getUsername())) {
            throw new IllegalStateException("Username già in uso");
        }

        Utente utente = new Utente();
        utente.setUsername(utenteRequest.getUsername());
        utente.setEmail(utenteRequest.getEmail());
        utente.setPassword(passwordEncoder.encode(utenteRequest.getPassword()));
        utente.setNome(utenteRequest.getNome());
        utente.setCognome(utenteRequest.getCognome());
        utente.setIsAPro(utenteRequest.getIsAPro());

        return utenteRepository.save(utente);
    }
}
