package com.authentication.implementation.repository;

import com.authentication.implementation.model.Role;
import com.authentication.implementation.model.User;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    public Optional<User> findByEmail(String emailId);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM users WHERE username = :username", nativeQuery = true)
    public Boolean existsByUsername(String username);
}
