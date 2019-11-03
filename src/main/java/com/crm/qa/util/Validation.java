package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import com.crm.qa.base.TestBase;

public class Validation extends TestBase{

	WebDriver driver;
	
	private final int TIMEOUT = 10;
/*
	public static void SelectDropDownOption(WebElement dropdown, String Option ) {
		
		Select dropdownoption = new Select(dropdown);
		System.out.println(dropdownoption);
		dropdownoption.selectByVisibleText(Option);
		
		}
		
	*/

	public void waitForElement(WebDriver driver, final String webElementId){
    	int timeOut = 90;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(new ExpectedCondition<Boolean>() {
        	public Boolean apply(WebDriver driver) {
                        if (driver.findElement(By.id(webElementId)) != null){
        			return Boolean.TRUE;
        		}
        		return null;
            }
        }); 
    }	
	
	//@SuppressWarnings("unchecked")
	public void waitUntilElementDisplayed(final WebElement webElement, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver arg0) {
		  try {
		     webElement.isDisplayed();
		     return true;
		  }
		  catch (NoSuchElementException e ) {
		    return false;
		  }
		  catch (StaleElementReferenceException f) {
		    return false;
		  }
		    }
		};
		wait.until(elementIsDisplayed);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
}
