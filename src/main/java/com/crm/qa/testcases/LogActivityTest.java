package com.crm.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;



import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.FinancialPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MeetingFlow;
import com.crm.qa.pages.NASF;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.base.InitializeUserData;
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.pages.SalesforceTestRestAPI;
import com.crm.qa.pages.Unenrollment;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.pages.HouseholdPage;
import com.crm.qa.pages.CommunicationPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.Validation;
import com.crm.qa.util.ExcelWrite;
import com.qa.DataProvider.*;


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
	InitializeUserData initializeData;
	FinancialPage financialPage;
	
	//VerifyTodo verifyTodo = new VerifyTodo();
	
	String sheetName = "demo";
	
	
	SoftAssert softAssertion = new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		
		
		testUtil 			= new TestUtil();
		detailsPage 		= new DetailsPage();
		loginPage 			= new LoginPage();
		excelWrite 			= new ExcelWrite();
		sfdcTestRestAPI 	= new SalesforceTestRestAPI();
		sfdcRestAPI 		= new SalesforceRestAPI();
		retailAccount 		= new RetailAccount();
		householdPage 		= new HouseholdPage();
		communicationPage 	= new CommunicationPage();
		initializeData 		= new InitializeUserData();
		financialPage		= new FinancialPage();
		opp					= new Opportunities();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		initializeData.initialize();
		
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		
	}
	
	
	
	@Test()
	public void debug() throws InterruptedException, ParseException{
		
		SalesforceTestRestAPI.APIConnection();
							
	}
	

	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void notReached_multipleUsers(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Not Reached Scenario for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_basic();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.logacallInteraction(detailsPage.notReached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");
		SalesforceTestRestAPI.validateTaskData1(1);
		softAssertion.assertAll();
		
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_multipleUsers(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Reached Scenario for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser("Primary");
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");
		SalesforceTestRestAPI.validateTaskData1(1);
	
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "No-Show", "MeetingExistNO");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void logaCall_Reached_Household_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Log a Call (Reached) through Household, Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser("Household");
		//householdPage.gotoHousehold();
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");
		SalesforceTestRestAPI.validateTaskData1(1);
	
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void logaCall_NotReached_Household_multipleUsers(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Log a Call (Not Reached) through Household, Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_basic();
		homePage.navigateToRetailuser("Household");			
		householdPage.enterComments(0);
		SalesforceTestRestAPI.validateTaskData(1);
		softAssertion.assertAll();
		
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void logaCall_UnplannedMeeting_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");			
		householdPage.unplannedAppointment();
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	

	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_Schedule_ToDo(String advisorId) throws Exception{
		
		TestUtil.print("Schedule To Do");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.logacallInteraction( detailsPage.reached,  "GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("ToDo");
		SalesforceTestRestAPI.validateTaskData2(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		
	}
	

	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_Schedule_Phonecall(String advisorId) throws Exception{
		
		TestUtil.print("Schedule Phone Call");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo",  "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("PhoneCall");
		SalesforceTestRestAPI.validateTaskData2(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_Schedule_Appointment(String advisorId) throws Exception{
		
		TestUtil.print("Schedule Appointment");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser("Primary");				
		detailsPage.logacallInteraction( detailsPage.reached,"GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("Meeting");
		SalesforceTestRestAPI.validateMeetingData(3, 0);
	
	}


	
	@Test()
	public void navigateToRetailUser() throws InterruptedException, ParseException{
		
		SalesforceRestAPI.dataCreation();
		homePage.navigateToRetailuser("Primary");		
								
	}


	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void notReachedwithBusinessLead(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Not Reached with Business Lead");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.logacallInteraction( detailsPage.notReached, "GTSconversionNo","CreateOpttyNO", "FutureActivityNO");
		SalesforceTestRestAPI.validateTaskData(1);
		SalesforceTestRestAPI.validateLeadData(4);	
								
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reachedwithBusinessLead(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Reached with Business Lead");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo","CreateOpttyNO", "FutureActivityNO");
		SalesforceTestRestAPI.validateTaskData1(1);
		SalesforceTestRestAPI.validateLeadDataReached(5);	
								
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reachedwithBusinessLead_SchedulePhoneCall(String advisorId) throws Exception{
		
		TestUtil.print("Reached with Business Lead, Schedule Phone Call");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("PhoneCall");
		SalesforceTestRestAPI.validateTaskData2(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		SalesforceTestRestAPI.validateLeadDataReached(5);	
								
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reachedwithBusinessLead_ScheduleTodo(String advisorId) throws Exception{
		
		TestUtil.print("Reached with Business Lead, Schedule To Do");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.logacallInteraction( detailsPage.reached,"GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("ToDo");
		SalesforceTestRestAPI.validateTaskData2(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		SalesforceTestRestAPI.validateLeadDataReached(5);	
								
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reachedwithBusinessLead_ScheduleMeeting(String advisorId) throws Exception{
		
		
		TestUtil.print("Reached with Business Lead, Schedule Meeting");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo","CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("Meeting");
		SalesforceTestRestAPI.validateMeetingData(3, 0);
		SalesforceTestRestAPI.validateLeadDataReached(5);	
								
	}
	


	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeetingWithExistingMeeting(String advisorId) throws Exception{
		
		TestUtil.print("Setting up an UnPlanned Meeting with Existing Meeting");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_basic();
		homePage.navigateToRetailuser("Primary");			
		detailsPage.scheduleFutureActivity("Meeting");
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo","In-Person Meeting", "Completed", "MeetingExistYes");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	
//Need to work on it
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void meeting_CompleteFlow(String advisorId) throws Exception{
		
		TestUtil.print("Meeting Complete Flow");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation1();
	
		homePage.navigateToRetailuser("Primary");
		//detailsPage.logacallInteraction( detailsPage.reached,"GTSconversionNo", "CreateOpttyNO", "FutureActivityYes");
		//detailsPage.scheduleFutureActivity("Meeting");
	
		detailsPage.reached_scheduleAppointment1(1);
		
		MeetingFlow meetingflow = new MeetingFlow();
		meetingflow.meetingCompletedFlow();
		
		SalesforceTestRestAPI.validateMeetingData(3, 1);
	
	}

//Need to work on it	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void meeting_CompleteFlowWithOptions(String advisorId) throws InterruptedException, ParseException, AWTException, InvalidFormatException, IOException{
		
		TestUtil.print("Meeting Complete Flow with Options");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation1();
		
		homePage.navigateToRetailuser("Primary");
		detailsPage.reached_scheduleAppointment1(1);
		
		MeetingFlow meetingflow = new MeetingFlow();
		meetingflow.meetingCompleteFlowWithOptions();
		
		SalesforceTestRestAPI.validateMeetingData(3, 1);
	
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void LogACallSpouse(String advisorId) throws InterruptedException, IOException, ParseException, InvalidFormatException {
		
		TestUtil.print("Log a Call Spouse");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		householdPage.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		homePage.navigateToSpouseuser();
		
		detailsPage.logacallInteraction( detailsPage.reached,"GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");
	
		SalesforceTestRestAPI.validateTaskData1(1);
		
	}
	
	
	@SuppressWarnings("static-access")
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void LogaCallwithSpouse_ValidateAtPrimary(String advisorId) throws Exception {
		
		TestUtil.print("Log a Call with Spouse and Validate at Primary");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		householdPage.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		homePage.navigateToSpouseuser();
		
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo","CreateOpttyNO", "FutureActivityNO");
		
		communicationPage.validateCallonCommunication();
		
	}
	
	
	@SuppressWarnings("static-access")
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void CreateAccount_Spouse(String advisorId) throws InterruptedException, InvalidFormatException, ParseException, IOException {
		
		TestUtil.print("Create a Account Spouse");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		householdPage.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		
		homePage.navigateToSpouseuser();
		
		SalesforceRestAPI.createCTAccount();
				
	}
	
	

	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UpdatePrimaryAccountdetails(String advisorId) throws Exception {
		
		TestUtil.print("UpdatePrimaryAccountdetails");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		//retailAccount.clickAccountviaAccountScreen();
		
		detailsPage.updateAccountDetails();
		detailsPage.verifyAccountDetails(detailsPage.emailupdate(),"(999) 888-7777","Male","12/11/1972","1234 Test StreetScottsdale");	
		
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UpdateSpouseAccountdetails(String advisorId) throws Exception {
		
		TestUtil.print("UpdateSpouseAccountdetails");
	
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		//retailAccount.clickAccountviaAccountScreen();
		householdPage.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		
		homePage.navigateToSpouseuser();
		detailsPage.updateAccountDetails();
		
		detailsPage.verifyAccountDetails(detailsPage.emailupdate(),"(999) 888-7777","Male","12/11/1972","1234 Test StreetScottsdale");		

	
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void nolead_Reached_createBranchOpportunity(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {
		
		TestUtil.print("create Branch Opportunity with no Lead and Reached Option");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");
		opp.createBranchOpportunity();	
				
		SalesforceTestRestAPI.validateTaskData(1);
		SalesforceTestRestAPI.validateBranchOpportunity(6);	
				
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void nolead_Reached_createWorkplaceOpportunity(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {
		
		TestUtil.print("Create WorkPlace Opportunity with no Lead and Reached Option");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");
		opp.createWorkplaceOpportunity();	
		
		SalesforceTestRestAPI.validateTaskData(1);
		SalesforceTestRestAPI.validateWorkPlaceOpportunity(6);	
				
	}
	
		
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void nolead_Reached_MultipleOpportunity(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser("Primary");
		Opportunities opp = new Opportunities();
		opp.createBranchOpportunity();	
		opp.createWorkplaceOpportunity();	
		SalesforceTestRestAPI.validateBranchOpportunity(6);	
		SalesforceTestRestAPI.validateWorkPlaceOpportunity(6);
		
				
	}
	

	@Test(dataProvider = "Robert", dataProviderClass = LogaCallDataProvider.class)
	public void validateFinancialDataForSponsoredClient(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {
		
		TestUtil.print("Validate Financial Data for Sponsored Client");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		homePage.navigateToSponsoredClient("0010R00000CSdLHQA1");
		financialPage.validateWorkplaceDetailsScreen();
				
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void validateEmail(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {
		
		TestUtil.print("Validate Email screen under Email Tab");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_basic();
		homePage.navigateToRetailuser("Primary");
		detailsPage.validateEmail();
				
	}
	
	
	
	
	
	
/*	//********************These Scripts are working but should not be a part of Regression****************************************
	
	@SuppressWarnings("static-access")
	@Test()
	public void CreateRetail1Account_Spouse() throws Exception {
		
		TestUtil.print("Create a Retail 1 Account Spouse");
		
		CreateRetail1Account();
		
		householdPage.addSpouse(retailAccount.spousefname, retailAccount.spouselname);
		
		homePage.navigateToSpouseuser();
		detailsPage.logacallInteraction( detailsPage.reached, "CreateOpttyNO", "FutureActivityNO");
				
	}
	
	
	@Test()
	public  void  OnlyCreateRetail_1_Account() throws Exception {
		
		System.out.println("Creating Retail 1 Account.........................");
		retailAccount.createRetailuser(1);
		retailAccount.searchAccount();
		
	}
	
	
	@Test()
	public void  CreateRetail1Account() throws Exception {
		
		System.out.println("Creating Retail 1 Account.........................");
		retailAccount.createRetailuser(1);
		retailAccount.searchAccount();
		
	}
	
	
	@Test()
	public void OnlyCreateRetail_2_Account() throws Exception {
		
		System.out.println("Creating Retail 2 Account.........................");
		
		HomePage.navigateToUser("advisor");
		retailAccount.createRetailuser(2);
		retailAccount.searchAccount();
		
	}
	
	
	@Test()
	public void CreateRetail2Account() throws Exception {
		
		System.out.println("Creating Retail 2 Account.........................");
		
		HomePage.navigateToUser("advisor");
		retailAccount.createRetailuser(2);
		retailAccount.searchAccount();
	}
	
*/	
	
	
	
	
	
/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	***************** OLD SCRIPTS. Keeping it for future Use***************************************************
----------------------------------------------------------------------------------------------------------------------------------------------------------------------*/	
	
/*	
	
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
		householdPage.addSpouse(SpouseFirstName, SpouseLastName);
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
		driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/r/Account/0010R00000v0rNNQAY/view");
	
		
		 if (driver.findElements(By.xpath("//*[@class='slds-button__icon slds-button__icon--large']")).size() != 0){
			 Thread.sleep(3000);driver.findElement(By.xpath("//*[@class='slds-button__icon slds-button__icon--large']")).click();Thread.sleep(2000);}
		 
		 
	}
*/

	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
		
		
	}

}

