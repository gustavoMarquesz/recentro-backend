package com.recentro.recentro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.recentro.recentro.repository.ImovelRepository;

@RestController
public class ImovelController {
    
    @Autowired
    ImovelRepository imovelRepository;

}
