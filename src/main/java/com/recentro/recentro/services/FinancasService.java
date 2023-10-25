package com.recentro.recentro.services;
import com.recentro.recentro.models.Financas;
import com.recentro.recentro.repository.FinancasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FinancasService {

    @Autowired
    FinancasRepository financasRepository;

    public Financas savePropriedade(Financas financas) {
        financasRepository.save(financas);
        return financas;
    }

    public List<Financas> findAll(Pageable pageable) {
        return financasRepository.findAll();
    }

    public Optional<Financas> findById(Long id) {
        return financasRepository.findById(id);
    }

    public void delete(Financas financas) {
        financasRepository.delete(financas);
    }
}
