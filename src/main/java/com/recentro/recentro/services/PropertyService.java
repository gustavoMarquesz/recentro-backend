package com.recentro.recentro.services;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.property.Property;
import com.recentro.recentro.models.property.PropertyDTO;
import com.recentro.recentro.repository.PropertyRepository;
import org.springframework.beans.BeanUtils;
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
            return propertiesFromOptionalToList.stream().map(PropertyDTO::new).collect(Collectors.toList());
        }
        throw new Exception();
    }

    public Property updateProperty(Long id, PropertyDTO propertyParam) throws Exception {
        Optional<Property> existingProperty = propertyRepository.findById(id);

        if (existingProperty.isPresent()) {
            Property propertyModel = existingProperty.get();
            BeanUtils.copyProperties(propertyParam, propertyModel);
            return propertyRepository.save(propertyModel);
        } else {
            throw new Exception("Property not found");
        }
    }
}
