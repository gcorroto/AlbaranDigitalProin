package com.proin.albaran.controller.rest;


import java.util.List;
import java.util.Optional;

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
import com.proin.albaran.entity.AlbaranEntity;
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

    @GetMapping(value = "/{id}")
	public ResponseEntity<?> getAlbaranById(@PathVariable(value = "id", required=true) String id, @RequestParam(value = "meta", required=false) boolean meta) {

        ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        try {
            log.info("recibimos consulta albaran con id " + id);
			Optional<AlbaranEntity> albaran = albaranService.obtenerAlbaran("3367", "3", "3", "SF");
			if (!albaran.isEmpty()){
				//response = new ResponseEntity<AlbaranDto>(dto, HttpStatus.OK);
			}
        	//response = new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
	}

	// POST GUARDAMOS NUEVO ALBARAN
    @PostMapping("/{id}")
	public ResponseEntity<AlbaranDto> postAlbaranById(@PathVariable("id") Integer id, @RequestBody AlbaranDto dto) {
        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
	}

	// PUT ACTUALIZAMOS ALBARAN ?¿
    @PutMapping("/{id}")
	public ResponseEntity<AlbaranDto> putAlbaranById(@PathVariable("id") Integer id, @RequestBody AlbaranDto dto) {
        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
	}

}