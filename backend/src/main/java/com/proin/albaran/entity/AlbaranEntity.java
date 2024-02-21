package com.proin.albaran.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
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
public class AlbaranEntity {
	
	@EmbeddedId
	private AlbaranEntityPK id;
	
    private String albaranid;

    @OneToOne(cascade = CascadeType.ALL)
        @JoinColumns({
        @JoinColumn(name = "numeroalbaran", referencedColumnName = "numeroalbaran"),
        @JoinColumn(name = "centro", referencedColumnName = "centro"),
        @JoinColumn(name = "codigoPlanta", referencedColumnName = "codigoPlanta"),
        @JoinColumn(name = "serie", referencedColumnName = "serie")
    })
    private DescripcionHormigonEntity descripcionHormigonEntity;

    private Double volumenTotalFabricado;

    private Double masaTotalFabricada;

    private String unidadMasaTotalFabricada;

    private String descripcionCementoAlbaran;

    private Double masaCementiciaReal;

    private String unidadMasaCementiciaReal;

    private String nombreProveedorCementoAlbaran;

    private Double relacionAguaCementoReal;

    private Date fechaAlbaran;

    private Double distanciaADestino;

    private String unidadDistanciaADestino;

    private String nombreCliente;

    private String cliente;

    private String nombreObra;

    private String obra;

    private String nombreOperadorTransporte;

    private String  cifOperadorTransporte;

    private String matriculaCamion;

    private String matricularemolque;

    private String nombreTransportista;

	private String cifTransportista;

	private Boolean clienteEsCargadorContractual; 

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
