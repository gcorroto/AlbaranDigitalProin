package com.proin.albaran.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TEvaluacionMeteorologica")
@Getter
@Setter
public class EvaluacionMeteorologicaEntity {

    @EmbeddedId
    private AlbaranEntityPK idAlbaran;

    @Column(name = "clima")
    private String clima;

    @Column(name = "direccionViento")
    private String direccionViento;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "humedad")
    private String humedad;

    @Column(name = "intensidadPrecipitacion")
    private String intensidadPrecipitacion;

    @Column(name = "presion")
    private String presion;

    @Column(name = "prevision")
    private String prevision;

    @Column(name = "razonesClima")
    private String razonesClima;

    @Column(name = "temperatura")
    private String temperatura;

    @Column(name = "velocidadViento")
    private String velocidadViento;



}
