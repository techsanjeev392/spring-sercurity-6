package com.authentication.implementation.service;

// Import statements...

import com.authentication.implementation.model.Category;
import com.authentication.implementation.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public ResponseEntity<Category> createCategory(Category category) {
		try {
			Category newCategory = new Category();
			newCategory.setName(category.getName());
			return new ResponseEntity<>(categoryRepository.save(newCategory), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Other CRUD methods

}