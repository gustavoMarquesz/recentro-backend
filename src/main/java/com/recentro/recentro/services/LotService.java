package com.recentro.recentro.services;
import com.recentro.recentro.models.lot.Lot;
import com.recentro.recentro.models.lot.LotRequestDTO;
import com.recentro.recentro.repository.LoteRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LotService {

    @Autowired
    LoteRepository loteRepository;

    @Transactional
    public Lot saveLot(LotRequestDTO lotParam) {
        Lot lot = new Lot(lotParam);

        return loteRepository.save(lot);
    }

    public void deleteLot(Long id) {
        Lot lot = loteRepository.getById(id);
        loteRepository.delete(lot);
        return ;
    }

    public List<Lot> findAll() {
        return loteRepository.findAll();
    }

    public Optional<Lot> findById(Long id) {
        return loteRepository.findById(id);
    }

//    public void deleteLot(Long id) {
//        loteRepository.delete(id);
//    }

    public Lot updateProperty(Long id, Lot lote) throws Exception {
        Optional<Lot> existingLote = loteRepository.findById(id);

        if (existingLote.isPresent()) {
            Lot updatedLote = existingLote.get();
            updatedLote.setNomeEdificil(lote.getNomeEdificil());
            updatedLote.setAutorizacaoDeInformacao(lote.getAutorizacaoDeInformacao());
            updatedLote.setTributacao(lote.getTributacao());
            updatedLote.setProprietarioLocalizado(lote.getProprietarioLocalizado());
            updatedLote.setRestauranteCafes(lote.getRestauranteCafes());
            updatedLote.setQualInvestimento(lote.getQualInvestimento());
            updatedLote.setPichacao(lote.getPichacao());
            updatedLote.setObsevacao(lote.getObsevacao());
            updatedLote.setAtividadeDeFuncionamento(lote.getAtividadeDeFuncionamento());
            updatedLote.setAcessibilidade(lote.getAcessibilidade());
            updatedLote.setLaudo(lote.getLaudo());
            updatedLote.setNumeroPavimentoEmUso(lote.getNumeroPavimentoEmUso());
            updatedLote.setGrauDeRisco(lote.getNumeroPavimentoEmUso());
            updatedLote.setSituacao(lote.getSituacao());
            updatedLote.setDisponibilidade(lote.getDisponibilidade());

            return loteRepository.save(updatedLote);
        } else {
            throw new Exception("Lote not found");
        }
    }
}
