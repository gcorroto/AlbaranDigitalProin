package com.proin.albaran.controller.rest;


import com.proin.albaran.aop.ResponseMetadataBody;
import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.entity.AlbaranEntity;
import com.proin.albaran.service.AlbaranService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/albaran")
public class AlbaranRestController {

	private List<String> catalogoUnidades = List.of();
	private final ModelMapper modelMapper;
	private final AlbaranService albaranService;

	@GetMapping()
	public ResponseEntity<?> getAlbaranesUsuario(@RequestParam(value = "meta", required=false) boolean meta) {

		Optional<AlbaranEntity> albaran2 = albaranService.obtenerAlbaranByIdJoinCons("1", "2", "HNESVASCOS001", "1");
		Optional<AlbaranEntity> albaran1 = albaranService.obtenerAlbaranByIdJoinConsJoinDescHorJoinEvMetJoinLiA("1", "2", "HNESVASCOS001", "1");


		return new ResponseEntity<>(HttpStatus.OK);
	}

	// GET CONSULTA ALBARAN CREADO ?¿
    @GetMapping(value = "/{id}")
	@ResponseMetadataBody
	public ResponseEntity<?> getAlbaranById(@PathVariable(value = "id", required=true) String id, @RequestParam(value = "meta", required=false) boolean meta) {

        ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);


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

}