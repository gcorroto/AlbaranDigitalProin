package com.proin.albaran.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HormigonDto extends BaseDto {

	private String tipo;
	// ficha tecinca referencia
	private String referencia;
	//relacion agua cemento
	private String relacion;
	private ContenidoDto contenido;
	private AdicionesHormigonDto adiciones;

}