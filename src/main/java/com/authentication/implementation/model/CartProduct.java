package com.authentication.implementation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cart_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private int quantity;
}
