package com.learnautomation.pages;

import java.security.cert.Extension;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;
import java.io.File;



public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
	excel = new ExcelDataProvider();
	
	ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Amazon"+Helper.getCurrentDateTime()+".html"));
	report = new ExtentReports();
	report.attachReporter(extent);
	
	}
	
	
	@BeforeClass
	public void setup() {
		driver= BrowserFactory.startApplication(driver, "Chrome","https://www.amazon.in/");
	}
	
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
		}
		report.flush();
	}

}
