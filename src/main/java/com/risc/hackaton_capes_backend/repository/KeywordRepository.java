package com.risc.hackaton_capes_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.Keyword;


@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Integer> {
	
	@Query(value = "SELECT * FROM keyword AS k " + 
			"WHERE LOWER(k.name) = LOWER(:name)",
			  nativeQuery = true)
	public Optional<Keyword> getByName(@Param("name") String name);
}
