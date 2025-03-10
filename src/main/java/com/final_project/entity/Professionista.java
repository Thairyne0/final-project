package com.final_project.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "professionisti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professionista {
        @Id
        private Long idProfessionista;

        @OneToOne
        @MapsId
        @JoinColumn(name = "idProfessionista")
        @JsonBackReference
        private Utente utente;

        private String nome;
        private String cognome;
        private String descrizione;
        private String nomeAzienda;
        private String regione;
        private String indirizzo;
        private String citta;
        private String provincia;
        private String cap;
        private String email;

//        @Lob
//        @Column(columnDefinition = "BYTEA")
//        private byte[] immagineOfficina;

}
