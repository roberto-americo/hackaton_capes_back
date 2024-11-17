package com.risc.hackaton_capes_backend.model.dto.globalview;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ObjectValue<T> {
	
	private T object;
	private Integer value;
	
	public ObjectValue(T object, Integer value) {
		this.object = object;
		this.value = value;
	}
}
