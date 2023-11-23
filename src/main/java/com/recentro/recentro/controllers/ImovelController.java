package com.recentro.recentro.controllers;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.*;
import com.recentro.recentro.models.finances.Finances;
import com.recentro.recentro.models.licensing.Licensing;
import com.recentro.recentro.models.lot.Lot;
import com.recentro.recentro.models.property.Property;
import com.recentro.recentro.models.property.PropertyResponseDTO;
import com.recentro.recentro.services.FinancesService;
import com.recentro.recentro.services.PropertyService;
import com.recentro.recentro.services.LicensingService;
import com.recentro.recentro.services.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> save(@RequestBody PropertyInformation propertyInformation) {
        Finances finance = financesService.saveFinance(propertyInformation.getFinances());
        Lot lot = lotService.saveLot(propertyInformation.getLot());
        Licensing licensing = licensingService.saveLicensing(propertyInformation.getLicensing());

        Property propertyToBePersisted = new Property(propertyInformation.getProperty());
        propertyToBePersisted.setFinances(finance);
        propertyToBePersisted.setLicensing(licensing);
        propertyToBePersisted.setLot(lot);

        propertyService.saveProperty(propertyToBePersisted);

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

    @PostMapping("/search")
    public ResponseEntity<List<PropertyResponseDTO>> listarPropriedades (
            @RequestBody String address
    ) throws Exception {
        List <PropertyResponseDTO> properties = propertyService.listProperties(address);

        return ResponseEntity.status(HttpStatus.OK).body(properties);
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
