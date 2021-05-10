package com.mercadolibre.challenge.services;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.mercadolibre.challenge.domains.Point;
import com.mercadolibre.challenge.dto.SatelliteDTO;
import com.mercadolibre.challenge.dto.SatelliteSplitDTO;
import com.mercadolibre.challenge.dto.TopSecretRequestDTO;
import com.mercadolibre.challenge.dto.TopSecretResponseDTO;
import com.mercadolibre.challenge.exceptions.InformationErrorException;
import com.mercadolibre.challenge.utils.MessageProcessorUtils;
import com.mercadolibre.challenge.utils.Trilateraton2DUtils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import static com.mercadolibre.challenge.constants.SatelliteConstants.*;
import static com.mercadolibre.challenge.utils.SatelliteUtils.*;


@Slf4j
@Service
public class TopSecretService {
	
	private static final String USER_ANONYMOUS = "anonymous";
	
	private static final String CACHE_TOP_SECRET = "top-secret-cache";
			
	@Resource
	private CacheManager cacheManager;;

	public TopSecretResponseDTO getTopSecret(TopSecretRequestDTO request) {
		log.debug("Ingresando al metodo  TopSecretService.getTopSecret {}", request);
		return buildTopSecret(request);
	}

	public void saveTopSecretSplit(String satelliteName, SatelliteSplitDTO request, String username) {
		log.debug("Ingresando al metodo  TopSecretService.saveTopSecretSplit {}", request);
		username = getUsername(username);
		TopSecretRequestDTO topSecret = getTopSecretRequestFromCache(username);
		SatelliteDTO satelliteNew = SatelliteDTO.builder()
				.name(satelliteName)
				.distance(request.getDistance())
				.message(request.getMessage())
				.build();
		if(topSecret == null) {
			topSecret = TopSecretRequestDTO.builder()
					.build();
		}
		if(topSecret.getSatellites() == null) {
			topSecret.setSatellites(new ArrayList<>());
		} else {
			topSecret.getSatellites().remove(satelliteNew);
		}
		topSecret.getSatellites().add(satelliteNew);
		getTopSecretCache().put(username, topSecret);
	}

	public TopSecretResponseDTO getTopSecretSplit(String username) {
		log.debug("Ingresando al metodo  TopSecretService.getTopSecretSplit {}", username);
		username = getUsername(username);
		TopSecretRequestDTO request = getTopSecretRequestFromCache(username);
		if(request == null || request.getSatellites().size() != 3) {
			throw new InformationErrorException("No hay suficiente informacion.");
		}
		return buildTopSecret(request);
	}
	
	
	private Cache getTopSecretCache() {
		Cache cache = cacheManager.getCache(CACHE_TOP_SECRET);
		return cache;
	}
	
	private TopSecretRequestDTO getTopSecretRequestFromCache(String key) {
		Cache cache = getTopSecretCache();
		TopSecretRequestDTO topSecret = cache.get(key, TopSecretRequestDTO.class);	
		log.debug("Cache key = {} topSecret = {} ", key, topSecret);
		return topSecret;
	}
	
	private String getUsername(String username) {
		return Objects.isNull(username) || (!Objects.isNull(username) && username.isEmpty()) ? USER_ANONYMOUS : username.toLowerCase();
	}
	
	private Point getLocation(Double... distances) {
		Point result = Trilateraton2DUtils.getLocation(
				satelliteConfig.get(SATELLITE_KENOBI),
				satelliteConfig.get(SATELLITE_SKYWALKER), 
				satelliteConfig.get(SATELLITE_SATO),
				distances);
		return result;
	}
	
	private String getMessage(List<String[]> messages) {
		String message = MessageProcessorUtils.processMessage(messages.toArray(new String[messages.size()][0]));
		return message;
	}
	
	private TopSecretResponseDTO buildTopSecret(TopSecretRequestDTO request) {
		final Double[] distances = new Double[NUMBER_SATELLITE];
		final List<String[]> messages = new ArrayList<String[]>();
		int index;
		for (SatelliteDTO satellite : request.getSatellites()) {
			index = satelliteOrder.get(satellite.getName().toLowerCase());
			distances[index] = satellite.getDistance();
			messages.add(satellite.getMessage());
		}
		return TopSecretResponseDTO.builder()
				.position(getLocation(distances))
				.message(getMessage(messages))
				.build();
	}
}
