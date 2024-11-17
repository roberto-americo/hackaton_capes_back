package com.risc.hackaton_capes_backend.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	@Query(value = "SELECT a FROM Author AS a " + 
			"WHERE LOWER(a.name) = LOWER(:name)")
	public Optional<Author> getByName(@Param("name") String name);
	
	@Query(value = "SELECT DISTINCT(a) FROM Author AS a "
			+ "INNER JOIN ArticleAuthor AS aa ON aa.articleAuthorId.authorId = a.id "
			+ "WHERE aa.articleAuthorId.articleId = :articleId")
	public Set<Author> getByArticleId(@Param("articleId") Integer id);

}
