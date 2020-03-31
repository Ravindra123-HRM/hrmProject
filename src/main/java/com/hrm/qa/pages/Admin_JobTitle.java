package com.hrm.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Admin_JobTitle extends Testbase{
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement admin;
	
	@FindBy(id="menu_admin_UserManagement")
	WebElement usermanement;
	@FindBy(xpath="//a[@id='menu_admin_Job']")
	WebElement job;
	@FindBy(id="menu_admin_viewJobTitleList")
	WebElement jobtitle;
	@FindBy(id="btnAdd")
	WebElement addbtn;
	@FindBy(id="jobTitle_jobTitle")
	WebElement jobtitlekey;
	@FindBy(id="jobTitle_jobDescription")
	WebElement jobdescription;
    @FindBy(id="btnSave")
	WebElement savebutton;
    
    public Admin_JobTitle(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	
    }
    
    public void ReadExcelFile() throws IOException, InterruptedException
    {
    	FileInputStream fis=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\hrmProject\\src\\main\\java\\Readdataexcel\\Jobtitle.xls");
    	HSSFWorkbook workbook=new HSSFWorkbook(fis);
    	HSSFSheet sheet=workbook.getSheet("Sheet1");
    	int rowcount=sheet.getLastRowNum();
    	System.out.println(rowcount);
    	int colcount=sheet.getRow(0).getLastCellNum();
    	
    	
    	for(int row=1;row<=rowcount;row++)
    	{
    		
    		HSSFRow currentrow=sheet.getRow(row);
    		String job_title=currentrow.getCell(0).getStringCellValue();
    		String job_description=currentrow.getCell(1).getStringCellValue();
    		
    	    admin.click();
    	    usermanement.click();
    	    Thread.sleep(2000);
    		job.click();
    		jobtitle.click();
    		addbtn.click();
    		jobtitlekey.sendKeys(job_title);
    		jobdescription.sendKeys(job_description);
    		savebutton.click();
    		
    	}
    }
    
    
	public void clickonadmin() 
	{
	
	    admin.click();
	   System.out.println("Done Mouse hover on 'admin' from Menu");
	   
     }
	
	
	
	
	

    }

    


