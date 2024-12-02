package com.proin.albaran.entity;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TEvaluacionMeteorologica")
@Setter
@Getter
public class EvaluacionMeteorologicaEntity {

    @EmbeddedId
	private AlbaranEntityPK id;

    private String clima;

    private String direccionViento;

    private LocalDateTime fechaCreacion;

    private String humedad;

    private String intensidadPrecipitacion;

    private String presion;

    private String prevision;

    private String razonesClima;

    private String temperatura;

    private String velocidadViento;
}
