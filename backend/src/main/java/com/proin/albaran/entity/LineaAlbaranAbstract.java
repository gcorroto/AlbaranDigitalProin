package com.proin.albaran.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.proin.conex.modelos.transporte.TMedida;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class LineaAlbaranAbstract implements java.io.Serializable{

    @Id
    private String lineaalbaranid;

    private String tipoMaterial;

    private String descripcion;

    private Double cantidad;

    private String sello;

    private String entidadCertificadora;

    private String logotipo;

    private Double cantidadSolicitadaPedido; 

    private String unidadCantidadSolicitadaPedido; 

    private Double cantidadServidaDia;

    private String unidadCantidadServidaDia;

}
