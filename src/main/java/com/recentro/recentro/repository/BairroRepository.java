package com.recentro.recentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recentro.recentro.models.Bairro;

import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

}