package com.risc.hackaton_capes_backend.repository;

import java.util.Optional;
import java.util.Set;

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
	
	@Query(value = "SELECT DISTINCT(k) FROM Keyword AS k "
			+ "INNER JOIN ArticleKeyword AS ak ON ak.articleKeywordId.keywordId = k.id "
			+ "WHERE ak.articleKeywordId.articleId = :articleId")
	public Set<Keyword> getByArticleId(@Param("articleId") Integer id);
}
