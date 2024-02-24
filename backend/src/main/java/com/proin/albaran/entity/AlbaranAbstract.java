package com.proin.albaran.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AlbaranAbstract {

    @EmbeddedId
    private AlbaranEntityPK id;

    private String camion;

    private String obra;

    private Boolean transportePropio;

    private Date fechaAlbaran;

    private String codigoExternoPedido;

    private String observaciones;

    private String conductor;

    private String cliente;

    private String albaranid;

    private String estadoAlbaran;

    private String unidadCapacidadCamion;

    private String nombreObra;

    private String nombreProveedor;

    private String codigoExternoProveedor;

    private String nombreTransportista;

    private String nombreCliente;

    private Double capacidadCamion;

    private String unidadDistanciaADestino;

    private Double distanciaADestino;

    private String codigoExternoTransportista;

    private String nombreConductor;

    private String unidadTara;

    private Double tara;

    private String estadoCierre;

    private String matriculaCamion;

    private Boolean clienteEsCargadorContractual;

    private String codigoExternoOperadorTransporte;

    private String nombreOperadorTransporte;

    private String cifTransportista;

    private String cifOperadorTransporte;

    private String codigoExternoFormula;

    private String codigoExternoGPSCamion;

    private String seriePedido;

    private String codigoExternoPedidoERP;

 }