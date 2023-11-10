package com.recentro.recentro.repository;

import com.recentro.recentro.models.property.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT address FROM Property address " +
            "WHERE UPPER(address.endereco) LIKE UPPER(CONCAT('%', :address, '%'))"
    )
    Optional<List<Property>> getPropertyByAddress(String address);
}
