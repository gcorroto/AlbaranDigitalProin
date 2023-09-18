package com.proin.albaran.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioDto extends BaseDto {

	private String cargaPlanta;
	private String llegadaObra;
	private String inicioDescarga;
	private String finalDescarga;
	private String llegadaPlanta;
	private String limiteUso;
	private Boolean hormigonBombeado;
	private String aguaCliente;

}