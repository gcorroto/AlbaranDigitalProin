package com.proin.albaran.controller.rest;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proin.albaran.controller.BaseController;
import com.proin.albaran.dto.InputLogDto;
import com.proin.albaran.service.LogFrontendService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/log")
@CrossOrigin(value = {"http://localhost:4200","http://localhost:8080"})
public class LogFrontendRestController implements BaseController<InputLogDto,InputLogDto> {

	private final LogFrontendService logFrontendService;

	@PostConstruct
	public void init() {
        configMappingDto(); 
    }


	// POST logs front
    @PostMapping("/send")
	public ResponseEntity<InputLogDto> logFront(@RequestBody InputLogDto dto) {

		// QUE HACEMOS?¿
		this.switchLog(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
	}


	private void switchLog(InputLogDto dto) {
		switch (dto.getLevel()) {
			case "log":
				logFrontendService.trace(dto.getMessage());
				break;
			case "debug":
				logFrontendService.debug(dto.getMessage());
				break;
			case "info":
				logFrontendService.info(dto.getMessage());
				break;
			case "warn":
				logFrontendService.warn(dto.getMessage());
				break;
			case "error":
				logFrontendService.error(dto.getMessage());
				break;
			default:
				break;
		}
	}


	/// MAPPINGS DTOS

	@Override
	public InputLogDto convertToDto(InputLogDto entity) {
		return entity;
	}

	@Override
	public InputLogDto convertToEntity(InputLogDto dto) {
		return dto;
	}

	@Override
	public void configMappingDto() {
	}
}