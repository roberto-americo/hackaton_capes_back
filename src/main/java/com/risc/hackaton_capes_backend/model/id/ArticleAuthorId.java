package com.risc.hackaton_capes_backend.model.id;

import java.io.Serializable;

import com.risc.hackaton_capes_backend.model.Article;
import com.risc.hackaton_capes_backend.model.Author;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class ArticleAuthorId implements Serializable {
	private static final long serialVersionUID = -5559894783581385346L;

	@OneToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
	private Article article;
	
	@ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;

	public ArticleAuthorId(Article article, Author author) {
		super();
		this.article = article;
		this.author = author;
	}
}
