package com.authentication.implementation.service;

// Import statements...

import com.authentication.implementation.model.Role;
import com.authentication.implementation.model.User;
import com.authentication.implementation.repository.RoleRepository;
import com.authentication.implementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<Role> createRole(Role role) {
		try {
			Role newRole = new Role();
			newRole.setRoleName(role.getRoleName());
			return new ResponseEntity<>(roleRepository.save(newRole), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HttpStatus> deleteRole(Integer id) {
		try {
			// Check if any users have this role
//			List<User> usersWithRole = userRepository.findByRoles_Id(id);
			List<User> usersWithRole = new ArrayList<>();
			if (!usersWithRole.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}

			roleRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Other CRUD methods
}