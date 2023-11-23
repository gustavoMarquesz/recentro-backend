package com.recentro.recentro.repository;

import com.recentro.recentro.models.property.Property;
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
    List<Property> getPropertyByAddress(@Param("address") String address);
}
