package com.risc.hackaton_capes_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.risc.hackaton_capes_backend.model.Article;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
