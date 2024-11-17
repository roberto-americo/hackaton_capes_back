package com.risc.hackaton_capes_backend.mapper;

import com.risc.hackaton_capes_backend.model.Institution;
import com.risc.hackaton_capes_backend.model.dto.InstitutionDTO;


public class InstitutionMapper {

	public static Institution fromDto(InstitutionDTO dto) {
		Institution institution = new Institution();

		institution.setName(dto.getName());
		institution.setId(dto.getId());
		institution.setCountry(dto.getCountry());
		
		return institution;
	}
	
	public static InstitutionDTO toDto(Institution institution) {
		return InstitutionDTO.builder()
				.name(institution.getName())
				.id(institution.getId())
				.country(institution.getCountry())
				.build();
	}
}
