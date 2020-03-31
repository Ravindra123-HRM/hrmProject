package com.hrm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class LoginPage extends Testbase {

	

	@FindBy(id="txtUsername")
	WebElement user_email;
	
	@FindBy(name="txtPassword")
	WebElement user_password;
	
	@FindBy(id="btnLogin")
	WebElement loginbutton;
	
	@FindBy	(css="img[alt*='OrangeHRM']")		
	WebElement image;

	
	
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public void Username(String user,String pass) throws IOException
	{
		user_email.sendKeys(user);
		user_password.sendKeys(pass);
		loginbutton.click();
		
	}
	
	public String getimagetext()
	{

		 image.isDisplayed();
		return toString() ;
	}

	
	
	
	
}
