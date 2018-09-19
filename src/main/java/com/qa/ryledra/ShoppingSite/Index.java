package com.qa.ryledra.ShoppingSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Index {
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	private WebElement navWomen;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private WebElement navDresses;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
	private WebElement navCasDress;
	
	public void moveToWomen()	{
		navWomen.click();
	}
	
	public void hoverDresses(WebDriver driver, ExtentTest test)	{
		Actions act = new Actions(driver);
		act.moveToElement(navDresses).perform();
		test.log(LogStatus.INFO, "mouse moved to 'Dresses' on nav bar");
		
		@SuppressWarnings("unused")
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a"))); 
		test.log(LogStatus.INFO, "Explicit wait while dropdown is initiated");
	}
	
	public void clickCasDress(WebDriver driver)	{
		Actions act = new Actions(driver);
		act.moveToElement(navCasDress).click().perform();
		//navCasDress.click();
	}
}
