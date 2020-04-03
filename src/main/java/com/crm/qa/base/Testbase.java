package com.crm.qa.base;



import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrm.qa.pages.Admin_Paygrades;
import com.hrm.qa.pages.LoginPage;




public  class Testbase  {
	
	public  WebDriver driver;
	public  Properties prop;
	 public LoginPage lp;
	 public Admin_Paygrades ap;
	 public ExtentHtmlReporter htmlreporter;
	 public ExtentReports extent;
	 public ExtentTest test;
	
	
	@BeforeTest
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
		
	
	}
	
	
	


	public WebDriver initialization() throws IOException
	{
		
		 prop=new Properties();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\hrmProject\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
		
		prop.load(fis);
		
	     String browsername=prop.getProperty("browser");
	     System.out.println(browsername);
		
		if(browsername.equals("chrome"))
		 {
			 
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\eclipse-workspace\\hrmProject\\src\\main\\java\\chrome80\\chromedriver.exe");
				driver=new ChromeDriver();
			    driver.get("https://opensource-demo.orangehrmlive.com/");
			   
				driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  }
		return driver;
		
		
		
	}
	@AfterTest
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
		
		
		String screenshotpath=Testbase.getScreenshot(driver,result.getName());
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
		
		
		
	}
	
	
	
}
