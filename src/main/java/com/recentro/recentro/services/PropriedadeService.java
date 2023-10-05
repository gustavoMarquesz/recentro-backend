package com.recentro.recentro.services;

import com.recentro.recentro.models.Propriedade;
import com.recentro.recentro.repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropriedadeService {

    @Autowired
    PropriedadeRepository propriedadeRepository;

    // deixando o exemplo do Save usando o JPA para salvar
    public Propriedade savePropriedade(Propriedade propriedade){
        propriedadeRepository.save(propriedade);
        return propriedade;
    }


}
