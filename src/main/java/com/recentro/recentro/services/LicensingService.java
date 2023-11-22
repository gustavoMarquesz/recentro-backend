package com.recentro.recentro.services;
import com.recentro.recentro.models.licensing.Licensing;
import com.recentro.recentro.models.licensing.LicensingDTO;
import com.recentro.recentro.models.lot.Lot;
import com.recentro.recentro.models.lot.LotDTO;
import com.recentro.recentro.repository.LicenciamentoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicensingService {

    @Autowired
    LicenciamentoRepository licenciamentoRepository;

    public void saveLicensing(LicensingDTO licensingParam) {
        Licensing licensing = new Licensing(licensingParam);
        licenciamentoRepository.save(licensing);
    }

    public void deleteLicensing(Long id) {
        Licensing licensing = licenciamentoRepository.getById(id);
        licenciamentoRepository.delete(licensing);
    }

    public List<LicensingDTO> findAll() {
        List<Licensing> licensings = licenciamentoRepository.findAll();
        return licensings.stream().map(LicensingDTO::new).collect(Collectors.toList());
    }

    public Optional<LicensingDTO> findById(Long id) throws Exception {
        Optional<Licensing> licensing = licenciamentoRepository.findById(id);

        if (licensing.isPresent()) {
            return licensing.map(LicensingDTO::new);
        }

        throw new Exception();
    }


    public Licensing updateLicensing(Long id, LicensingDTO licensingParam) throws Exception {
        Optional<Licensing> existingLicensing = licenciamentoRepository.findById(id);

        if (existingLicensing.isPresent()) {
            Licensing licensingModel = existingLicensing.get();
            BeanUtils.copyProperties(licensingParam, licensingModel);
            return licenciamentoRepository.save(licensingModel);
        } else {
            throw new Exception("Licenciamento not found");
        }
    }
}
