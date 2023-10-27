package com.recentro.recentro.controllers;


import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.Propriedade;
import com.recentro.recentro.services.PropriedadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/imovel")
@Api(value = "API Recentro")
@CrossOrigin(origins = "*")
public class PropriedadeController {

    @Autowired
    PropriedadeService propriedadeService;

    // Tentar manter o padrão de Reponse Entity
    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    @ApiOperation(value = "Salva um imovel no mapa")
    public ResponseEntity<Void> save (@RequestBody Propriedade propriedade){
        propriedade = propriedadeService.savePropriedade(propriedade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(propriedade.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) throws ExistingEmail {
        Propriedade cota = propriedadeService.find(id);
        return ResponseEntity.ok().body(cota);
    }

    @GetMapping("/listar")
    public List<Propriedade> listarPropriedades() {
        return propriedadeService.listarPropriedades();
    }

}
