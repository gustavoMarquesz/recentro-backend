package com.recentro.recentro.services;
import com.recentro.recentro.models.Licenciamento;
import com.recentro.recentro.repository.LicenciamentoRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LicenciamentoService {

    @Autowired
    LicenciamentoRepository licenciamentoRepository;

    public Licenciamento savePropriedade(Licenciamento licenciamento) {
        licenciamentoRepository.save(licenciamento);
        return licenciamento;
    }

    public void deletePropriedade(Long id) {
        Licenciamento l = licenciamentoRepository.getById(id);
        licenciamentoRepository.delete(l);
        return ;
    }

    public List<Licenciamento> findAll() {
        return licenciamentoRepository.findAll();
    }

    public Optional<Licenciamento> findById(Long id) {
        return licenciamentoRepository.findById(id);
    }

    public void delete(Licenciamento licenciamento) {
        licenciamentoRepository.delete(licenciamento);
    }

    public Licenciamento updatePropriedade(Long id, Licenciamento licenciamento) throws Exception {
        Optional<Licenciamento> existingLicenciamento = licenciamentoRepository.findById(id);

        if (existingLicenciamento.isPresent()) {
            Licenciamento updatedLicenciamento = existingLicenciamento.get();
            updatedLicenciamento.setNuProcesso(licenciamento.getNuProcesso());
            updatedLicenciamento.setNuLicenca(licenciamento.getNuLicenca());
            updatedLicenciamento.setProcessoAberto2018(licenciamento.getProcessoAberto2018());

            return licenciamentoRepository.save(updatedLicenciamento);
        } else {
            throw new Exception("Licenciamento not found");
        }
    }
}
