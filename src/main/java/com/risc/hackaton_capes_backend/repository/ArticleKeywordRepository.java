package com.risc.hackaton_capes_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.ArticleKeyword;
import com.risc.hackaton_capes_backend.model.id.ArticleKeywordId;


@Repository
public interface ArticleKeywordRepository extends JpaRepository<ArticleKeyword, ArticleKeywordId> {

}
