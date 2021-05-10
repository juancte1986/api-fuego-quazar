package com.mercadolibre.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.challenge.dto.SatelliteSplitDTO;
import com.mercadolibre.challenge.dto.TopSecretRequestDTO;
import com.mercadolibre.challenge.dto.TopSecretResponseDTO;
import com.mercadolibre.challenge.services.TopSecretService;

import static org.springframework.http.ResponseEntity.status;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/topsecret")
public class TopSecretController {

	@Autowired
	private TopSecretService service;

	@PostMapping
	public ResponseEntity<TopSecretResponseDTO> geTopSecret(@RequestBody @Validated TopSecretRequestDTO request) {
		return status(OK)
				.body(service.getTopSecret(request));
	}

	@PostMapping("/topsecret_split/{satellite_name}")
	public ResponseEntity<Void> saveTopSecretSplit(@PathVariable(value = "satellite_name") String satelliteName,
			@RequestBody @Validated SatelliteSplitDTO request, @RequestHeader(required = false) String username) {
		service.saveTopSecretSplit(satelliteName, request, username);
		return status(CREATED)
				.build();
	}

	@GetMapping("/topsecret_split")
	public ResponseEntity<TopSecretResponseDTO> geTopSecretSplit(@RequestHeader(required = false) String username) {
		return status(OK)
				.body(service.getTopSecretSplit(username));
	}
}
