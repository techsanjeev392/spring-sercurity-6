package com.authentication.implementation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/get-details")
	public  String getuserDetails(){
		return "hi";
	}
}
