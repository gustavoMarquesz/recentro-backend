package com.recentro.recentro.repository;

import com.recentro.recentro.models.property.Property;
import com.recentro.recentro.models.property.PropertyResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT address FROM Property address")
    List<Property> getAllPropertyData();

    @Query("SELECT new com.recentro.recentro.models.property.PropertyResponseDTO(" +
            "lot.nomeEdificil, property.endereco, lot.disponibilidade, property.longetude, property.latitude " + ") " +
            "FROM Property property " +
            "INNER JOIN property.finances finances " +
            "INNER JOIN property.lot lot " +
            "WHERE UPPER(lot.disponibilidade) LIKE UPPER(CONCAT('%', :available, '%')) " +
            "OR UPPER(lot.disponibilidade) = UPPER(:occupied) " +
            "OR UPPER(lot.disponibilidade) = UPPER(:abandoned) " +
            "OR UPPER(lot.situacao) = UPPER(:atConstruction) " +
            "OR UPPER(lot.atividadeDeFuncionamento) LIKE UPPER(CONCAT('%', :cowork, '%')) " +
            "OR UPPER(finances.bairro) = UPPER(:RecifeAntigo) " +
            "OR UPPER(finances.bairro) = UPPER(:SantoAmaro) " +
            "OR UPPER(finances.bairro) = UPPER(:SaoJose)"
    )
    List<PropertyResponseDTO> getPropertiesByFilteringWithCheckboxInformation(
            @Param("available") String available,
            @Param("occupied") String occupied,
            @Param("atConstruction") String atConstruction,
            @Param("abandoned") String abandoned,
            @Param("cowork") String cowork,
            @Param("RecifeAntigo") String recifeAntigo,
            @Param("SantoAmaro") String santoAmaro,
            @Param("SaoJose") String saoJose
    );

    @Query("SELECT new com.recentro.recentro.models.property.PropertyResponseDTO( " +
            "lot.nomeEdificil, property.endereco, lot.disponibilidade, property.longetude, property.latitude " + ") " +
            "FROM Property property " +
            "INNER JOIN property.finances finances " +
            "INNER JOIN property.lot lot " +
            "WHERE UPPER(property.endereco) LIKE UPPER(CONCAT('%', :search, '%')) " +
            "OR UPPER(finances.bairro) LIKE UPPER(CONCAT('%', :search, '%'))"
    )
    List<PropertyResponseDTO> getPropertyDataByNameOrNeighborhood(@Param("search") String search);
}
