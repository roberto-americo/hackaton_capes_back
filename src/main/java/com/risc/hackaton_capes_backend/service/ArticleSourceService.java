package com.risc.hackaton_capes_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.model.Article;
import com.risc.hackaton_capes_backend.model.ArticleSource;
import com.risc.hackaton_capes_backend.model.Source;
import com.risc.hackaton_capes_backend.model.id.ArticleSourceId;
import com.risc.hackaton_capes_backend.repository.ArticleSourceRepository;

@Service
public class ArticleSourceService {

	@Autowired
	private ArticleSourceRepository repository;
	
	public void save(Article article, Source source) {
		
		if (article == null || source == null) {
			return;
		}
		
		ArticleSourceId id = new ArticleSourceId(article.getId(), source.getId());
		
		Optional<ArticleSource> optional = repository.findById(id);
		
		if (!optional.isPresent()) {
			ArticleSource articleSource = new ArticleSource();
			articleSource.setArticleSourceId(id);
			
			repository.save(articleSource);
		}	
	}
}
