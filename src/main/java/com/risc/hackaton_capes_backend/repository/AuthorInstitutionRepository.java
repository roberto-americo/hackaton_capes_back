package com.risc.hackaton_capes_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.AuthorInstitution;
import com.risc.hackaton_capes_backend.model.id.AuthorInstitutionId;


@Repository
public interface AuthorInstitutionRepository extends JpaRepository<AuthorInstitution, AuthorInstitutionId> {

}
