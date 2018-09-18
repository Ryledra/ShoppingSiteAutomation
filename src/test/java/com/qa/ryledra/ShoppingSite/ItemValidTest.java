package com.qa.ryledra.ShoppingSite;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@RunWith(Parameterized.class)
public class ItemValidTest {
	
	@Parameters
	public static List<String> data() {
		return Arrays.asList(
				new String[] {"Blouse", "Printed Dress", "Short Shorts"});
	}
	
	public ItemValidTest(String item)	{
		searchItem = item;
	}
	
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	final String cDFilePath = "C:\\Testing\\chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";
	
	private String searchItem;
	
	@Before
	public void setup()	{
		System.setProperty(driverType, cDFilePath);
		driver = new ChromeDriver();
		// driver.manage().window().fullscreen();
		driver.get(url);
	}
	
	@Test
	public void testAssertItem()	{
		
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.moveToWomen();
		
		Women womenPage = PageFactory.initElements(driver, Women.class);
		assertTrue(searchItem + " not found", womenPage.findItem(searchItem));
	}
	
	@After
	public void tearDown() throws InterruptedException	{
		// Thread.sleep(3000);
		driver.quit();
	}
}
