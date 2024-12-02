package com.proin.albaran.entity;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TDescripcionHormigon")
public class DescripcionHormigonEntity {

	@EmbeddedId
	private AlbaranEntityPK id;

    @Basic
    private String literal;

    @Basic
    private String tipoBasico;

    @Basic
    private String tipo;

    @Basic
    private String tipoHormigonEstructural;

    @Basic
    private String tipoHormigonEspecial;

    @Basic
    private String tipoHormigonFibras;

    @Basic
    private String especificacion;

    @Basic
    private String resistencia;

    @Basic
    private String tipoConsistencia;

    @Basic
    private String conoConsistencia;

    @Basic
    private String contenidoCemento;

    @Basic
    private String contenidoFibra;

    @Basic
    private String tamanoMaximo;

    @Basic
    private String ambiente;

    @Basic
    private String autocompactabilidad;

    @Basic
    private String tipoEscurrimiento;

    @Basic
    private String tipoViscosidad;

    @Basic
    private String tipoResistenciaBloqueo;

    @Basic
    private String tipoFibra;

    @Basic
    private String resistenciaFlexotraccionR1;

    @Basic
    private String resistenciaFlexotraccionR3;

    @Basic
    private String tipoResistenciaFibrasFuncionNoEstructural;

    @Basic
    private String longitudFibra;

    @Basic
    private String mensajeError;

}