package com.recentro.recentro.services;
import com.recentro.recentro.models.Finanças;
import com.recentro.recentro.repository.FinançasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FinançasService {

    @Autowired
    FinançasRepository finançasRepository;

    public Finanças savePropriedade(Finanças finanças) {
        finançasRepository.save(finanças);
        return finanças;
    }

    public List<Finanças> findAll(Pageable pageable) {
        return finançasRepository.findAll();
    }

    public Optional<Finanças> findById(Long id) {
        return finançasRepository.findById(id);
    }

    public void delete(Finanças finanças) {
        finançasRepository.delete(finanças);
    }
}
