package com.recentro.recentro.services;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.finances.Finances;
import com.recentro.recentro.models.finances.FinancesResponseDTO;
import com.recentro.recentro.models.licensing.Licensing;
import com.recentro.recentro.models.licensing.LicensingResponseDTO;
import com.recentro.recentro.models.lot.Lot;
import com.recentro.recentro.models.lot.LotResponseDTO;
import com.recentro.recentro.models.property.Property;
import com.recentro.recentro.models.property.PropertyRequestDTO;
import com.recentro.recentro.models.property.PropertyResponseDTO;
import com.recentro.recentro.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
        return ;
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
                    property.get().getLongetude(),
                    property.get().getLatitude(),
                    property.get().getPlantaRegional(),
                    property.get().getUsoDoImovel()
            );
        }

        throw new Exception();
    }

    public List<PropertyResponseDTO> listProperties(String address) {
        List<Property> propertiesFromRepository = propertyRepository.getPropertyByAddress(address);

        List<PropertyResponseDTO> properties = new ArrayList<PropertyResponseDTO>();
        properties.addAll(propertiesFromRepository.stream().map(
                propertyData -> new PropertyResponseDTO (
                        propertyData.getEndereco(),
                        propertyData.getContatoProprietario(),
                        propertyData.getProprietarioCartorio(),
                        propertyData.getObservacao(),
                        propertyData.getDescricaoJudicializacao(),
                        propertyData.getProprietarioCampo(),
                        propertyData.getPlanta(),
                        propertyData.getRgi(),
                        propertyData.getValorDoAluguel(),
                        propertyData.getJudicializacao(),
                        propertyData.getLongetude(),
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
                        propertyData.getLicensing().getProcessoAberto2018()
                )
        ).collect(Collectors.toList()));

        return properties;
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
