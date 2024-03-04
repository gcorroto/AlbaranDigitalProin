package com.proin.albaran.service;

import java.util.List;
import java.util.Optional;

import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.entity.AlbaranEntity;

public interface AlbaranService {

	AlbaranDto obtenerAlbaran(String numeroAlbaran, String centro, String codigoPlanta, String serie);

	List<AlbaranDto> obtener10Albaranes();
	

}