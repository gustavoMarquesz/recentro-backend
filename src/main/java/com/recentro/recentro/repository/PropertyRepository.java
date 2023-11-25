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

    @Query("SELECT address FROM Property address " +
            "WHERE UPPER(address.endereco) LIKE UPPER(CONCAT('%', :address, '%'))"
    )
    List<Property> getAllPropertyData(@Param("address") String address);

    @Query("SELECT new com.recentro.recentro.models.property.PropertyResponseDTO( " +
            "property.endereco, lot.disponibilidade, property.longetude, property.latitude " + ") " +
            "FROM Property property " +
            "INNER JOIN property.finances finances " +
            "INNER JOIN property.lot lot " +
            "WHERE UPPER(lot.disponibilidade) = UPPER(:available)"
    )
    List<PropertyResponseDTO> getPropertiesByFilteringWithCheckboxInformation(
            @Param("available") String available
    );

    @Query("SELECT new com.recentro.recentro.models.property.PropertyResponseDTO( " +
            "property.endereco, lot.disponibilidade, property.longetude, property.latitude " + ") " +
            "FROM Property property " +
            "INNER JOIN property.finances finances " +
            "INNER JOIN property.lot lot " +
            "WHERE UPPER(property.endereco) LIKE UPPER(CONCAT('%', :address, '%')) " +
            "OR UPPER(finances.bairro) LIKE UPPER(CONCAT('%', :neighborhood, '%'))"
    )
    List<PropertyResponseDTO> getPropertyDataByNameOrNeighborhood(@Param("address") String address, @Param("neighborhood") String neighborhood);
}
