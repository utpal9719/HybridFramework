package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement signin;
	@FindBy(id="ap_email_login") WebElement uname;
	@FindBy(xpath="//*[@id=\"continue\"]/span/input") WebElement con;
	@FindBy(id="ap_password") WebElement pass;
	@FindBy(xpath="//*[@id=\"signInSubmit\"]") WebElement sign;
	
	public void loginToCRM(String usernameApplicaton, String passwordApplication)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			
		}
		signin.click();
		uname.sendKeys(usernameApplicaton);
		con.click();
		pass.sendKeys(passwordApplication);
		sign.click();
		
	}
	
}
