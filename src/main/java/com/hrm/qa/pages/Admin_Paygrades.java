package com.hrm.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import com.crm.qa.base.Testbase;

public class Admin_Paygrades extends Testbase
{
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement admin;
	
	@FindBy(id="menu_admin_UserManagement")
	WebElement usermanement;
	@FindBy(xpath="//a[@id='menu_admin_Job']")
	WebElement job;
	@FindBy(id="menu_admin_viewJobTitleList")
	WebElement jobtitle;
	@FindBy(id="btnAdd")
	WebElement btnadd;
	@FindBy(xpath="//a[contains(text(),'Pay Grades')]")
	WebElement paygrades;
	@FindBy(id="btnAddCurrency")
	WebElement addbtn;
	@FindBy(id="payGrade_name")
	WebElement paygradename;
	@FindBy(id="btnSave")
	WebElement savebutton;
	@FindBy(id="payGradeCurrency_currencyName")
	WebElement currency;
	@FindBy(id="payGradeCurrency_minSalary")
	WebElement minsal;
	@FindBy(id="payGradeCurrency_maxSalary")
	WebElement maxsal;
	@FindBy(id="btnSaveCurrency")
	WebElement btnsavecurrency;
	@FindBy(css="input[id='ohrmList_chkSelectRecord_5']")
	WebElement checkbox;
    
    public Admin_Paygrades(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	
    }
    
    public void ReadExcelFile() throws IOException, InterruptedException
    {
    	FileInputStream fis=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\hrmProject\\src\\main\\java\\Readdataexcel\\Jobtitle.xls");
    	HSSFWorkbook workbook=new HSSFWorkbook(fis);
    	HSSFSheet sheet=workbook.getSheet("Sheet2");
    	int rowcount=sheet.getLastRowNum();
    	System.out.println(rowcount);
    	//int colcount=sheet.getRow(0).getLastCellNum();
    	
    	
    	for(int row=1;row<=rowcount;row++)
    	{
    		
    		HSSFRow currentrow=sheet.getRow(row);
    		String min_sal=currentrow.getCell(1).getStringCellValue();
    		String max_sal=currentrow.getCell(2).getStringCellValue();
    		String pay_grade=currentrow.getCell(0).getStringCellValue();
    	    admin.click();
    		usermanement.click();
    		 job.click();
    		 paygrades.click();
    		 btnadd.click();
             paygradename.sendKeys(pay_grade);
    		 savebutton.click();
    	      addbtn.click();
    		 currency.sendKeys("INR");
    		 currency.sendKeys(Keys.ARROW_DOWN);
    		 currency.sendKeys(Keys.ENTER);
    		 minsal.sendKeys(min_sal);
    		 maxsal.sendKeys(max_sal);
    		 btnsavecurrency.click();
    		 Thread.sleep(5000);
    		 
    	}
    }
    
    
	public void clickonadmin() 
	{
	
	    admin.click();
	   System.out.println("Done Mouse hover on 'admin' from Menu");
	   
     }
	
	/*public void selectcheckbox()
	{
		
		java.util.List<WebElement> checkbox = driver.findElements(By.cssSelector("input[type='checkbox']"));
		int numofelement=checkbox.size();
		for(int i=0;i<numofelement;i++)
		{
			 admin.click();
    		 usermanement.click();
    		 job.click();
    		 paygrades.click();
    		 if(checkbox.contains(driver.findElement(By.cssSelector("input[type='checkbox']"))))
    		 {
    			 driver.findElement(By.xpath("//tbody//tr[3]//td[2]//a[contains(text(),'Mechanical engineer')]")).click();
    			 driver.findElement(By.xpath("//tbody//tr[4]//td[2]//a[contains(text(),'Software developer')]")).click();
    			 driver.findElement(By.xpath("//tbody//tr[5]//td[2]//a[contains(text(),'Software Testing456')]")).click();
    			 driver.findElement(By.id("btnDelete")).click();
			
		      }*/
	    }
	
	
	

    


    


