package com.proin.albaran.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proin.albaran.entity.AlbaranEntity;
import com.proin.albaran.repository.AlbaranRepository;
import com.proin.albaran.repository.CustomAlbaranRepository;
import com.proin.albaran.service.AlbaranService;
import com.proin.conex.modelos.transporte.TAlbaran;
import com.proin.conex.modelos.transporte.TAlbaranId;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbaranServiceImpl implements AlbaranService{
	
	private final CustomAlbaranRepository albaranRepository;
	private final AlbaranRepository albaranRepositoryEntities;
	
	@Override
	public TAlbaran obtenerAlbaran(String numeroAlbaran, String centro, String codigoPlanta, String serie) {
		return albaranRepository.obtenerAlbaranPorId(new TAlbaranId(numeroAlbaran, centro, codigoPlanta, serie));
	}
	
	@Override
	public List<AlbaranEntity> obtenerConEntities(){
		return albaranRepositoryEntities.findAll();
	}
	
	
	public static void main (String args[]) {
		System.out.println("HHola mundo raul");
	}
	
}