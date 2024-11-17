package com.risc.hackaton_capes_backend.mapper;

import java.util.HashSet;
import java.util.Set;

import com.risc.hackaton_capes_backend.model.Keyword;
import com.risc.hackaton_capes_backend.model.dto.KeywordDTO;


public class KeywordMapper {

	public static Keyword fromDto(KeywordDTO dto) {
		Keyword keyword = new Keyword();

		keyword.setName(dto.getName());
		keyword.setId(dto.getId());
		
		return keyword;
	}
	
	public static KeywordDTO toDto(Keyword keyword) {
		return KeywordDTO.builder()
				.name(keyword.getName())
				.id(keyword.getId())
				.build();
	}
	
	public static Set<KeywordDTO> toDto(Set<Keyword> keywords) {
		Set<KeywordDTO> keywordsDTO = new HashSet<>();
		
		for (Keyword keyword: keywords) {
			keywordsDTO.add(toDto(keyword));
		}
		
		return keywordsDTO;
	}
}
