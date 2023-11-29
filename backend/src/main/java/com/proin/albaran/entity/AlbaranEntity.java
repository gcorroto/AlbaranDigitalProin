package com.proin.albaran.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="TAlbaran")
@Setter
@Getter
public class AlbaranEntity {
	
	@EmbeddedId
	private AlbaranEntityPK idAlbaran;
	
    @Column(name = "albaranid")
    private String albaranid;

    @Column(name = "fechaAlbaran")
    private Date fechaAlbaran;

    @Column(name = "cantidadAlbaran")
    private Float cantidadAlbaran;

    @Column(name = "distanciaADestino")
    private Float distanciaADestino;

    @Column(name = "obra")
    private Integer obra;

    @Column(name = "NombreObra")
    private String nombreObra;

    @Column(name = "nombreCliente")
    private String nombreCliente;

    @Column(name = "codigoPostalObra")
    private String codigoPostalObra;

    @Column(name = "nombreTransportista")
    private String nombreTransportista;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TAlbaran_TConsumos",
            joinColumns = {
                    @JoinColumn(name = "numeroAlbaran", referencedColumnName = "numeroalbaran"),
                    @JoinColumn(name = "codigoPlanta", referencedColumnName = "codigoPlanta"),
                    @JoinColumn(name = "serie", referencedColumnName = "serie"),
                    @JoinColumn(name = "centro", referencedColumnName = "centro")
            },
            inverseJoinColumns = @JoinColumn(name = "idConsumo", referencedColumnName = "id")
    )
    private List<ConsumoEntity> consumos;

    @OneToOne(optional = false)
    @JoinColumn(name = "numeroalbaran", referencedColumnName = "numeroAlbaran")
    @JoinColumn(name = "centro", referencedColumnName = "centro")
    @JoinColumn(name = "codigoPlanta", referencedColumnName = "codigoPlanta")
    @JoinColumn(name = "serie", referencedColumnName = "serie")
    private DescripcionHormigonEntity descripcionHormigon;

    @OneToOne(optional = false)
    @JoinColumn(name = "numeroalbaran", referencedColumnName = "numeroAlbaran")
    @JoinColumn(name = "centro", referencedColumnName = "centro")
    @JoinColumn(name = "codigoPlanta", referencedColumnName = "codigoPlanta")
    @JoinColumn(name = "serie", referencedColumnName = "serie")
    private EvaluacionMeteorologicaEntity evaluacionMeteorologica;

    @OneToMany
    @JoinColumn(name = "numeroAlbaran", referencedColumnName = "numeroalbaran")
    @JoinColumn(name = "codigoPlanta", referencedColumnName = "codigoPlanta")
    @JoinColumn(name = "serie", referencedColumnName = "serie")
    @JoinColumn(name = "centro", referencedColumnName = "centro")
    private List<LineaAlbaranEntity> lineasAlbaran;
}
