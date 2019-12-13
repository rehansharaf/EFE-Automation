package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DetailsPage__exp2;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MeetingFlow;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.util.TestUtil;


public class MeetingFlowTests extends TestBase{

	DetailsPage__exp2 detailsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	createLead createlead;
	verifyLead verifylead;
	MeetingFlow meetingflow;
	
	String sheetName = "meeting";
		
	   
	public MeetingFlowTests(){
			super();
			
	}

	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		detailsPage = new DetailsPage__exp2();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickSearchInput();
	}
	
	SoftAssert softAssertion = new SoftAssert();
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
		
	@Test(dataProvider="getCRMTestData")
	public void meetingFlowTest(String ActivityType, String Meetclient, String Meetingoutcome) throws InterruptedException {
		MeetingFlow meetingflow = new MeetingFlow();	
		homePage.clickSearchInput();
		meetingflow.meetingWorkflow(ActivityType, Meetclient, Meetingoutcome);
		System.out.println("comments:" + Meetingoutcome);
	}	
	
	
	@Test()
	public void meetingCompleteFlow() throws InterruptedException {
		
		MeetingFlow meetingflow = new MeetingFlow();	
		homePage.clickSearchInput();
		meetingflow.meetingCompletedFlow();		
	}
	
	
	@Test()
	public void meetingCompleteFlowwithoptions() throws InterruptedException {
		
		MeetingFlow meetingflow = new MeetingFlow();	
		homePage.clickSearchInput();
		meetingflow.meetingCompleteFlowWithOptions();
	}
	

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
