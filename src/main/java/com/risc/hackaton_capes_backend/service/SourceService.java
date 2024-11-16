package com.risc.hackaton_capes_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.common.Utils;
import com.risc.hackaton_capes_backend.mapper.SourceMapper;
import com.risc.hackaton_capes_backend.model.Source;
import com.risc.hackaton_capes_backend.model.dto.SourceDTO;
import com.risc.hackaton_capes_backend.repository.SourceRepository;

@Service
public class SourceService {

	@Autowired
	private SourceRepository repository;
	
	public Source save(SourceDTO dto) {
		
		if (dto == null) {
			return null;
		}
		
		cleanData(dto);
		
		Source source = SourceMapper.fromDto(dto);
		
		Optional<Source> optional = repository.getByName(source.getName());
		
		if (optional.isPresent()) {
			return optional.get();
		}
		
		return repository.save(source);		
	}
	
	private void cleanData(SourceDTO dto) {
		dto.setName(Utils.transformUpper(dto.getName()));
	}
}
