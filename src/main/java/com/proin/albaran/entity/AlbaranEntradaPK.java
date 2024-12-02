package com.proin.albaran.entity;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class AlbaranEntradaPK implements java.io.Serializable{
    
    private String codigoExternoAlbaranEntrada;
    private String codigoExternoCentro;

}
