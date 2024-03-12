package com.proin.albaran.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public List<AlbaranDto> obtenerAlbaranesByUsuarioAutenticado() {
		ReactiveSecurityContextHolder.getContext().map(SecurityContext::getAuthentication)
		.subscribe(authentication -> {
			// Aquí puedes usar el objeto de autenticación
			System.out.println(authentication.getName());
		});
		List<AlbaranEntity> albaranesEntity = albaranRepository.findAllByCifTransportistaOrderByFechaAlbaranDesc("B14952631");
		return albaranesEntity.stream().map(entity -> modelMapper.map(entity, AlbaranDto.class)).collect(Collectors.toList());
	}

}