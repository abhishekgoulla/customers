package com.assignment.one.Entities;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data

@Entity
public class Customer {

	@javax.persistence.Id
	private int Id;
	@NotBlank(message = "mandatory field")
	@NotNull(message = "mandatory field")
	private String name;
	private long mobile;
	@NotBlank(message = "mandatory field")
	private String city;
	@Email(message = "enter a valid email")
	private String email;

}
