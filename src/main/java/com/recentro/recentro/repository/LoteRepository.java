package com.recentro.recentro.repository;

import com.recentro.recentro.models.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {

    @Query("select disponibilidade from Lote where disponibilidade = :dispo")
    Lote findByDispo(String dispo);
    
}
