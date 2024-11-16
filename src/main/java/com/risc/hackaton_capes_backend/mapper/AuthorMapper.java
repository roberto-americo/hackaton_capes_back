package com.risc.hackaton_capes_backend.mapper;

import com.risc.hackaton_capes_backend.model.Author;
import com.risc.hackaton_capes_backend.model.dto.AuthorDTO;


public class AuthorMapper {

	public static Author fromDto(AuthorDTO dto) {
		Author author = new Author();

		author.setName(dto.getName());
		author.setId(dto.getId());
		
		return author;
	}
	
	public static AuthorDTO toDto(Author author) {
		return AuthorDTO.builder()
				.name(author.getName())
				.id(author.getId())
				.build();
	}
}
