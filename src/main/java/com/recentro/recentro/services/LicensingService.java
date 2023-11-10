package com.recentro.recentro.services;
import com.recentro.recentro.models.licensing.Licensing;
import com.recentro.recentro.models.licensing.LicensingDTO;
import com.recentro.recentro.repository.LicenciamentoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicensingService {

    @Autowired
    LicenciamentoRepository licenciamentoRepository;

    public void saveLicensing(LicensingDTO licensingParam) {
        Licensing licensing = new Licensing(licensingParam);
        licenciamentoRepository.save(licensing);
        return ;
    }

    public void deleteLicensing(Long id) {
        Licensing licensing = licenciamentoRepository.getById(id);
        licenciamentoRepository.delete(licensing);
        return ;
    }

    public List<LicensingDTO> findAll() {
        List<Licensing> licensings = licenciamentoRepository.findAll();
        List<LicensingDTO> licensingDTO = licensings.stream().map(licensing -> new LicensingDTO(licensing)).collect(Collectors.toList());
        return licensingDTO;
    }

    public Optional<LicensingDTO> findById(Long id) throws Exception {
        Optional<Licensing> licensing = licenciamentoRepository.findById(id);

        if (licensing.isPresent()) {
            Optional<LicensingDTO> licensingDTO = licensing.map(currentLicensing -> new LicensingDTO(currentLicensing));
            return licensingDTO;
        }

        throw new Exception();
    }

//    public void delete(Licenciamento licenciamento) {
//        licenciamentoRepository.delete(licenciamento);
//    }

//    public Licenciamento updatePropriedade(Long id, Licenciamento licenciamento) throws Exception {
//        Optional<Licenciamento> existingLicenciamento = licenciamentoRepository.findById(id);
//
//        if (existingLicenciamento.isPresent()) {
//            Licenciamento updatedLicenciamento = existingLicenciamento.get();
//            updatedLicenciamento.setNuProcesso(licenciamento.getNuProcesso());
//            updatedLicenciamento.setNuLicenca(licenciamento.getNuLicenca());
//            updatedLicenciamento.setProcessoAberto2018(licenciamento.getProcessoAberto2018());
//
//            return licenciamentoRepository.save(updatedLicenciamento);
//        } else {
//            throw new Exception("Licenciamento not found");
//        }
//    }
}
