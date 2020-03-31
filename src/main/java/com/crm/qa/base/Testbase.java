package com.crm.qa.base;



import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public  class Testbase  {
	
	public  WebDriver driver;
	public  Properties prop;

	static ExtentTest test;
	static ExtentReports report;
	/*@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	test = report.startTest("ExtentDemo");
	}*/
	
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
	/*public static String capture(WebDriver driver) throws IOException {
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}*/
}
