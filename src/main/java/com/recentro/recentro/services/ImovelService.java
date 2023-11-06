package com.recentro.recentro.services;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.Imovel;
import com.recentro.recentro.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ImovelService {

    @Autowired
    ImovelRepository imovelRepository;

    public Imovel savePropriedade(Imovel imovel){
         return imovelRepository.save(imovel);
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
}
