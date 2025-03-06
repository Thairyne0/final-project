package com.final_project.controller;

import com.final_project.entity.Prenotazione;
import com.final_project.repository.PrenotazioneRepository;
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

    public PrenotazioneController(PrenotazioneService prenotazioneService, PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneService = prenotazioneService;
        this.prenotazioneRepository = prenotazioneRepository;
    }

    @PostMapping
    public ResponseEntity<Prenotazione> creaPrenotazione(@RequestBody PrenotazioneRequest prenotazioneRequest) {
        Prenotazione nuovaPrenotazione = prenotazioneService.creaPrenotazione(prenotazioneRequest);
        return ResponseEntity.ok(nuovaPrenotazione);
    }

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }
}
