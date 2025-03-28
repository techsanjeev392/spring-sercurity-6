package com.authentication.implementation.controller;

import com.authentication.implementation.service.DataSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class Controller {

	@Autowired
	DataSeeder dataSeeder;

	@PostMapping("/set-details")
	public ResponseEntity getuserDetails(){
		try {
			dataSeeder.seedData();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

        return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
	}


}
