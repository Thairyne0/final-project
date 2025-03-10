package com.final_project.service;

import com.final_project.DTO.UtenteDTO;
import com.final_project.config.JwtUtil;
import com.final_project.entity.Utente;
import com.final_project.repository.UtenteRepository;
import com.final_project.request.UtenteRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    private final JwtUtil jwtUtil;

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

    public String loginUser(String email, String password) {
        Utente utente = utenteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        if (!passwordEncoder.matches(password, utente.getPassword())) {
            throw new RuntimeException("Password errata");
        }

        return jwtUtil.generateToken(utente.getEmail(), utente.getId());
    }

}
