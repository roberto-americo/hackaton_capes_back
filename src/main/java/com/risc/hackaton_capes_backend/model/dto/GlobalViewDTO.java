package com.risc.hackaton_capes_backend.model.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class GlobalViewDTO {

	List<ObjectPerArticle<String>> articlesPerYear;
	List<ObjectPerArticle<AuthorDTO>> authorsPerArticle;
	List<ObjectPerArticle<KeywordDTO>> keywordsPerArticle;
	List<ObjectPerArticle<SourceDTO>> sourcesPerArticle;
	List<ObjectPerArticle<KeywordsPerYear>> keywordsPerYear;
	List<ObjectPerArticle<AuthorPerKeyword>> authorsPerKeyword;
	
}
