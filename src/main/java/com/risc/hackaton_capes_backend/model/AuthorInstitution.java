package com.risc.hackaton_capes_backend.model;

import java.io.Serializable;

import com.risc.hackaton_capes_backend.model.id.AuthorInstitutionId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "author_institution")
@Getter
@Setter
@ToString
public class AuthorInstitution implements Serializable {
	private static final long serialVersionUID = -2040502523721639678L;

	@EmbeddedId
	private AuthorInstitutionId authorInstitutionId;
}
