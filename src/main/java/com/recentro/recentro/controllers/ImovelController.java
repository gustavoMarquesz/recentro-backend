package com.recentro.recentro.controllers;

import com.recentro.recentro.models.Financas;
import com.recentro.recentro.models.Imovel;
import com.recentro.recentro.models.Licenciamento;
import com.recentro.recentro.models.Lote;
import com.recentro.recentro.services.FinancasService;
import com.recentro.recentro.services.ImovelService;
import com.recentro.recentro.services.LicenciamentoService;
import com.recentro.recentro.services.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity save(@RequestBody Imovel i, @RequestBody Financas f, @RequestBody Lote lo, @RequestBody Licenciamento li) {
        imovelService.savePropriedade(i);
        financasService.savePropriedade(f);
        loteService.savePropriedade(lo);
        licenciamentoService.savePropriedade(li);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) {
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("imovel", imovelService.findById(id));
        responseBody.put("financas", financasService.findById(id));
        responseBody.put("lote", loteService.findById(id));
        responseBody.put("licenciamento", licenciamentoService.findById(id));
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/list")
    public List<?> listarPropriedades() {
        List<Object> propriedades = new ArrayList<>();
        List <Imovel> imoveis = imovelService.findAll();
        List <Financas> financas = financasService.findAll();
        List <Lote> lotes = loteService.findAll();
        List <Licenciamento> licenciamentos = licenciamentoService.findAll();
        for (int i = 0; i < imoveis.size(); i++) {
            propriedades.add(imoveis.get(i));
            propriedades.add(financas.get(i));
            propriedades.add(lotes.get(i));
            propriedades.add(licenciamentos.get(i));
        }
        return propriedades;
    }
}
