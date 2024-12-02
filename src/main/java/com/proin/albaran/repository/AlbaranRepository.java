package com.proin.albaran.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proin.albaran.entity.AlbaranEntity;
import com.proin.albaran.entity.AlbaranEntityPK;

@Repository
public interface AlbaranRepository extends JpaRepository<AlbaranEntity, AlbaranEntityPK>{
	
	Optional<AlbaranEntity> findById(AlbaranEntityPK id);

	List<AlbaranEntity> findAllByCifTransportistaOrderByFechaAlbaranDesc(String usuarioAutenticado);
}
