package com.recentro.recentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recentro.recentro.models.Disponibilidade;

import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {

}