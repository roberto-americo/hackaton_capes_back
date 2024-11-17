package com.risc.hackaton_capes_backend.service;

import static com.risc.hackaton_capes_backend.enums.CSVEnum.ABSTRACT;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.AUTHORS_2;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.COUNTRIES;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.INSTITUTIONS;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.JOURNAL;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.KEYWORDS;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.KEYWORDS_ES;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.KEYWORDS_PT;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.LANGUAGE;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.TITLE;
import static com.risc.hackaton_capes_backend.enums.CSVEnum.YEAR;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.risc.hackaton_capes_backend.enums.CSVEnum;
import com.risc.hackaton_capes_backend.model.dto.ArticleDTO;
import com.risc.hackaton_capes_backend.model.dto.AuthorDTO;
import com.risc.hackaton_capes_backend.model.dto.InstitutionDTO;
import com.risc.hackaton_capes_backend.model.dto.KeywordDTO;
import com.risc.hackaton_capes_backend.model.dto.SourceDTO;

@Service
public class FileDataService {
	
	private final CSVEnum[] prioritiesFields = {TITLE, KEYWORDS, AUTHORS_2, ABSTRACT};

	@Autowired
	private ArticleService articleService;
	
	public void extractFromCSV() {
		Set<ArticleDTO> articles = new HashSet<>();
		
		try {
			List<String[]> lines = loadCsv();
			
			for (int count = 1; count < lines.size(); count ++) {
				String[] line = lines.get(count);
				
				if (hasPriority(line)) {
					
					SourceDTO source = SourceDTO.builder()
							.name(line[JOURNAL.getIndex()])
							.build();
					
					Set<KeywordDTO> keywords = new HashSet<KeywordDTO>();
					
					getKeywords(line, keywords);
					
					Set<AuthorDTO> authors = new HashSet<AuthorDTO>();
					
					String[] authorsSplitted = line[AUTHORS_2.getIndex()].split("\\;");
					
					for (int i = 0; i < authorsSplitted.length; i++) {
						String name = get(i, line, AUTHORS_2);
						
						if (name == null) {
							System.out.println(line[8]);
							continue;
						}
						
						InstitutionDTO institution = null;
						
						String institutionName = get(i, line, INSTITUTIONS);
						
						if (institutionName != null) {							
							String country = get(i, line, COUNTRIES);
							
							institution = InstitutionDTO.builder()
									.name(institutionName)
									.country(country)
									.build();
						}
						
						AuthorDTO author = AuthorDTO.builder()
								.name(name)
								.institution(institution)
								.build();
						
						authors.add(author);						
					}
					
					ArticleDTO articleDTO = ArticleDTO.builder()
							.title(line[TITLE.getIndex()])
							.language(line[LANGUAGE.getIndex()])
							.year(line[YEAR.getIndex()])
							.abstractArticle(line[ABSTRACT.getIndex()])
							.source(source)
							.keywords(keywords)
							.authors(authors)
							.build();
					
					articleService.save(articleDTO);
					
					articles.add(articleDTO);
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		articles.size();
	}

	private void getKeywords(String[] line, Set<KeywordDTO> keywords) {
		String[] keywordsSplitted = line[KEYWORDS.getIndex()].split("\\;");
		
		for (String keywordSplitted: keywordsSplitted) {
			keywords.add(KeywordDTO.builder().name(keywordSplitted).build());
		}
	}
	
	private List<String[]> loadCsv() throws Exception {
		Path path = Paths.get(ClassLoader.getSystemResource("csv/output.csv").toURI());
	    
	    List<String[]> list = new ArrayList<>();
	    try (Reader reader = Files.newBufferedReader(path)) {
	        try (CSVReader csvReader = new CSVReader(reader)) {
	            String[] line;
	            while ((line = csvReader.readNext()) != null) {
	                list.add(line);
	            }
	        }
	    }
	    return list;
	}
	
	private boolean hasPriority(String[] line) {
		for (CSVEnum csvEnum: prioritiesFields) {
			String str = line[csvEnum.getIndex()];
			
			if (isNOTValidField(str) && isNOTValidKeyword(csvEnum, str)) {
				return false;
			}
		}
		
		return true;
	}

	private boolean isNOTValidField(String str) {
		return StringUtils.isBlank(str) || str.equals("NA");
	}
	
	private String get(int index, String[] array, CSVEnum csvEnum) {
		String output = null;
		String field = array[csvEnum.getIndex()];
		
		if (!isNOTValidField(field)) {
			String[] splited = field.split("\\;");
			
			if (index < splited.length) {
				output = splited[index];
			}
		}
		
		return output;
	}
	
	private boolean isNOTValidKeyword(CSVEnum csvEnum, String str) {
		if (str.contains("email:")) {
			System.out.println("");
		}

		if (csvEnum.equals(KEYWORDS) || csvEnum.equals(KEYWORDS_PT) || csvEnum.equals(KEYWORDS_ES)) {
			if (!str.contains(";")) {
				return true;
			}
			
			if (str.contains("[") && str.contains("Links") && str.contains("]")) {
				return true;
			}
			
			if (str.contains("[") && str.contains("LINKS") && str.contains("]")) {
				return true;
			}
			
			if (str.contains(",") && (str.contains("(") || str.contains(")"))) {
				return true;
			}
			
			if (str.contains("@")) {
				return true;
			}
		}
		
		return false;
	}
}
