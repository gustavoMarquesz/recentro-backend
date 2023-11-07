package com.recentro.recentro.controllers;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.*;
import com.recentro.recentro.services.FinancasService;
import com.recentro.recentro.services.ImovelService;
import com.recentro.recentro.services.LicenciamentoService;
import com.recentro.recentro.services.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/imovel")
public class ImovelController {
    
    @Autowired
    ImovelService imovelService;

    @Autowired
    FinancasService financasService;

    @Autowired
    LoteService loteService;

    @Autowired
    LicenciamentoService licenciamentoService;

    @PostMapping("/register")
    public ResponseEntity save(@RequestBody PropertyInformation property) {
        imovelService.savePropriedade(property.getImovel());
        financasService.savePropriedade(property.getFinancas());
        loteService.savePropriedade(property.getLote());
        licenciamentoService.savePropriedade(property.getLicenciamento());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) throws ExistingEmail {
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("imovel", imovelService.findById(id));
        responseBody.put("financas", financasService.findById(id));
        responseBody.put("lote", loteService.findById(id));
        responseBody.put("licenciamento", licenciamentoService.findById(id));
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/list")
    public List<?> listarPropriedades (
            @RequestParam(name = "address", defaultValue = "") String address
    ) throws Exception {

        List<Object> propriedades = new ArrayList<>();

        List <Imovel> imoveis = imovelService.listProperties(address);
        List <Financas> financas = financasService.findAll();
        List <Lote> lotes = loteService.findAll();
        List <Licenciamento> licenciamentos = licenciamentoService.findAll();

        for (int i = 0; i < imoveis.size(); i++) {
            propriedades.add(imoveis.get(i));
        }
        return propriedades;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePropriedades(@PathVariable(value="id") Long id) throws ExistingEmail {
        imovelService.deletePropriedade(id);
        financasService.deletePropriedade(id);
        loteService.deletePropriedade(id);
        licenciamentoService.deletePropriedade(id);
        return ResponseEntity.status(HttpStatus.OK).body("Imovel deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePropriedade(@PathVariable(value="id") Long id,
                                                    @RequestBody PropertyInformation property) throws Exception {
        imovelService.updatePropriedade(id, property.getImovel());
        licenciamentoService.updatePropriedade(id, property.getLicenciamento());
        loteService.updatePropriedade(id, property.getLote());
        financasService.updatePropriedade(id, property.getFinancas());
        return ResponseEntity.status(HttpStatus.OK).body("Imovel modified successfully.");
    }
}
