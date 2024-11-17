package com.risc.hackaton_capes_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.model.Article;
import com.risc.hackaton_capes_backend.model.ArticleAuthor;
import com.risc.hackaton_capes_backend.model.Author;
import com.risc.hackaton_capes_backend.model.id.ArticleAuthorId;
import com.risc.hackaton_capes_backend.repository.ArticleAuthorRepository;

@Service
public class ArticleAuthorService {

	@Autowired
	private ArticleAuthorRepository repository;
	
	public void save(Article article, Author author) {
		
		ArticleAuthorId id = new ArticleAuthorId(article.getId(), author.getId());
		
		Optional<ArticleAuthor> optional = repository.findById(id);
		
		if (!optional.isPresent()) {
			ArticleAuthor articleAuthor = new ArticleAuthor();
			articleAuthor.setArticleAuthorId(id);
			
			repository.save(articleAuthor);
		}	
	}
}
