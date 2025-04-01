package com.authentication.implementation.controller;

import com.authentication.implementation.model.User;
import com.authentication.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Create - POST
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	// Read All - GET
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return userService.getAllUsers();
	}

	// Read Single - GET
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	// Update - PUT
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable Integer id,
			@RequestBody User userDetails) {
		return userService.updateUser(id, userDetails);
	}

	// Delete - DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) {
		return userService.deleteUser(id);
	}

	// Additional endpoints
	@GetMapping("/email")
	public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
		return userService.getUserByEmail(email);
	}

	@GetMapping("/check-username")
	public ResponseEntity<Boolean> checkUsernameExists(@RequestParam String username) {
		return userService.existsByUsername(username);
	}
}