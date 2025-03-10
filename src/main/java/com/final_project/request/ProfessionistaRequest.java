package com.final_project.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionistaRequest {

    @NotNull(message = "L'ID utente è obbligatorio")
    private Long utenteId;

    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String cognome;

    @Size(max = 500, message = "La descrizione può avere massimo 500 caratteri")
    private String descrizione;

    @NotBlank(message = "Il nome dell'azienda è obbligatorio")
    private String nomeAzienda;

    @NotBlank(message = "La regione è obbligatoria")
    private String regione;

    @NotBlank(message = "L'indirizzo è obbligatorio")
    private String indirizzo;

    @NotBlank(message = "La città è obbligatoria")
    private String citta;

    @NotBlank(message = "La provincia è obbligatoria")
    private String provincia;

    @NotBlank(message = "Il CAP è obbligatorio")
    @Size(min = 5, max = 5, message = "Il CAP deve essere di 5 cifre")
    private String cap;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Formato email non valido")
    private String email;
//
//    private byte[] immagine;

}
