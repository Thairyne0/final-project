package com.final_project.controller;

import com.final_project.entity.Prenotazione;
import com.final_project.entity.Professionista;
import com.final_project.entity.Utente;
import com.final_project.repository.PrenotazioneRepository;
import com.final_project.repository.ProfessionistaRepository;
import com.final_project.repository.UtenteRepository;
import com.final_project.request.PrenotazioneRequest;
import com.final_project.service.PrenotazioneService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
@Tag(name = "Prenotazioni", description = "Gestione prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;
    private final PrenotazioneRepository prenotazioneRepository;

    private final ProfessionistaRepository professionistaRepository;

    private final UtenteRepository utenteRepository;

    public PrenotazioneController(PrenotazioneService prenotazioneService, PrenotazioneRepository prenotazioneRepository, ProfessionistaRepository professionistaRepository, UtenteRepository utenteRepository) {
        this.prenotazioneService = prenotazioneService;
        this.prenotazioneRepository = prenotazioneRepository;

        this.professionistaRepository = professionistaRepository;
        this.utenteRepository = utenteRepository;
    }

    @PostMapping("/crea")
    public ResponseEntity<Prenotazione> creaPrenotazione(@RequestBody PrenotazioneRequest prenotazioneRequest) {
        Professionista professionista = professionistaRepository.findById(prenotazioneRequest.getIdProfessionista())
                .orElseThrow(() -> new RuntimeException("Professionista non trovato"));

        Utente utente = utenteRepository.findById(prenotazioneRequest.getUtenteId())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));


        Prenotazione nuovaPrenotazione = prenotazioneService.creaPrenotazione(prenotazioneRequest, professionista, utente);
        return ResponseEntity.ok(nuovaPrenotazione);
    }

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }
}
