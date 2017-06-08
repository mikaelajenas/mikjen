package se.iths;

import static org.junit.Assert.*;

import org.junit.Test;

public class AmericanizerTest {

	@Test
	public void canConvertTimeWithoutConverter() {
		Americanizer american = new Americanizer();
		String Time = american.convertTime(10);
		
		assertEquals(Time, "");
			
	}
	
	@Test
	public void canConvertTimeWithConverterAM() {
		Americanizer american = new Americanizer();
		american.setTimeConverter(new TimeConverter());
		
		String Time = american.convertTime(10);
		String expected = "10 AM";
		
		assertEquals(Time, expected);
			
	}
	
	@Test
	public void canConvertTimeWithConverterPM() {
		Americanizer american = new Americanizer();
		american.setTimeConverter(new TimeConverter());
		
		String Time = american.convertTime(15);
		String expected = "3 PM";
		
		assertEquals(Time, expected);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void canConvertPoundWithoutConverter() {
		Americanizer american = new Americanizer();
		
		int pound = american.convertToPound(10);
		
		
	}
	
	@Test
	public void canConvertPoundWithConverter() {
		Americanizer american = new Americanizer();
		american.setWeightConverter(new MeasureConverter());
		
		int pound = american.convertToPound(10);
		
		assertEquals(3, pound);
	}
	
	@Test
	public void canConvertSpeachWithNull() {
		Americanizer american = new Americanizer();
		
		String speach = american.convertSpeach(null);
		
		assertEquals("yo dude!" + null + ", you know?", speach);
	}
	
	@Test
	public void canConvertSpeach() {
		Americanizer american = new Americanizer();
		
		String speach = american.convertSpeach("Hi");
		
		assertEquals("yo dude!Hi, you know?", speach);
	}
	
	@Test(expected = NullPointerException.class)
	public void canConvertFeetWithoutConverter() {
		Americanizer american = new Americanizer();
		
		int feet = american.convertToFeet(30);
		
		
	}
	
	@Test
	public void canConvertFeetWithConverter() {
		Americanizer american = new Americanizer();
		american.setWeightConverter(new MeasureConverter());
		int feet = american.convertToFeet(30);
		
		assertEquals(1, feet);
	}
	
	

}
