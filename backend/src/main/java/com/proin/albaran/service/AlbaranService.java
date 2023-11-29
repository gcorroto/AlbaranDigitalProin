package com.proin.albaran.service;

import com.proin.albaran.entity.AlbaranEntity;

import java.util.List;
import java.util.Optional;

public interface AlbaranService {

	Optional<AlbaranEntity> obtenerAlbaranByIdJoinCons(String numeroAlbaran, String centro, String codigoPlanta, String serie);

	Optional<AlbaranEntity> obtenerAlbaranByIdJoinConsJoinDescHorJoinEvMetJoinLiA(String numeroAlbaran, String centro, String codigoPlanta, String serie);
}