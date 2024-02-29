package com.proin.albaran.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbaranDto {

	// Información básica del albarán
    private String numeroAlbaran;
    private String centro;
    private String codigoPlanta;
    private String serie;
    private Date fecha;
  
    // Información del hormigón
    private String tipoHormigon;
    private String referenciaCliente;
    private String nombreComercial;
  
    // Cantidades
    private Double volumenTotalFabricado;
    private Double masaTotalFabricada;
    private String unidadMasaTotalFabricada;
  
    // Cemento
    private String descripcionCementoAlbaran;
    private Double masaCementiciaReal;
    private String unidadMasaCementiciaReal;
    private String nombreProveedorCementoAlbaran;
  
    // Relación agua/cemento
    private Double relacionAguaCementoReal;
  
    // Datos del camión
    private String matriculaCamion;
    private String matricularemolque;
  
    // Entorno
    private String clima;
    private String temperatura;
    private String humedad;
    private String velocidadViento;
    private String direccionViento;
  
    // Fechas
    private Date llegadaobra;
    private Date iniciodescarga;
    private Date salidaobra;
    private Date llegadaplanta;
  
    // Observaciones
    private String observaciones;
}
