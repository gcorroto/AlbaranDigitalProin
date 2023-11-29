package com.proin.albaran.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbaranDto extends BaseDto {

	private String numAlbaran;
	private String fechaAlbaran; //fechaEntrega;
	private Integer radial;
	private Float cantidadAlbaran; //m3;
	private Float distanciaADestino;//progresoDia;
	private String codigoPlanta; //planta;
	private Integer obra; //viaCarga;
	private String nombreObra;
	private String nombreCliente; //direccion;
	private String codigoPostalObra; //cp
	private String nombreTransportista; //municipio;

	private ClienteDto cliente;
	private TransporteDto transporte;
	private MeteorologiaDto meteorologia;
	private HormigonDto hormigon;
	private HorarioDto horario;
	private RecepcionDto recepcion;


}