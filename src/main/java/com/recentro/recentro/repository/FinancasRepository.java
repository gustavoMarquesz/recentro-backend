package com.recentro.recentro.repository;


import com.recentro.recentro.models.Financas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.stereotype.Repository;

@Repository
public interface FinancasRepository extends JpaRepository<Financas, Long> {
}