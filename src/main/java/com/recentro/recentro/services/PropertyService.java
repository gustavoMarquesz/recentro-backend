package com.recentro.recentro.services;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.property.LocationDTO;
import com.recentro.recentro.models.property.Property;
import com.recentro.recentro.models.property.PropertyRequestDTO;
import com.recentro.recentro.models.property.PropertyResponseDTO;
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

    public void saveProperty(Property propertyToBePersisted) {
        propertyRepository.save(propertyToBePersisted);
    }

    public void deleteProperty(Long id) {
        Property propertyId = propertyRepository.getById(id);
        propertyRepository.delete(propertyId);
    }

    public PropertyResponseDTO findById(Long id) throws Exception {
        Optional<Property> property = propertyRepository.findById(id);

        if (property.isPresent()) {
            return new PropertyResponseDTO(
                    property.get().getEndereco(),
                    property.get().getContatoProprietario(),
                    property.get().getProprietarioCartorio(),
                    property.get().getObservacao(),
                    property.get().getDescricaoJudicializacao(),
                    property.get().getProprietarioCampo(),
                    property.get().getPlanta(),
                    property.get().getRgi(),
                    property.get().getValorDoAluguel(),
                    property.get().getJudicializacao(),
                    property.get().getLongitude(),
                    property.get().getLatitude(),
                    property.get().getPlantaRegional(),
                    property.get().getUsoDoImovel()
            );
        }

        throw new ExistingEmail();
    }

    public List<PropertyResponseDTO> listPropertiesToAdmin() {
        List<Property> propertiesFromRepository = propertyRepository.getAllPropertyData();

        List<PropertyResponseDTO> properties = new ArrayList<>();
        properties.addAll(propertiesFromRepository.stream().map(
                propertyData -> new PropertyResponseDTO (
                        propertyData.getValorDeVenda(), propertyData.getId(), propertyData.getEndereco(),
                        propertyData.getContatoProprietario(),
                        propertyData.getProprietarioCartorio(),
                        propertyData.getObservacao(),
                        propertyData.getDescricaoJudicializacao(),
                        propertyData.getProprietarioCampo(),
                        propertyData.getPlanta(),
                        propertyData.getRgi(),
                        propertyData.getValorDoAluguel(),
                        propertyData.getJudicializacao(),
                        propertyData.getLongitude(),
                        propertyData.getLatitude(),
                        propertyData.getPlantaRegional(),
                        propertyData.getUsoDoImovel(),
                        propertyData.getFinances().getDsqfl(),
                        propertyData.getFinances().getNumero(),
                        propertyData.getFinances().getRua(),
                        propertyData.getFinances().getDsq(),
                        propertyData.getFinances().getTipoEmpreendimento(),
                        propertyData.getFinances().getAreaTotal(),
                        propertyData.getFinances().getBairro(),
                        propertyData.getLot().getNomeEdificil(),
                        propertyData.getLot().getAutorizacaoDeInformacao(),
                        propertyData.getLot().getTributacao(),
                        propertyData.getLot().getProprietarioLocalizado(),
                        propertyData.getLot().getRestauranteCafes(),
                        propertyData.getLot().getQualInvestimento(),
                        propertyData.getLot().getInvestimento(),
                        propertyData.getLot().getPichacao(),
                        propertyData.getLot().getObsevacao(),
                        propertyData.getLot().getAtividadeDeFuncionamento(),
                        propertyData.getLot().getAcessibilidade(),
                        propertyData.getLot().getLaudo(),
                        propertyData.getLot().getNumeroPavimentoEmUso(),
                        propertyData.getLot().getGrauDeRisco(),
                        propertyData.getLot().getSituacao(),
                        propertyData.getLot().getDisponibilidade(),
                        propertyData.getLicensing().getNuProcesso(),
                        propertyData.getLicensing().getNuLicenca(),
                        propertyData.getLicensing().getProcessoAberto2018(),

                        propertyData.getCoincidenciaProprietario())
        ).collect(Collectors.toList()));

        return properties;
    }


    public List<LocationDTO> getAllPropertyLocations() {
        List<Property> properties = propertyRepository.findAll();
        List<LocationDTO> propertyLocations = new ArrayList<>();

        for (Property property : properties) {
            propertyLocations.add(new LocationDTO(property.getLatitude(), property.getLongitude()));
        }

        return propertyLocations;
    }

    public List<PropertyResponseDTO> listAllProperties() {
        List<Property> propertiesFromRepository = propertyRepository.findAll();
        List<PropertyResponseDTO> properties = new ArrayList<PropertyResponseDTO>();
        properties.addAll(propertiesFromRepository.stream().map(
                propertyData -> new PropertyResponseDTO (
                        propertyData.getValorDeVenda(), propertyData.getId(), propertyData.getEndereco(),
                        propertyData.getContatoProprietario(),
                        propertyData.getProprietarioCartorio(),
                        propertyData.getObservacao(),
                        propertyData.getDescricaoJudicializacao(),
                        propertyData.getProprietarioCampo(),
                        propertyData.getPlanta(),
                        propertyData.getRgi(),
                        propertyData.getValorDoAluguel(),
                        propertyData.getJudicializacao(),
                        propertyData.getLongitude(),
                        propertyData.getLatitude(),
                        propertyData.getPlantaRegional(),
                        propertyData.getUsoDoImovel(),
                        propertyData.getFinances().getDsqfl(),
                        propertyData.getFinances().getNumero(),
                        propertyData.getFinances().getRua(),
                        propertyData.getFinances().getDsq(),
                        propertyData.getFinances().getTipoEmpreendimento(),
                        propertyData.getFinances().getAreaTotal(),
                        propertyData.getFinances().getBairro(),
                        propertyData.getLot().getNomeEdificil(),
                        propertyData.getLot().getAutorizacaoDeInformacao(),
                        propertyData.getLot().getTributacao(),
                        propertyData.getLot().getProprietarioLocalizado(),
                        propertyData.getLot().getRestauranteCafes(),
                        propertyData.getLot().getQualInvestimento(),
                        propertyData.getLot().getInvestimento(),
                        propertyData.getLot().getPichacao(),
                        propertyData.getLot().getObsevacao(),
                        propertyData.getLot().getAtividadeDeFuncionamento(),
                        propertyData.getLot().getAcessibilidade(),
                        propertyData.getLot().getLaudo(),
                        propertyData.getLot().getNumeroPavimentoEmUso(),
                        propertyData.getLot().getGrauDeRisco(),
                        propertyData.getLot().getSituacao(),
                        propertyData.getLot().getDisponibilidade(),
                        propertyData.getLicensing().getNuProcesso(),
                        propertyData.getLicensing().getNuLicenca(),
                        propertyData.getLicensing().getProcessoAberto2018(),
                        propertyData.getCoincidenciaProprietario()
                )
        ).collect(Collectors.toList()));

        return properties;
    }

    public List<PropertyResponseDTO> listPropertiesByCheckboxFilterInformation(
            String available,
            String occupied,
            String atConstruction,
            String abandoned,
            String cowork,
            String recifeAntigo,
            String santoAmaro,
            String saoJose
    ) {
        List<PropertyResponseDTO> propertiesFromRepository = propertyRepository.getPropertiesByFilteringWithCheckboxInformation(
                        available,
                        occupied,
                        atConstruction,
                        abandoned,
                        cowork,
                        recifeAntigo,
                        santoAmaro,
                        saoJose
        );

        return propertiesFromRepository;
    }

    public List<PropertyResponseDTO> listPropertiesWithFilteredData(String search) {
        List<PropertyResponseDTO> propertiesFromRepository = propertyRepository.getPropertyDataByNameOrNeighborhood(search);

        return propertiesFromRepository;
    }

    public Property updateProperty(Long id, PropertyRequestDTO propertyParam) throws Exception {
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
