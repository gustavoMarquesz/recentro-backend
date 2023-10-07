package com.recentro.recentro.repository;

import com.recentro.recentro.models.Licenciamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenciamentoRepository extends JpaRepository<Licenciamento, String> {
    // Para funções básicas como CRUD, só isso basta. Aqui tem métodos como:
    // FindById, Save, DeleteById, Filter
    // Algo mais personalizado, só colocar o código aqui

}
