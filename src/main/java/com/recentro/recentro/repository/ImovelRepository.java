package com.recentro.recentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recentro.recentro.models.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    
}
