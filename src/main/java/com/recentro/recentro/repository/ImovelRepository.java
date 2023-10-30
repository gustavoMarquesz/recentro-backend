package com.recentro.recentro.repository;

import com.recentro.recentro.models.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
