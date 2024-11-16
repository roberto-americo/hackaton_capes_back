package com.risc.hackaton_capes_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.ArticleSource;
import com.risc.hackaton_capes_backend.model.id.ArticleSourceId;


@Repository
public interface ArticleSourceRepository extends JpaRepository<ArticleSource, ArticleSourceId> {

}
