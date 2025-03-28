package com.authentication.implementation.service;

import com.authentication.implementation.model.*;
import com.authentication.implementation.repository.*;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

@Component
public class DataSeeder {

	@Autowired
	UserRepository userRepository;

//	@PostConstruct
//	@Transactional
	public void seedData() {
		User john = new User();
		john.setId(1);
		john.setUsername("john_doe");
//		john.setPassword("password123");
		john.setEmail("john@example.com");

		User jane = new User();
		jane.setId(2);
		jane.setUsername("jane_doe");
		jane.setPassword("password456");
		jane.setEmail("jane@example.com");
		try {
			userRepository.saveAll(Set.of(john, jane));

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

	@Transactional
	public void addUserToUserTable(User user) {
		try {
			User newUser = new User();

			var res = userRepository.save(user);

			System.out.println("ssssssssssssssssssssss: "+res);

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
}
