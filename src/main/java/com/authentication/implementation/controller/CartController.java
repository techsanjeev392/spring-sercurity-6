package com.authentication.implementation.controller;

import com.authentication.implementation.model.Cart;
import com.authentication.implementation.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		return cartService.createCart(cart);
	}

	@GetMapping
	public ResponseEntity<List<Cart>> getAllCarts() {
		return cartService.getAllCarts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable Integer id) {
		return cartService.getCartById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable Integer id, @RequestBody Cart cart) {
		return cartService.updateCart(id, cart);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCart(@PathVariable Integer id) {
		return cartService.deleteCart(id);
	}
}