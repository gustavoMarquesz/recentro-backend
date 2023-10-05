package com.recentro.recentro.repository;


import com.recentro.recentro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select i from User i where i.email = :email")
    User findByEmail(String email);
}