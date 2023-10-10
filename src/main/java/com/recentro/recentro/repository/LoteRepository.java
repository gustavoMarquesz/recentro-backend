package com.recentro.recentro.repository;

import com.recentro.recentro.models.Lote;
import com.recentro.recentro.models.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {

}
