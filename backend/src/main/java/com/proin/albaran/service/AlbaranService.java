package com.proin.albaran.service;

import java.util.List;

import com.proin.albaran.entity.AlbaranEntity;
import com.proin.conex.modelos.transporte.TAlbaran;

public interface AlbaranService {

	TAlbaran obtenerAlbaran(String numeroAlbaran, String centro, String codigoPlanta, String serie);
	
	List<AlbaranEntity> obtenerConEntities();
}