package com.authentication.implementation.service;

import com.authentication.implementation.model.Cart;
import com.authentication.implementation.model.User;
import com.authentication.implementation.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserService userService;

	public ResponseEntity<Cart> createCart(Cart cart) {
		try {
			// Verify user exists
			ResponseEntity<User> userResponse = userService.getUserById(cart.getUser().getId());
			if (userResponse.getStatusCode() != HttpStatus.OK) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			Cart newCart = new Cart();
			newCart.setUser(userResponse.getBody());
			return new ResponseEntity<>(cartRepository.save(newCart), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Cart>> getAllCarts() {
		try {
			return new ResponseEntity<>(cartRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Cart> getCartById(Integer id) {
		Optional<Cart> cart = cartRepository.findById(id);
		return cart.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	public ResponseEntity<Cart> updateCart(Integer id, Cart cartDetails) {
		try {
			Optional<Cart> cartOptional = cartRepository.findById(id);
			if (cartOptional.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			Cart existingCart = cartOptional.get();
			// Update relationships if needed
			if (cartDetails.getUser() != null) {
				existingCart.setUser(cartDetails.getUser());
			}

			return new ResponseEntity<>(cartRepository.save(existingCart), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HttpStatus> deleteCart(Integer id) {
		try {
			cartRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}