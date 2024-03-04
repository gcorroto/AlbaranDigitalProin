package com.proin.albaran.controller.rest;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.service.AlbaranService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/albaran")
public class AlbaranRestController {
	
	private final AlbaranService albaranService;

	@GetMapping()
	public ResponseEntity<?> getAlbaranesUsuario(@RequestParam(value = "meta", required=false) boolean meta) {

		List<AlbaranDto> albaranes = albaranService.obtener10Albaranes();
        ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        try {            
			if (!albaranes.isEmpty()) {
				response = new ResponseEntity<List<AlbaranDto>>(albaranes, HttpStatus.OK);
			} 
        } catch (Exception e) {
			log.error("Error al general el listado de albaranes", e);
            response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
	}

    @GetMapping(value = "/{numeroalbaran}")
	public ResponseEntity<?> getAlbaranByNumeroAlbaran(@PathVariable(value = "numeroalbaran", required=true) String numeroalbaran, 
											@RequestParam(value = "centro", required=true) String centro,
											@RequestParam(value = "codigoPlanta", required=true) String codigoPlanta,
											@RequestParam(value = "serie", required=true) String serie) {
		return new ResponseEntity<AlbaranDto>(albaranService.obtenerAlbaran(numeroalbaran, centro, codigoPlanta, serie), HttpStatus.OK);
	}

	// POST GUARDAMOS NUEVO ALBARAN
    @PostMapping("/{numeroalbaran}")
	public ResponseEntity<AlbaranDto> postAlbaranById(@PathVariable("numeroalbaran") Integer numeroalbaran, @RequestBody AlbaranDto dto) {
        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
	}

	// PUT ACTUALIZAMOS ALBARAN ?¿
    @PutMapping("/{numeroalbaran}")
	public ResponseEntity<AlbaranDto> putAlbaranById(@PathVariable("numeroalbaran") Integer numeroalbaran, @RequestBody AlbaranDto dto) {
        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
	}

}