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

@Service
public class DataSeeder {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	CartProductRepository cartProductRepository;

//	@PostConstruct
//	@Transactional
	public void seedData() {
		// Insert Roles
		Role roleUser = new Role();
		roleUser.setId(1);
		roleUser.setRoleName("ROLE_USER");

		Role roleAdmin = new Role();
		roleAdmin.setId(2);
		roleAdmin.setRoleName("ROLE_ADMIN");

		try {
			roleRepository.save(roleUser);
			roleRepository.save(roleAdmin);

		}catch (Exception e){
			System.out.println(e.getMessage());
		}


//
//		// Insert Users
//		User john = new User();
//		john.setId(1L);
//		john.setUsername("john_doe");
//		john.setPassword("password123");
//		john.setEmail("john@example.com");
//		john.setRoles(Set.of(roleUser));
//
//		User jane = new User();
//		jane.setId(2L);
//		jane.setUsername("jane_doe");
//		jane.setPassword("password456");
//		jane.setEmail("jane@example.com");
//		jane.setRoles(Set.of(roleAdmin));
//
//		userRepository.saveAll(Set.of(john, jane));
//
//		// Insert Categories
//		Category electronics = new Category();
//		electronics.setId(1L);
//		electronics.setName("Electronics");
//
//		Category clothing = new Category();
//		clothing.setId(2L);
//		clothing.setName("Clothing");
//
//		categoryRepository.saveAll(Set.of(electronics, clothing));
//
//		// Insert Products
//		Product smartphone = new Product();
//		smartphone.setId(1L);
//		smartphone.setName("Smartphone");
//		smartphone.setPrice(699.99);
//		smartphone.setDescription("High-end smartphone with great features");
//		smartphone.setCategory(electronics);
//
//		Product laptop = new Product();
//		laptop.setId(2L);
//		laptop.setName("Laptop");
//		laptop.setPrice(999.99);
//		laptop.setDescription("Powerful laptop for professionals");
//		laptop.setCategory(electronics);
//
//		Product headphones = new Product();
//		headphones.setId(3L);
//		headphones.setName("Headphones");
//		headphones.setPrice(199.99);
//		headphones.setDescription("Noise-cancelling wireless headphones");
//		headphones.setCategory(electronics);
//
//		Product tShirt = new Product();
//		tShirt.setId(4L);
//		tShirt.setName("T-Shirt");
//		tShirt.setPrice(19.99);
//		tShirt.setDescription("Cotton t-shirt with modern design");
//		tShirt.setCategory(clothing);
//
//		Product jeans = new Product();
//		jeans.setId(5L);
//		jeans.setName("Jeans");
//		jeans.setPrice(49.99);
//		jeans.setDescription("Slim-fit jeans for everyday use");
//		jeans.setCategory(clothing);
//
//		productRepository.saveAll(Set.of(smartphone, laptop, headphones, tShirt, jeans));
//
//		// Insert Carts
//		Cart johnCart = new Cart();
//		johnCart.setId(1L);
//		johnCart.setUser(john);
//
//		Cart janeCart = new Cart();
//		janeCart.setId(2L);
//		janeCart.setUser(jane);
//
//		cartRepository.saveAll(Set.of(johnCart, janeCart));
//
//		// Add Products to Carts
//		CartProduct cartProduct1 = new CartProduct();
//		cartProduct1.setId(1L);
//		cartProduct1.setCart(johnCart);
//		cartProduct1.setProduct(smartphone);
//		cartProduct1.setQuantity(2);
//
//		CartProduct cartProduct2 = new CartProduct();
//		cartProduct2.setId(2L);
//		cartProduct2.setCart(johnCart);
//		cartProduct2.setProduct(tShirt);
//		cartProduct2.setQuantity(3);
//
//		CartProduct cartProduct3 = new CartProduct();
//		cartProduct3.setId(3L);
//		cartProduct3.setCart(janeCart);
//		cartProduct3.setProduct(laptop);
//		cartProduct3.setQuantity(1);
//
//		CartProduct cartProduct4 = new CartProduct();
//		cartProduct4.setId(4L);
//		cartProduct4.setCart(janeCart);
//		cartProduct4.setProduct(jeans);
//		cartProduct4.setQuantity(2);
//
//		cartProductRepository.saveAll(Set.of(cartProduct1, cartProduct2, cartProduct3, cartProduct4));
	}
}
