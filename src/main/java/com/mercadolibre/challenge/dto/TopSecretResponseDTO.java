package com.mercadolibre.challenge.dto;

import com.mercadolibre.challenge.domains.Point;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopSecretResponseDTO {
	
	private Point position;
	
	private String message;

	@Override
	public String toString() {
		return "ResponseSecretDTO [point=" + position + ", message=" + message + "]";
	} 
}
