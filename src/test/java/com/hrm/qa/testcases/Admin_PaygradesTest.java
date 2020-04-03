package com.hrm.qa.testcases;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.base.Testbase;

import com.hrm.qa.pages.Admin_Paygrades;
import com.hrm.qa.pages.LoginPage;


public class Admin_PaygradesTest  extends Testbase {

	
	 public LoginPage lp;
	 public Admin_Paygrades ap;
	 //public ExtentHtmlReporter htmlreporter;
	// public ExtentReports extent;
	// public ExtentTest test;
	
	
	/*@BeforeTest
	public void setextent()
	{
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myreport.html");
		htmlreporter.config().setDocumentTitle("Functional Report");
		htmlreporter.config().setReportName("Automation Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname","LocalHost");
		extent.setSystemInfo("OS","WINDOWS 10");
		extent.setSystemInfo("Tester Name","Ravindra");
		extent.setSystemInfo("Browser","chrome");
		
	
	}*/

	
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
		//lp.Username(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	
	@Test(priority=1)
	public void clickonadminpaygradeTestTest() throws InterruptedException, IOException
	{
		test=extent.createTest("click on Admin_Paygrades Test");
		lp.Username(prop.getProperty("username"),prop.getProperty("password"));
		String title=driver.getTitle();
		System.out.println(title);
		ap.clickonadmin();
	    ap.ReadExcelFile();
	   // ap.selectcheckbox();
		
	}
	/*@AfterTest
	public void endreport()
	{
		
		extent.flush();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{	
	if(result.getStatus()==ITestResult.FAILURE)
	{
		
		test.log(Status.FAIL, "TEST CASE FAILED IS"+result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED IS"+result.getThrowable());
		
		
		String screenshotpath=Admin_PaygradesTest.getScreenshot(driver,result.getName());
		test.addScreenCaptureFromPath(screenshotpath);
		
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP,"TEST CASE SKIPPED IS"+result.getName());
	
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS,"TEST CASE SKIPPED IS"+result.getName());
		
	}
	driver.quit();
	}

	
	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException
	{
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String destination=System.getProperty("user.dir")+"/ScreenShot/"+screenshotName+dateName+".png";
		File finalDestination=new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
		
		
	}*/
	
}

