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
@Table(name = "keyword")
@Getter
@Setter
@ToString
public class Keyword implements Serializable {
	private static final long serialVersionUID = -955361563363936450L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Integer id;
	
	@Column(columnDefinition = "TEXT")
	@Nonnull
	private String name;
}
