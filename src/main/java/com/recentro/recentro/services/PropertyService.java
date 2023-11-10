package com.recentro.recentro.services;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.property.Property;
import com.recentro.recentro.models.property.PropertyDTO;
import com.recentro.recentro.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public void saveProperty(PropertyDTO propertyParam) {
        Property property = new Property(propertyParam);
        this.propertyRepository.save(property);
    }

    public void deleteProperty(Long id){
        Property propertyId = propertyRepository.getById(id);
        propertyRepository.delete(propertyId);
        return ;
    }

    public PropertyDTO findById(Long id) throws ExistingEmail {
        Optional<Property> property = propertyRepository.findById(id);

        if (property.isPresent()) {
            return new PropertyDTO(property.get());
        }

        throw new ExistingEmail();
    }

    public List<PropertyDTO> listProperties(String address) throws Exception {
        Optional<List<Property>> properties = propertyRepository.getPropertyByAddress(address);

        if (properties.isPresent()) {
            List<Property> propertiesFromOptionalToList = new ArrayList<>(properties.get());
            List<PropertyDTO> fromListOfPropertiesToListOfPropertiesDTO = propertiesFromOptionalToList.stream().map(property -> new PropertyDTO(property)).collect(Collectors.toList());
            return fromListOfPropertiesToListOfPropertiesDTO;
        }

        throw new Exception();
    }

//    public Imovel updatePropriedade(Long id, Imovel imovel) throws Exception {
//        Optional<Imovel> existingImovel = imovelRepository.findById(id);
//
//        if (existingImovel.isPresent()) {
//            Imovel updatedImovel = existingImovel.get();
//            updatedImovel.setEndereco(imovel.getEndereco());
//            updatedImovel.setLatitude(imovel.getLatitude());
//            updatedImovel.setJudicializacao(imovel.getJudicializacao());
//            updatedImovel.setUsoDoImovel(imovel.getUsoDoImovel());
//            updatedImovel.setObservacao(imovel.getObservacao());
//            updatedImovel.setContatoProprietario(imovel.getContatoProprietario());
//            updatedImovel.setProprietarioCartorio(imovel.getProprietarioCartorio());
//            updatedImovel.setDescricaoJudicializacao(imovel.getDescricaoJudicializacao());
//            updatedImovel.setProprietarioCampo(imovel.getProprietarioCampo());
//            updatedImovel.setPlanta(imovel.getPlanta());
//            updatedImovel.setRgi(imovel.getRgi());
//            updatedImovel.setValorDoAluguel(imovel.getValorDoAluguel());
//            updatedImovel.setLongetude(imovel.getLongetude());
//            updatedImovel.setPlantaRegional(imovel.getPlantaRegional());
//
//            return imovelRepository.save(updatedImovel);
//        } else {
//            throw new Exception("Imovel not found");
//        }
//    }
}
