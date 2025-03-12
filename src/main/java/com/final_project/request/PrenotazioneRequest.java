package com.final_project.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class PrenotazioneRequest {

    @NotBlank(message = "La marca del veicolo è obbligatoria")
    private String marcaVeicolo;

    @NotBlank(message = "Il modello del veicolo è obbligatorio")
    private String modelloVeicolo;

    @NotBlank(message = "La descrizione del problema è obbligatoria")
    private String descrizioneProblema;

    private String fotoProblema;

    @NotBlank(message = "Il nome è obbligatorio")
    private String nomeUtente;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String cognomeUtente;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Formato email non valido")
    private String emailUtente;

    @NotBlank(message = "La regione è obbligatoria")
    private String regione;

    @NotBlank(message = "L'indirizzo è obbligatorio")
    private String indirizzo;

    @NotBlank(message = "La città è obbligatoria")
    private String citta;

    @NotBlank(message = "La provincia è obbligatoria")
    private String provincia;

    @NotBlank(message = "Il CAP è obbligatorio")
    private String cap;

    @NotBlank(message = "L'ID del professionista è obbligatorio")
    private Long idProfessionista;

    @NotBlank(message = "L'ID dell'utente è obbligatorio")
    private Long utenteId;

    @NotBlank(message = "La data della prenotazione è obbligatoria")
    private LocalDate dataPrenotazione;

    @NotBlank(message = "L'orario della prenotazione è obbligatorio")
    private LocalTime orarioPrenotazione;

}

