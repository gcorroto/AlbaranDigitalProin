package com.proin.albaran.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
