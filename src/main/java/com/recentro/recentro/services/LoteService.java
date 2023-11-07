package com.recentro.recentro.services;
import com.recentro.recentro.models.Lote;
import com.recentro.recentro.repository.LoteRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoteService {

    @Autowired
    LoteRepository loteRepository;

    public Lote savePropriedade(Lote lote) {
        loteRepository.save(lote);
        return lote;
    }

    public void deletePropriedade(Long id) {
        Lote l = loteRepository.getById(id);
        loteRepository.delete(l);
        return ;
    }

    public List<Lote> findAll() {
        return loteRepository.findAll();
    }

    public Optional<Lote> findById(Long id) {
        return loteRepository.findById(id);
    }

    public void delete(Lote lote) {
        loteRepository.delete(lote);
    }

    public Lote updatePropriedade(Long id, Lote lote) throws Exception {
        Optional<Lote> existingLote = loteRepository.findById(id);

        if (existingLote.isPresent()) {
            Lote updatedLote = existingLote.get();
            updatedLote.setNomeEdificil(lote.getNomeEdificil());
            updatedLote.setAutorizacaoDeInformacao(lote.getAutorizacaoDeInformacao());
            updatedLote.setTributacao(lote.getTributacao());
            updatedLote.setProprietarioLocalizado(lote.getProprietarioLocalizado());
            updatedLote.setRestauranteCafes(lote.getRestauranteCafes());
            updatedLote.setQualInvestimento(lote.getQualInvestimento());
            updatedLote.setPichacao(lote.getPichacao());
            updatedLote.setObsevacao(lote.getObsevacao());
            updatedLote.setAtividadeDeFuncionament(lote.getAtividadeDeFuncionament());
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
