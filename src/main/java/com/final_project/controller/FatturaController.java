package com.epicEnergyServices.controller;

import com.epicEnergyServices.entity.Fattura;
import com.epicEnergyServices.repository.FatturaRepository;
import com.epicEnergyServices.request.FatturaRequest;
import com.epicEnergyServices.service.FatturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fatture")
@Tag(name = "Fatture", description = "Gestione fatture")
public class FatturaController {

    private final FatturaService fatturaService;

    private final FatturaRepository fatturaRepository;


    @Operation(summary = "Trova tutti le fatture", description = "Restituisce una lista di tutte le fatture")
    @GetMapping
    public List<Fattura> getAllFatture() {
        return fatturaRepository.findAll();
    }

    @Operation(summary = "Crea una nuova fattura", description = "Restituisce la fattura creata")
    @PostMapping
    public ResponseEntity<Fattura> creaFattura(@RequestBody FatturaRequest fatturaRequest) {
        Fattura nuovaFattura = fatturaService.creaFattura(fatturaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovaFattura);
    }

}
