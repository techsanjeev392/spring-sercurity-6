package com.authentication.implementation.repository;

import com.authentication.implementation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
