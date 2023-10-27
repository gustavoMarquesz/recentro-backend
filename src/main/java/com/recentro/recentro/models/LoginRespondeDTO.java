package com.recentro.recentro.models;


import lombok.Data;

@Data
public class LoginRespondeDTO {
    String token;

    public LoginRespondeDTO(String token){
        this.token = token;
    }
}
