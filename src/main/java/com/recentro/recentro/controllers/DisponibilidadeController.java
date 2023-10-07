package com.recentro.recentro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.recentro.recentro.repository.DisponibilidadeRepository;

@RestController
public class DisponibilidadeController {
    
    @Autowired
    DisponibilidadeRepository disponibilidadeRepository;
}
