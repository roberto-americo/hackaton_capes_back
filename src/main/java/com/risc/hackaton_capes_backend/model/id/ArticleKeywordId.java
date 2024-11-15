package com.risc.hackaton_capes_backend.model.id;

import java.io.Serializable;

import com.risc.hackaton_capes_backend.model.Article;
import com.risc.hackaton_capes_backend.model.Keyword;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class ArticleKeywordId implements Serializable {

	private static final long serialVersionUID = -1383180013540120407L;
	
	@OneToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
	private Article article;
	
	@ManyToOne
    @JoinColumn(name = "keyword_id", referencedColumnName = "id")
	private Keyword keyword;

	public ArticleKeywordId(Article article, Keyword keyword) {
		super();
		this.article = article;
		this.keyword = keyword;
	}
}
