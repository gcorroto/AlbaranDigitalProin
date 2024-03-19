package com.proin.albaran.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AlbaranDto {

	////////// Pestaña cabecera
  
    private String especificacion;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "%.2f")
    private BigDecimal volumenTotalFabricado;
    private String unidadVolumenTotalFabricado;
    private BigDecimal masaTotalFabricada;
    private String unidadMasaTotalFabricada;
    private String descripcionCementoAlbaran;
    private BigDecimal masaCementiciaReal;
    private String unidadMasaCementiciaReal;
    private String nombreProveedorCementoAlbaran;
    private BigDecimal relacionAguaCementoReal;

    ////////// Pestaña de cliente
    private String numeroAlbaran;
    private Date fecha;
    private String unidadDistanciaADestino;
    private BigDecimal distanciaADestino;
    private String codigoPlanta;
    private String centro;
    private String serie;
    private String nombreCliente;
    private String cliente;
    private String nombreObra;
    private String obra;

    ////////// Pestaña de transporte
    private String nombreOperadorTransporte;
    private String cifOperadorTransporte;
    private String matriculaCamion;
    private String matricularemolque;
    private String nombreTransportista;
    private String cifTransportista;
    private Boolean clienteEsCargadorContractual;

    ////////// Pestaña de hormigones 
    private List<LineaAlbaranDto> lineasAlbaran;

    ////////// Pestaña meteorología 
    private String clima;
    private String direccionViento;
    private Date fechaCreacion;
    private String humedad;
    private String intensidadPrecipitacion;
    private String presion;
    private String prevision;
    private String razonesClima;
    private String temperatura;
    private String velocidadViento;

    ////////// Pestaña Horarios
    private Date fechaAlbaran;
    private Date llegadaobra;
    private Date iniciodescarga;
    private Date salidaobra;
    private Date llegadaplanta;

    ////////// Pestaña firma
    private String firmaCliente;
}