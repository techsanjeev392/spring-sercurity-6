package com.authentication.implementation.controller;

import com.authentication.implementation.model.User;
import com.authentication.implementation.service.DataSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	DataSeeder dataSeeder;

	@GetMapping("/get-details")
	public  String getuserDetails(){
		return "hi";
	}

	@PostMapping("/put/id/{id}")
	public ResponseEntity addUser(@Param("id") String id, @RequestBody User u1){

		dataSeeder.addUserToUserTable(u1);

		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}


}
