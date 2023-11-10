package com.recentro.recentro.controllers;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.LoginRespondeDTO;
import com.recentro.recentro.models.user.User;
import com.recentro.recentro.models.user.UserDTO;
import com.recentro.recentro.security.TokenService;
import com.recentro.recentro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<Void> save(@RequestBody UserDTO user) throws ExistingEmail {
        String encryptedPassword = passwordEncoder.encode(user.getPassword()); // PasswordEncoder injetado

        User newUser = new User(user.getEmail(), encryptedPassword, user.getRole()); // senha criptografada
        userService.save(newUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRespondeDTO> login(@RequestBody @Validated UserDTO user) {
        var userPassword = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        var auth = authenticationManager.authenticate(userPassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        // Crie uma classe TokenResponseDTO para representar a resposta com o token JWT
        LoginRespondeDTO responseDTO = new LoginRespondeDTO(token);

        return ResponseEntity.ok(responseDTO);
    }


}
