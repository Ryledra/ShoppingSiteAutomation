package com.qa.ryledra.ShoppingSite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NavBarTest {
	
	public static ExtentReports report;
	public ExtentTest test;

	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	final String cDFilePath = "C:\\Testing\\chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";
	
	@BeforeClass
	public static void initial()	{
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automated Testing\\Reports\\ShoppingReport.html", false);
	}
	
	@Before
	public void setup()	{
		System.setProperty(driverType, cDFilePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test
	public void navTest()	{
		
		test = report.startTest("Navigation Bar - hover test");
		
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.hoverDresses(driver, test);
		indexPage.clickCasDress(driver);
		test.log(LogStatus.INFO, "clicked on 'Casual Dresses'");
		
		if (driver.getTitle().equals("Casual Dresses - My Store"))	{
			test.log(LogStatus.PASS, "has navigated to the correct page from the nav bar");
		} else	{
			test.log(LogStatus.FAIL, "has navigated to the wrong page");
		}
		assertEquals("Navigated to the wrong page","Casual Dresses - My Store",driver.getTitle());
		report.endTest(test);
	}
	
	@After
	public void tearDown() throws InterruptedException	{
		//Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterClass
	public static void end()	{
		report.flush();
	}
}
