package com.proin.albaran.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.entity.AlbaranEntity;
import com.proin.albaran.entity.AlbaranEntityPK;
import com.proin.albaran.repository.AlbaranRepository;
import com.proin.albaran.service.AlbaranService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbaranServiceImpl implements AlbaranService{
	
	private final AlbaranRepository albaranRepository;

	private final ModelMapper modelMapper;
	
	@Override
	public AlbaranDto obtenerAlbaran(String numeroAlbaran, String centro, String codigoPlanta, String serie) {
		return modelMapper.map(albaranRepository.findById(new AlbaranEntityPK(numeroAlbaran, centro, codigoPlanta, serie)),AlbaranDto.class);
	}
	
	@Override
	public List<AlbaranDto> obtener10Albaranes() {
		Page<AlbaranEntity> albaranesEntity = albaranRepository.findAll(PageRequest.of(0, 10));
		return albaranesEntity	.stream().map(entity -> modelMapper.map(entity, AlbaranDto.class)).collect(Collectors.toList());
	}

}