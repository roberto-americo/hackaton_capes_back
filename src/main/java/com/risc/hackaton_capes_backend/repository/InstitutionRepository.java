package com.risc.hackaton_capes_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.Institution;


@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
	
	@Query(value = "SELECT * FROM institution AS i " + 
			"WHERE LOWER(i.name) = LOWER(:name)",
			  nativeQuery = true)
	public Optional<Institution> getByName(@Param("name") String name);
	
	@Query(value = "SELECT DISTINCT(i) FROM Institution AS i "
			+ "INNER JOIN AuthorInstitution AS ai ON ai.authorInstitutionId.institutionId = i.id "
			+ "WHERE ai.authorInstitutionId.authorId = :authorId")
	public Optional<Institution> getByAuthorId(@Param("authorId") Integer id);

}
