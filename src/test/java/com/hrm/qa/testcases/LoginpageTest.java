package com.hrm.qa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.hrm.qa.pages.LoginPage;

public class LoginpageTest extends Testbase {
	
	public LoginPage lp;
	
	
	
	LoginpageTest() throws IOException
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException 
	{
		initialization();
		lp=new LoginPage(driver);
		
		
		
	}
	
	@Test(priority=1)
	public void login() throws IOException
	{   
		lp.Username(prop.getProperty("username"),prop.getProperty("password"));
		//Assert.assertEquals("orangeHRM", "orangeHRM");

	}
	
	
	/*@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}*/
	
}
