package com.mercadolibre.challenge.utils;

import java.util.Map;

import com.mercadolibre.challenge.domains.Point;

import static com.mercadolibre.challenge.constants.SatelliteConstants.*;

public final class SatelliteUtils {

	private static final Double KENOBI_POSITION_X = -500.0;

	private static final Double KENOBI_POSITION_Y = -200.0;

	private static final Double SKYWALKER_POSITION_X = 100.0;

	private static final Double SKYWALKER_POSITION_Y = -100.0;

	private static final Double SATO_POSITION_X = 500.0;

	private static final Double SATO_POSITION_Y = 100.0;

	public static Map<String, Point> satelliteConfig = Map.of(
			SATELLITE_KENOBI,Point.builder().x(KENOBI_POSITION_X).y(KENOBI_POSITION_Y).build(),
			SATELLITE_SKYWALKER, Point.builder().x(SKYWALKER_POSITION_X).y(SKYWALKER_POSITION_Y).build(),
			SATELLITE_SATO, Point.builder().x(SATO_POSITION_X).y(SATO_POSITION_Y).build());

	public static Map<String, Integer> satelliteOrder = Map.of(
			SATELLITE_KENOBI, 0, 
			SATELLITE_SKYWALKER, 1, 
			SATELLITE_SATO,2);

	private SatelliteUtils() { }
}