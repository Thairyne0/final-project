package com.final_project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private Boolean isAPro;

    @OneToOne(mappedBy = "utente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Professionista professionista;
}
