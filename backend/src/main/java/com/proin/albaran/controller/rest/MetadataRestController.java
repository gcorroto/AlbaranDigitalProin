package com.proin.albaran.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proin.albaran.constantes.MetadataAlbaranEnum;
import com.proin.albaran.controller.BaseController;
import com.proin.albaran.dto.InputMetadataDto;
import com.proin.albaran.dto.OutputMetadataDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/metadata")
public class MetadataRestController implements BaseController<OutputMetadataDto,InputMetadataDto> {

	@PostConstruct
	public void init() {
        configMappingDto(); 
    }


	// POST logs front
    @PostMapping()
	public ResponseEntity<List<OutputMetadataDto>> getFormMetadata(@RequestBody InputMetadataDto dto) {

		// QUE HACEMOS?¿
		List<OutputMetadataDto> response =  this.switchEntity(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
	}


	private List<OutputMetadataDto> switchEntity(InputMetadataDto dto) {
		List<OutputMetadataDto> metadata = new ArrayList<>();
		switch (dto.getEntidad()) {
			case "albaran":
				metadata = mapMetadata(dto.getPropiedades());
				break;
			default:
				break;
		}

		return metadata;
	}


	private List<OutputMetadataDto> mapMetadata(List<String> properties) {
		return properties.stream()
		.map(p -> new OutputMetadataDto(MetadataAlbaranEnum.findByName(p)))
		.collect(Collectors.toList());
	}


	/// MAPPINGS DTOS

	@Override
	public InputMetadataDto convertToDto(OutputMetadataDto entity) {
		return new InputMetadataDto();
	}

	@Override
	public OutputMetadataDto convertToEntity(InputMetadataDto dto) {
		return new OutputMetadataDto();
	}

	@Override
	public void configMappingDto() {
	}
}