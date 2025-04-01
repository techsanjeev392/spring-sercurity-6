package com.authentication.implementation.service;

import com.authentication.implementation.model.*;
import com.authentication.implementation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartProductService {

	@Autowired
	private CartProductRepository cartProductRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<CartProduct> createCartProduct(CartProduct cartProduct) {
		try {
			// Verify cart and product exist
			Optional<Cart> cart = cartRepository.findById(cartProduct.getCart().getId());
			Optional<Product> product = productRepository.findById(cartProduct.getProduct().getId());

			if (cart.isEmpty() || product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			CartProduct newCartProduct = new CartProduct();
			newCartProduct.setCart(cart.get());
			newCartProduct.setProduct(product.get());
			newCartProduct.setQuantity(cartProduct.getQuantity());

			return new ResponseEntity<>(cartProductRepository.save(newCartProduct), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Other CRUD methods similar to CartService
}