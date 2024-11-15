package com.risc.hackaton_capes_backend.model.id;

import java.io.Serializable;

import com.risc.hackaton_capes_backend.model.Author;
import com.risc.hackaton_capes_backend.model.Institution;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class AuthorInstitutionId implements Serializable {
	private static final long serialVersionUID = 6562864145070522207L;

	@OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;
	
	@ManyToOne
    @JoinColumn(name = "institution_id", referencedColumnName = "id")
	private Institution institution;

	public AuthorInstitutionId(Author author, Institution institution) {
		super();
		this.author = author;
		this.institution = institution;
	}
}
