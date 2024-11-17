package com.risc.hackaton_capes_backend.mapper;

import com.risc.hackaton_capes_backend.model.Source;
import com.risc.hackaton_capes_backend.model.dto.SourceDTO;


public class SourceMapper {

	public static Source fromDto(SourceDTO dto) {
		Source source = new Source();

		source.setName(dto.getName());
		source.setId(dto.getId());
		
		return source;
	}
	
	public static SourceDTO toDto(Source source) {
		return SourceDTO.builder()
				.name(source.getName())
				.id(source.getId())
				.build();
	}
}
