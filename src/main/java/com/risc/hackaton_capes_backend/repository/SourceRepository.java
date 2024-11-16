package com.risc.hackaton_capes_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.Source;


@Repository
public interface SourceRepository extends JpaRepository<Source, Integer> {
	
	@Query(value = "SELECT * FROM source AS s " + 
			"WHERE LOWER(s.name) = LOWER(:name)",
			  nativeQuery = true)
	public Optional<Source> getByName(@Param("name") String name);

}
