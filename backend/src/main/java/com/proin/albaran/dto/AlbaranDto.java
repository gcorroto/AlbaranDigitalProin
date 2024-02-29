package com.proin.albaran.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class AlbaranDto {

	////////// Pestaña cabecera
  
    private String especificacion;
    private Double volumenTotalFabricado;
    private Double masaTotalFabricada;
    private String unidadMasaTotalFabricada;
    private String descripcionCementoAlbaran;
    private Double masaCementiciaReal;
    private String unidadMasaCementiciaReal;
    private String nombreProveedorCementoAlbaran;
    private Double relacionAguaCementoReal;

    ////////// Pestaña de cliente
    private String numeroAlbaran;
    private Date fecha;
    private String unidadDistanciaADestino;
    private Double distanciaADestino;
    private String codigoPlanta;
    private String centro;
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
}