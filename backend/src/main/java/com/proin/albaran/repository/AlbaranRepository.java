package com.proin.albaran.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proin.albaran.entity.AlbaranEntity;
import com.proin.albaran.entity.AlbaranEntityPK;
import com.proin.conex.modelos.transporte.TEvaluacionMeteorologica;

@Repository
public interface AlbaranRepository extends JpaRepository<AlbaranEntity, AlbaranEntityPK>{
	
	Optional<AlbaranEntity> findById(AlbaranEntityPK id);

	Page<AlbaranEntity> findAll(Pageable pageable);
}
