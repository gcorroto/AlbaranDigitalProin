package com.proin.albaran.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="TLineaAlbaran")
@Setter
@Getter
public class LineaAlbaranEntity {

    @Id
    @Column(name = "lineaalbaranid")
    private int lineaAlbaranId;

    @Column(name = "cantidad")
    private Float cantidad;

    @Column(name = "codigoExternoMaterial")
    private String codigoExternoMaterial;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Float precio;

    @Column(name = "tipoMaterial")
    private String tipoMaterial;

    @Column(name = "unidad")
    private String unidad;

    @Column(name = "unidadPrecioUnitario")
    private String unidadPrecioUnitario;

    @Column(name = "unidadCantidadRestantePedido")
    private String unidadCantidadRestantePedido;

    @Column(name = "cantidadRestantePedido")
    private Float cantidadRestantePedido;

    @Column(name = "unidadCantidadServidaPedido")
    private String unidadCantidadServidaPedido;

    @Column(name = "cantidadServidaPedido")
    private Float cantidadServidaPedido;

    @Column(name = "unidadCantidadSolicitadaPedido")
    private String unidadCantidadSolicitadaPedido;

    @Column(name = "cantidadSolicitadaPedido")
    private Float cantidadSolicitadaPedido;

    @Column(name = "centro")
    private String centro;

    @Column(name = "numeroAlbaran")
    private String numeroAlbaran;

    @Column(name = "codigoPlanta")
    private String codigoPlanta;

    @Column(name = "serie")
    private String serie;

}
