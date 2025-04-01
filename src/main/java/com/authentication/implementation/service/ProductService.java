package com.authentication.implementation.service;

// Import statements...

import com.authentication.implementation.model.Category;
import com.authentication.implementation.model.Product;
import com.authentication.implementation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryService categoryService;

	public ResponseEntity<Product> createProduct(Product product) {
		try {
			// Verify category exists
//			ResponseEntity<Category> categoryResponse = categoryService.getCategoryById(
//					product.getCategory().getId());

			ResponseEntity<Category> categoryResponse = null;

			if (categoryResponse.getStatusCode() != HttpStatus.OK) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			Product newProduct = new Product();
			newProduct.setName(product.getName());
			newProduct.setPrice(product.getPrice());
			newProduct.setDescription(product.getDescription());
			newProduct.setCategory(categoryResponse.getBody());

			return new ResponseEntity<>(productRepository.save(newProduct), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Other CRUD methods
}