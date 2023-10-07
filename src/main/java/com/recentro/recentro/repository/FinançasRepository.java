package com.recentro.recentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recentro.recentro.models.Finanças;

import org.springframework.stereotype.Repository;

@Repository
public interface FinançasRepository extends JpaRepository<Finanças, Long> {

}