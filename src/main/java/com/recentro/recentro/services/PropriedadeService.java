package com.recentro.recentro.services;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.Propriedade;
import com.recentro.recentro.repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PropriedadeService {

    @Autowired
    PropriedadeRepository propriedadeRepository;

    // deixando o exemplo do Save usando o JPA para salvar
    public Propriedade savePropriedade(Propriedade propriedade){
        return  propriedadeRepository.save(propriedade);
    }

    public Propriedade find(Long id) throws ExistingEmail {
        Optional<Propriedade> propriedade = propriedadeRepository.findById(id);
        return propriedade.orElseThrow(() -> new ExistingEmail());
    }

    public List<Propriedade> listarPropriedades() {
        return propriedadeRepository.findAll();
    }

}
