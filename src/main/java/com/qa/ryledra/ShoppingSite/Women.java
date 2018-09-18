package com.qa.ryledra.ShoppingSite;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Women {
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul")
	private WebElement itemGrid;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li")
	private List<WebElement> listOfEle;
	
	int itemGridSize;
	
	public void setItemGridSize()	{
	}
	
	public boolean findItem(String item)	{
		for (WebElement ele : listOfEle) {
			String[] parts = ele.getText().split("\n");
			if (parts[0].equals(item)) return true;
		}
		return false;
	}
}
