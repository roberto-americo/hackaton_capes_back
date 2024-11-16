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
	private Integer author;

	@Column(name = "institution_id")
	private Integer institution;

	public AuthorInstitutionId() {
	}

	public AuthorInstitutionId(Integer author, Integer institution) {
		super();
		this.author = author;
		this.institution = institution;
	};
}
