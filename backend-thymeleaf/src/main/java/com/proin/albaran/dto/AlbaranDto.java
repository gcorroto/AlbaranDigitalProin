package com.proin.albaran.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbaranDto {

	private String numAlbaran;
	private String fechaEntrega;
	private Integer radial;
	private Float m3;
	private Integer progresoDia;
	private String planta;
	private Integer viaCarga;
	private String obra;
	private String direccion;
	private String cp;
	private String municipio;

	private ClienteDto cliente;
	private TransporteDto transporte;
	private MeteorologiaDto meteorologia;
	private HormigonDto hormigon;
}