package com.crm.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.Enrollment;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MeetingFlow;
import com.crm.qa.pages.NASF;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.pages.SalesforceTestRestAPI;
import com.crm.qa.pages.Unenrollment;
import com.crm.qa.pages.VerifyAccount;
import com.crm.qa.pages.VerifyTodo;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.pages.HouseholdPage;
import com.crm.qa.pages.CommunicationPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.Validation;
import com.crm.qa.util.ExcelWrite;

public class LogActivityTest extends TestBase {
	
	DetailsPage detailsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	createLead createlead;
	verifyLead verifylead;
	Opportunities opp;
	ReferralAppointment ref;
	SalesforceTestRestAPI sfdc;
	MeetingFlow meetingflow;
	Validation validation;
	ExcelWrite excelWrite;
	SalesforceTestRestAPI sfdcTestRestAPI;
	SalesforceRestAPI sfdcRestAPI;
	RetailAccount retailAccount;
	HouseholdPage householdPage;
	CommunicationPage communicationPage;
	
	VerifyTodo verifyTodo = new VerifyTodo();
	
	String sheetName = "demo";
	
	
	SoftAssert softAssertion = new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		detailsPage = new DetailsPage();
		loginPage = new LoginPage();
		excelWrite = new ExcelWrite();
		sfdcTestRestAPI = new SalesforceTestRestAPI();
		sfdcRestAPI = new SalesforceRestAPI();
		retailAccount = new RetailAccount();
		householdPage = new HouseholdPage();
		communicationPage = new CommunicationPage();
		
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String uname = sfdcData.get("sfdcUsername");
		String upwd = sfdcData.get("sfdcUserpassword");
		homePage = loginPage.login(uname, upwd);
		
		//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test()
	public void debug() throws InterruptedException, ParseException{
		
		SalesforceTestRestAPI.APIConnection();
							
	}
	

	
	@Test()
	public void notReached() throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Not Reached");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation_basic();
		homePage.navigateToRetailuser();			
		detailsPage.enterComments(0);
		SalesforceTestRestAPI.validateTaskData(1);
		softAssertion.assertAll();
		
	}


	
	@Test()
	public void reached() throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Reached");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();			
		detailsPage.enterComments(1);
		SalesforceTestRestAPI.validateTaskData1(1);
	
	}

	
	@Test()
	public void reached_Schedule_Phonecall() throws Exception{
		
		TestUtil.print("Schedule Phone Call");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();			
		detailsPage.reached_schedule(1, "Phone Call");
		SalesforceTestRestAPI.validateTaskData1(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		
	}

		
	@Test()
	public void reached_Schedule_ToDo() throws Exception{
		
		TestUtil.print("Schedule To Do");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();			
		detailsPage.reached_schedule(1, "ToDo");
		SalesforceTestRestAPI.validateTaskData1(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		
	}
	

	@Test()
	public void reached_Schedule_Appointment() throws InterruptedException, ParseException, AWTException{
		
		TestUtil.print("Schedule Appointment");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();				
		detailsPage.reached_scheduleAppointment1();
		SalesforceTestRestAPI.validateMeetingData(3, 0);
	
	}


	
	@Test()
	public void navigateToRetailUser() throws InterruptedException, ParseException{
		
		SalesforceRestAPI.dataCreation();
		homePage.navigateToRetailuser();		
								
	}


	
	@Test()
	public void notReachedwithBusinessLead() throws InterruptedException, ParseException, IOException{
		
		TestUtil.print("Not Reached with Business Lead");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser();			
		detailsPage.enterComments(0);
		SalesforceTestRestAPI.validateTaskData(1);
		SalesforceTestRestAPI.validateLeadData(4);	
								
	}
	
	
	@Test()
	public void reachedwithBusinessLead() throws InterruptedException, ParseException, IOException{
		
		TestUtil.print("Reached with Business Lead");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser();			
		detailsPage.enterComments(1);
		SalesforceTestRestAPI.validateTaskData1(1);
		SalesforceTestRestAPI.validateLeadDataReached(5);	
								
	}
	
	
	@Test()
	public void reachedwithBusinessLead_SchedulePhoneCall() throws Exception{
		
		TestUtil.print("Reached with Business Lead, Schedule Phone Call");
		
		//SalesforceTestRestAPI.APIConnection();
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser();			
		detailsPage.reached_schedule(1, "Phone Call");
		SalesforceTestRestAPI.validateTaskData1(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		SalesforceTestRestAPI.validateLeadDataReached(5);	
								
	}
	
	
	@Test()
	public void reachedwithBusinessLead_ScheduleTodo() throws Exception{
		
		TestUtil.print("Reached with Business Lead, Schedule To Do");
		
		//SalesforceTestRestAPI.APIConnection();
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser();			
		detailsPage.reached_schedule(1, "ToDo");
		SalesforceTestRestAPI.validateTaskData1(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		SalesforceTestRestAPI.validateLeadDataReached(5);	
								
	}
	
	@Test()
	public void reachedwithBusinessLead_ScheduleMeeting() throws InterruptedException, ParseException, AWTException{
		
		
		TestUtil.print("Reached with Business Lead, Schedule Meeting");
		//SalesforceTestRestAPI.APIConnection();
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser();			
		detailsPage.reached_scheduleAppointment1();
		SalesforceTestRestAPI.validateMeetingData(3, 0);
		SalesforceTestRestAPI.validateLeadDataReached(5);	
								
	}
	
	
	@Test()
	public void reachedwithBusinessLead_UnplannedMeeting() throws InterruptedException, ParseException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting");
		
		//SalesforceTestRestAPI.APIConnection();
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser();			
		detailsPage.unplannedAppointment();
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}

	
	@Test()
	public void UnplannedMeeting() throws InterruptedException, ParseException{
		
		TestUtil.print("Setting up an UnPlanned Meeting");
		
		//SalesforceTestRestAPI.APIConnection();
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation_basic();
		homePage.navigateToRetailuser();			
		detailsPage.unplannedAppointment();
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	

	@Test()
	public void meeting_CompleteFlow() throws InterruptedException, ParseException, AWTException{
		
		TestUtil.print("Meeting Complete Flow");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation1();
	
		homePage.navigateToRetailuser();
		detailsPage.reached_scheduleAppointment1();
	
		MeetingFlow meetingflow = new MeetingFlow();
		meetingflow.meetingCompletedFlow();
		
		SalesforceTestRestAPI.validateMeetingData(3, 1);
	
	}

	
	@Test()
	public void meeting_CompleteFlowWithOptions() throws InterruptedException, ParseException, AWTException{
		
		TestUtil.print("Meeting Complete Flow with Options");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.dataCreation1();
		
		homePage.navigateToRetailuser();
		detailsPage.reached_scheduleAppointment1();
		
		MeetingFlow meetingflow = new MeetingFlow();
		meetingflow.meetingCompleteFlowWithOptions();
		
		SalesforceTestRestAPI.validateMeetingData(3, 1);
	
	}
	
	
	
	@Test()
	public void nolead_Reached_createBranchOpportunity() throws InterruptedException, ParseException, IOException {
		
		TestUtil.print("create Branch Opportunity with no Lead and Reached Option");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser();
		
		Opportunities opp = new Opportunities();
		opp.createBranchOpportunity();	
				
		SalesforceTestRestAPI.validateTaskData(1);
		SalesforceTestRestAPI.validateBranchOpportunity(6);	
				
	}
	
	
	@Test()
	public void nolead_Reached_createWorkplaceOpportunity() throws InterruptedException, ParseException, IOException {
		
		TestUtil.print("Create WorkPlace Opportunity with no Lead and Reached Option");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser();
		
		Opportunities opp = new Opportunities();
		opp.createWorkplaceOpportunity();	
		
		SalesforceTestRestAPI.validateTaskData(1);
		SalesforceTestRestAPI.validateWorkPlaceOpportunity(6);	
				
	}
	
	
	
	
	@Test()
	public void LogACallSpouse() throws InterruptedException, IOException, ParseException {
		
		TestUtil.print("Log a Call Spouse");
		
		System.out.println("Running HomePage.navigatetoUser..................... ");
		HomePage.navigateToUser("advisor");
	
		System.out.println("Running SalesforceTestRestAPI.APIConnection()..................... ");
		SalesforceTestRestAPI.APIConnection();
		
		System.out.println("Running homePage.navigateToRetailuser..................... ");
		homePage.navigateToRetailuser();
		
		System.out.println("Running acc.addSpouse..................... ");
		RetailAccount acc = new RetailAccount();
		acc.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		
		System.out.println("Running homePage.navigateToSpouseuser()..................... ");
		homePage.navigateToSpouseuser();
		
		System.out.println("Running detailsPage.enterComments(1)..................... ");
		detailsPage.enterComments(1);
		
		SalesforceTestRestAPI.validateTaskData1(1);
		
	}
	
	
	@Test()
	public void LogaCallwithSpouse_ValidateAtPrimary() throws Exception {
		
		TestUtil.print("Log a Call with Spouse and Validate at Primary");
		
		//CreateRetail2Account();
		System.out.println("Running HomePage.navigatetoUser..................... ");
		HomePage.navigateToUser("advisor");
		
		System.out.println("Running SalesforceTestRestAPI.APIConnection()..................... ");
		SalesforceTestRestAPI.APIConnection();
		
		System.out.println("Running homePage.navigateToRetailuser..................... ");
		homePage.navigateToRetailuser();
		
		System.out.println("Running acc.addSpouse..................... ");
		RetailAccount acc = new RetailAccount();
		acc.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		
		System.out.println("Running homePage.navigateToSpouseuser()..................... ");
		homePage.navigateToSpouseuser();
		
		System.out.println("Running detailsPage.enterComments(1)..................... ");
		detailsPage.enterComments(1);
		
		//System.out.println("Running Salesforce API validateTaskData1(1)..................... ");
		//SalesforceTestRestAPI.validateTaskData1(1);
		
		communicationPage.validateCallonCommunication();
		
	}
	
	
	
	@Test()
	public void CreateAccount_Spouse() throws InterruptedException {
		
		TestUtil.print("Create a Account Spouse");
		
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser();
		
		RetailAccount acc = new RetailAccount();
		acc.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		
		homePage.navigateToSpouseuser();
		
		SalesforceRestAPI.createCTAccount();
				
	}
	
	
	
	@Test()
	public void CreateRetail1Account_Spouse() throws Exception {
		
		TestUtil.print("Create a Retail 1 Account Spouse");
		
		CreateRetail1Account();
		
		RetailAccount acc = new RetailAccount();
		acc.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		
		homePage.navigateToSpouseuser();
		detailsPage.enterComments(1);
				
	}
	
	
	@Test()
	public static void  CreateRetail1Account() throws Exception {
		
		//TestUtil.print("Create a Retail 1 Account");
		System.out.println("Creating Retail 1 Account.........................");
		
		//TestUtil.closeAllOpenTabs(driver);
		
		RetailAccount acc = new RetailAccount();
		acc.createRetailuser(1);
		acc.searchAccount();
		
		
	}
	
	
	
	@Test()
	public void CreateRetail2Account() throws Exception {
		
		//TestUtil.print("Create Retail2 Account");
		System.out.println("Creating Retail 2 Account.........................");
		
		HomePage.navigateToUser("advisor");
		RetailAccount acc = new RetailAccount();
		acc.createRetailuser(2);
		acc.searchAccount();
		
		
	}
	

	
	@Test()
	public void UpdatePrimaryAccountdetails() throws Exception {
		
		TestUtil.print("UpdatePrimaryAccountdetails");
		
		System.out.println("Running HomePage.navigatetoUser..................... ");
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		
		//TestUtil.closeAllOpenTabs(driver);
		
		System.out.println("Running HomePage.navigatetoRetailUser..................... ");
		homePage.navigateToRetailuser();
		
		System.out.println("Running retailAccount.clickAccountAccountScreen..................... ");
		retailAccount.clickAccountviaAccountScreen();
		
		System.out.println("Running detailsPage.updateAccountDetails();..................... ");
		detailsPage.updateAccountDetails();
		System.out.println("Running detailsPage.verifyAccountDetails();..................... ");
		detailsPage.verifyAccountDetails(detailsPage.emailupdate(),"(999) 888-7777","Male","12/11/1972","1234 Test StreetScottsdale, AZ 85254");	
		
		//TestUtil.closeAllOpenTabs(driver);
		
	}
	
	@Test()
	public void UpdateSpouseAccountdetails() throws Exception {
		
		TestUtil.print("UpdateSpouseAccountdetails");
		
		System.out.println("Running HomePage.navigatetoUser..................... ");
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		
		System.out.println("Running HomePage.navigatetoRetailUser..................... ");
		homePage.navigateToRetailuser();
		
		
		System.out.println("Running retailAccount.clickAccountAccountScreen..................... ");
		retailAccount.clickAccountviaAccountScreen();
		
		System.out.println("Running acc.addSpouse..................... ");
		RetailAccount acc = new RetailAccount();
		acc.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		
		System.out.println("Running homePage.navigateToSpouseuser()..................... ");
		homePage.navigateToSpouseuser();
		
		System.out.println("Running detailsPage.updateAccountDetails();..................... ");
		detailsPage.updateAccountDetails();
		
		System.out.println("Running detailsPage.verifyAccountDetails();..................... ");
		detailsPage.verifyAccountDetails(detailsPage.emailupdate(),"(999) 888-7777","Male","12/11/1972","1234 Test StreetScottsdale, AZ 85254");		
	
		//TestUtil.closeAllOpenTabs(driver);
	
	}
	
	
	
	@Test()
	public void nolead_Reached_MultipleOpportunity() throws InterruptedException, ParseException, IOException {
		
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();
		Opportunities opp = new Opportunities();
		opp.createBranchOpportunity();	
		opp.createWorkplaceOpportunity();	
		SalesforceTestRestAPI.validateTaskData(1);
		SalesforceTestRestAPI.validateBranchOpportunity(6);	
		//validate workplace opp
				
	}
	
	
	@Test()
	public void Unenrollment_delinkAccount() throws InterruptedException {
		
		SalesforceTestRestAPI.dataCreation2();
		homePage.navigateToRetailuser();
		Unenrollment unenroll = new Unenrollment();
		unenroll.unenrollmentFlow(2, "Regular");
		unenroll.updateUnenrollCase();
		SalesforceTestRestAPI.verifyFinancialAccount(7, "Regular", true);
	}
	
	@Test()
	public void Unenrollment_TerminateAll() throws InterruptedException {
		
		SalesforceTestRestAPI.dataCreation2();
		homePage.navigateToRetailuser();
		Unenrollment unenroll = new Unenrollment();
		unenroll.unenrollmentFlow(1, "Regular");
		unenroll.updateUnenrollCase();
		SalesforceTestRestAPI.verifyFinancialAccount(7, "Centralised Trading", true);
	}
	
	@Test()
	public void createCTAccount() throws InterruptedException {
		
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();
		NASF newAccount = new NASF();
		newAccount.createAccount(1);
		homePage.navigateToRetailuser();
		newAccount.verifyFinancialData();
		SalesforceTestRestAPI.verifyFinancialAccount(7, "Centralized Trading", false);
		
	}
	
	@Test()
	public void createRPAccount() throws InterruptedException {
		
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();
		NASF newAccount = new NASF();
		newAccount.createAccount(2);
		homePage.navigateToRetailuser();
		newAccount.verifyFinancialData();
		SalesforceTestRestAPI.verifyFinancialAccount(7, "Retirement Paycheck", false);
	}
	
	@Test()
	public void createRegularAccount() throws InterruptedException {
		
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();
		NASF newAccount = new NASF();
		newAccount.createAccount(3);
		homePage.navigateToRetailuser();
		newAccount.verifyFinancialData();
		SalesforceTestRestAPI.verifyFinancialAccount(7, "Regular", false);
	}
	
	@Test()
	public void createFalconAccount() throws InterruptedException {
		
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();
		NASF newAccount = new NASF();
		newAccount.createAccount(4);
		homePage.navigateToRetailuser();
		newAccount.verifyFinancialData();
		SalesforceTestRestAPI.verifyFinancialAccount(7, "Falcon", false);
	}
	
	
	@Test()
	public void createDemoUsers() throws InterruptedException {
		
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();
		NASF newAccount = new NASF();
		newAccount.createAccount(4);
		homePage.navigateToRetailuser();
		newAccount.verifyFinancialData();
		SalesforceTestRestAPI.verifyFinancialAccount(7, "Falcon", false);
	}
	
	
	@DataProvider
	public Object[][] getDemoTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(dataProvider="getDemoTestData")
	public void demoTest(String FirstName, String LastName, String Email, String SpouseFirstName, String SpouseLastName) throws InterruptedException {
		SalesforceTestRestAPI.dataCreation3(FirstName, LastName,Email);
		homePage.navigateToRetailuser();
		RetailAccount acc = new RetailAccount();
		acc.addSpouse(SpouseFirstName, SpouseLastName);
		SalesforceTestRestAPI.dataCreation4(FirstName, LastName);
		
	}	
	
	
	@Test()
	public void createCTAccount1() throws InterruptedException {
		
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();
		NASF newAccount = new NASF();
		newAccount.createAccount(1);
		homePage.navigateToRetailuser();
		newAccount.verifyFinancialData();
		SalesforceTestRestAPI.verifyFinancialAccount(7, "Centralized Trading", false);
		
	}


	
	@Test()
	public void experiment() throws InterruptedException {
		
		HomePage.navigateToUser("advisor");
		TestUtil.closeAllOpenTabs(driver);	
		
	}


	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
		
		
	}

}

