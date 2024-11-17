package com.risc.hackaton_capes_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.model.Author;
import com.risc.hackaton_capes_backend.model.AuthorInstitution;
import com.risc.hackaton_capes_backend.model.Institution;
import com.risc.hackaton_capes_backend.model.id.AuthorInstitutionId;
import com.risc.hackaton_capes_backend.repository.AuthorInstitutionRepository;

@Service
public class AuthorInstitutionService {

	@Autowired
	private AuthorInstitutionRepository repository;
	
	public void save(Author author, Institution institution) {
		
		if (author == null || institution == null) {
			return;
		}
		
		AuthorInstitutionId id = new AuthorInstitutionId(author.getId(), institution.getId());
		
		Optional<AuthorInstitution> optional = repository.findById(id);
		
		if (!optional.isPresent()) {
			AuthorInstitution authorInstitution = new AuthorInstitution();
			authorInstitution.setAuthorInstitutionId(id);
			
			repository.save(authorInstitution);
		}	
	}
}
