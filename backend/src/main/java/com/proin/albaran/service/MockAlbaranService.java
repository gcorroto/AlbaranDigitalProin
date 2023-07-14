package com.proin.albaran.service;

import com.proin.albaran.dto.AlbaranDto;
import com.proin.conex.modelos.transporte.TAlbaran;

public interface MockAlbaranService {

    public TAlbaran obtenerAlbaran();

    public AlbaranDto rellenarCamposAlbaran(AlbaranDto dto);
}