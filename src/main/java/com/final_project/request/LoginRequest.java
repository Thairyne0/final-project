package com.final_project.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
