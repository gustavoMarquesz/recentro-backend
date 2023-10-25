package com.recentro.recentro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.recentro.recentro.services.FinancasService;

@RestController
public class FinancasController {
    
    @Autowired
    FinancasService financasService;

}
