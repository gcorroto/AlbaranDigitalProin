package com.proin.albaran.repository;

import com.proin.conex.modelos.transporte.TAlbaran;
import com.proin.conex.modelos.transporte.TAlbaranId;

public interface CustomAlbaranRepository {
	
	TAlbaran obtenerAlbaranPorId(TAlbaranId id);
	
}
