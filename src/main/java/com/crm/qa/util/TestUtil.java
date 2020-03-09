package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import static org.testng.Assert.assertFalse;

import com.crm.qa.base.TestBase;
import com.google.common.base.Predicate;


public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 50;
	
	public static String TESTDATA_SHEET_PATH = (System.getProperty("user.dir")+ "/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx");

	
	static Workbook book;
	static Sheet sheet;
	
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	
	
	public static Object[] getTestData1(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
    public static void SelectDropDownOption(WebElement dropdown, String Option ) {
		
		Select dropdownoption = new Select(dropdown);
		dropdownoption.selectByVisibleText(Option);
		
	}
    
    
    public static void clickElement(WebElement element) throws InterruptedException { 
    	
    	waitUntilElementVisible(element);
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); 
    	    
    }
		
    public static void scrollintoView(WebElement element) { 
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
    }
      

    public static void waitUntilElementVisible(WebElement element) throws InterruptedException { 
	   	 
    	WebDriverWait wait = new WebDriverWait(driver, 15);
	   	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
     
    public static void waitUntilPageLoad(WebDriver driver) throws InterruptedException { 
    	new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

    	
    }
    
    
   
    
    
    
    public static void print(String TestCaseName) {
    	 
    	 System.out.println();
    	 System.out.println("***************************** Executing Test Case: "+TestCaseName+" ******************************");
    	 System.out.println();
     }
     
      
     public static void closeAllOpenTabs(WebDriver driver) throws InterruptedException {
    	 
    	WebElement openTabgrid= driver.findElement(By.xpath("//*[contains (@class, ('tabBarItems slds-grid'))]")); Thread.sleep(2000);
    	 	
    	 List<WebElement> listoftabs = openTabgrid.findElements(By.xpath("//a[contains (@class, ('slds-context-bar'))][contains (@href, ('/lightning/'))]"));
    	 	
    	 	int i = listoftabs.size();
    	 	
    	 	if (listoftabs.size()>1){
    	 		for (int j=0; j<i-1; j++)
    	 			{driver.findElement(By.xpath("//div[2]//button[1][contains (@title, ('Close'))]")).click(); }
    	 	}
     	 	
    	 	clickAccountLink();
     }
 
     
     public static void clickAccountLink() throws InterruptedException {
    	 
    	 String accountId = RetailUserdetails.get_sfdcID();
    	 
    	 driver.findElement(By.xpath("//a[contains (@class, ('" +accountId+ "'))]")).click();
    	 Thread.sleep(2000);
    	 
    	 
     }
 
     public void clickAccountviaAccountScreen() throws InterruptedException{ 
 		
 		Thread.sleep(2000);
 		changeNavigationMenu("Accounts");
 		Thread.sleep(2000);
 		TestUtil.closeAllOpenTabs(driver);
 		Thread.sleep(2000);
 		driver.findElement(By.xpath("(//a[contains (@title, ('" +RetailUserdetails.getaccountName("primary")+ "'))][contains (@class, ('slds-truncate'))])[1]")).click();
 		Thread.sleep(2000);
 		
 	}
     
     public static void changeNavigationMenu(String Menu) throws InterruptedException{
 		
 		driver.findElement(By.xpath("//button[contains (@title, ('Show Navigation Menu'))]")).click();
 		Thread.sleep(2000);
 		driver.findElement(By.xpath("//span[contains (@class,('menuLabel slds-listbox'))][contains(text(),'" +Menu+ "')]")).click();
 	}
 	
     
     
     public boolean isLeadLinkVisible(){
 	    WebDriverWait zeroWait = new WebDriverWait(driver, 0);
 	    ExpectedCondition<WebElement> c = ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Create New Application']"));
 	    try {
 	        zeroWait.until(c);
 	        return true;
 	    } catch (Exception e) {
 	        return false;
 	    }
 	}   
     
    
     
}
