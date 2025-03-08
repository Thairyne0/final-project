package com.final_project.controller;

import com.final_project.entity.Professionista;
import com.final_project.repository.ProfessionistaRepository;
import com.final_project.request.ProfessionistaRequest;
import com.final_project.service.ProfessionistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    private final ProfessionistaRepository professionistaRepositroy;

    @Operation(summary = "Trova tutti i professionisti", description = "Restituisce una lista di tutti i professionisti")
    @GetMapping
    public List<Professionista> getAllProfessionisti() {
        return professionistaRepositroy.findAll();
    }

    @Operation(summary = "Crea un nuovo professionista", description = "Restituisce il professionista creato")
    @PostMapping
    public ResponseEntity<Professionista> creaProfessionista(@RequestBody ProfessionistaRequest professionistaRequestRequest) {
        Professionista nuovoProfessionista = professionistaService.creaProfiloProfessionista(professionistaRequestRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovoProfessionista);
    }


    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());

            return ResponseEntity.ok("/uploads/mechanics/" + fileName);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Errore durante l'upload");
        }
    }

}


