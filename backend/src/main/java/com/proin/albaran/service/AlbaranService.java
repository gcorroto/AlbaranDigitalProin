package com.proin.albaran.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.proin.albaran.entity.AlbaranEntity;

public interface AlbaranService {

	Optional<AlbaranEntity> obtenerAlbaran(String numeroAlbaran, String centro, String codigoPlanta, String serie);

	Page<AlbaranEntity> obtener10Albaranes();
	

}