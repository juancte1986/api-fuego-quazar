package com.mercadolibre.challenge.utils;

import static com.mercadolibre.challenge.utils.VectorUtils.*;

import com.mercadolibre.challenge.domains.Point;

/**
 * Clase que se encarga de resolver la trilateracion 2D
 * Bibliografia :
 * https://en.wikipedia.org/wiki/True-range_multilateration
 * https://stackoverflow.com/questions/9747227/2d-trilateration
 *
 */
public final class Trilateraton2DUtils {
	
	
	/**
	 * @param pointA
	 * @param pointB
	 * @param pointC
	 * @param distances
	 * @return Point
	 */
	public static Point getLocation(Point pointA, Point pointB, Point pointC, Double... distances) {
		Point ex = vectorDivide(vectorSubtract(pointB, pointA), norm(vectorSubtract(pointB, pointA)));
		Double i = dot(ex, vectorSubtract(pointC, pointA));
		Point a = vectorSubtract(vectorSubtract(pointC, pointA), vectorMultiply(ex, i));
		Point ey = vectorDivide(a, norm(a));
		Double d = norm(vectorSubtract(pointB, pointA));
		Double j = dot(ey, vectorSubtract(pointC, pointA));
		Double x = (sqr(distances[0]) - sqr(distances[1]) + sqr(d)) / (2 * d);
		Double y = (sqr(distances[0]) - sqr(distances[2]) + sqr(i) + sqr(j)) / (2 * j) - (i / j) * x;
		Point result =  vectorAdd(pointA, vectorAdd(vectorMultiply(ex, x), vectorMultiply(ey, y)));
		
		return roundOut(result);
	}
	
	private Trilateraton2DUtils() { }
}