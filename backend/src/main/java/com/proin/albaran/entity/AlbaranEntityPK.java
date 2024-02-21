package com.proin.albaran.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbaranEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;

    private String numeroalbaran;

    private String centro;
    
    private String codigoPlanta;
    
    private String serie;
    
}
