package com.risc.hackaton_capes_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.common.Utils;
import com.risc.hackaton_capes_backend.mapper.KeywordMapper;
import com.risc.hackaton_capes_backend.model.Keyword;
import com.risc.hackaton_capes_backend.model.dto.ArticleDTO;
import com.risc.hackaton_capes_backend.model.dto.KeywordDTO;
import com.risc.hackaton_capes_backend.repository.KeywordRepository;

@Service
public class KeywordService {

	@Autowired
	private KeywordRepository repository;
	
	public Keyword save(KeywordDTO dto) {
		
		cleanData(dto);
		
		Keyword keyword = KeywordMapper.fromDto(dto);
		
		Optional<Keyword> optional = repository.getByName(keyword.getName());
		
		if (optional.isPresent()) {
			return optional.get();
		}
		
		return repository.save(keyword);		
	}
	
	public Set<Keyword> getByArticleId(Integer articleId) {
		return repository.getByArticleId(articleId);
	}
	
	public void get(List<ArticleDTO> articles) {
		for (ArticleDTO article: articles) {
			Set<Keyword> keywords = getByArticleId(article.getId());
			
			article.setKeywords(KeywordMapper.toDto(keywords));
		}
	}
	
	private void cleanData(KeywordDTO dto) {
		String name = dto.getName().replaceFirst("^s ", "");
		dto.setName(Utils.transformUpper(name));
	}
}
