package com.authentication.implementation.controller;

import com.authentication.implementation.model.User;
import com.authentication.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;


	@PutMapping	("/add")
	public ResponseEntity<User> addUsertoUserTable(@RequestBody User user){
		return userService.addUserToRepo(user);
	}

	@GetMapping("/users")
	public  ResponseEntity<List<User>> getUserDetails(){
		return userService.getUserList();
	}



}
