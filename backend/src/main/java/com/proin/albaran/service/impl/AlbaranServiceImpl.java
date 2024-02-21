package com.proin.albaran.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.proin.albaran.entity.AlbaranEntity;
import com.proin.albaran.entity.AlbaranEntityPK;
import com.proin.albaran.repository.AlbaranRepository;
import com.proin.albaran.service.AlbaranService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbaranServiceImpl implements AlbaranService{
	
	private final AlbaranRepository albaranRepository;
	
	@Override
	public Optional<AlbaranEntity> obtenerAlbaran(String numeroAlbaran, String centro, String codigoPlanta, String serie) {
		return albaranRepository.findById(new AlbaranEntityPK(numeroAlbaran, centro, codigoPlanta, serie));
	}
	
	@Override
	public Page<AlbaranEntity> obtener10Albaranes(){
		return albaranRepository.findAll(PageRequest.of(0, 10));
	}

}