package com.risc.hackaton_capes_backend.model;

import java.io.Serializable;

import com.risc.hackaton_capes_backend.model.id.ArticleSourceId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "article_source")
@Getter
@Setter
@ToString
public class ArticleSource implements Serializable {
	private static final long serialVersionUID = 5631299219989176714L;
	
	@EmbeddedId
	private ArticleSourceId articleSourceId;
}
