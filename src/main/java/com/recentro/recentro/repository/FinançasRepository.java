package com.recentro.recentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recentro.recentro.models.Finanças;
import com.recentro.recentro.models.Lote;

import org.springframework.stereotype.Repository;

@Repository
public interface FinançasRepository extends JpaRepository<Finanças, Long> {

    @Query("select bairro from Finanças where bairro = :bairro")
    Lote findByBairro(String bairro);

    @Query("select rua, número from Finanças where rua = :rua and número = :num")
    Lote findByDispo(String rua, String num);
    
}