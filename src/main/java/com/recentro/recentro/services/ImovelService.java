package com.recentro.recentro.services;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.Imovel;
import com.recentro.recentro.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ImovelService {

    @Autowired
    ImovelRepository imovelRepository;

    public Imovel savePropriedade(Imovel imovel){
         return imovelRepository.save(imovel);
    }

    public void deletePropriedade(Long id){
        Imovel i = imovelRepository.getById(id);
        imovelRepository.delete(i);
        return ;
    }

    public Imovel findById(Long id) throws ExistingEmail {
        Optional<Imovel> propriedade = imovelRepository.findById(id);
        return propriedade.orElseThrow(() -> new ExistingEmail());
    }

    public List<Imovel> listProperties(String address) throws Exception {
        Optional<List<Imovel>> imoveis = imovelRepository.getPropertyByAddress(address);

        if (imoveis.isPresent()) {
            return new ArrayList<>(imoveis.get());
        }

        throw new Exception();
    }

    public Imovel updatePropriedade(Long id, Imovel imovel) throws Exception {
        Optional<Imovel> existingImovel = imovelRepository.findById(id);

        if (existingImovel.isPresent()) {
            Imovel updatedImovel = existingImovel.get();
            updatedImovel.setEndereco(imovel.getEndereco());
            updatedImovel.setLatitude(imovel.getLatitude());
            updatedImovel.setJudicializacao(imovel.getJudicializacao());
            updatedImovel.setUsoDoImovel(imovel.getUsoDoImovel());
            updatedImovel.setObservacao(imovel.getObservacao());
            updatedImovel.setContatoProprietario(imovel.getContatoProprietario());
            updatedImovel.setProprietarioCartorio(imovel.getProprietarioCartorio());
            updatedImovel.setDescricaoJudicializacao(imovel.getDescricaoJudicializacao());
            updatedImovel.setProprietarioCampo(imovel.getProprietarioCampo());
            updatedImovel.setPlanta(imovel.getPlanta());
            updatedImovel.setRgi(imovel.getRgi());
            updatedImovel.setValorDoAluguel(imovel.getValorDoAluguel());
            updatedImovel.setLongetude(imovel.getLongetude());
            updatedImovel.setPlantaRegional(imovel.getPlantaRegional());

            return imovelRepository.save(updatedImovel);
        } else {
            throw new Exception("Imovel not found");
        }
    }
}
