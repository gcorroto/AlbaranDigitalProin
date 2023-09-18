package com.proin.albaran.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecepcionDto extends BaseDto {

	private String laboratorio;
	private String elementoHormigon;
	private String horaToma;
	private String cono;
	private Integer numProbetas;

}