package com.risc.hackaton_capes_backend.model.dto.globalview;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ArticlesResumeDTO {

	private Integer articlesNumber;
	private Integer authorsNumber;
	
	private List<ObjectValue<String>> articlesLanguages;
	private List<ObjectValue<String>> articlesCountries;
}
