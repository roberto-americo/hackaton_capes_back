package com.risc.hackaton_capes_backend.model.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ArticleDTO {

	private Integer id;
	private String title;
	private String language;
	private String year;
	private String abstractArticle;
	private SourceDTO source;

	private Set<KeywordDTO> keywords;
	private Set<AuthorDTO> authors;
}
