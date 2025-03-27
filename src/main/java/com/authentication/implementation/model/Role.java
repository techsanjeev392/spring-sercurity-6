package com.authentication.implementation.model;

import jakarta.persistence.*;
import lombok.*;

import javax.lang.model.element.Name;

@Entity(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "role_name")
	private String roleName;
}
