package com.authentication.implementation.model;

import jakarta.persistence.*;
import lombok.*;

import javax.lang.model.element.Name;

@Entity
@Getter
@Setter
@Table(name="ROLE")
public class Role {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "role_name")
	private String roleName;
}
