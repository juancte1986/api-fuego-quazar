package com.mercadolibre.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PointDTO {
	
	private Double x;
	
	private Double y;

	@Override
	public String toString() {
		return "PointDTO [x=" + x + ", y=" + y + "]";
	}
}
