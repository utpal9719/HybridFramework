package com.learnautomation.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;


public class LoginTestCRM extends BaseClass {
	// new adding to check github
	@Test(priority=0)
	public void loginApp()
	{
		
		logger= report.createTest("Login to Amazon");
		
		//ExcelDataProvider excel=new ExcelDataProvider();
	    //excel.getStringData("Login",0, 0);
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		//loginPage.loginToCRM("mandalutpalhowrah@gmail.com","utpal@1644");
		
		loginPage.loginToCRM(excel.getStringData("Login",0, 0),excel.getStringData("Login",0, 1));
	
		logger.pass("Login Success");
	//	Helper.captureScreenshot(driver);
	}
	@Test(priority=1)
	public void loginApp2()
	{
		
		logger= report.createTest("Login to Amazon");
		
		logger.fail("Logout failed");
	
	}
	
	
}
