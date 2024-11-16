package com.risc.hackaton_capes_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	@Query(value = "SELECT * FROM author AS a " + 
			"WHERE LOWER(a.name) = LOWER(:name)",
			  nativeQuery = true)
	public Optional<Author> getByName(@Param("name") String name);

}
