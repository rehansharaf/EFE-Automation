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



public class LogActivityTest_HouseHold extends TestBase {

	
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
		
		TestUtil.print(" HouseHold- Not Reached Scenario for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_basic();
		homePage.navigateToRetailuser("Primary");	
		//householdPage.gotoHouseholdviaAcctScreen();
		householdPage.gotoHousehold();
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
		//householdPage.gotoHouseholdviaAcctScreen();
		householdPage.gotoHousehold();
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");
		SalesforceTestRestAPI.validateTaskData1(1);
	
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");	
		//householdPage.gotoHouseholdviaAcctScreen();
		householdPage.gotoHousehold();
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "No-Show", "MeetingExistNO");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	

	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withOutcome_NoShow_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");
		householdPage.gotoHousehold();
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "No-Show", "MeetingExistNO");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withOutcome_Cancelled_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");	
		householdPage.gotoHousehold();
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "Cancelled", "MeetingExistNO");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withOutcome_Completed_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");	
		householdPage.gotoHousehold();
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "Completed", "MeetingExistNO");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withMeeting_OnPhone_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");
		householdPage.gotoHousehold();
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "On-Phone Meeting", "Completed", "MeetingExistNO");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withMeeting_OnSiteEvent_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");		
		householdPage.gotoHousehold();
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "On-Site Event", "Completed", "MeetingExistNO");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withMeeting_VirtualMeeting_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");		
		householdPage.gotoHousehold();
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "Virtual Meeting", "Completed", "MeetingExistNO");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	
	

	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_Schedule_ToDo(String advisorId) throws Exception{
		
		TestUtil.print("Schedule To Do");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser("Primary");	
		householdPage.gotoHousehold();
		detailsPage.logacallInteraction( detailsPage.reached,  "GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("ToDo", "viaLogaCall");
		SalesforceTestRestAPI.validateTaskData2(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		
	}
	

	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_Schedule_Phonecall(String advisorId) throws Exception{
		
		TestUtil.print("Schedule Phone Call");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser("Primary");
		householdPage.gotoHousehold();
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo",  "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("PhoneCall","viaLogaCall");
		SalesforceTestRestAPI.validateTaskData2(1);
		SalesforceTestRestAPI.validateTaskScheduleData(2);
		
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_Schedule_Appointment(String advisorId) throws Exception{
		
		TestUtil.print("Schedule Appointment");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser("Primary");	
		householdPage.gotoHousehold();
		detailsPage.logacallInteraction( detailsPage.reached,"GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("Meeting","viaLogaCall");
		SalesforceTestRestAPI.validateMeetingData(3, 0);
	
	}


	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void notReachedwithBusinessLead(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Not Reached with Business Lead");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_businesslead();
		homePage.navigateToRetailuser("Primary");
		householdPage.gotoHousehold();
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
		householdPage.gotoHousehold();
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
		householdPage.gotoHousehold();
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("PhoneCall", "viaLogaCall");
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
		householdPage.gotoHousehold();
		detailsPage.logacallInteraction( detailsPage.reached,"GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("ToDo","viaLogaCall");
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
		householdPage.gotoHousehold();
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo","CreateOpttyNO", "FutureActivityYES");
		detailsPage.scheduleFutureActivity("Meeting","viaLogaCall");
		SalesforceTestRestAPI.validateMeetingData(3, 0);
		SalesforceTestRestAPI.validateLeadDataReached(5);	
								
	}
	


	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeetingWithExistingMeeting(String advisorId) throws Exception{
		
		TestUtil.print("Setting up an UnPlanned Meeting with Existing Meeting");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.dataCreation_basic();
		homePage.navigateToRetailuser("Primary");	
		householdPage.gotoHousehold();
		detailsPage.scheduleFutureActivity("Meeting","viaLogaCall");
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo","In-Person Meeting", "Completed", "MeetingExistYes");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);
	
	}
	
	

	@SuppressWarnings("static-access")
	@Test(dataProvider = "Imran", dataProviderClass = LogaCallDataProvider.class)
	public void meeting_CompleteFlow(String advisorId) throws Exception{
		
		TestUtil.print("Meeting Complete Flow");
		
		homePage.navigateToMultipleUser("Admin", advisorId);
		SalesforceTestRestAPI.dataCreation1();
	
		homePage.navigateToRetailuser("Primary");
		householdPage.gotoHousehold();
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo","In-Person Meeting", "Completed", "MeetingExistNo");

		detailsPage.meetingCompletedFlow();
		
		SalesforceTestRestAPI.validateMeetingData(3, 1);
	
	}


	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UpdateHouseholdAccountdetails(String advisorId) throws Exception {
		
		TestUtil.print("UpdatePrimaryAccountdetails");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		householdPage.gotoHousehold();
		householdPage.updateAccountDetails();
		householdPage.verifyAccountDetails(detailsPage.emailupdate(),"12/11/1972", "Male");	
		
	}
	
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void nolead_Reached_createBranchOpportunity(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {
		
		TestUtil.print("create Branch Opportunity with no Lead and Reached Option");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		householdPage.gotoHousehold();
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");
		opp.createBranchOpportunity("viaLogaCall");	
				
		SalesforceTestRestAPI.validateTaskData(1);
		SalesforceTestRestAPI.validateBranchOpportunity(6);	
				
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void nolead_Reached_createWorkplaceOpportunity(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {
		
		TestUtil.print("Create WorkPlace Opportunity with no Lead and Reached Option");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		SalesforceTestRestAPI.APIConnection();
		
		homePage.navigateToRetailuser("Primary");
		householdPage.gotoHousehold();
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
		householdPage.gotoHousehold();
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");
		opp.createWorkplaceOpportunity();
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");
		opp.createBranchOpportunity("vialogaCall");

		SalesforceTestRestAPI.validateBranchOpportunity(6);	
		SalesforceTestRestAPI.validateWorkPlaceOpportunity(6);
		
				
	}
	

	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
