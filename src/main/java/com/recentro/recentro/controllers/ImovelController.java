package com.recentro.recentro.controllers;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.*;
import com.recentro.recentro.models.finances.Finances;
import com.recentro.recentro.models.licensing.Licensing;
import com.recentro.recentro.models.lot.Lot;
import com.recentro.recentro.models.property.Property;
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
    public ResponseEntity<Void> save(@RequestBody PropertyInformation property) {
        financasService.savePropriedade(property.getFinances());
        loteService.savePropriedade(property.getLot());
        licenciamentoService.savePropriedade(property.getLicensing());
        imovelService.savePropriedade(property.getProperty());
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

        List <Property> imoveis = imovelService.listProperties(address);
        List <Finances> financas = financasService.findAll();
        List <Lot> lots = loteService.findAll();
        List <Licensing> licensings = licenciamentoService.findAll();

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
        imovelService.updatePropriedade(id, property.getProperty());
        licenciamentoService.updatePropriedade(id, property.getLicensing());
        loteService.updatePropriedade(id, property.getLot());
        financasService.updatePropriedade(id, property.getFinances());
        return ResponseEntity.status(HttpStatus.OK).body("Imovel modified successfully.");
    }
}
