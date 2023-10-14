package com.recentro.recentro.services;
import com.recentro.recentro.models.Lote;
import com.recentro.recentro.repository.LoteRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoteService {

    @Autowired
    LoteRepository loteRepository;

    public Lote savePropriedade(Lote lote) {
        loteRepository.save(lote);
        return lote;
    }

    public List<Lote> findAll(Pageable pageable) {
        return loteRepository.findAll();
    }

    public Optional<Lote> findById(Long id) {
        return loteRepository.findById(id);
    }

    public void delete(Lote lote) {
        loteRepository.delete(lote);
    }
}
