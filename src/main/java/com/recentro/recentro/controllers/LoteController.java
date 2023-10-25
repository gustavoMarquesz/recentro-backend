package com.recentro.recentro.controllers;

import com.recentro.recentro.services.LoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class LoteController {

    @Autowired
    LoteService loteService;
}
