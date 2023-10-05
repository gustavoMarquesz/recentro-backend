package com.recentro.recentro.controllers;


import com.recentro.recentro.models.Propriedade;
import com.recentro.recentro.services.PropriedadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;



@RestController
@RequestMapping(value = "/eventos")
@Api(value = "API Recentro")
@CrossOrigin(origins = "*")
public class PropriedadeController {

    @Autowired
    PropriedadeService propriedadeService;

    // Tentar manter o padrão de Reponse Entity
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "Salva uma propriedade")
    public ResponseEntity<Void> save (@RequestBody Propriedade propriedade){
        propriedade = propriedadeService.savePropriedade(propriedade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(propriedade.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
