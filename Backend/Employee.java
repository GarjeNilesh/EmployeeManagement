package com.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Employee {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	
	private String username;
	
	private String email;
	
	private String password;
	
}
