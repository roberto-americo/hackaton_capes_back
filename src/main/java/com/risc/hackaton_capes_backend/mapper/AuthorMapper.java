package com.risc.hackaton_capes_backend.mapper;

import java.util.HashSet;
import java.util.Set;

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
	
	public static Set<AuthorDTO> toDto(Set<Author> authors) {
		Set<AuthorDTO> authorDTOs = new HashSet<>();
		
		for (Author author: authors) {
			authorDTOs.add(toDto(author));
		}
		
		return authorDTOs;
	}
}
