package com.qa.ryledra.ShoppingSite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.relevantcodes.extentreports.ExtentReports;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ItemValidTest.class,
	NavBarTest.class
})

public class TestSuite {
	
	public static ExtentReports report = new ExtentReports(
			"C:\\Users\\Admin\\Desktop\\Automated Testing\\Reports\\ShoppingReport.html", true);
}
