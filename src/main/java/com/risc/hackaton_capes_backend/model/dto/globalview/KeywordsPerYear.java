package com.risc.hackaton_capes_backend.model.dto.globalview;

import java.util.Objects;

import com.risc.hackaton_capes_backend.model.dto.KeywordDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class KeywordsPerYear {
	
	private String year;
	
	private KeywordDTO keyword;

	@Override
	public int hashCode() {
		return Objects.hash(keyword, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			
			return true;
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		KeywordsPerYear other = (KeywordsPerYear) obj;
		return Objects.equals(keyword, other.keyword) && Objects.equals(year, other.year);
	}
	
	
}
