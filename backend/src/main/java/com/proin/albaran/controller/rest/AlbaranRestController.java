package com.proin.albaran.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proin.albaran.controller.BaseController;
import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.dto.CamionDto;
import com.proin.albaran.dto.ClienteDto;
import com.proin.albaran.dto.DesgloseContenidoDto;
import com.proin.albaran.dto.HormigonDto;
import com.proin.albaran.dto.MeteorologiaDto;
import com.proin.albaran.dto.RemolqueDto;
import com.proin.albaran.dto.TransporteDto;
import com.proin.albaran.service.MockAlbaranService;
import com.proin.albaran.util.EasyRandomUtils;
import com.proin.conex.modelos.transporte.TAlbaran;
import com.proin.conex.modelos.transporte.TMedida;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/albaran")
@CrossOrigin(value = {"http://localhost:4200","http://localhost:8080"})
public class AlbaranRestController implements BaseController<TAlbaran,AlbaranDto> {

	private List<String> catalogoUnidades = TMedida.mapaUnidades.keySet().stream().collect(Collectors.toList());
	private final ModelMapper modelMapper;
	private final MockAlbaranService mockService;

	@PostConstruct
	public void init() {
        configMappingDto(); 
    }

	/// REST CONTROLLERS

	// GET BASE ALBARAN
	@GetMapping()
	public ResponseEntity<AlbaranDto> getAlbaran() {

        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        try {
            TAlbaran entity = mockService.obtenerAlbaran();
            AlbaranDto dto = mockService.rellenarCamposAlbaran(convertToDto(entity));
        if (dto == null) {
            response = new ResponseEntity<AlbaranDto>(HttpStatus.NO_CONTENT);
        }
        response = new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
			log.error("Error al general el primer albaran", e);
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
	}

	// GET CONSULTA ALBARAN CREADO ?¿
    @GetMapping("/{id}")
	public ResponseEntity<AlbaranDto> getAlbaranById(@PathVariable("id") String id) {

        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        try {
            log.info("recibimos consulta albaran con id " + id);
            TAlbaran entity = mockService.obtenerAlbaran();
            AlbaranDto dto = mockService.rellenarCamposAlbaran(convertToDto(entity));
            dto.setNumAlbaran(id);
        	response = new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
	}

	// POST GUARDAMOS NUEVO ALBARAN
    @PostMapping("/{id}")
	public ResponseEntity<AlbaranDto> postAlbaranById(@PathVariable("id") Integer id, @RequestBody AlbaranDto dto) {

		// QUE HACEMOS?¿
        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        log.info("recibimos alta albaran con NumAlbaran " + dto.getNumAlbaran());

        return response;
	}

	// PUT ACTUALIZAMOS ALBARAN ?¿
    @PutMapping("/{id}")
	public ResponseEntity<AlbaranDto> putAlbaranById(@PathVariable("id") Integer id, @RequestBody AlbaranDto dto) {
		
		// QUE HACEMOS?¿
        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        log.info("recibimos modificación albaran con NumAlbaran " + dto.getNumAlbaran());

        return response;
	}




	/// MAPPINGS DTOS

	@Override
	public AlbaranDto convertToDto(TAlbaran entity) {
		AlbaranDto dto = EASY_RANDOM.nextObject(AlbaranDto.class);
		dto =  modelMapper.map(entity, AlbaranDto.class);
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
			c.setCantidad(String.valueOf(
				EASY_RANDOM.nextObject(Integer.class) + 
				" "+ 
				(ArrayUtils.isEmpty(catalogoUnidades.toArray(new String[0])) ? "" :EasyRandomUtils.catalogoRandomGenerator(catalogoUnidades).getRandomValue())
			));
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