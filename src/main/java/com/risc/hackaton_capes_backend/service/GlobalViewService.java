package com.risc.hackaton_capes_backend.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.risc.hackaton_capes_backend.model.dto.ArticleDTO;
import com.risc.hackaton_capes_backend.model.dto.AuthorDTO;
import com.risc.hackaton_capes_backend.model.dto.GlobalViewDTO;
import com.risc.hackaton_capes_backend.model.dto.InstitutionDTO;
import com.risc.hackaton_capes_backend.model.dto.KeywordDTO;
import com.risc.hackaton_capes_backend.model.dto.SourceDTO;
import com.risc.hackaton_capes_backend.model.dto.globalview.ArticlesResumeDTO;
import com.risc.hackaton_capes_backend.model.dto.globalview.AuthorPerKeyword;
import com.risc.hackaton_capes_backend.model.dto.globalview.KeywordsPerYear;
import com.risc.hackaton_capes_backend.model.dto.globalview.ObjectValue;

@Service
public class GlobalViewService {

	public GlobalViewDTO globalView(List<ArticleDTO> articles) {
		Map<String, Integer> articlesPerYear = new HashMap<>();
		Map<AuthorDTO, Integer> authorsPerArticle = new HashMap<>();
		Map<KeywordDTO, Integer> keywordsPerArticle = new HashMap<>();
		Map<SourceDTO, Integer> sourcesPerArticle = new HashMap<>();
		Map<KeywordsPerYear, Integer> keywordsPerYearPerArticle = new HashMap<>();
		Map<AuthorPerKeyword, Integer> authorsPerKeyword = new HashMap<>();
		
		Map<String, Integer> articlesLanguages = new HashMap<>();
		Map<String, Integer> articlesCountries = new HashMap<>();

		for (ArticleDTO article : articles) {

			compute(articlesPerYear, article.getYear());

			compute(sourcesPerArticle, article.getSource());
			
			compute(articlesLanguages, article.getLanguage());

			for (AuthorDTO author : article.getAuthors()) {
				compute(authorsPerArticle, author);
				
				InstitutionDTO institutionDTO = author.getInstitution();
				
				String country = "NA";
				
				if (institutionDTO != null && StringUtils.isNotBlank(institutionDTO.getCountry())) {
					country = institutionDTO.getCountry();				
				}

				compute(articlesCountries, country);
				
				
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
		articlesLanguages = order(articlesLanguages);
		articlesCountries = order(articlesCountries);
		
		ArticlesResumeDTO resume = ArticlesResumeDTO.builder()
				.articlesNumber(articles.size())
				.authorsNumber(authorsPerArticle.size())
				.articlesCountries(fromMap(articlesCountries))
				.articlesLanguages(fromMap(articlesLanguages))
				.build();

		return GlobalViewDTO.builder()
							.articlesPerYear(fromMap(articlesPerYear))
							.authorsPerArticle(fromMap(authorsPerArticle))
							.keywordsPerArticle(fromMap(keywordsPerArticle))
							.sourcesPerArticle(fromMap(sourcesPerArticle))
							.keywordsPerYear(fromMap(keywordsPerYearPerArticle))
							.authorsPerKeyword(fromMap(authorsPerKeyword))
							.resume(resume)
							.build();
	}

	private <T> List<ObjectValue<T>> fromMap(Map<T, Integer> map) {
		List<ObjectValue<T>> list = new ArrayList<>();

		for (Entry<T, Integer> entry : map.entrySet()) {
			list.add(new ObjectValue<T>(entry.getKey(), entry.getValue()));
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
