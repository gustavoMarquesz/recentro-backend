package com.recentro.recentro.services;
import com.recentro.recentro.models.licensing.Licensing;
import com.recentro.recentro.models.licensing.LicensingRequestDTO;
import com.recentro.recentro.models.licensing.LicensingResponseDTO;
import com.recentro.recentro.repository.LicenciamentoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LicensingService {

    @Autowired
    LicenciamentoRepository licenciamentoRepository;

    @Transactional
    public Licensing saveLicensing(LicensingRequestDTO licensingParam) {
        Licensing licensing = new Licensing(licensingParam);

        return licenciamentoRepository.save(licensing);
    }

    public void deleteLicensing(Long id) {
        Licensing licensing = licenciamentoRepository.getById(id);
        licenciamentoRepository.delete(licensing);
    }

    public List<LicensingResponseDTO> findAll() {
        List<Licensing> licensings = licenciamentoRepository.findAll();

        List<LicensingResponseDTO> licensingResponseDTO = licensings.stream().map(licensing -> new LicensingResponseDTO(
                licensing.getNuProcesso(),
                licensing.getNuLicenca(),
                licensing.getProcessoAberto2018()
        )).collect(Collectors.toList());

        return licensingResponseDTO;
    }

    public Optional<LicensingResponseDTO> findById(Long id) throws Exception {
        Optional<Licensing> licensing = licenciamentoRepository.findById(id);

        if (licensing.isPresent()) {
            Optional<LicensingResponseDTO> licensingDTO = licensing.map(currentLicensing -> new LicensingResponseDTO(
                    currentLicensing.getNuProcesso(),
                    currentLicensing.getNuLicenca(),
                    currentLicensing.getProcessoAberto2018()
            ));

            return licensingDTO;
        }

        throw new Exception();
    }


    public Licensing updateLicensing(Long id, LicensingRequestDTO licensingParam) throws Exception {
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
