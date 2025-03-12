package com.final_project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "prenotazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marcaVeicolo;
    private String modelloVeicolo;
    private String descrizioneProblema;
    private String fotoProblema;

    private String nomeUtente;
    private String cognomeUtente;
    private String emailUtente;

    private String regione;
    private String indirizzo;
    private String citta;
    private String provincia;
    private String cap;

    private LocalDate dataPrenotazione;
    private LocalTime orarioPrenotazione;

    @ManyToOne
    private Professionista professionista;

    @ManyToOne
    private Utente utente;
}
