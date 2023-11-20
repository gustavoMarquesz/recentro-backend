package com.recentro.recentro.controllers;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.*;
import com.recentro.recentro.models.property.PropertyDTO;
import com.recentro.recentro.services.FinancesService;
import com.recentro.recentro.services.PropertyService;
import com.recentro.recentro.services.LicensingService;
import com.recentro.recentro.services.LotService;
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
    PropertyService propertyService;

    @Autowired
    FinancesService financesService;

    @Autowired
    LotService lotService;

    @Autowired
    LicensingService licensingService;

    @PostMapping("/register")
    public ResponseEntity<Void> save(@RequestBody PropertyInformation property) {
        financesService.saveFinance(property.getFinances());
        lotService.saveLot(property.getLot());
        licensingService.saveLicensing(property.getLicensing());
        propertyService.saveProperty(property.getProperty());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) throws ExistingEmail, Exception {
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("imovel", propertyService.findById(id));
        responseBody.put("financas", financesService.findById(id));
        responseBody.put("lote", lotService.findById(id));
        responseBody.put("licenciamento", licensingService.findById(id));
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/list")
    public List<?> listarPropriedades (
            @RequestParam(name = "address", defaultValue = "") String address
    ) throws Exception {

        List<Object> propriedades = new ArrayList<>();

        List <PropertyDTO> properties = propertyService.listProperties(address);

        for (PropertyDTO property : properties) {
            propriedades.add(property);
        }

        return propriedades;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProperty(@PathVariable(value="id") Long id) throws ExistingEmail {
        propertyService.deleteProperty(id);
        financesService.deleteFinance(id);
        lotService.deleteLot(id);
        licensingService.deleteLicensing(id);
        return ResponseEntity.status(HttpStatus.OK).body("Imovel deleted successfully.");
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updatePropriedade(@PathVariable(value="id") Long id,
//                                                    @RequestBody PropertyInformation property) throws Exception {
//        propertyService.updatePropriedade(id, property.getProperty());
//        licensingService.updatePropriedade(id, property.getLicensing());
//        lotService.updatePropriedade(id, property.getLot());
//        financesService.updatePropriedade(id, property.getFinances());
//        return ResponseEntity.status(HttpStatus.OK).body("Imovel modified successfully.");
//    }
}
