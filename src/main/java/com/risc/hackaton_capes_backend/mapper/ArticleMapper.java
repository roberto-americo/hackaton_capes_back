package com.risc.hackaton_capes_backend.mapper;

import java.util.ArrayList;
import java.util.List;

import com.risc.hackaton_capes_backend.model.Article;
import com.risc.hackaton_capes_backend.model.dto.ArticleDTO;


public class ArticleMapper {

	public static Article fromDto(ArticleDTO dto) {
		Article article = new Article();

		article.setLanguage(dto.getLanguage());
		article.setTitle(dto.getTitle());
		article.setYear(dto.getYear());
		article.setId(dto.getId());
		article.setAbstractArticle(dto.getAbstractArticle());
		
		return article;
	}
	
	public static ArticleDTO toDto(Article article) {
		return ArticleDTO.builder()
				.title(article.getTitle())
				.language(article.getLanguage())
				.year(article.getYear())
				.id(article.getId())
				.abstractArticle(article.getAbstractArticle())
				.build();
	}
	
	public static List<ArticleDTO> toDto(List<Article> articles) {
		List<ArticleDTO> dtos = new ArrayList<ArticleDTO>();
		
		for (Article article: articles) {
			dtos.add(toDto(article));
		}
		
		return dtos;
	}
}
