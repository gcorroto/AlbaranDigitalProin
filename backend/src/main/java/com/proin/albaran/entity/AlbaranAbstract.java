package com.proin.albaran.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AlbaranAbstract {

    @EmbeddedId
    private AlbaranEntityPK id;

    @Basic
    private String camion;

    @Basic
    private String obra;

    @Basic
    private Boolean transportePropio;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlbaran;

    @Basic
    private String codigoExternoPedido;

    @Basic
    private String observaciones;

    @Basic
    private String conductor;

    @Basic
    private String cliente;

    @Basic
    private String albaranid;

    @Basic
    private String estadoAlbaran;

    @Basic
    private String unidadCapacidadCamion;

    @Basic
    private String nombreObra;

    @Basic
    private String nombreProveedor;

    @Basic
    private String codigoExternoProveedor;

    @Basic
    private String nombreTransportista;

    @Basic
    private String nombreCliente;

    @Basic
    private Double capacidadCamion;

    @Basic
    private String unidadDistanciaADestino;

    @Basic
    private Double distanciaADestino;

    @Basic
    private String codigoExternoTransportista;

    @Basic
    private String nombreConductor;

    @Basic
    private String unidadTara;

    @Basic
    private Double tara;

    @Basic
    private String estadoCierre;

    @Basic
    private String matriculaCamion;

    @Basic
    private Boolean clienteEsCargadorContractual;

    @Basic
    private String codigoExternoOperadorTransporte;

    @Basic
    private String nombreOperadorTransporte;

    @Basic
    private String cifTransportista;

    @Basic
    private String cifOperadorTransporte;

    @Basic
    private String codigoExternoFormula;

    @Basic
    private String codigoExternoGPSCamion;

    @Basic
    private String seriePedido;

    @Basic
    private String codigoExternoPedidoERP;

 }