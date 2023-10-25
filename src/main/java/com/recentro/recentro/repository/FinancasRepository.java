package com.recentro.recentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.recentro.recentro.models.Financas;

import org.springframework.stereotype.Repository;

@Repository
public interface FinancasRepository extends JpaRepository<Financas, Long> {

    /*@Query("select bairro from Finanças where bairro = :bairro")
    Financas findByBairro(String bairro);

    @Query("select rua, número from Finanças where rua = :rua and número = :num")
    Financas findByDispo(String rua, String num);*/
    
}