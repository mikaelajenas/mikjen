package se.iths.selenium_first_project;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class ShopTest {
	private static final By Business = null;
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Seleniumgecko\\geckodriver.exe");
		//sökväg till webbläsare
		driver = new FirefoxDriver(); 
		// vilken webbläsare som ska köras
	}
	
	@Test
	public void testGoToDefaultStore() throws InterruptedException {
		 
		
		
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html");
		// den sidan man vill gå till.
		
		WebElement storeLink = driver.findElement(By.linkText("Default store")	);
		storeLink.click();
		//visar vilken del i webbläsaren man vill klicka på. 
		
		Thread.sleep(2000);
		//väntar x antal sekunder innan den har tänkt klart
		assertEquals("Shopizer Demo - Default store",driver.getTitle());
		System.out.println(driver.getTitle());
		driver.quit(); 
		
	}
	
	@Test
	public void testGoToComputerBooks() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		WebElement storeLink = driver.findElement(By.linkText("Business"));
		storeLink.click();
		
		Thread.sleep(2000);
		assertEquals("Business",driver.findElement(By.xpath(".//*[@id='mainContent']/header/div[1]/div/h2")).getText());
		driver.quit();
		
	}
	
	
	@Test 
	public void addToCart() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		WebElement book = driver.findElement(By.xpath("//*[contains(@src,'spring')]"));
		book.click();
		
		
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		WebElement addToCart = driver.findElement(By.className("addToCartButton"));
		addToCart.click();
		
		
		Thread.sleep(2000);
		jse.executeScript("scroll(0, -250);");
		WebElement shoppingBag = driver.findElement(By.xpath(".//*[@id='open-cart']"));
		shoppingBag.click();
		
		
		Thread.sleep(2000);
		WebElement checkOut = driver.findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
		checkOut.click();
		
		Thread.sleep(2000);
		assertEquals("Review your order",driver.findElement(By.xpath(".//*[@id='main-content']/div/h1")).getText());
		
		
		driver.quit();
	
	}
		
	
	@Test
	public void detailsAboutABook()  throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		Thread.sleep(1000);
		WebElement detailsBook = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[1]/div/div[1]/a/img")); 
		detailsBook.click();
		
		
		Thread.sleep(2000);
		WebElement specificationsBook = driver.findElement(By.linkText("Specifications"));
		specificationsBook.click();
		
		
		Thread.sleep(2000);
		WebElement CustomerReview = driver.findElement(By.linkText("Customer review(s)"));
		CustomerReview.click();
		
		
		Thread.sleep(2000);
		WebElement addToCart = driver.findElement(By.className("addToCartButton"));
		addToCart.click();
		
		
		Thread.sleep(2000);
		jse.executeScript("scroll(0, -450);");
		Thread.sleep(2000);
		
		assertEquals("Spring in Action",driver.findElement(By.xpath(".//*[@id='shop']/section/div/h1")).getText());
		
		driver.quit();
		
	}
	
	
	@Test
	public void findContactUs() throws InterruptedException, AWTException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 450);");
		WebElement Contact = driver.findElement(By.linkText("Contact us"));
		Contact.click();
		
		Thread.sleep(4000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		assertEquals("Contact us",driver.findElement(By.xpath(".//*[@id='main-content']/h1")).getText());
		
		
		driver.quit();
	}
	
	@Test
	public void findBusiness() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 450);");
		Thread.sleep(1000);
		WebElement toBusiness = driver.findElement(By.linkText("Business"));
		toBusiness.click();
		
		Thread.sleep(2000);
		assertEquals("Business",driver.findElement(By.xpath(".//*[@id='mainContent']/header/div[1]/div/h2")).getText());
		
		driver.quit();
	}
	
	@Test 
	public void addToCartTwoBooks() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 550);");
		WebElement book = driver.findElement(By.xpath("//*[contains(@src,'spring')]"));
		book.click();
		
		Thread.sleep(1000);
		jse.executeScript("scroll(0, 550);");
		Thread.sleep(1000);
		WebElement addToCart = driver.findElement(By.xpath(".//*[@id='input-1']/div/button"));
		addToCart.click();
		
		
		Thread.sleep(1000);
		jse.executeScript("scroll(0, -250);");
		WebElement shoppingBag = driver.findElement(By.xpath(".//*[@id='open-cart']"));
		shoppingBag.click();
		
		Thread.sleep(1000);
		WebElement storeLink = driver.findElement(By.linkText("Default store")	);
		storeLink.click();
		
		Thread.sleep(1000);
		jse.executeScript("scroll(0, 350);");
		WebElement book2 = driver.findElement(By.xpath(".//*[@id='pageContainer']/div[2]/div[3]/div[2]/div/div[2]/div/div[1]/a/img"));
		book2.click();
		
		Thread.sleep(1000);
		jse.executeScript("scroll(0, 350);");
		WebElement addToCart2 = driver.findElement(By.xpath(".//*[@id='input-6']/div/button"));
		addToCart2.click();
		
		Thread.sleep(1000);
		jse.executeScript("scroll(0, -350);");
		WebElement goToCart = driver.findElement(By.xpath(".//*[@id='open-cart']"));
		goToCart.click();
		WebElement goToCart2 = driver.findElement(By.xpath(".//*[@id='miniCartDetails']/li/div/a"));
		goToCart2.click(); 
		
		Thread.sleep(2000);
		assertEquals("Review your order",driver.findElement(By.xpath(".//*[@id='main-content']/div/h1")).getText());
		
		
		driver.quit();
	
	}
}


	
		
