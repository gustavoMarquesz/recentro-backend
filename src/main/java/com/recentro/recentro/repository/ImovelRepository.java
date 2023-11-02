package com.recentro.recentro.repository;

import com.recentro.recentro.models.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    @Query("SELECT obj FROM Imovel obj " +
            "WHERE UPPER(obj.endereco) LIKE UPPER(CONCAT('%', :address, '%'))")
    List<Imovel> getPropertyByAddress(String address);
}
