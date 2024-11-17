package com.risc.hackaton_capes_backend.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ObjectPerArticle<T> {
	
	private T object;
	private Integer value;
	
	public ObjectPerArticle(T object, Integer value) {
		this.object = object;
		this.value = value;
	}
}
