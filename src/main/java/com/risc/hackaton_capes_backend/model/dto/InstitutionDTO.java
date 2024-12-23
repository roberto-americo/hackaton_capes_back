package com.risc.hackaton_capes_backend.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class InstitutionDTO {

	private Integer id;
	private String name;
	private String country;
}
