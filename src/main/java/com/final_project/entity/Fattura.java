package com.epicEnergyServices.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "fatture")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fattura {

    private LocalDate data;
    private String importo;
    private StatoFattura stato;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long numeroFattura;

    @ManyToOne
    private Cliente idCliente;

}

