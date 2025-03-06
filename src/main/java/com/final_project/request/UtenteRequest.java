package com.epicEnergyServices.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtenteRequest {

    @NotNull(message = "ID user is required")
    private String idUtente;

    @NotEmpty(message = "Username is required")
    @Size(min = 3, max = 20,  message = "Username must be between 3 and 20 characters")
    private String username;

    @Email
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 8, max = 20,  message = "Password must be between 8 and 20 characters")
    private String password;

    @NotNull(message = "Name is required")
    private String nome;

    @NotNull(message = "Surname is required")
    private String cognome;

    @NotNull(message = "Role is required")
    private String ruolo;




}
