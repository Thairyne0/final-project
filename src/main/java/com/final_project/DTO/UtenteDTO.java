package com.final_project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtenteDTO {

    private Long id;
    private String email;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private Boolean isAPro;

}
