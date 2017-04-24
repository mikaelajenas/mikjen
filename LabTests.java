package se.iths;
import static org.junit.Assert.*;

import java.io.Console;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LabTests {

	private static Lab1 lab;
	private static int counter = 0;
	
	@Before
	public void start() {
		lab = new Lab1();
	}
	
	@After
	@Test
	public void getCounter() {
		int result = lab.getCounter();		
		System.out.println("Result: " + result + " Counter:" + counter);
		assertEquals(result, counter);
	}
	
	@Test
	public void canAdd() { 
		int result = lab.add(10, 2);
		assertEquals(result, 12);
		
		counter++;
	}
	
	@Test
	public void canSubstract() {
		int result = lab.subtract(12, 2);
		assertEquals(result, 10);
		
		counter++;
	}
	
	@Test
	public void canMultiply() {
		int result = lab.multiply(7, 3);
		assertEquals(result, 21);
		
		counter++;
	}
	
	@Test
	public void canDivide() {
		int result = lab.divide(64, 8);
		assertEquals(result, 8);
		
		counter++; 
	}
	
	@Test
	public void canReverse() {
		String original = "Hello World";
		String result = lab.reverse(original);
		
		assertNotEquals(result, original);
		assertEquals(result, "dlroW olleH");
		
		counter++;
		
	}
	
	@Test
	public void canQuote() {
		String[] quoteArray = {"We cannot solve our problems with the same thinking we used when we created them. - Albert Einstein",
								"A fool thinks himself to be wise, but a wise man knows himself to be a fool. - William Shakespeare",
								"You must be the change you wish to see in the world. - Mahatma Gandhi",
								"In the End, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King, Jr.",
								"Choose a job you love, and you will never have to work a day in your life. - Confucius",
								"To expect the unexpected shows a thoroughly modern intellect. - Oscar Wilde",
								"Without music, life would be a mistake. - Friedrich Nietzsche",
								"I love deadlines. I like the whooshing sound they make as they fly by. - Douglas Adams"};
		
		String[] resultsArray = new String[10];
		
		for(int i = 0; i < 10; i++) { 
			
			String result = lab.quote();
			resultsArray[i] = result;			
			counter++;
			
			boolean success = false;
			
			for(int j = 0; j < quoteArray.length; j++) {
				if (quoteArray[j].equals(result)) {
					success = true;
					break;
				}
			}
			
			assertTrue(success);
		}
		
		boolean differents = false;
		
		for(int i = 0; i < resultsArray.length; i++) {
			
			String current = resultsArray[i];
			
			for(int j = 0; j < resultsArray.length; j++) {
				if (resultsArray[j].equals(current) == false) {
					differents = true;
					break;
				}
			}
			
			if(differents == true) {
				break;
			}
		}
		
		assertTrue(differents); 
		
	}
	
	
	
} 

