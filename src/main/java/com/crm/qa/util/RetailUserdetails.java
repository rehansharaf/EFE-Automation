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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class RetailUserdetails extends TestBase{

	WebDriver driver;
		
	//static String[] ret = addDaysToCurrentTime(7);
    /*
	String enteredDate = ret[0];
    static String verifyDate = ret[1];
    static String meetingDate = ret[2];
    static String meetingformattedDate = ret[3];
    public static String uniqueid = ret[4];
    static String unplannedDate = ret[6];
*/
    
	String[] ret = addDaysToCurrentTime(7);
	
	private static String enteredDate ;
    private static String verifyDate ;
    private static String meetingDate;
    private static String meetingformattedDate ;
    private static String uniqueid ;
    private static String unplannedDate ;
    
	
	DetailsPage detailspage = new DetailsPage();
	
	
	/*
	
	static String uid = DetailsPage.uniqueid;
	
	static String fname = "Testf"+ uid;
	static String lname = "Testl"+ uid;
	
	static String spousefname = "spouseTestf"+ uid;
	static String spouselname = "spouseTestl"+ uid;
	static String aname = fname+" "+lname;
    
    
    
    String schedule1 = "Phone Call";
	String schedule2 = "ToDo";
	String schedule3 = "Appointment";
	*/
 
	//************************* GET RETAIL ID FROM SALESFORCE API*************************
	
	public static String get_sfdcID(){return SalesforceRestAPI.getHashMapData()[0];}
	public static String getbusinessLeadID(){return SalesforceRestAPI.getHashMapData()[1];}
	public static String getspouse_sfdcID(){return SalesforceRestAPI.getHashMapData()[2];}
	public static String getprimary_sfdcID(){return SalesforceRestAPI.getHashMapData()[1];}
		

	//************************* GET DATA TO ENTER IN DETAIL PAGE*************************
	
	public static Map<String, String> getDetailPageData(){
		
		String[] ret = addDaysToCurrentTime(7);
		
		Map<String, String> detailPageData = new HashMap<String, String>();
		    
		detailPageData.put("enteredDate", ret[0]);
		detailPageData.put("verifyDate", ret[1]);
		detailPageData.put("meetingDate", ret[2]);
		detailPageData.put("meetingformattedDate", ret[3]);
		detailPageData.put("uniqueid", ret[4]);
		detailPageData.put("unplannedDate", ret[6]);
		
		return detailPageData;
	
		}
		
/*	
	public static void setDetailPageData(){
		
		
		
		}
	
	public void setenteredDate(){enteredDate = ret[0];}
	public String gettenteredDate(){return enteredDate;}
	
	public void setverifyDate(){verifyDate = ret[1];}
	public String getverifyDate(){return verifyDate;}
	
	public void setmeetingDate(){meetingDate = ret[2];}
	public String getmeetingDate(){return meetingDate;}
	
	public void setmeetingformattedDate(){meetingformattedDate = ret[3];}
	public String getmeetingformattedDate(){return meetingformattedDate;}
	
	public void setuniqueid(){ uniqueid = ret[4];}
	public String getuniqueid(){return uniqueid;}
	
	public void setunplannedDate(){unplannedDate = ret[6];}
	public String getunplannedDate(){return unplannedDate;}
	
	*/
	
	//************************* GET UNIQUE ID*********************************************
	public static String getUniqueID(){return getDetailPageData().get("uniqueid");}
	
	
	//************************* GET ACCOUNT NAME *************************
	public static String getaccountName(String User){
		String AccountName = null;
		if (User.toLowerCase() =="primary"){AccountName = getPrimaryFirstName()+" "+getPrimaryLastName();}
		else if(User.toLowerCase() =="spouse"){AccountName = getSpouseFirstName()+" "+getSpouseLastName();} 
		return AccountName;
	}
		
	
	//************************* GET PRIMARY/HOUSEHOLD FIRST AND LAST NAME*************************
	public static String getPrimaryFirstName(){String fname = "Testf"+ getUniqueID();return fname;}
	public static String getPrimaryLastName(){String lname = "Testl"+ getUniqueID();return lname;}
	
	
	//************************* GET SPOUSE FIRST AND LAST NAME*************************
	public static String getSpouseFirstName(){String spousefname = "spouseTestf"+ getUniqueID();return spousefname;}
	public static String getSpouseLastName(){String spouselname = "spouseTestl"+ getUniqueID();return spouselname;}
	
	
	//*********************************GET TIME STAMPS **************************
	
	public static String getTimeStamp(){
		SimpleDateFormat timestamp = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		String timeStamp = timestamp.format(new Date());
		return timeStamp;
	}
	
	public static String getTimeStamp12(){
		SimpleDateFormat timestamp12 = new SimpleDateFormat("MM/dd/yyyy");
		String timeStamp12 = timestamp12.format(new Date());
		return timeStamp12;
	}
 
	public static String getTimeStamp11(){
		SimpleDateFormat timestamp11 = new SimpleDateFormat("M/d/yyyy");
		String timeStamp11 = timestamp11.format(new Date());
		return timeStamp11;
	}
	
	public static String[] dateStr12(){
	//String[] dateStr12 = timeStamp11.split("\\s+");
		String[] dateStr12 = getTimeStamp11().split("\\s+");
		return dateStr12;
	}
	
	
	//************************* GET COMMENTS TO ENTER IN DETAIL PAGE **************************
    public static String commentsToEnter(){	return "TestingPurpose " + getUniqueID();}
	
  //************************* GET EMAIL UPDATE FOR DETAIL PAGE **************************
    public static String emailUpdate(){return "testf"+getUniqueID()+"@updateaccount.com";}
	
	
	

}
