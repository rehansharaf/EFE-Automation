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
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.SalesforceRestAPI;

public class Navigation extends TestBase{

	WebDriver driver;
	
	
	DetailsPage detailspage = new DetailsPage();
	static String uid = DetailsPage.uniqueid;
	
	static String fname = "Testf"+ uid;
	static String lname = "Testl"+ uid;
	
	static String spousefname = "spouseTestf"+ uid;
	static String spouselname = "spouseTestl"+ uid;
	static String aname = fname+" "+lname;
	
	
	public static String get_sfdcID(){return SalesforceRestAPI.getHashMapData()[0];}
	
	public static String getbusinessLeadID(){return SalesforceRestAPI.getHashMapData()[1];}
	
	public static String getspouse_sfdcID(){return SalesforceRestAPI.getHashMapData()[2];}
	
	public static String getprimary_sfdcID(){return SalesforceRestAPI.getHashMapData()[1];}
	
	public static String getaccountName(){return aname;}
	
	
	
	
	
	
	
	
	

}
