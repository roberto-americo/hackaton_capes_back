package com.risc.hackaton_capes_backend.model.id;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class ArticleKeywordId implements Serializable {

	private static final long serialVersionUID = -1383180013540120407L;
	
    @Column(name = "article_id")
	private Integer articleId;
	
    @Column(name = "keyword_id")
	private Integer keywordId;

	public ArticleKeywordId() {}

	public ArticleKeywordId(Integer articleId, Integer keywordId) {
		super();
		this.articleId = articleId;
		this.keywordId = keywordId;
	}	
}
