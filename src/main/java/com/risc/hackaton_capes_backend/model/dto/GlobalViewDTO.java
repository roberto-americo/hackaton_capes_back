package com.risc.hackaton_capes_backend.model.dto;

import java.util.List;

import com.risc.hackaton_capes_backend.model.dto.globalview.ArticlesResumeDTO;
import com.risc.hackaton_capes_backend.model.dto.globalview.AuthorPerKeyword;
import com.risc.hackaton_capes_backend.model.dto.globalview.KeywordsPerYear;
import com.risc.hackaton_capes_backend.model.dto.globalview.ObjectValue;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class GlobalViewDTO {

	private List<ObjectValue<String>> articlesPerYear;
	private List<ObjectValue<AuthorDTO>> authorsPerArticle;
	private List<ObjectValue<KeywordDTO>> keywordsPerArticle;
	private List<ObjectValue<SourceDTO>> sourcesPerArticle;
	private List<ObjectValue<KeywordsPerYear>> keywordsPerYear;
	private List<ObjectValue<AuthorPerKeyword>> authorsPerKeyword;
	
	private ArticlesResumeDTO resume;
}
