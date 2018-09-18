package com.qa.ryledra.ShoppingSite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ItemValidTest {
	
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	final String cDFilePath = "C:\\Testing\\chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";
	
	@Before
	public void setup()	{
		System.setProperty(driverType, cDFilePath);
		driver = new ChromeDriver();
		// driver.manage().window().fullscreen();
		driver.get(url);
	}
	
	@Test
	public void testAssertItem()	{
		
		String searchItem = "Blouse";
		
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.moveToWomen();
		
		Women womenPage = PageFactory.initElements(driver, Women.class);
		assertTrue(searchItem + " not found", womenPage.findItem(searchItem));
	}
	
	@After
	public void tearDown() throws InterruptedException	{
		Thread.sleep(3000);
		driver.quit();
	}
}
