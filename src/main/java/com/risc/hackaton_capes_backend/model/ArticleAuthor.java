package com.risc.hackaton_capes_backend.model;

import java.io.Serializable;

import com.risc.hackaton_capes_backend.model.id.ArticleAuthorId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "article_author")
@Getter
@Setter
@ToString
public class ArticleAuthor implements Serializable {
	private static final long serialVersionUID = -967965450169212262L;
	
	@EmbeddedId
	private ArticleAuthorId articleAuthorId;
}
