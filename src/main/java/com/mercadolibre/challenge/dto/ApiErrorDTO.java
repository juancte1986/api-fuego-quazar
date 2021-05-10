package com.mercadolibre.challenge.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiErrorDTO {
	
	private String error;
	
	private String message;
	
	private String timestamp;
	
	private String path;
	
	private int status;
	
	private String exception;
}
