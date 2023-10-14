package com.recentro.recentro.services;
import com.recentro.recentro.models.Imovel;
import com.recentro.recentro.repository.ImovelRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImovelService {

    @Autowired
    ImovelRepository imovelRepository;

    public Imovel savePropriedade(Imovel imovel) {
        imovelRepository.save(imovel);
        return imovel;
    }

    public List<Imovel> findAll(Pageable pageable) {
        return imovelRepository.findAll();
    }

    public Optional<Imovel> findById(Long id) {
        return imovelRepository.findById(id);
    }

    public void delete(Imovel imovel) {
        imovelRepository.delete(imovel);
    }
}
