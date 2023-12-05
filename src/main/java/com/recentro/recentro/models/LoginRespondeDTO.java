package com.recentro.recentro.models;


import lombok.Data;

@Data
public class LoginRespondeDTO {
    String token;
    private String email;

    private String role;

    public LoginRespondeDTO(String token, String email,  String role) {
        this.token = token;
        this.email = email;

        this.role = role;
    }
}
