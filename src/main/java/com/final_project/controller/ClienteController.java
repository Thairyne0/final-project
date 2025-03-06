package com.epicEnergyServices.controller;

import com.epicEnergyServices.entity.Cliente;
import com.epicEnergyServices.request.ClienteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clienti")
@Tag(name = "Clienti", description = "Gestione clienti")
public class ClienteController {

    private final com.epicEnergyServices.service.ProfessionistaService professionistaService;

    private final com.epicEnergyServices.repository.ProfessionistaRepositroy professionistaRepositroy;

    @Operation(summary = "Trova tutti i clienti", description = "Restituisce una lista di tutti i clienti")
    @GetMapping
    public List<Cliente> getAllClienti() {
        return professionistaRepositroy.findAll();
    }

    @Operation(summary = "Crea un nuovo cliente", description = "Restituisce il cliente creato")
    @PostMapping
    public ResponseEntity<Cliente> creaCliente(@RequestBody ClienteRequest clienteRequest) {
        Cliente nuovoCliente = professionistaService.creaCliente(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovoCliente);
    }
}


