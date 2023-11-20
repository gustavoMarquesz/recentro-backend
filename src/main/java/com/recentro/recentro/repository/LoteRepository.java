package com.recentro.recentro.repository;

import com.recentro.recentro.models.lot.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lot, Long> {
    
}
