package com.authentication.implementation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private double price;
	private String description;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
