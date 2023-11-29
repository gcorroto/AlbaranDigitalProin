package com.proin.albaran.controller.rest;


import com.proin.albaran.dto.InputLogDto;
import com.proin.albaran.service.log.LogFrontendService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/log")
public class LogFrontendRestController  {

	private final LogFrontendService logFrontendService;

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

}