package com.risc.hackaton_capes_backend.mapper;

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
}
