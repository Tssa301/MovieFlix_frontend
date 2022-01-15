package com.tssa301.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tssa301.movieflix.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	@Query("SELECT obj FROM Review obj WHERE obj.movie.id = :movieId")
	List<Review> findMovieReviews(Long movieId);
}
