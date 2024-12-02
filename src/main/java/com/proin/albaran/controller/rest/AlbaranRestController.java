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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.reactive.function.client.WebClientResponseException.BadRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException.NotFound;

import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.service.AlbaranService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/albaran")
public class AlbaranRestController {
	
	private final AlbaranService albaranService;


	@Operation(summary = "Obtiene Albaranes por Usuario.", description = "Obtiene los albaranes por usuario autenticado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Creado", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AlbaranDto.class)))),
            @ApiResponse(responseCode = "400", description = "Error de validacion", content = @Content(schema = @Schema(implementation = BadRequest.class))),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(schema = @Schema(implementation = NotFound.class))),
            @ApiResponse(responseCode = "500", description = "Error de servidor",content = @Content(schema = @Schema(implementation = InternalServerError.class)))
    })
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
	@GetMapping()
	public ResponseEntity<?> getAlbaranesUsuario(@RequestParam(value = "meta", required=false) boolean meta) {

		List<AlbaranDto> albaranes = albaranService.obtenerAlbaranesByUsuarioAutenticado();
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

	@Operation(summary = "Obtener un albarán por número de albarán.", description = "Obtener un albarán por número de albarán")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Creado", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AlbaranDto.class)))),
            @ApiResponse(responseCode = "400", description = "Error de validacion", content = @Content(schema = @Schema(implementation = BadRequest.class))),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(schema = @Schema(implementation = NotFound.class))),
            @ApiResponse(responseCode = "500", description = "Error de servidor",content = @Content(schema = @Schema(implementation = InternalServerError.class)))
    })
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @GetMapping(value = "/{numeroalbaran}")
	public ResponseEntity<?> getAlbaranByNumeroAlbaran(@PathVariable(value = "numeroalbaran", required=true) String numeroalbaran, 
											@RequestParam(value = "centro", required=true) String centro,
											@RequestParam(value = "codigoPlanta", required=true) String codigoPlanta,
											@RequestParam(value = "serie", required=true) String serie) {
		return new ResponseEntity<AlbaranDto>(albaranService.obtenerAlbaran(numeroalbaran, centro, codigoPlanta, serie), HttpStatus.OK);
	}

	// POST GUARDAMOS NUEVO ALBARAN
	@Operation(summary = "Creación de albarán.", description = "Creación de albarán")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Creado", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AlbaranDto.class)))),
            @ApiResponse(responseCode = "400", description = "Error de validacion", content = @Content(schema = @Schema(implementation = BadRequest.class))),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(schema = @Schema(implementation = NotFound.class))),
            @ApiResponse(responseCode = "500", description = "Error de servidor",content = @Content(schema = @Schema(implementation = InternalServerError.class)))
    })
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    @PostMapping("/{numeroalbaran}")
	public ResponseEntity<AlbaranDto> postAlbaranById(@PathVariable("numeroalbaran") Integer numeroalbaran, @RequestBody AlbaranDto dto) {
        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
	}

	// PUT ACTUALIZAMOS ALBARAN
	@Operation(summary = "Actualización de albarán.", description = "Actualización de albarán")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Creado", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AlbaranDto.class)))),
            @ApiResponse(responseCode = "400", description = "Error de validacion", content = @Content(schema = @Schema(implementation = BadRequest.class))),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(schema = @Schema(implementation = NotFound.class))),
            @ApiResponse(responseCode = "500", description = "Error de servidor",content = @Content(schema = @Schema(implementation = InternalServerError.class)))
    })
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @PutMapping("/{numeroalbaran}")
	public ResponseEntity<AlbaranDto> putAlbaranById(@PathVariable("numeroalbaran") Integer numeroalbaran, @RequestBody AlbaranDto dto) {
        ResponseEntity<AlbaranDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
	}

}