package com.recentro.recentro.repository;

import com.recentro.recentro.models.finances.Finances;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

@Repository
public interface FinancasRepository extends JpaRepository<Finances, Long> {
}