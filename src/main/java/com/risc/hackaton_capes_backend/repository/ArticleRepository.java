package com.risc.hackaton_capes_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.Article;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	@Query(value = "SELECT DISTINCT(art) FROM Article AS art "
			+ "INNER JOIN ArticleKeyword AS ak ON ak.articleKeywordId.articleId = art.id "
			+ "INNER JOIN Keyword AS k ON k.id = ak.articleKeywordId.keywordId "
			+ "WHERE LOWER(art.title) like CONCAT('%', :keyword,'%') "
			+ "OR art.year = :keyword "
			+ "OR art.language = :keyword "
			+ "OR LOWER(art.abstractArticle) like CONCAT('%', :keyword,'%') "
			+ "OR k.name = :keyword")
	public List<Article> findByKeyword(@Param("keyword") String keyword);

}
