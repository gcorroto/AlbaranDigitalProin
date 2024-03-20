package com.proin.albaran.entity;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TAlbaran")
@Setter
@Getter
public class AlbaranEntity extends AlbaranAbstract{
		
    @OneToOne(cascade = CascadeType.ALL)
        @JoinColumns({
        @JoinColumn(name = "numeroalbaran", referencedColumnName = "numeroalbaran"),
        @JoinColumn(name = "centro", referencedColumnName = "centro"),
        @JoinColumn(name = "codigoPlanta", referencedColumnName = "codigoPlanta"),
        @JoinColumn(name = "serie", referencedColumnName = "serie")
    })
    private DescripcionHormigonEntity descripcionHormigonEntity;

    private BigDecimal volumenTotalFabricado;

    private String unidadVolumenTotalFabricado;

    private BigDecimal masaTotalFabricada;

    private String unidadMasaTotalFabricada;

    private String descripcionCementoAlbaran;

    private BigDecimal masaCementiciaReal;

    private String unidadMasaCementiciaReal;

    private String nombreProveedorCementoAlbaran;

    private BigDecimal relacionAguaCementoReal;

    private String matricularemolque;

    @OneToMany(fetch = javax.persistence.FetchType.EAGER)
    @JoinColumns({
    @JoinColumn(name = "numeroalbaran", referencedColumnName = "numeroalbaran"),
    @JoinColumn(name = "centro", referencedColumnName = "centro"),
    @JoinColumn(name = "codigoPlanta", referencedColumnName = "codigoPlanta"),
    @JoinColumn(name = "serie", referencedColumnName = "serie")
    })
    private List<LineaAlbaranEntity> lineasAlbaran;

    @OneToOne(fetch = javax.persistence.FetchType.EAGER)
    @JoinColumns({
    @JoinColumn(name = "numeroalbaran", referencedColumnName = "numeroalbaran"),
    @JoinColumn(name = "centro", referencedColumnName = "centro"),
    @JoinColumn(name = "codigoPlanta", referencedColumnName = "codigoPlanta"),
    @JoinColumn(name = "serie", referencedColumnName = "serie")
    })
    private EvaluacionMeteorologicaEntity evaluacionMeteorologicaEntity;

    private Date llegadaobra;

    private Date iniciodescarga;

    private Date salidaobra;

    private Date llegadaplanta;
}
