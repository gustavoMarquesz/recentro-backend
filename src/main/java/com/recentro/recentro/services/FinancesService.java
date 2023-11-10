package com.recentro.recentro.services;
import com.recentro.recentro.models.finances.Finances;
import com.recentro.recentro.models.finances.FinancesDTO;
import com.recentro.recentro.repository.FinancasRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancesService {

    @Autowired
    FinancasRepository financasRepository;

    public Finances saveFinance(FinancesDTO financesParam) {
        Finances finances = new Finances(financesParam);
        financasRepository.save(finances);
        return finances;
    }

    public void deleteFinance(Long id) {
        Finances finance = financasRepository.getById(id);
        financasRepository.delete(finance);
        return;
    }

    public List<FinancesDTO> findAll() {

        List<Finances> financesList = financasRepository.findAll();
        List<FinancesDTO> finances = financesList.stream().map(currentFinance -> new FinancesDTO(currentFinance)).collect(Collectors.toList());
        return finances;
    }

    public Optional<FinancesDTO> findById(Long id) throws Exception {
        Optional<Finances> optionalFinance = financasRepository.findById(id);

        if (optionalFinance.isPresent()) {
            return Optional.of(new FinancesDTO(optionalFinance.get()));
        }

        throw new Exception();
    }

//    public void delete(Finances financas) {
//        financasRepository.delete(financas);
//    }
//
//    public Financas updatePropriedade(Long id, Financas financas) throws Exception {
//        Optional<Financas> existingFinancas = financasRepository.findById(id);
//
//        if (existingFinancas.isPresent()) {
//            Financas updatedFinancas = existingFinancas.get();
//            updatedFinancas.setDsqfl(financas.getDsqfl());
//            updatedFinancas.setNumero(financas.getNumero());
//            updatedFinancas.setRua(financas.getRua());
//            updatedFinancas.setDsq(financas.getDsq());
//            updatedFinancas.setTipoEmpreendimento(financas.getTipoEmpreendimento());
//            updatedFinancas.setAreaTotal(financas.getAreaTotal());
//            updatedFinancas.setBairro(financas.getBairro());
//
//            return financasRepository.save(updatedFinancas);
//        } else {
//            throw new Exception("Financas not found");
//        }
//    }
}
