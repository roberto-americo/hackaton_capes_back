package com.risc.hackaton_capes_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.mapper.AuthorMapper;
import com.risc.hackaton_capes_backend.model.Author;
import com.risc.hackaton_capes_backend.model.Institution;
import com.risc.hackaton_capes_backend.model.dto.ArticleDTO;
import com.risc.hackaton_capes_backend.model.dto.AuthorDTO;
import com.risc.hackaton_capes_backend.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repository;

	@Autowired
	private InstitutionService institutionService;

	@Autowired
	private AuthorInstitutionService authorInstitutionService;
	
	public Author save(AuthorDTO dto) {
		
		cleanData(dto);
		
		Author author = AuthorMapper.fromDto(dto);
		
		Optional<Author> optional = repository.getByName(author.getName());
		
		if (optional.isPresent()) {
			return optional.get();
		}
		
		author = repository.save(author);
		
		Institution institution = institutionService.save(dto.getInstitution());

		authorInstitutionService.save(author, institution);
		
		return author;		
	}
	
	public Set<Author> getByArticleId(Integer articleId) {
		return repository.getByArticleId(articleId);
	}
	
	public void get(List<ArticleDTO> articles) {
		for (ArticleDTO article: articles) {
			Set<Author> authors = getByArticleId(article.getId());
			
			Set<AuthorDTO> dtos = AuthorMapper.toDto(authors);
			
			institutionService.get(dtos);
			
			article.setAuthors(dtos);
		}
	}
	
	private void cleanData(AuthorDTO dto) {
		dto.setName(dto.getName().trim());
	}
}
