package com.risc.hackaton_capes_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.mapper.AuthorMapper;
import com.risc.hackaton_capes_backend.model.Author;
import com.risc.hackaton_capes_backend.model.Institution;
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
	
	private void cleanData(AuthorDTO dto) {
		dto.setName(dto.getName().trim());
	}
}
