package com.recentro.recentro.controllers;


import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.exceptions.ImovelNotFound;
import com.recentro.recentro.models.Imovel;
import com.recentro.recentro.models.User;
import com.recentro.recentro.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/imovel")
public class ImovelController {

    @Autowired
    ImovelService imovelService;

    @PostMapping("/register")
    public ResponseEntity save(@RequestBody Imovel imovel) throws ExistingEmail {
        imovelService.save(imovel);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) throws  ImovelNotFound {
        Imovel imovel = imovelService.find(id);
        return ResponseEntity.ok().body(imovel);
    }

    @GetMapping("/list")
    public List<Imovel> listarPropriedades() {
        return imovelService.listarPropriedades();
    }
}
