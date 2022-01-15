package com.tssa301.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tssa301.movieflix.entities.Genre;
import com.tssa301.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	 
		@Query("SELECT DISTINCT obj FROM Movie obj INNER JOIN obj.genre ge WHERE "
				+ "(COALESCE(:genre) IS NULL OR ge IN :genre )"
				+ "ORDER BY obj.title ASC")
	 Page<Movie> find(List<Genre> genre, Pageable pageable);
}
