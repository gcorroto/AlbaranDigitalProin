package com.proin.albaran.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TAlbaranEntrada")
public class AlbaranEntradaEntity {

    @EmbeddedId
    private AlbaranEntradaPK id;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Basic
    private String observaciones;

    @Basic
    private String codigoExternoAlbaranProveedor;

    @Basic
    private String codigoExternoLote;

    @Basic
    private String estadoCierre;

    @Basic
    private String codigoExternoConductor;

    @Basic
    private String codigoExternoProveedor;

    @Basic
    private String matriculaCamion;

    @Basic
    private String codigoExternoCamion;

    @Basic
    private String codigoExternoOrigen;

    @Basic
    private String codigoExternoPedidoCompraAbierto;

    @Basic
    private String codigoExternoMaterial;

    @Basic
    private Double cantidad;

    @Basic
    private String unidadCantidad;

    @Basic
    private Double cantidadSegunProveedor;

    @Basic
    private String unidadCantidadSegunProveedor;

    @Basic
    private String codigoExternoTransportista;

    @Basic
    private String codigoExternoProveedorAsociadoTransportista;

    @Basic
    private String razonSocialProveedorAsociadoTransportista;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBorrado;

}
