package com.proin.albaran.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TDescripcionHormigon")
@Getter
@Setter
public class DescripcionHormigonEntity {

    @EmbeddedId
    private AlbaranEntityPK idAlbaran;

    @Column(name = "literal")
    private String literal;

    @Column(name = "tipoBasico")
    private String tipoBasico;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "tipoHormigonEstructural")
    private String tipoHormigonEstructural;

    @Column(name = "tipoHormigonEspecial")
    private String tipoHormigonEspecial;

    @Column(name = "tipoHormigonFibras")
    private String tipoHormigonFibras;

    @Column(name = "especificacion")
    private String especificacion;

    @Column(name = "resistencia")
    private String resistencia;

    @Column(name = "tipoConsistencia")
    private String tipoConsistencia;

    @Column(name = "conoConsistencia")
    private String conoConsistencia;

    @Column(name = "contenidoCemento")
    private String contenidoCemento;

    @Column(name = "contenidoFibra")
    private String contenidoFibra;

    @Column(name = "tamanoMaximo")
    private String tamanoMaximo;

    @Column(name = "ambiente")
    private String ambiente;

    @Column(name = "autocompactabilidad")
    private String autocompactabilidad;

    @Column(name = "tipoEscurrimiento")
    private String tipoEscurrimiento;

    @Column(name = "tipoViscosidad")
    private String tipoViscosidad;

    @Column(name = "tipoResistenciaBloqueo")
    private String tipoResistenciaBloqueo;

    @Column(name = "tipoFibra")
    private String tipoFibra;

    @Column(name = "resistenciaFlexotraccionR1")
    private String resistenciaFlexotraccionR1;

    @Column(name = "resistenciaFlexotraccionR3")
    private String resistenciaFlexotraccionR3;

    @Column(name = "tipoResistenciaFibrasFuncionNoEstructural")
    private String tipoResistenciaFibrasFuncionNoEstructural;

    @Column(name = "longitudFibra")
    private String longitudFibra;

    @Column(name = "mensajeError")
    private String mensajeError;


}
