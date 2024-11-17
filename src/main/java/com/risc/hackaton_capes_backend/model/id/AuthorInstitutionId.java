package com.risc.hackaton_capes_backend.model.id;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class AuthorInstitutionId implements Serializable {
	private static final long serialVersionUID = 6562864145070522207L;

	@Column(name = "author_id")
	private Integer authorId;

	@Column(name = "institution_id")
	private Integer institutionId;

	public AuthorInstitutionId() {
	}

	public AuthorInstitutionId(Integer author, Integer institution) {
		super();
		this.authorId = author;
		this.institutionId = institution;
	};
}
