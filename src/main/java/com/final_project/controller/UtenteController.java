package com.final_project.controller;

import com.final_project.entity.Utente;
import com.final_project.repository.UtenteRepository;
import com.final_project.request.UtenteRequest;
import com.final_project.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/utenti")
@Tag(name = "Utenti", description = "Gestione utenti")
public class UtenteController {

    private final UtenteService utenteService;

    private final UtenteRepository utenteRepository;

    @Operation(summary = "Trova tutti gli utente", description = "Restituisce una lista di utenti")
    @GetMapping
    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    @Operation(summary = "Crea un nuovo utente", description = "Restituisce l'utente creato")
    @PostMapping
    public ResponseEntity<Utente> creaUtente(@RequestBody UtenteRequest utenteRequest) {
        Utente nuovoUtente = utenteService.creaUtente(utenteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovoUtente);

    }

}
