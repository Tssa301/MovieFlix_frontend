package com.tssa301.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tssa301.movieflix.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
