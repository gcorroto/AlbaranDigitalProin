package com.proin.albaran.service;

import java.util.List;

import com.proin.albaran.dto.AlbaranDto;

public interface AlbaranService {

	AlbaranDto obtenerAlbaran(String numeroAlbaran, String centro, String codigoPlanta, String serie);

	List<AlbaranDto> obtenerAlbaranesByUsuarioAutenticado();
	

}