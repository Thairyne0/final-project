package com.final_project.service;

import com.final_project.entity.Utente;
import com.final_project.repository.UtenteRepository;
import com.epicEnergyServices.request.UtenteRequest;
import com.epicEnergyServices.responses.CreateResponse;
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
    public Utente creaUtente(String username, String email, String password, String nome, String cognome, Boolean isAPro) {
        if (utenteRepository.existsByEmail(email)) {
            throw new IllegalStateException("Email già in uso");
        }
        if (utenteRepository.existsByUsername(username)) {
            throw new IllegalStateException("Username già in uso");
        }

        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setEmail(email);
        utente.setPassword(passwordEncoder.encode(password));
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setIsAPro(isAPro);

        return utenteRepository.save(utente);
    }
}
