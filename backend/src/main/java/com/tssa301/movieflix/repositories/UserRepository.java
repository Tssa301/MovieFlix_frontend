package com.tssa301.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tssa301.movieflix.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
