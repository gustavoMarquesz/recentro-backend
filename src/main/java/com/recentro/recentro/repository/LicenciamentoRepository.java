package com.recentro.recentro.repository;

import com.recentro.recentro.models.Licenciamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenciamentoRepository extends JpaRepository<Licenciamento, Long> {

}