package com.proin.albaran.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="TConsumo")
@Setter
@Getter
public class ConsumoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "cantidad")
    private BigDecimal cantidad;

    @Basic
    @Column(name = "codigoExternoMaterial")
    private String codigoExternoMaterial;

    @Basic
    @Column(name = "unidad")
    private String unidad;

    @Basic
    @Column(name = "unidadCantidadTeorica")
    private String unidadCantidadTeorica;

    @Basic
    @Column(name = "descripcionMaterial")
    private String descripcionMaterial;

    @Basic
    @Column(name = "cantidadTeorica")
    private BigDecimal cantidadTeorica;

}
