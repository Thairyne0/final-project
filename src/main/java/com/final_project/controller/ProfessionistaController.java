package com.final_project.controller;

import com.final_project.entity.Professionista;
import com.final_project.repository.ProfessionistaRepository;
import com.final_project.request.ProfessionistaRequest;
import com.final_project.service.ProfessionistaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    private final ProfessionistaService professionistaService;

    private final ProfessionistaRepository professionistaRepository;

    @Operation(summary = "Trova tutti i professionisti", description = "Restituisce una lista di tutti i professionisti")
    @GetMapping
    public List<Professionista> getAllProfessionisti() {
        return professionistaRepository.findAll();
    }

    @Operation(summary = "Crea un nuovo professionista", description = "Restituisce il professionista creato")
    @PostMapping("/create")
    public ResponseEntity<?> createProfessionista(@Valid @RequestBody ProfessionistaRequest professionistaRequest) {
        try {
            Professionista professionista = professionistaService.creaProfiloProfessionista(professionistaRequest);
            return ResponseEntity.ok(professionista);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}


