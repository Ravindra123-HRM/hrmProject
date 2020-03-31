package com.hrm.qa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import com.crm.qa.base.Testbase;
import com.hrm.qa.pages.Admin_JobTitle;
import com.hrm.qa.pages.Admin_Paygrades;
import com.hrm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Admin_PaygradesTest  extends Testbase {
	
	public LoginPage lp;
	public Admin_Paygrades ap;
	 
	
	
	
	static ExtentTest test;
	
	Admin_PaygradesTest() throws IOException
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException 
	{
		initialization();
	
		lp=new LoginPage(driver);
		ap=new Admin_Paygrades(driver);
		lp.Username(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	@Test(priority=1)
	public void clickonadminpageTest() throws InterruptedException, IOException
	{
		/*test.log(LogStatus.PASS, "Navigated to the specified URL");
		test.log(LogStatus.FAIL, "Test Failed");
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");*/
		ap.clickonadmin();
	    ap.ReadExcelFile();
	   // ap.selectcheckbox();
		
	}
	
	
	
	
}
