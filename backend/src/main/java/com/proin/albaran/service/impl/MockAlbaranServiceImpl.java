package com.proin.albaran.service.impl;

import java.util.Date;
import java.util.List;

import org.jeasy.random.EasyRandom;
import org.springframework.stereotype.Service;

import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.service.MockAlbaranService;
import com.proin.albaran.util.EasyRandomUtils;
import com.proin.conex.modelos.transporte.TAlbaran;
import com.proin.conex.modelos.transporte.TConsumo;
import com.proin.conex.modelos.transporte.TIncidenciaAlbaran;
import com.proin.conex.modelos.transporte.TIncidenciaAlbaranId;
import com.proin.conex.modelos.transporte.TLineaAlbaran;
import com.proin.conex.modelos.transporte.TMedida;
import com.proin.conex.modelos.transporte.albaranes.TDescripcionHormigon;


@Service
public class MockAlbaranServiceImpl implements MockAlbaranService {
	
	final EasyRandom EASY_RANDOM = EasyRandomUtils.generateEasyRandom();
    //// testing
	public TAlbaran obtenerAlbaran() {

		TAlbaran albaran = EASY_RANDOM.nextObject(TAlbaran.class);
		albaran.setAlbaranid(1l);
		albaran.setCantidadARecuperar(new TMedida());
		albaran.setConsumos(obtenerConsumos());
		albaran.setDescripcionHormigon(obtenerDescripcionDeHormigon(albaran));
		albaran.setFechaAlbaran(new Date());
		albaran.setIncidencias(obtenerIncidencias());
		albaran.setLineasAlbaran(obtenerLineasAlbaran(albaran));
		albaran.setFechaAlbaran(new Date());
		albaran.setCliente(EasyRandomUtils.nombreCompletoGenerator().getRandomValue());
		albaran.setId(23456789L);
		albaran.setCifTransportista(EasyRandomUtils.cifGenerator().getRandomValue());
		albaran.setMatriculaCamion(EasyRandomUtils.matriculaGenerator().getRandomValue());
		albaran.setMatricularemolque(EasyRandomUtils.matriculaGenerator().getRandomValue());
		albaran.setCodigoEmpresa(1);
		albaran.setCifTransportista(EasyRandomUtils.cifGenerator().getRandomValue());
		albaran.setClienteEsCargadorContractual(true);
		albaran.setNumeroalbaran(EasyRandomUtils.numeroIsbnGenerator().getRandomValue());
		albaran.setFechaAlbaran(new Date());
		albaran.setPlantasChanged(EasyRandomUtils.stringGenerator(5).getRandomValue());
		albaran.setClienteEsCargadorContractual(true);
		albaran.setObra(EasyRandomUtils.stringGenerator(4).getRandomValue());

		return albaran;
	}

	//// testing
	public AlbaranDto rellenarCamposAlbaran(AlbaranDto dto) {

		dto.setM3(EasyRandomUtils.floatGenerator(4).getRandomValue());
		dto.setProgresoDia(EasyRandomUtils.integerGenerator(2).getRandomValue());
		dto.setDireccion(EasyRandomUtils.streetGenerator().getRandomValue());
		dto.setCp(EasyRandomUtils.codigoPostalGenerator().getRandomValue());
		dto.setMunicipio(EasyRandomUtils.countryGenerator().getRandomValue());

		return dto;
	}

	private List<TLineaAlbaran> obtenerLineasAlbaran(TAlbaran albaran) {
		TLineaAlbaran a = new TLineaAlbaran();
		a.setAlbaran(albaran);
		a.setCantidadRestantePedido(new TMedida());
		a.setLineaalbaranid(1);
		return List.of(a);
	}

	private List<TIncidenciaAlbaran> obtenerIncidencias() {
		TIncidenciaAlbaran a = new TIncidenciaAlbaran();
		a.setCantidadARecuperar(new TMedida());
		TIncidenciaAlbaranId id = new TIncidenciaAlbaranId();
		id.setCentro("centro");
		id.setCodigoExterno("codigoexterno");
		id.setCodigoExternoAlbaran("codigoexternoalbaran");
		id.setCodigoPlanta("codigoplanta");
		id.setSerieAlbaran("seriealbaran");
		return List.of(a);
	}

	private TDescripcionHormigon obtenerDescripcionDeHormigon(TAlbaran albaran) {
		TDescripcionHormigon a = new TDescripcionHormigon();
		a.setAlbaran(albaran);
		return a;
	}

	private List<TConsumo> obtenerConsumos() {
		TConsumo c = new TConsumo();
		c.setId(1);
		return List.of(c);
	}
}