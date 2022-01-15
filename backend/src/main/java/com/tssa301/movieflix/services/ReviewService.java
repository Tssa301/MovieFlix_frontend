package com.tssa301.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tssa301.movieflix.dto.ReviewDTO;
import com.tssa301.movieflix.entities.Review;
import com.tssa301.movieflix.entities.User;
import com.tssa301.movieflix.repositories.MovieRepository;
import com.tssa301.movieflix.repositories.ReviewRepository;
import com.tssa301.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private AuthService authService;
	
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> findMovieReviews(Long movieId) {
		try {
			List<Review> list = repository.findMovieReviews(movieId);
			return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
			
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + movieId);
		}	
	}
	
	@Transactional
	public ReviewDTO inser(ReviewDTO dto) {
		
		User user = authService.authenticated();
		
		Review entity = new Review();
		entity.setText(dto.getText());
		entity.setMovie(movieRepository.getOne(dto.getMovieId()));
		entity.setUser(user);
		repository.save(entity);
		return new ReviewDTO(entity);
	}
}
