package com.authentication.implementation.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "USERS") // To avoid conflict with 'user' reserved keyword
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String password;
	private String email;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;

	@ManyToMany
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles;
}
