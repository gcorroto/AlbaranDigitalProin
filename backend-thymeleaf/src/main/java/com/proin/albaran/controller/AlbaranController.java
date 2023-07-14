package com.proin.albaran.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.dto.CamionDto;
import com.proin.albaran.dto.ClienteDto;
import com.proin.albaran.dto.DesgloseContenidoDto;
import com.proin.albaran.dto.HormigonDto;
import com.proin.albaran.dto.MeteorologiaDto;
import com.proin.albaran.dto.RemolqueDto;
import com.proin.albaran.dto.TransporteDto;
import com.proin.albaran.util.EasyRandomUtils;
import com.proin.conex.modelos.transporte.TAlbaran;
import com.proin.conex.modelos.transporte.TConsumo;
import com.proin.conex.modelos.transporte.TIncidenciaAlbaran;
import com.proin.conex.modelos.transporte.TIncidenciaAlbaranId;
import com.proin.conex.modelos.transporte.TLineaAlbaran;
import com.proin.conex.modelos.transporte.TMedida;
import com.proin.conex.modelos.transporte.albaranes.TDescripcionHormigon;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AlbaranController implements BaseController<TAlbaran,AlbaranDto> {
	// private final AlbaranService albaranService;

	private final List<String> catalogoUnidades = TMedida.mapaUnidades.keySet().stream().collect(Collectors.toList());
	
	private final ModelMapper modelMapper;
	@GetMapping("/")
	public String inicio(Model model) {
		TAlbaran entity = obtenerAlbaran();
		AlbaranDto dto = convertToDto(entity);
		model.addAttribute("albaran", dto);
		return "albaran";
	}

	@PostConstruct
	public void init() {
        configMappingDto(); 
    }
	
	private TAlbaran obtenerAlbaran() {

		TAlbaran albaran = EASY_RANDOM.nextObject(TAlbaran.class);
		albaran.setAlbaranid(1l);
		albaran.setCantidadARecuperar(new TMedida());
		albaran.setConsumos(obtenerConsumos());
		albaran.setDescripcionHormigon(obtenerDescripcionDeHormigon(albaran));
		albaran.setFechaAlbaran(new Date());
		albaran.setIncidencias(obtenerIncidencias());
		albaran.setLineasAlbaran(obtenerLineasAlbaran(albaran));

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

	@PostMapping("/submit")
	public String submit(Model model) {
		return "index";
	}

	@Override
	public AlbaranDto convertToDto(TAlbaran entity) {
		AlbaranDto dto =  modelMapper.map(entity, AlbaranDto.class);
		dto.setCliente(modelMapper.map(entity, ClienteDto.class));
		dto.setTransporte(modelMapper.map(entity, TransporteDto.class));
		dto.getTransporte().setCamion(modelMapper.map(entity, CamionDto.class));
		dto.getTransporte().setRemolque(modelMapper.map(entity, RemolqueDto.class));
		dto.setMeteorologia(modelMapper.map(entity, MeteorologiaDto.class));
		dto.setHormigon(modelMapper.map(entity, HormigonDto.class));
		dto.setHormigon(EASY_RANDOM.nextObject(HormigonDto.class));
		dto.getHormigon().getContenido().setCementos(mapContenidoHormigon(dto.getHormigon().getContenido().getCementos()));
		dto.getHormigon().getContenido().setAditivos(mapContenidoHormigon(dto.getHormigon().getContenido().getAditivos()));
		dto.getHormigon().getContenido().setAdiciones(mapContenidoHormigon(dto.getHormigon().getContenido().getAdiciones()));
		return dto;
	}

	private List<DesgloseContenidoDto> mapContenidoHormigon(List<DesgloseContenidoDto> degloses){
		return degloses.stream().map(c-> {
			c.setFabricante(EasyRandomUtils.companiaGenerator().getRandomValue());
			c.setModelo(EasyRandomUtils.modeloHormigonGenerator().getRandomValue());
			c.setCantidad(String.valueOf(EASY_RANDOM.nextObject(Integer.class) + " "+ EasyRandomUtils.catalogoRandomGenerator(catalogoUnidades).getRandomValue()));
			return c;
		}).collect(Collectors.toList());
	}

	@Override
	public TAlbaran convertToEntity(AlbaranDto dto) {
		return modelMapper.map(dto, TAlbaran.class);
	}

	@Override
	public void configMappingDto() {

		TypeMap<TAlbaran, ClienteDto> propertyMapperCliente = modelMapper.createTypeMap(TAlbaran.class, ClienteDto.class);
		propertyMapperCliente.addMappings(mapper -> {
			mapper.map(TAlbaran::getCliente, ClienteDto::setNombre);
			mapper.map(TAlbaran::getId, ClienteDto::setId);
			mapper.map(TAlbaran::getCifTransportista, ClienteDto::setCif);
		});

		TypeMap<TAlbaran, CamionDto> propertyMapperCamion = modelMapper.createTypeMap(TAlbaran.class, CamionDto.class);
		propertyMapperCamion.addMappings(mapper -> {
			mapper.map(TAlbaran::getMatriculaCamion, CamionDto::setMatricula);
		});
		
		TypeMap<TAlbaran, RemolqueDto> propertyMapperRemolque = modelMapper.createTypeMap(TAlbaran.class, RemolqueDto.class);
		propertyMapperRemolque.addMappings(mapper -> {
			mapper.map(TAlbaran::getMatricularemolque, RemolqueDto::setMatricula);
		});

		TypeMap<TAlbaran, TransporteDto> propertyMapper = modelMapper.createTypeMap(TAlbaran.class, TransporteDto.class);
		propertyMapper.addMappings(mapper -> {
			mapper.map(TAlbaran::getCodigoEmpresa, TransporteDto::setEmpresa);
			mapper.map(TAlbaran::getCifTransportista, TransporteDto::setCif);
			mapper.map(src -> src.getClienteEsCargadorContractual()?" no se que va aquí":" tampoco aquí", TransporteDto::setCargadorContractual);
			// mapper.map(src -> propertyMapperCamion, TransporteDto::setCamion);
			// mapper.map(src -> propertyMapperRemolque, TransporteDto::setRemolque);
		});

		//revisar esto es un listado
		// modelMapper.createTypeMap(TAlbaran.class, MeteorologiaDto.class).addMappings(mapper -> {
		// 	mapper.map(src -> src.getConsumos().stream().filter(c -> c.getHumedad().getValor()).findFirst().get(), MeteorologiaDto::setTemperatura);
		// });


		TypeMap<TAlbaran, AlbaranDto> typeMapAlbaran = modelMapper.createTypeMap(TAlbaran.class, AlbaranDto.class);
		typeMapAlbaran.addMappings(mapper -> {
			mapper.map(TAlbaran::getNumeroalbaran, AlbaranDto::setNumAlbaran);
			mapper.map(TAlbaran::getFechaAlbaran, AlbaranDto::setFechaEntrega);
			// mapper.map(TAlbaran::get, AlbaranDto::setRadial); @Hugo  radial que es
			// mapper.map(TAlbaran::get, AlbaranDto::setM3);
			// mapper.map(TAlbaran::get, AlbaranDto::setProgresoDia);
			mapper.map(TAlbaran::getPlantasChanged, AlbaranDto::setPlanta);
			mapper.map(src ->src.getClienteEsCargadorContractual()?1:0, AlbaranDto::setViaCarga);
			// mapper.map(src -> modelMapper.map(src, ClienteDto.class), AlbaranDto::setCliente);
			mapper.map(TAlbaran::getObra, AlbaranDto::setObra);
			// mapper.map(TAlbaran::get, AlbaranDto::setDireccion);
			// mapper.map(TAlbaran::get, AlbaranDto::setCp);
			// mapper.map(TAlbaran::get, AlbaranDto::setMunicipio);
			// mapper.map(src -> modelMapper.map(src, TransporteDto.class), AlbaranDto::setTransporte);
			mapper.map(src -> new MeteorologiaDto(), AlbaranDto::setMeteorologia);
		});
	}
}