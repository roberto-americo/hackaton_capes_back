package com.risc.hackaton_capes_backend.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.common.Utils;
import com.risc.hackaton_capes_backend.mapper.InstitutionMapper;
import com.risc.hackaton_capes_backend.model.Institution;
import com.risc.hackaton_capes_backend.model.dto.AuthorDTO;
import com.risc.hackaton_capes_backend.model.dto.InstitutionDTO;
import com.risc.hackaton_capes_backend.repository.InstitutionRepository;

@Service
public class InstitutionService {

	@Autowired
	private InstitutionRepository repository;
	
	public Institution save(InstitutionDTO dto) {
		
		if (dto == null) {
			return null;
		}
		
		cleanData(dto);
		
		Institution institution = InstitutionMapper.fromDto(dto);
		
		Optional<Institution> optional = repository.getByName(institution.getName());
		
		if (optional.isPresent()) {
			return optional.get();
		}
		
		return repository.save(institution);		
	}
	
	public Institution getByAuthorId(Integer authorId) {
		Optional<Institution> institution = repository.getByAuthorId(authorId);
		
		if (institution.isPresent()) {
			return institution.get();			
		}
		
		return null;
	}
	
	public void get(Set<AuthorDTO> authors) {
		for (AuthorDTO author: authors) {
			Institution institution = getByAuthorId(author.getId());
			
			if (institution != null) {
				author.setInstitution(InstitutionMapper.toDto(institution));
			}
		}
	}
	
	private void cleanData(InstitutionDTO institution) {
		institution.setCountry(Utils.transformUpper(institution.getCountry()));
		institution.setName(Utils.transformUpper(institution.getName()));
	}
}
