package com.risc.hackaton_capes_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.common.Utils;
import com.risc.hackaton_capes_backend.mapper.KeywordMapper;
import com.risc.hackaton_capes_backend.model.Keyword;
import com.risc.hackaton_capes_backend.model.dto.KeywordDTO;
import com.risc.hackaton_capes_backend.repository.KeywordRepository;

@Service
public class KeywordService {

	@Autowired
	private KeywordRepository repository;
	
	public Keyword save(KeywordDTO dto) {
		
		Keyword keyword = KeywordMapper.fromDto(dto);
		
		cleanData(dto);
		
		Optional<Keyword> optional = repository.getByName(keyword.getName());
		
		if (optional.isPresent()) {
			return optional.get();
		}
		
		return repository.save(keyword);		
	}
	
	private void cleanData(KeywordDTO dto) {
		dto.setName(Utils.transformUpper(dto.getName()));
	}
}
