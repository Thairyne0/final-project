package com.epicEnergyServices.request;

import com.epicEnergyServices.entity.Indirizzo;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotBlank(message = "Business name is required")
    private String ragioneSociale;

    @NotBlank(message = "VAT number is required")
    @Pattern(regexp = "^[0-9]{11}$", message = "VAT number must be 11 digits")
    private String partitaIva;

    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String telefono;

    @NotBlank(message = "Contact name is required")
    private String nomeContatto;

    @NotBlank(message = "Contact surname is required")
    private String cognomeContatto;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact phone must be 10 digits")
    private String telefonoContatto;

    @Email(message = "Please provide a valid email address for contact")
    @NotBlank(message = "Contact email is required")
    private String emailContatto;

    @NotNull(message = "Address is required")
    private Indirizzo indirizzoSedeLegale;

    @NotNull(message = "Address is required")
    private Indirizzo indirizzoSedeOperativa;

    @NotNull(message = "Annual revenue is required")
    @Min(value = 0, message = "Annual revenue must be positive")
    private Double fatturatoAnnuale;

    @NotBlank(message = "PEC is required")
    @Email(message = "Please provide a valid PEC address")
    private String pec;

    @NotNull(message = "Date is required")
    private LocalDate dataInserimento;

    @NotNull(message = "Date is required")
    private LocalDate dataUltimoContatto;

}
