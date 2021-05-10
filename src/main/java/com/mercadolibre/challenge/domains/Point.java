package com.mercadolibre.challenge.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Point {

	private Double x;
	
	private Double y;

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
