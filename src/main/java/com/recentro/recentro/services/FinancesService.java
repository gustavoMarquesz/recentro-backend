package com.recentro.recentro.services;
import com.recentro.recentro.models.finances.Finances;
import com.recentro.recentro.models.finances.FinancesRequestDTO;
import com.recentro.recentro.models.finances.FinancesResponseDTO;
import com.recentro.recentro.repository.FinancasRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FinancesService {

    @Autowired
    FinancasRepository financasRepository;

    @Transactional
    public Finances saveFinance(FinancesRequestDTO financesParam) {
        Finances finance = new Finances(financesParam);

        return financasRepository.save(finance);
    }

    public void deleteFinance(Long id) {
        Finances finance = financasRepository.getById(id);
        financasRepository.delete(finance);
    }

    public List<FinancesResponseDTO> findAll() {
        List<Finances> financesList = financasRepository.findAll();
        List<FinancesResponseDTO> finances = financesList.stream().map(currentFinance -> new FinancesResponseDTO(
                currentFinance.getDsqfl(),
                currentFinance.getNumero(),
                currentFinance.getRua(),
                currentFinance.getDsq(),
                currentFinance.getTipoEmpreendimento(),
                currentFinance.getAreaTotal(),
                currentFinance.getBairro()
        )).collect(Collectors.toList());

        return finances;
    }

    public Optional<FinancesResponseDTO> findById(Long id) throws Exception {
        Optional<Finances> finance = financasRepository.findById(id);

        if (finance.isPresent()) {
            return Optional.of(new FinancesResponseDTO(
                    finance.get().getDsqfl(),
                    finance.get().getNumero(),
                    finance.get().getRua(),
                    finance.get().getDsq(),
                    finance.get().getTipoEmpreendimento(),
                    finance.get().getAreaTotal(),
                    finance.get().getBairro()
            ));
        }
        throw new Exception();
    }


    public Finances updateFinances(Long id, FinancesRequestDTO financesParam) throws Exception {
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
