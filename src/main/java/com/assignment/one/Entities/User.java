package com.assignment.one.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class User {
	@Id
	private long id;
	private String username;
	private String password;
	private String role;

}
