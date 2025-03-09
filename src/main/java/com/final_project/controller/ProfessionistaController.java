package com.final_project.controller;

import com.final_project.entity.Professionista;
import com.final_project.repository.ProfessionistaRepository;
import com.final_project.request.ProfessionistaRequest;
import com.final_project.service.ProfessionistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/professionisti")
@CrossOrigin(origins = "http://localhost:5174")
@Tag(name = "Professionisti", description = "Gestione professionisti")
public class ProfessionistaController {
    private final String UPLOAD_DIR = "uploads/mechanics/";

    private final ProfessionistaService professionistaService;

    private final ProfessionistaRepository professionistaRepository;

    @Operation(summary = "Trova tutti i professionisti", description = "Restituisce una lista di tutti i professionisti")
    @GetMapping
    public List<Professionista> getAllProfessionisti() {
        return professionistaRepository.findAll();
    }

    @Operation(summary = "Crea un nuovo professionista", description = "Restituisce il professionista creato")
    @PostMapping
    public ResponseEntity<Professionista> creaProfessionista(@RequestBody ProfessionistaRequest professionistaRequestRequest) {
        Professionista nuovoProfessionista = professionistaService.creaProfiloProfessionista(professionistaRequestRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovoProfessionista);
    }


    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            Professionista professionista = professionistaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Professionista non trovato"));

            professionista.setImmagineOfficina(file.getBytes());
            professionistaRepository.save(professionista);

            return ResponseEntity.ok("Immagine caricata con successo!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante l'upload");
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        try {
            Professionista professionista = professionistaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Professionista non trovato"));

            if (professionista.getImmagineOfficina() == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(professionista.getImmagineOfficina());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}


