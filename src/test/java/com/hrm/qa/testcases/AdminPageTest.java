package com.hrm.qa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.hrm.qa.pages.Admin_JobTitle;
import com.hrm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;


public class AdminPageTest  extends Testbase {
	
	public LoginPage lp;
	public Admin_JobTitle ap;
	static ExtentTest test;
	
	
	
	AdminPageTest() throws IOException
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException 
	{
		initialization();
		lp=new LoginPage(driver);
		ap=new Admin_JobTitle(driver);
		lp.Username(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	@Test(priority=1)
	public void clickonadminpageTest() throws InterruptedException, IOException
	{
		
		ap.clickonadmin();
		ap.ReadExcelFile();
		
		/*test.log(LogStatus.PASS, "Navigated to the specified URL");
		test.log(LogStatus.FAIL, "Test Failed");
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");*/
	}
	
	
}
