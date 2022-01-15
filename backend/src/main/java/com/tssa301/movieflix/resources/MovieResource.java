package com.tssa301.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tssa301.movieflix.dto.MovieCardDTO;
import com.tssa301.movieflix.dto.MovieDTO;
import com.tssa301.movieflix.dto.ReviewDTO;
import com.tssa301.movieflix.services.MovieService;
import com.tssa301.movieflix.services.ReviewService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<Page<MovieCardDTO>> findByGenre(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			Pageable pageable) {
		
		Page<MovieCardDTO> list = service.findByGenre(genreId, pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		MovieDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{movieId}/reviews")
	public ResponseEntity<List<ReviewDTO>> findMovieReviews(@PathVariable Long movieId) {
		List<ReviewDTO> list = reviewService.findMovieReviews(movieId);
		return ResponseEntity.ok(list);
	}
}
