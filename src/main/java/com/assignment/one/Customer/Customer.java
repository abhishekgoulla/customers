package com.assignment.one.Customer;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;


@Data

@Entity
public class Customer {
	
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@NotBlank(message="mandatory field")
	@NotNull(message="mandatory field")
	private String name;
	
	private long mobile;
	@NotBlank(message="mandatory field")
	private String city;
	@Email(message="enter a valid email")
	private String email;

	
	
	

}
