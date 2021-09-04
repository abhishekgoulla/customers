package com.assignment.one.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.one.Entities.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	 User findByUsername(String username);

}
