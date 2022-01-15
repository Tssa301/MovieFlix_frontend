package com.tssa301.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tssa301.movieflix.entities.User;
import com.tssa301.movieflix.repositories.UserRepository;
import com.tssa301.movieflix.services.exceptions.ForbiddenException;
import com.tssa301.movieflix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		}
		catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}
	
	public void validateSelforAdmin(Long userId) {
		User user = authenticated();
		if (!user.getId().equals(userId) && !user.hasHole("MEMBER")) {
			throw new ForbiddenException("Access denied");
		}
	}
}
