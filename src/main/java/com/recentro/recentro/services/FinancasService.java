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

    public void deletePropriedade(Long id) {
        Financas f = financasRepository.getById(id);
        financasRepository.delete(f);
        return;
    }

    public List<Financas> findAll() {
        return financasRepository.findAll();
    }

    public Optional<Financas> findById(Long id) {
        return financasRepository.findById(id);
    }

    public void delete(Financas financas) {
        financasRepository.delete(financas);
    }

    public Financas updatePropriedade(Long id, Financas financas) throws Exception {
        Optional<Financas> existingFinancas = financasRepository.findById(id);

        if (existingFinancas.isPresent()) {
            Financas updatedFinancas = existingFinancas.get();
            updatedFinancas.setDsqfl(financas.getDsqfl());
            updatedFinancas.setNumero(financas.getNumero());
            updatedFinancas.setRua(financas.getRua());
            updatedFinancas.setDsq(financas.getDsq());
            updatedFinancas.setTipoEmpreendimento(financas.getTipoEmpreendimento());
            updatedFinancas.setAreaTotal(financas.getAreaTotal());
            updatedFinancas.setBairro(financas.getBairro());

            return financasRepository.save(updatedFinancas);
        } else {
            throw new Exception("Financas not found");
        }
    }
}
