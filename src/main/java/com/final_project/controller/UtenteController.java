package com.final_project.controller;

import com.final_project.DTO.UtenteDTO;
import com.final_project.entity.Utente;
import com.final_project.repository.UtenteRepository;
import com.final_project.request.LoginRequest;
import com.final_project.request.UtenteRequest;
import com.final_project.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/utenti")
@CrossOrigin(origins = "http://localhost:5174")
@Tag(name = "Utenti", description = "Gestione utenti")
public class UtenteController {

    private final UtenteService utenteService;

    private final UtenteRepository utenteRepository;

    @Operation(summary = "Trova tutti gli utente", description = "Restituisce una lista di utenti")
    @GetMapping
    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }


    @Operation(summary = "Registra un nuovo utente", description = "Registra un nuovo utente")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UtenteDTO utenteDTO) {
        try {
            utenteService.registerUser(utenteDTO);
            return ResponseEntity.ok("Utente registrato con successo");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Login", description = "Login")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            String token = utenteService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());

            return ResponseEntity.ok().body(Map.of(
                    "token", token,
                    "userId", utenteRepository.findByEmail(loginRequest.getEmail()).get().getId()
            ));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
