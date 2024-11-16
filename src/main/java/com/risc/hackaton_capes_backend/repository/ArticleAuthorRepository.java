package com.risc.hackaton_capes_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.ArticleAuthor;
import com.risc.hackaton_capes_backend.model.id.ArticleAuthorId;


@Repository
public interface ArticleAuthorRepository extends JpaRepository<ArticleAuthor, ArticleAuthorId> {

}
