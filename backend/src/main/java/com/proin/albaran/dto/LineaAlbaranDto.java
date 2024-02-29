package com.proin.albaran.dto;

import lombok.Data;

@Data
public class LineaAlbaranDto {

    private String tipoMaterial;    
    private String descripcion;
    private Double cantidad;
    //unidadCantidad
    private String sello;
    private String entidadCertificadora;
    private String logotipo;
    private Double cantidadSolicitadaPedido; 
    private String unidadCantidadSolicitadaPedido; 
    private Double cantidadServidaDia;
    private String unidadCantidadServidaDia;
}
