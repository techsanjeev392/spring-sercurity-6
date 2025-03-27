package com.authentication.implementation.model;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Table(name= "USER")
@Getter
@Setter
public class User {

	private Integer userId;
	private String userName;
}
