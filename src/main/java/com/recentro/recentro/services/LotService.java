package com.recentro.recentro.services;
import com.recentro.recentro.models.lot.Lot;
import com.recentro.recentro.models.lot.LotDTO;
import com.recentro.recentro.models.property.Property;
import com.recentro.recentro.models.property.PropertyDTO;
import com.recentro.recentro.repository.LoteRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotService {

    @Autowired
    LoteRepository loteRepository;

    public void saveLot(LotDTO lotParam) {
        Lot lot = new Lot(lotParam);
        loteRepository.save(lot);
    }

    public void deleteLot(Long id) {
        Lot lot = loteRepository.getById(id);
        loteRepository.delete(lot);
    }

    public List<Lot> findAll() {
        return loteRepository.findAll();
    }

    public Optional<Lot> findById(Long id) {
        return loteRepository.findById(id);
    }

    public Lot updateLot(Long id, LotDTO loteParam) throws Exception {
        Optional<Lot> existingLot = loteRepository.findById(id);

        if (existingLot.isPresent()) {
            Lot loteModel = existingLot.get();
            BeanUtils.copyProperties(loteParam, loteModel);
            return loteRepository.save(loteModel);
        } else {
            throw new Exception("Lote not found");
        }
    }

}
