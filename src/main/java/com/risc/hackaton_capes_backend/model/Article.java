package com.risc.hackaton_capes_backend.model;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "article")
@Getter
@Setter
@ToString
public class Article implements Serializable {
	private static final long serialVersionUID = 667066273378785254L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Integer id;
	
	@Column
	@Nonnull
	private String title;
	
	@Column(name = "publication_year")
	@Nonnull
	private String year;
	
	@Column
	@Nonnull
	private String language;

}
