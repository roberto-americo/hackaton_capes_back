package com.risc.hackaton_capes_backend.model.dto;

import java.util.Objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AuthorDTO {
	
	private Integer id;
	private String name;
	
	private InstitutionDTO institution;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		AuthorDTO other = (AuthorDTO) obj;
		
		return Objects.equals(id, other.id);
	}
}
