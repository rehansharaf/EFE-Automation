package com.crm.qa.testcases;


import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MeetingFlow;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.util.TestUtil;


public class MeetingFlowTests extends TestBase{

	DetailsPage detailsPage;
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
		detailsPage = new DetailsPage();
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
/*		
	@Test(dataProvider="getCRMTestData")
	public void meetingFlowTest(String ActivityType, String Meetclient, String Meetingoutcome) throws InterruptedException {
		MeetingFlow meetingflow = new MeetingFlow();	
		homePage.clickSearchInput();
		meetingflow.meetingWorkflow(ActivityType, Meetclient, Meetingoutcome);
		System.out.println("comments:" + Meetingoutcome);
	}	
	
*/	
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
