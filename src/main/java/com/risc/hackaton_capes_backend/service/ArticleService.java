package com.risc.hackaton_capes_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.common.Utils;
import com.risc.hackaton_capes_backend.mapper.ArticleMapper;
import com.risc.hackaton_capes_backend.model.Article;
import com.risc.hackaton_capes_backend.model.Author;
import com.risc.hackaton_capes_backend.model.Keyword;
import com.risc.hackaton_capes_backend.model.Source;
import com.risc.hackaton_capes_backend.model.dto.ArticleDTO;
import com.risc.hackaton_capes_backend.model.dto.AuthorDTO;
import com.risc.hackaton_capes_backend.model.dto.KeywordDTO;
import com.risc.hackaton_capes_backend.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repository;

	@Autowired
	private KeywordService keywordService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private SourceService sourceService;
	
	@Autowired
	private ArticleKeywordService articleKeywordService;
	
	@Autowired
	private ArticleAuthorService articleAuthorService;
	
	@Autowired
	private ArticleSourceService articleSourceService;
	
	public Article save(ArticleDTO dto) {
		
		cleanData(dto);
		
		Article article = ArticleMapper.fromDto(dto);
		
		article = repository.save(article);
		
		Source source = sourceService.save(dto.getSource());
		
		articleSourceService.save(article, source);
		
		for (KeywordDTO keywordDTO: dto.getKeywords()) {
			Keyword keyword = keywordService.save(keywordDTO);
			
			articleKeywordService.save(article, keyword);
		}
		
		for (AuthorDTO authorDTO: dto.getAuthors()) {
			Author author = authorService.save(authorDTO);
			
			articleAuthorService.save(article, author);
		}
		
		return article;		
	}
	
	public List<ArticleDTO> search(String search) {
		search = Utils.transformLower(search);
		
		List<Article> articles = repository.findByKeyword(search);
		
		return getDTOfromDB(articles);
	}

	private List<ArticleDTO> getDTOfromDB(List<Article> articles) {
		List<ArticleDTO> dtos = new ArrayList<ArticleDTO>();
		
		dtos = ArticleMapper.toDto(articles);
		
		sourceService.get(dtos);
		keywordService.get(dtos);
		authorService.get(dtos);
		return dtos;
	}
	
	private void cleanData(ArticleDTO dto) {
		dto.setTitle(dto.getTitle().trim());
		dto.setAbstractArticle(dto.getAbstractArticle().trim());
		dto.setLanguage(Utils.transformUpper(dto.getLanguage()));
		dto.setYear(dto.getYear().trim());
	}
}
