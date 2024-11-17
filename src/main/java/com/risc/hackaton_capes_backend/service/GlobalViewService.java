package com.risc.hackaton_capes_backend.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.model.dto.ArticleDTO;
import com.risc.hackaton_capes_backend.model.dto.AuthorDTO;
import com.risc.hackaton_capes_backend.model.dto.AuthorPerKeyword;
import com.risc.hackaton_capes_backend.model.dto.GlobalViewDTO;
import com.risc.hackaton_capes_backend.model.dto.KeywordDTO;
import com.risc.hackaton_capes_backend.model.dto.KeywordsPerYear;
import com.risc.hackaton_capes_backend.model.dto.ObjectPerArticle;
import com.risc.hackaton_capes_backend.model.dto.SourceDTO;

@Service
public class GlobalViewService {

	public GlobalViewDTO globalView(List<ArticleDTO> articles) {

		Map<String, Integer> articlesPerYear = new HashMap<>();

		Map<AuthorDTO, Integer> authorsPerArticle = new HashMap<>();

		Map<KeywordDTO, Integer> keywordsPerArticle = new HashMap<>();

		Map<SourceDTO, Integer> sourcesPerArticle = new HashMap<>();

		Map<KeywordsPerYear, Integer> keywordsPerYearPerArticle = new HashMap<>();

		Map<AuthorPerKeyword, Integer> authorsPerKeyword = new HashMap<>();

		for (ArticleDTO article : articles) {

			compute(articlesPerYear, article.getYear());

			compute(sourcesPerArticle, article.getSource());

			for (AuthorDTO author : article.getAuthors()) {
				compute(authorsPerArticle, author);
				
				for (KeywordDTO keyword : article.getKeywords()) {

					AuthorPerKeyword authorPerKeyword = AuthorPerKeyword.builder()
							.keyword(keyword)
							.author(author)
							.build();

					compute(authorsPerKeyword, authorPerKeyword);
				}
			}

			for (KeywordDTO keyword : article.getKeywords()) {
				compute(keywordsPerArticle, keyword);

				KeywordsPerYear keywordsPerYear = KeywordsPerYear.builder()
						.keyword(keyword)
						.year(article.getYear())
						.build();

				compute(keywordsPerYearPerArticle, keywordsPerYear);
			}
		}

		articlesPerYear = orderYear(articlesPerYear);
		authorsPerArticle = order(authorsPerArticle);
		keywordsPerArticle = order(keywordsPerArticle);
		sourcesPerArticle = order(sourcesPerArticle);

		return GlobalViewDTO.builder()
				.articlesPerYear(fromMap(articlesPerYear))
				.authorsPerArticle(fromMap(authorsPerArticle))
				.keywordsPerArticle(fromMap(keywordsPerArticle))
				.sourcesPerArticle(fromMap(sourcesPerArticle))
				.keywordsPerYear(fromMap(keywordsPerYearPerArticle))
				.authorsPerKeyword(fromMap(authorsPerKeyword))
				.build();
	}

	private <T> List<ObjectPerArticle<T>> fromMap(Map<T, Integer> map) {
		List<ObjectPerArticle<T>> list = new ArrayList<>();

		for (Entry<T, Integer> entry : map.entrySet()) {
			list.add(new ObjectPerArticle<T>(entry.getKey(), entry.getValue()));
		}

		return list;
	}

	private <T> Map<T, Integer> order(Map<T, Integer> map) {

		return map.entrySet().stream().sorted(Map.Entry.<T, Integer>comparingByValue(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2) {
					return 0;
				}

				if (o1 > o2) {
					return -1;
				} else {
					return 1;
				}
			}
		})).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
				LinkedHashMap::new));
	}

	private Map<String, Integer> orderYear(Map<String, Integer> map) {

		return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				Integer o1 = Integer.valueOf(s1);
				Integer o2 = Integer.valueOf(s2);

				if (o1 == o2) {
					return 0;
				}

				if (o1 > o2) {
					return 1;
				} else {
					return -1;
				}
			}
		})).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
				LinkedHashMap::new));
	}

	private <T> void compute(Map<T, Integer> map, T key) {
		if (map.containsKey(key)) {
			map.compute(key, (k, v) -> v + 1);
		} else {
			map.put(key, 1);
		}
	}
}
