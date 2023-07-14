package com.proin.albaran.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContenidoDto {

	private List<DesgloseContenidoDto> cementos;
	private List<DesgloseContenidoDto> aditivos;
	private List<DesgloseContenidoDto> adiciones;
}