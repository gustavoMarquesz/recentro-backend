package com.recentro.recentro.services;
import com.recentro.recentro.models.finances.Finances;
import com.recentro.recentro.models.finances.FinancesDTO;
import com.recentro.recentro.repository.FinancasRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancesService {

    @Autowired
    FinancasRepository financasRepository;

    public void saveFinance(FinancesDTO financesParam) {
        Finances finances = new Finances(financesParam);
        financasRepository.save(finances);
    }

    public void deleteFinance(Long id) {
        Finances finance = financasRepository.getById(id);
        financasRepository.delete(finance);
    }

    public List<FinancesDTO> findAll() {
        List<Finances> financesList = financasRepository.findAll();
        return financesList.stream().map(FinancesDTO::new).collect(Collectors.toList());
    }

    public Optional<FinancesDTO> findById(Long id) throws Exception {
        Optional<Finances> optionalFinance = financasRepository.findById(id);

        if (optionalFinance.isPresent()) {
            return Optional.of(new FinancesDTO(optionalFinance.get()));
        }
        throw new Exception();
    }


    public Finances updateFinances(Long id, FinancesDTO financesParam) throws Exception {
        Optional<Finances> existingFinances = financasRepository.findById(id);

        if (existingFinances.isPresent()) {
            Finances financesModel = existingFinances.get();
            BeanUtils.copyProperties(financesParam, financesModel);
            return financasRepository.save(financesModel);
        } else {
            throw new Exception("Financas not found");
        }
    }
}
