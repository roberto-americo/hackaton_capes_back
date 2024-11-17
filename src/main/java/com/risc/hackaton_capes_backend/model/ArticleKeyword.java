package com.risc.hackaton_capes_backend.model;

import java.io.Serializable;

import com.risc.hackaton_capes_backend.model.id.ArticleKeywordId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "article_keyword")
@Getter
@Setter
@ToString
public class ArticleKeyword implements Serializable {
	private static final long serialVersionUID = 830430262162980315L;
	
	@EmbeddedId
	private ArticleKeywordId articleKeywordId;
}
