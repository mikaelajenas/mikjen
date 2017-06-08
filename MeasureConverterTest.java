package se.iths;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeasureConverterTest {

	
	@Test
	public void canConvertWeight() {
		MeasureConverter converter = new MeasureConverter();
		int toMetricResult = converter.convertWeight(6, true);
		
		assertEquals(toMetricResult, 2);
				
	}
	
	@Test
	public void canConverToPoundWeigth() {
		MeasureConverter converter = new MeasureConverter();
		int toPoundResult = converter.convertWeight(5, false);
	
		assertEquals(toPoundResult, 13);
	
	}
	
	@Test
	public void canConverToFeet() {
		MeasureConverter converter = new MeasureConverter();
		int toFeetResult = converter.convertToFeet(200);
		
		assertEquals(toFeetResult, 6);
	}
		

}
