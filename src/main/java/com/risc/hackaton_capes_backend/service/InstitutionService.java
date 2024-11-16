package com.risc.hackaton_capes_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.common.Utils;
import com.risc.hackaton_capes_backend.mapper.InstitutionMapper;
import com.risc.hackaton_capes_backend.model.Institution;
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
	
	private void cleanData(InstitutionDTO institution) {
		institution.setCountry(Utils.transformUpper(institution.getCountry()));
		institution.setName(Utils.transformUpper(institution.getName()));
	}
}
