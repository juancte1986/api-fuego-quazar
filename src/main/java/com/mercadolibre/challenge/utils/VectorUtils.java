package com.mercadolibre.challenge.utils;

import static java.lang.Math.*;

import com.mercadolibre.challenge.domains.Point;

/**
 * Clase que se encarga de realizar las operaciones con vectores
 *
 */
public final class VectorUtils {

	/**
	 * @param Double a
	 * @return pow(a, 2)
	 */
	public static Double sqr(Double a) {
		return pow(a, 2);
	}

	/**
	 * @param a
	 * @return Double
	 */
	public static Double norm(Point a) {
		return sqrt(sqr(a.getX()) + sqr(a.getY()));
	}
	
	
	/**
	 * @param a
	 * @return Redondea un punto a 3 decimales
	 */
	public static Point roundOut(Point a) {
		Double x = round(a.getX() * 1000.0) / 1000.0;
		Double y = round(a.getY() * 1000.0) / 1000.0;
		return Point.builder().x(x).y(y).build();
	}

	/**
	 * @param a
	 * @param b
	 * @return Double
	 */
	public static Double dot(Point a, Point b) {
		return a.getX() * b.getX() + a.getY() * b.getY();
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public static Point vectorSubtract(Point a, Point b) {
		Double x = a.getX() - b.getX();
		Double y = a.getY() - b.getY();
		return Point.builder().x(x).y(y).build();

	}

	/**
	 * @param a
	 * @param b
	 * @return Point
	 */
	public static Point vectorAdd(Point a, Point b) {
		Double x = a.getX() + b.getX();
		Double y = a.getY() + b.getY();
		return Point.builder().x(x).y(y).build();

	}

	/**
	 * @param a
	 * @param b
	 * @return Point
	 */
	public static Point vectorDivide(Point a, double b) {
		Double x = a.getX() / b;
		Double y = a.getY() / b;
		return Point.builder().x(x).y(y).build();

	}

	/**
	 * @param a
	 * @param b
	 * @return Point
	 */
	public static Point vectorMultiply(Point a, double b) {
		Double x = a.getX() * b;
		Double y = a.getY() * b;
		return Point.builder().x(x).y(y).build();
	}

	private VectorUtils() {}
}