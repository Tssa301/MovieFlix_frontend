package com.tssa301.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tssa301.movieflix.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
