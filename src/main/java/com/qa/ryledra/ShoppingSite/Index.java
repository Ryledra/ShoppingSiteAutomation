package com.qa.ryledra.ShoppingSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Index {
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	private WebElement NavWomen;
	
	public void moveToWomen()	{
		NavWomen.click();
	}
}
