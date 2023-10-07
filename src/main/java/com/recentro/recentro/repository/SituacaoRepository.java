package com.recentro.recentro.repository;

import com.recentro.recentro.models.Propriedade;
import com.recentro.recentro.models.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, Long> {
    // Para funções básicas como CRUD, só isso basta. Aqui tem métodos como:
    // FindById, Save, DeleteById, Filter
    // Algo mais personalizado, só colocar o código aqui

}
