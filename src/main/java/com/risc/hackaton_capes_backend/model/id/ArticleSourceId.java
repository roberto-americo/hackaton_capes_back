package com.risc.hackaton_capes_backend.model.id;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ArticleSourceId implements Serializable {
	private static final long serialVersionUID = 8264088198904922144L;

	@Column(name = "article_id")
	private Integer articleId;

	@Column(name = "source_id")
	private Integer sourceId;

	public ArticleSourceId() {
	}

	public ArticleSourceId(Integer article, Integer source) {
		super();
		this.articleId = article;
		this.sourceId = source;
	};
}
