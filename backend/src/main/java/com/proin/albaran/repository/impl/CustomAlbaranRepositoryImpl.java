// package com.proin.albaran.repository.impl;

// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;

// import org.springframework.stereotype.Repository;

// import com.proin.albaran.repository.CustomAlbaranRepository;
// import com.proin.conex.modelos.transporte.TAlbaran;
// import com.proin.conex.modelos.transporte.TAlbaranId;

// @Repository
// public class CustomAlbaranRepositoryImpl implements CustomAlbaranRepository {

// 	@PersistenceContext
//     private EntityManager entityManager;
	
// 	@Override
// 	public TAlbaran obtenerAlbaranPorId(TAlbaranId id) {
// 		return entityManager.find(TAlbaran.class, id);
// 	}
	
// }
