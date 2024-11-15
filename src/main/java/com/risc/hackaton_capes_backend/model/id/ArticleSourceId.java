package com.risc.hackaton_capes_backend.model.id;

import java.io.Serializable;

import com.risc.hackaton_capes_backend.model.Article;
import com.risc.hackaton_capes_backend.model.Source;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class ArticleSourceId implements Serializable {
	private static final long serialVersionUID = 8264088198904922144L;

	@OneToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
	private Article article;
	
	@ManyToOne
    @JoinColumn(name = "source_id", referencedColumnName = "id")
	private Source source;

	public ArticleSourceId(Article article, Source source) {
		super();
		this.article = article;
		this.source = source;
	}
}
