package com.proin.albaran.service;

import java.util.List;

import com.proin.albaran.dto.AlbaranDto;
import com.proin.conex.modelos.transporte.TAlbaran;

public interface MockAlbaranService {

    public TAlbaran obtenerAlbaran(String... id);

    public List<TAlbaran> obtenerAlbaranesUsuario();

    public AlbaranDto rellenarCamposAlbaran(AlbaranDto dto);

    public void actualizarAlbaran(String id, AlbaranDto dto);
}