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

    public Imovel save(Imovel imovel){
         return imovelRepository.save(imovel);
    }

    public Imovel find(Long id) throws ExistingEmail {
        Optional<Imovel> propriedade = imovelRepository.findById(id);
        return propriedade.orElseThrow(() -> new ExistingEmail());
    }

    public Optional<List<Imovel>> listProperties(String address) {
        return imovelRepository.getPropertyByAddress(address);
    }
}
