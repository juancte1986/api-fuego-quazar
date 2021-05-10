package com.mercadolibre.challenge.units;

import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.challenge.domains.Point;
import com.mercadolibre.challenge.utils.Trilateraton2DUtils;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;


@SpringBootTest	
public class Trilateration2DUtilsTests {
	
	@Test
	public void getLocationExactPositionAtTheIntersectionOfTheCircles() throws Exception {
		Point pointA = Point.builder().x(150.0).y(100.0).build();
		Point pointB = Point.builder().x(270.0).y(300.0).build();
		Point pointC = Point.builder().x(370.0).y(150.0).build();
		Double [] distances = {150.0, 100.0, 120.0}; 
		Point result = Trilateraton2DUtils.getLocation(pointA, pointB, pointC, distances);
		assertThat(result.getX()).isEqualTo(261.25);
		assertThat(result.getY()).isEqualTo(200.5);
	}
	
	@Test
	public void getLocationPositionInTheRegionWhereTheCirclesShareACommonArea() throws Exception {
		Point pointA = Point.builder().x(150.0).y(100.0).build();
		Point pointB = Point.builder().x(270.0).y(300.0).build();
		Point pointC = Point.builder().x(300.0).y(150.0).build();
		Double [] distances = {150.0, 100.0, 120.0}; 
		Point result = Trilateraton2DUtils.getLocation(pointA, pointB, pointC, distances);
		assertThat(result.getX()).isEqualTo(218.229);
		assertThat(result.getY()).isEqualTo(226.313);
	}
	
	@Test
	public void getLocationIntermediatePositionWhereTheSecondAndThirdCirclesIntersectTheFirst() throws Exception {
		Point pointA = Point.builder().x(150.0).y(100.0).build();
		Point pointB = Point.builder().x(270.0).y(300.0).build();
		Point pointC = Point.builder().x(300.0).y(50.0).build();
		Double [] distances = {150.0, 100.0, 120.0}; 
		Point result = Trilateraton2DUtils.getLocation(pointA, pointB, pointC, distances);
		assertThat(result.getX()).isEqualTo(288.403);
		assertThat(result.getY()).isEqualTo(184.208);
	}
	
	@Test
	public void getLocationMiddlePositionBetweenTheCentersOfTheCircles() throws Exception {
		Point pointA = Point.builder().x(150.0).y(100.0).build();
		Point pointB = Point.builder().x(270.0).y(350.0).build();
		Point pointC = Point.builder().x(500.0).y(50.0).build();
		Double [] distances = {150.0, 100.0, 120.0};
		Point result = Trilateraton2DUtils.getLocation(pointA, pointB, pointC, distances);
		assertThat(result.getX()).isEqualTo(351.845);
		assertThat(result.getY()).isEqualTo(181.914);
	}
}
