package se.iths;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeConverterTest {

	@Test(expected = IllegalArgumentException.class)
	public void negativeHourThrowsIllegalArgumentException() {
		TimeConverter converter = new TimeConverter();
		
		converter.getMeridiem(-5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void toLargeHourThrowsIllegalArgumentException() {
		TimeConverter converter = new TimeConverter();
		
		converter.getMeridiem(35);
	}
	
	@Test
	public void canReturnAM() {
		TimeConverter converter = new TimeConverter();
		String returnAM = converter.getMeridiem(10);
		
		assertEquals(returnAM, "AM");
	}
	
	@Test
	public void canReturnPM() {
		TimeConverter converter = new TimeConverter();
		String returnPM = converter.getMeridiem(20);
		
		assertEquals(returnPM, "PM");
	}
}
