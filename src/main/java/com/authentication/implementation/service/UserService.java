package com.authentication.implementation.service;

import com.authentication.implementation.model.User;
import com.authentication.implementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Create
	public ResponseEntity<User> createUser(User user) {
		try {
			User newUser = new User();
			newUser.setUsername(user.getUsername());
			newUser.setEmail(user.getEmail());
			newUser.setPassword(user.getPassword()); // Should be encoded in real application
			newUser.setRoles(user.getRoles());
			newUser.setCart(user.getCart());

			User savedUser = userRepository.save(newUser);
			return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Read All
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> users = userRepository.findAll();
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Read Single
	public ResponseEntity<User> getUserById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// Update
	public ResponseEntity<User> updateUser(Integer id, User userDetails) {
		try {
			Optional<User> userOptional = userRepository.findById(id);
			if (userOptional.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			User existingUser = userOptional.get();
			existingUser.setUsername(userDetails.getUsername());
			existingUser.setEmail(userDetails.getEmail());

			// Only update password if provided
			if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
				existingUser.setPassword(userDetails.getPassword()); // Should encode in real application
			}

			// Update relationships
			if (userDetails.getRoles() != null) {
				existingUser.setRoles(userDetails.getRoles());
			}
			if (userDetails.getCart() != null) {
				existingUser.setCart(userDetails.getCart());
			}

			User updatedUser = userRepository.save(existingUser);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Delete
	public ResponseEntity<HttpStatus> deleteUser(Integer id) {
		try {
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Additional utility methods
	public ResponseEntity<User> getUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	public ResponseEntity<Boolean> existsByUsername(String username) {
		try {
			Boolean exists = userRepository.existsByUsername(username);
			return new ResponseEntity<>(exists, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}