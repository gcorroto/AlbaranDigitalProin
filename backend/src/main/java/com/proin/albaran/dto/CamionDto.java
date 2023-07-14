package com.proin.albaran.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CamionDto extends VehiculoDto {

	public CamionDto(String matricula){
		super();
		this.matricula = matricula;
	}

}