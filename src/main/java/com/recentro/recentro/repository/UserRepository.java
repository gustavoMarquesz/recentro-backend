package com.recentro.recentro.repository;


import com.recentro.recentro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select i from User i where i.email = :email")
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByLogin(@Param("email") String email);

}