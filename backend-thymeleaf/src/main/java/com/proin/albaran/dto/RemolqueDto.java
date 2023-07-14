package com.proin.albaran.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RemolqueDto extends VehiculoDto {

	public RemolqueDto(String matricula){
		super();
		this.matricula = matricula;
	}

}