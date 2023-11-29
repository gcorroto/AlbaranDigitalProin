package com.proin.albaran.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;

    @Column(name = "numeroalbaran")
    private String numeroAlbaran;

    @Column(name = "centro")
    private String centro;
    
    @Column(name = "codigoPlanta")
    private String codigoPlanta;
    
    @Column(name = "serie")
    private String serie;

    @Column(name = "idConsumo")
    private Integer idConsumo;
    
}
