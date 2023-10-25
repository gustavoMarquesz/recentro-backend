package com.recentro.recentro.controllers;

import com.recentro.recentro.models.Lote;
import com.recentro.recentro.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class LoteController {

    @Autowired
    LoteRepository loteRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Lote>> getAllProducts(){
        List<Lote> productsList = loteRepository.findAll();
        if(!productsList.isEmpty()) {
            /*for(Lote lote : productsList) {
                Long id = lote.getId();
                lote.add(linkTo(methodOn(LoteController.class).getOneProduct(id)).withSelfRel());
            }*/
        }
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }


}
