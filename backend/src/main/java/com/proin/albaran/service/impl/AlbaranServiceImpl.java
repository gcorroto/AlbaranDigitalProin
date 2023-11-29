package com.proin.albaran.service.impl;

import com.proin.albaran.entity.AlbaranEntity;
import com.proin.albaran.entity.AlbaranEntityPK;
import com.proin.albaran.repository.AlbaranRepository;
import com.proin.albaran.service.AlbaranService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlbaranServiceImpl implements AlbaranService{

	private final AlbaranRepository albaranRepository;

	@Override
	public Optional<AlbaranEntity> obtenerAlbaranByIdJoinCons(String numeroAlbaran, String centro, String codigoPlanta, String serie){
		return albaranRepository.findById(new AlbaranEntityPK(numeroAlbaran, centro, codigoPlanta, serie));
	}

	@Override
	public Optional<AlbaranEntity> obtenerAlbaranByIdJoinConsJoinDescHorJoinEvMetJoinLiA(String numeroAlbaran, String centro, String codigoPlanta, String serie) {
		return albaranRepository.findByIdJoinConsJoinDescHorJoinEvMetJoinLinA(numeroAlbaran, centro, codigoPlanta, serie);
	}
}