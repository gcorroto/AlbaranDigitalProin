package com.proin.albaran.dto;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseDto {


	@JsonIgnore
	public List<String> getFieldsList() {
		Class<? extends Object> componentClass = getClass();
		Field[] fields = componentClass.getDeclaredFields();
		List<String> lines = new ArrayList<>(fields.length);

		Arrays.stream(fields).forEach(field -> {
			field.setAccessible(true);
			lines.add(field.getName());
		});

		return lines;
	}

}