package com.authentication.implementation.service;

import com.authentication.implementation.model.*;
import com.authentication.implementation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public ResponseEntity<User> addUserToRepo(User user) {
		if (user !=null){
			User user1 = new User();
			user1.setId(user.getId());
			user1.setUsername(user.getUsername());
			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());
			try{
				return  new ResponseEntity<>(userRepository.save(user1), HttpStatus.OK);
			}catch (Exception e){
				System.out.println(e.getStackTrace());
				return  new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		return  new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<List<User>> getUserList() {

		List<User> userList = userRepository.findAll();
		return new  ResponseEntity<>(userList,HttpStatus.OK);

	}
}
