package com.crm.qa.testcases;



import java.io.IOException;
import java.text.ParseException;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.FinancialPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.base.InitializeUserData;
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.pages.SalesforceTestRestAPI;
import com.crm.qa.pages.HouseholdPage;
import com.crm.qa.pages.CommunicationPage;
import com.crm.qa.util.TestUtil;
import com.qa.DataProvider.*;



public class LogActivityTest_HouseHold extends TestBase {

	
	DetailsPage detailsPage;
	LoginPage loginPage;
	HomePage homePage;
	Opportunities opp;
	SalesforceTestRestAPI sfdcTestRestAPI;
	SalesforceRestAPI sfdcRestAPI;
	RetailAccount retailAccount;
	HouseholdPage householdPage;
	CommunicationPage communicationPage;
	InitializeUserData initializeData;
	FinancialPage financialPage;
	
	
	
	SoftAssert softAssertion = new SoftAssert();
	static Logger log = Logger.getLogger("trail");
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		
		
		
		detailsPage 		= new DetailsPage();
		loginPage 			= new LoginPage();
		sfdcTestRestAPI 	= new SalesforceTestRestAPI();
		sfdcRestAPI 		= new SalesforceRestAPI();
		retailAccount 		= new RetailAccount();
		householdPage 		= new HouseholdPage();
		communicationPage 	= new CommunicationPage();
		initializeData 		= new InitializeUserData();
		financialPage		= new FinancialPage();
		opp					= new Opportunities();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		initializeData.setTestCaseonDemandtoNo();
		initializeData.initialize();
		
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		
	}
	
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void notReached_multipleUsers(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print(" HouseHold- Not Reached Scenario for Multiple Users");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_basic();		log.info("Complete running SalesforceTestRestAPI.dataCreation_basic()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");			
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction(detailsPage.notReached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateTaskData1(1);			log.info("Complete Validation through API");
		
	
	
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_multipleUsers(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Reached Scenario for Multiple Users");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.APIConnection();		log.info("Complete running SalesforceTestRestAPI.APIConnection()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateTaskData1(1);		log.info("Complete Validation through API");
	
	
	}
	
	
/*	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
	
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();		log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");	
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "No-Show", "MeetingExistNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);		log.info("Complete Validation through API");
	
	}
*/	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withOutcome_NoShow_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();		log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");	
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "No-Show", "MeetingExistNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);		log.info("Complete Validation through API");
	
	
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withOutcome_Cancelled_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");

		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();		log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");			
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "Cancelled", "MeetingExistNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);		log.info("Complete Validation through API");
	
	
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withOutcome_Completed_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();		log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");		
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "Completed", "MeetingExistNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);		log.info("Complete Validation through API");
	
	
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withMeeting_OnPhone_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();		log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");		
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "On-Phone Meeting", "Completed", "MeetingExistNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);		log.info("Complete Validation through API");
	
	
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withMeeting_OnSiteEvent_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();		log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");			
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "On-Site Event", "Completed", "MeetingExistNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);		log.info("Complete Validation through API");
	
	
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeeting_withMeeting_VirtualMeeting_multipleUsers(String advisorId) throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		TestUtil.print("Reached with Business Lead, UnPlanned Meeting for Multiple Users");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();		log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");			
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "Virtual Meeting", "Completed", "MeetingExistNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);		log.info("Complete Validation through API");
	
	
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_Schedule_ToDo(String advisorId) throws Exception{
		
		TestUtil.print("Schedule To Do");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.APIConnection();		log.info("Complete running SalesforceTestRestAPI.APIConnection()");
		homePage.navigateToRetailuser("Primary");	log.info("Open up the Account and log a Call");		
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.reached,  "GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");		log.info("Complete log a call scenario with future activity");
		detailsPage.scheduleFutureActivity("ToDo", "viaLogaCall","On-Phone Meeting");		log.info("Complete adding Meeting for Future Activity");
		SalesforceTestRestAPI.validateTaskData2(1);		log.info("Complete Task Data Validation through API");
		SalesforceTestRestAPI.validateTaskScheduleData(2);		log.info("Complete Task Schedule Data Validation through API");
		
		
	}
	

	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_Schedule_Phonecall(String advisorId) throws Exception{
		
		TestUtil.print("Schedule Phone Call");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.APIConnection();		log.info("Complete running SalesforceTestRestAPI.APIConnection()");
		homePage.navigateToRetailuser("Primary");	log.info("Open up the Account and log a Call");		
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo",  "CreateOpttyNO", "FutureActivityYES");		log.info("Complete log a call scenariowith future acitivity");
		detailsPage.scheduleFutureActivity("PhoneCall","viaLogaCall", "On-Phone Meeting");		log.info("Complete adding Meeting for Future Activity");
		SalesforceTestRestAPI.validateTaskData2(1);		log.info("Complete Task Data Validation through API");
		SalesforceTestRestAPI.validateTaskScheduleData(2);		log.info("Complete Task Schedule Data Validation through API");
		
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reached_Schedule_Appointment(String advisorId) throws Exception{
		
		TestUtil.print("Schedule Appointment");
	
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.APIConnection();		log.info("Complete running SalesforceTestRestAPI.APIConnection()");
		homePage.navigateToRetailuser("Primary");	log.info("Open up the Account and log a Call");			
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.reached,"GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");		log.info("Complete log a call scenariowith future acitivity");
		detailsPage.scheduleFutureActivity("Meeting","viaLogaCall", "On-Phone Meeting");		log.info("Complete adding Meeting for Future Activity");
		SalesforceTestRestAPI.validateMeetingData(3, "Prospect Meeting");		log.info("Complete Meeting Data Validation through API");
	
	}

	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void notReachedwithBusinessLead(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Not Reached with Business Lead");
		
		homePage.navigateToMultipleUser("advisor", advisorId);log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");log.info("Open up the Account and log a Call");			
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.notReached, "GTSconversionNo","CreateOpttyNO", "FutureActivityNO");log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateTaskData1(1);log.info("Complete Task Data Validation through API");
		SalesforceTestRestAPI.validateLeadData(4);	log.info("Complete Lead Data Validation through API");
						
								
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reachedwithBusinessLead(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		TestUtil.print("Reached with Business Lead");
		
		homePage.navigateToMultipleUser("advisor", advisorId);log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");	log.info("Open up the Account and log a Call");		
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo","CreateOpttyNO", "FutureActivityNO");log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateTaskData1(1);log.info("Complete Task Data Validation through API");
		SalesforceTestRestAPI.validateLeadDataReached(5);	log.info("Complete Lead Data Validation through API");
			
								
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reachedwithBusinessLead_SchedulePhoneCall(String advisorId) throws Exception{
		
		TestUtil.print("Reached with Business Lead, Schedule Phone Call");

		homePage.navigateToMultipleUser("advisor", advisorId);log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");	log.info("Open up the Account and log a Call");		
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");log.info("Complete log a call scenario with future activity");
		detailsPage.scheduleFutureActivity("PhoneCall", "viaLogaCall","On-Phone Meeting");log.info("Complete adding Meeting for Future Activity");
		SalesforceTestRestAPI.validateTaskData2(1);log.info("Complete Task Data Validation through API");
		SalesforceTestRestAPI.validateTaskScheduleData(2);log.info("Complete Task Schedule Data Validation through API");
		SalesforceTestRestAPI.validateLeadDataReached(5);log.info("Complete Lead Data Validation through API");	
				
								
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reachedwithBusinessLead_ScheduleTodo(String advisorId) throws Exception{
		
		TestUtil.print("Reached with Business Lead, Schedule To Do");
		
		homePage.navigateToMultipleUser("advisor", advisorId);log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");	log.info("Open up the Account and log a Call");		
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.reached,"GTSconversionNo", "CreateOpttyNO", "FutureActivityYES");log.info("Complete log a call scenario with future activity");
		detailsPage.scheduleFutureActivity("ToDo","viaLogaCall","On-Phone Meeting");log.info("Complete adding Meeting for Future Activity");
		SalesforceTestRestAPI.validateTaskData2(1);log.info("Complete Task Data Validation through API");
		SalesforceTestRestAPI.validateTaskScheduleData(2);log.info("Complete Task Schedule Data Validation through API");
		SalesforceTestRestAPI.validateLeadDataReached(5);log.info("Complete Lead Data Validation through API");	
				
								
	}
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void reachedwithBusinessLead_ScheduleMeeting(String advisorId) throws Exception{
		
		
		TestUtil.print("Reached with Business Lead, Schedule Meeting");
		
		homePage.navigateToMultipleUser("advisor", advisorId);log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_businesslead();log.info("Complete running SalesforceTestRestAPI.dataCreation_businesslead()");
		homePage.navigateToRetailuser("Primary");	log.info("Open up the Account and log a Call");		
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo","CreateOpttyNO", "FutureActivityYES");log.info("Complete log a call scenario with future activity");
		detailsPage.scheduleFutureActivity("Meeting","viaLogaCall","On-Phone Meeting");log.info("Complete adding Meeting for Future Activity");
		SalesforceTestRestAPI.validateMeetingData(3, "Prospect Meeting");log.info("Complete Meeting Data Validation through API");
		SalesforceTestRestAPI.validateLeadDataReached(5);	log.info("Complete Lead Data Validation through API");
			
								
	}
	

	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UnplannedMeetingWithExistingMeeting(String advisorId) throws Exception{
		
		TestUtil.print("Setting up an UnPlanned Meeting with Existing Meeting");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation_basic();		log.info("Complete running SalesforceTestRestAPI.dataCreation_basic()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");		
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteraction( detailsPage.reached, "GTSconversionNo","CreateOpttyNO", "FutureActivityYES");		log.info("Complete log a call scenario");
		detailsPage.scheduleFutureActivity("Meeting","viaLogaCall","On-Phone Meeting");		log.info("Complete schedule Meeting ");
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo","In-Person Meeting", "Completed", "MeetingExistYes");		log.info("Complete log a call scenario eith Meeting");
		SalesforceTestRestAPI.validateUnplannedMeetingData(3);		log.info("Complete Meeting Data Validation through API");
	
	
	}
	
	

	
	@Test(dataProvider = "Imran", dataProviderClass = LogaCallDataProvider.class)
	public void meeting_CompleteFlow(String advisorId) throws Exception{
		
		TestUtil.print("Meeting Complete Flow");
		
		homePage.navigateToMultipleUser("Admin", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.dataCreation1();		log.info("Complete running SalesforceTestRestAPI.dataCreation1()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");
		householdPage.gotoHousehold();		log.info("Go to Household Account");	
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo","In-Person Meeting", "Completed", "MeetingExistNo");		log.info("Complete log a call scenario");
		detailsPage.meetingCompletedFlow();		log.info("Complete Meeting Flow");
		SalesforceTestRestAPI.validateMeetingData(3, "Client Meeting");		log.info("Complete Meeting Data Validation through API");
	
	
	}


	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void UpdateHouseholdAccountdetails(String advisorId) throws Exception {
		
		TestUtil.print("UpdatePrimaryAccountdetails");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.APIConnection();		log.info("Complete running SalesforceTestRestAPI.APIConnection()");
		homePage.navigateToRetailuser("Primary");	log.info("Open up the Account and update Accuont details");
		householdPage.gotoHousehold();				log.info("Go to Household Account");	
		householdPage.updateAccountDetails();		log.info("Complete updating Account Details");
		householdPage.verifyAccountDetails(detailsPage.emailupdate(),"12/11/1972", "Male");			log.info("Complete validating Account details");
		
	}
	
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void nolead_Reached_createBranchOpportunity(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {
		
		TestUtil.print("create Branch Opportunity with no Lead and Reached Option");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.APIConnection();		log.info("Complete running SalesforceTestRestAPI.APIConnection()");
		homePage.navigateToRetailuser("Primary");	log.info("Open up the Account and log a Call");
		householdPage.gotoHousehold();				log.info("Go to Household Account");	
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");		log.info("Complete log a call scenario");
		opp.createBranchOpportunity("viaLogaCall");		log.info("Complete creating Branch Optty");
		SalesforceTestRestAPI.validateTaskData(1);		log.info("Complete Task Data Validation through API");
		SalesforceTestRestAPI.validateBranchOpportunity(6);			log.info("Complete creating Branch Optty through API");
			
				
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void nolead_Reached_createWorkplaceOpportunity(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {
		
		TestUtil.print("Create WorkPlace Opportunity with no Lead and Reached Option");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		
		//********Using a particular account for Workplace Optty scenario. Once the issue is resolved we remove the comments from the following two lines of code
		//SalesforceTestRestAPI.APIConnection();
		//homePage.navigateToRetailuser("Primary");
		
		//This line can be removed once the issue is resolved.
		householdPage.gotoHousehold();				log.info("Go to Household Account");	
		driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/r/Account/0010R00000vhxshQAA/view");  log.info("Navigate to the Account");
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");		log.info("Complete log a Call scenario");
		opp.createWorkplaceOpportunity();		log.info("Complete creating WorkPlace optty");
		SalesforceTestRestAPI.validateTaskData(1);		log.info("Complete Task Data Validation through API");
		SalesforceTestRestAPI.validateWorkPlaceOpportunity(6);		log.info("Complete creating WorkPlace Optty through API");
					
	}
	
		
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void nolead_Reached_MultipleOpportunity(String advisorId) throws InterruptedException, ParseException, IOException, InvalidFormatException {

		homePage.navigateToMultipleUser("advisor", advisorId);	log.info("Logged in as : " +advisorType(advisorId));
		SalesforceTestRestAPI.APIConnection();		log.info("Complete running SalesforceTestRestAPI.APIConnection()");
		homePage.navigateToRetailuser("Primary");		log.info("Open up the Account and log a Call");
		householdPage.gotoHousehold();				log.info("Go to Household Account");	
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");		log.info("Complete log a call scenario");
		opp.createWorkplaceOpportunity();		log.info("Complete creating WorkPlace optty");
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");		log.info("Complete log a call scenario");
		opp.createBranchOpportunity("vialogaCall");		log.info("Complete creating Branch Optty");
		SalesforceTestRestAPI.validateBranchOpportunity(6);			log.info("Complete creating Branch Optty through API");
		SalesforceTestRestAPI.validateWorkPlaceOpportunity(6);		log.info("Complete creating WorkPlace Optty through API");
				
	}
	

	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
