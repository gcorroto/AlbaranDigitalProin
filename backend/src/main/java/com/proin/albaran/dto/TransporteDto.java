package com.proin.albaran.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransporteDto extends BaseDto {

	private String empresa;
	private String cif;
	private CamionDto camion;
	private RemolqueDto remolque;
	private String cargadorContractual;
}