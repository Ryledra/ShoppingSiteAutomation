package com.qa.ryledra.ShoppingSite;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@RunWith(Parameterized.class)
public class ItemValidTest {
	
	public static ExtentReports report;
	public ExtentTest test;
	
	@Parameters
	public static List<String> data() {
		return Arrays.asList(
				new String[] {"Blouse", "Printed Dress", "Short Shorts"});
	}
	
	public ItemValidTest(String item)	{
		searchItem = item;
	}
	
	WebDriver driver;
	
	private String searchItem;
	
	@BeforeClass
	public static void initial()	{
		report = TestSuite.report;
	}
	
	@Before
	public void setup()	{
		System.setProperty(Constants.driverType, Constants.cDFilePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.url);
	}
	
	@Test
	public void testAssertItem()	{
		
		test = report.startTest("Search '" + searchItem + "'.");
		
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.moveToWomen();
		test.log(LogStatus.INFO, "moved to 'women's clothing' page");
		
		Women womenPage = PageFactory.initElements(driver, Women.class);
		if (searchItem.equals("Short Shorts"))	{
			if (!womenPage.findItem(searchItem)) test.log(LogStatus.PASS, searchItem + " not found (not expected)");
			else test.log(LogStatus.FAIL, searchItem + " found (not expected)");
			assertFalse(searchItem + " incorrectly found", womenPage.findItem(searchItem));
		} else	{
			if (womenPage.findItem(searchItem)) test.log(LogStatus.PASS, searchItem + " found (expected)");
			else test.log(LogStatus.FAIL, searchItem + " not found (expected)");;
			assertTrue(searchItem + " not found", womenPage.findItem(searchItem));
		}
		report.endTest(test);
	}
	
	@After
	public void tearDown() throws InterruptedException	{
		// Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterClass
	public static void end()	{
		report.flush();
	}
}
