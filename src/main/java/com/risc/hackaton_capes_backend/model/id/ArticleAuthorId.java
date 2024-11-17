package com.risc.hackaton_capes_backend.model.id;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class ArticleAuthorId implements Serializable {
	private static final long serialVersionUID = -5559894783581385346L;

	@Column(name = "article_id")
	private Integer articleId;
	
	@Column(name = "author_id")
	private Integer authorId;
	
	public ArticleAuthorId() {}

	public ArticleAuthorId(Integer articleId, Integer authorId) {
		super();
		this.articleId = articleId;
		this.authorId = authorId;
	}
}
