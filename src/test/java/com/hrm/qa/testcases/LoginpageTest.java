package com.hrm.qa.testcases;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.base.Testbase;
import com.hrm.qa.pages.LoginPage;

public class LoginpageTest extends Testbase {
	
	public LoginPage lp;
	 public ExtentHtmlReporter htmlreporter;
	 public ExtentReports extent;
	 public com.aventstack.extentreports.ExtentTest test;
	
	@BeforeTest
	public void setextent()
	{
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		htmlreporter.config().setDocumentTitle("Functional Report");
		htmlreporter.config().setReportName("Automation Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname","LocalHost");
		extent.setSystemInfo("OS","WINDOWS 10");
		extent.setSystemInfo("Tester Name","Ravindra");
		extent.setSystemInfo("Browser","chrome");
		
	
	}
	
	LoginpageTest() throws IOException
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException 
	{
		initialization();
		lp=new LoginPage(driver);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShot/Screen.png"));
		System.out.println("the Screenshot is taken");
		
	}
	
	@Test(priority=1)
	public void login() throws IOException
	{   
		lp.Username(prop.getProperty("username"),prop.getProperty("password"));
		//Assert.assertEquals("orangeHRM", "orangeHRM");

	}
	
	@AfterTest
	public void endreport()
	{
		
		extent.flush();
	}
	
	//@AfterMethod
	public void tearDown(ITestResult result)
	{	
	if(result.getStatus()==ITestResult.FAILURE)
	{
		
		test.log(Status.FAIL, "TEST CASE FAILED IS"+result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED IS"+result.getThrowable());
		//String screenshotpath=clickonadmin.getScreenshot(driver,result.getName());
		//test.addScreenCaptureFromPath(screenshotpath);
		
	}else if(result.getStatus()==ITestResult.SKIP) {
		test.log(Status.SKIP,"TEST CASE SKIPPED IS"+result.getName());
	}else if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS,"TEST CASE SKIPPED IS"+result.getName());
		
	}
	
	}
	
}
