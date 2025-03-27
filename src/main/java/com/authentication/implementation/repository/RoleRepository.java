package com.authentication.implementation.repository;

import com.authentication.implementation.model.Product;
import com.authentication.implementation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
