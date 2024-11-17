package com.risc.hackaton_capes_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.model.Article;
import com.risc.hackaton_capes_backend.model.ArticleKeyword;
import com.risc.hackaton_capes_backend.model.Keyword;
import com.risc.hackaton_capes_backend.model.id.ArticleKeywordId;
import com.risc.hackaton_capes_backend.repository.ArticleKeywordRepository;

@Service
public class ArticleKeywordService {

	@Autowired
	private ArticleKeywordRepository repository;
	
	public void save(Article article, Keyword keyword) {
		
		ArticleKeywordId id = new ArticleKeywordId(article.getId(), keyword.getId());
		
		Optional<ArticleKeyword> optional = repository.findById(id);
		
		if (!optional.isPresent()) {
			ArticleKeyword articleKeyword = new ArticleKeyword();
			articleKeyword.setArticleKeywordId(id);
			
			repository.save(articleKeyword);
		}	
	}
}
