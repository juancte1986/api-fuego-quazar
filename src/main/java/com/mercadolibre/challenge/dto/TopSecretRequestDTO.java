package com.mercadolibre.challenge.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopSecretRequestDTO {
	
	@NotNull
	@Size(min=3, max=3)
	private List<SatelliteDTO> satellites;
	
	@Override
	public String toString() {
		return "RequestSecretDTO [satellites=" + satellites + "]";
	}
}
