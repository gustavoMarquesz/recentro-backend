package com.recentro.recentro.repository;

import com.recentro.recentro.models.licensing.Licensing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenciamentoRepository extends JpaRepository<Licensing, Long> {

}
