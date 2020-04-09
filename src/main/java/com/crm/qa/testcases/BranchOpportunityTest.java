package com.crm.qa.testcases;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.pages.SalesforceTestRestAPI;
import com.crm.qa.util.Log;
import com.crm.qa.util.TestUtil;
import com.qa.DataProvider.*;
import com.qa.ExtentReport.*;
import com.crm.qa.base.*;



public class BranchOpportunityTest extends TestBase {
	
		DetailsPage 		detailsPage;
		LoginPage 			loginPage;
		HomePage 			homePage;
		TestUtil 			testUtil;
		Opportunities 		opp;
		RetailAccount 		retailAccount;
		InitializeUserData 	initializeData;
		
		SoftAssert softAssertion = new SoftAssert();
		static Logger log = Logger.getLogger("trail");
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
	
		testUtil 		= new TestUtil();
		detailsPage 	= new DetailsPage();
		loginPage 		= new LoginPage();
		retailAccount 	= new RetailAccount();
		opp 			= new Opportunities();
		initializeData 	= new InitializeUserData();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		initializeData.setTestCaseonDemandtoNo();
		initializeData.initialize();
	}

/*	
	//@Test()
	public void createBranchOptty_viaAPI() throws Exception {

		SalesforceTestRestAPI.APIConnection();
		SalesforceTestRestAPI.dataCreation4(SalesforceRestAPI.fname, SalesforceRestAPI.lname);
		homePage.navigateToRetailuser("Primary");
		opp.validateOpttyCounter(1);
		
	}
	
*/	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void opttyClosedLost_viaAPI(String advisorId) throws Exception {
		
		TestUtil.print("Newly created Opportunity - Mark Opportunity as Closed Lost ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		opp.createBranchOptty_viaAPI();		log.info("Complete running opp.createBranchOptty_viaAPI()");
		opp.clickOpportunity();			log.info("Opportunity Selected");
		opp.opportunityClosedLost();	log.info("Oppty moved to Closed/Lost");
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("NAC Outbound","Closed Lost", "$125,000", 6);		log.info("Complete Validating Branch Optty");
		opp.validateOpttyforStageStatus("Closed Lost");		log.info("Complete Validating Optty Stage as Closed/Lost");
				
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void moveStageStatusManually(String advisorId) throws Exception {
		
		TestUtil.print("Newly created Opportunity - Move Stage Status Manually ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		opp.createBranchOptty_viaAPI();		log.info("Complete running opp.createBranchOptty_viaAPI()");
		opp.moveOpttyStageManually();		log.info("Complete moving optty stage Manually");
		
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void logacall_notReached_Optty(String advisorId) throws Exception {
		
		TestUtil.print("Newly created Opportunity - Log a Call / Not Reached ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		opp.createBranchOptty_viaAPI();		log.info("Complete running opp.createBranchOptty_viaAPI()");
		detailsPage.logacallInteraction(detailsPage.notReached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("NAC Outbound","Attempting", "$125,000", 6);		log.info("Complete Validating Optty details");
		opp.clickOpportunity();		log.info("Opportunity Selected");
		opp.validateOpttyforStageStatus("Attempting");	log.info("Complete validaating optty stage as Attempting");
		
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void logacall_Reached_Optty(String advisorId) throws Exception {
		
		TestUtil.print("Newly created Opportunity - Log a Call / Reached  ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		opp.createBranchOptty_viaAPI();		log.info("Complete running opp.createBranchOptty_viaAPI()");
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("NAC Outbound","Attempting", "$125,000", 6);		log.info("Complete Validating Optty details");
		opp.clickOpportunity();		log.info("Opportunity Selected");
		opp.validateOpttyforStageStatus("Attempting");		log.info("Complete validaating optty stage as Attempting");
		
	}
	

	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void logacall_Reached_StageClosedLost(String advisorId) throws Exception {
		
		TestUtil.print("Newly created Opportunity - Log a Call / Reached - Move Stage to Closed ");
		
		homePage.navigateToMultipleUser("advisor", advisorId); 		log.info("Logged in as : " +advisorType(advisorId));
		opp.createBranchOptty_viaAPI();		log.info("Complete running opp.createBranchOptty_viaAPI()");
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");		log.info("Complete log a call scenario");
		opp.clickOpportunity();		log.info("Opportunity Selected");
		opp.opportunityClosedLost();		log.info("Move Optty stage to Closed/Lost  ");
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("NAC Outbound","Closed Lost", "$125,000", 6);
		opp.validateOpttyforStageStatus("Closed Lost");		log.info("Complete validaating optty stage as Closed/Lost");
		
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void scheduleMeetingandthenCloseMeeting(String advisorId) throws Exception {
		
		TestUtil.print("Newly created Opportunity - Schedule Meeting and then Close Meeting ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		opp.createBranchOptty_viaAPI();		log.info("Complete running opp.createBranchOptty_viaAPI()");
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "Completed", "MeetingExistNO");		log.info("Complete log a call scenario");
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("NAC Outbound","Initial Appointment", "$125,000", 6);
		opp.clickOpportunity();		log.info("Opportunity Selected");
		opp.validateOpttyforStageStatus("Initial Appointment");		log.info("Complete validaating optty stage as Initial Apointment");
		
	}
	
	
	@Test(dataProvider = "Ian", dataProviderClass = LogaCallDataProvider.class)
	public void scheduleMeetingviaNextAction(String advisorId) throws Exception {
		
		TestUtil.print("Newly created Opportunity - Schedule Meeting through Next Action Section ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		opp.createBranchOptty_viaAPI();		log.info("Complete running opp.createBranchOptty_viaAPI()");
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");		log.info("Complete log a call scenario");
		opp.clickOpportunity();		log.info("Opportunity Selected");
		opp.scheduleMeetingusingNextAction("On-Phone Meeting");
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("NAC Outbound","Initial Appointment", "$125,000", 6);
		opp.validateOpttyforStageStatus("Initial Appointment");		log.info("Complete validaating optty stage as Initial Apointment");
		
	}
	

	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void enrollment_BM(String advisorId) throws Exception {
		
		TestUtil.print("BM Opportunity - Add a Financial Account ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);		log.info("Logged in as : " +advisorType(advisorId));
		opp.createBranchOptty_viaAPI();		log.info("Complete running opp.createBranchOptty_viaAPI()");
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");		log.info("Complete log a call scenario");
		opp.clickOpportunity();		log.info("Opportunity Selected");
		opp.enrollinBM();			log.info("Completed Enrolling in Branch  ");
		opp.addNumberofFinancialAccounts(1); log.info("Added Financial Account  ");
		opp.validateFinancialAccount();		log.info("Complete Validation of Financial Account ");
		
		
	}
	

	
/*------------------------------------------------------------------------------------------------------------------------	
	
*******************************************Old Scripts. May need them in future****************************************
	
//------------------------------------------------------------------------------------------------------------------------	*/
	//This functionality is removed	
/*
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void createNewFinancialAccount_BMOptty(String advisorId) throws Exception {
		
		TestUtil.print("Create a New Financial Account ");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		
		opp.createBranchOptty_viaAPI();
		opp.clickOpportunity();
		opp.createFinancialAccount();
		SalesforceTestRestAPI.verifyFinancialAccount(7, "true", 1);
		
		
	}
*/
	
	
	/*	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void changeStageStatus(String advisorId) throws Exception {
		
		TestUtil.print("Change Opportunity Stage Stauses ");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		opp.createBranchOptty_viaAPI();
		opp.clickOpportunity();
		opp.changeStatusTo("Stage", "Attempting");
		opp.changeStatusTo("Stage", "Initial Appointment");
		opp.changeStatusTo("Stage", "Follow-Up Appointment");
		opp.changeStatusTo("Stage", "Client Setup");
		opp.changeStatusTo("Stage", "Transfers Pending");
		opp.changeStatusTo("Stage", "Closed");
		
	}
	
	*/
	
	
	
	
	
	
	
	
	@Test(description = "Experiment 1 - Test Case.")
	public void exp(Method method) throws Exception {
		Log.info("Test is Starting.....");
		/*
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		
		SalesforceTestRestAPI.dataCreation4(SalesforceRestAPI.getFirstName(), SalesforceRestAPI.getLastName());
	
		//SalesforceTestRestAPI.validateBranchOpportunity(6);
		*/
		//logger.log(Status.INFO, "test example");
		ExtentTestManager.startTest(method.getName(), "Test Case Description.");
		
		driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/r/Account/0010R00000uzeBZQAY/view");
		//logger.log(Status.INFO, "Navigate to SFDC Account");
		Log.info("Navigate to the URL");
		driver.findElement(By.xpath("//label[contains (@for, ('scheduleAnAppointmentChoice'))]//span[contains (@class, ('slds-radio--faux'))]")).click();
		Log.info("Find Element1");
		driver.findElement(By.xpath("//div[contains (@class,('slds-box'))]//footer//button[contains (@title,'Next')]")).click();
		Log.info("Find Button");
		
		
		
	}
	
	
/*	
	@Test()
	
	public void createBranchOptty_viaUI() throws Exception {
		
		//TestUtil.print("create Branch Opportunity ");
		
		//LogActivityTest.CreateRetail1Account();
		System.out.println("Running HomePage.navigatetoUser..................... ");
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		
		TestUtil.closeAllOpenTabs(driver);
		
		System.out.println("Running HomePage.navigatetoRetailUser..................... ");
		homePage.navigateToRetailuser();
		
		System.out.println("Running retailAccount.clickAccountAccountScreen..................... ");
		retailAccount.clickAccountviaAccountScreen();
		
		System.out.println("Running opp.createBranchOpportunity()..................... ");
		//Opportunities opp = new Opportunities();
		opp.createBranchOpportunity();
		
	}
	
	
	
	@Test()
	
	public void createandverifyBranchOptty_viaUI() throws Exception {
		
		TestUtil.print("create and verify Branch Opportunity ");
		createBranchOptty_viaUI();
		opp.verifyBranchOppty();
		TestUtil.closeAllOpenTabs(driver);
		
	}
	
	
	@Test()
	public void opttyClosedLost_viaUI() throws Exception {
		
		TestUtil.print("Newly created Opportunity - Mark Opportunity as Closed Lost ");
		createBranchOptty_viaUI();
		opp.opportunityClosedLost();
		//TestUtil.closeAllOpenTabs(driver);
		
	}
	
	
*/	
	
	
	/*
	@Test()
	public void nolead_Reached_createBranchOpportunity() throws InterruptedException, ParseException, IOException {
		
		TestUtil.print("create Branch Opportunity with no Lead and Reached Option");
		
		HomePage.navigateToUser("advisor");
		
		System.out.println("Running SalesforceTestRestAPI..................... ");
		SalesforceTestRestAPI.APIConnection();
		
		System.out.println("Running homePage.navigateToRetailuser()..................... ");
		homePage.navigateToRetailuser();
		
		System.out.println("Running opp.createBranchOpportunity()..................... ");
		//Opportunities opp = new Opportunities();
		opp.createBranchOpportunity();	
		
		
		
		
		//System.out.println("Running SalesforceTestRestAPI..................... ");
		//SalesforceTestRestAPI.validateTaskData(1);
		
		//System.out.println("Running SalesforceTestRestAPI..................... ");
		//SalesforceTestRestAPI.validateBranchOpportunity(6);	
		
		TestUtil.closeAllOpenTabs(driver);
				
	}
	*/
	
	/*----------------------------------------------------------------------------------------------------------*/
	
	/*
	
	
	@Test()
	public void createBranchOpportunity_Schedulerefapp() throws InterruptedException, ParseException, IOException {
			
		homePage.clickSearchInput();
		Opportunities opp = new Opportunities();
		opp.deleteOpportunity();
		String[] meetingLinks = detailsPage.scheduleReferralAppointment();
		opp.createBranchOpportunity();
		detailsPage.verifyMeetingAll(meetingLinks[1]);
		detailsPage.VerifyMeetings(meetingLinks[0]);
		opp.verifyBranchOpportunity();		
		
	}
	
	@Test()
	public void businessLead_CreateBranchOpportunity() throws InterruptedException, ParseException, IOException {
			
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		opp.deleteOpportunity();
		createLead createlead = new createLead();
		createlead.createnewlead(1);
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		opp.createBranchOpportunity();
		opp.verifyBranchOpportunity();	
		verifylead.verifyBusinessLead();
		
	}
	
	@Test()
	public void branchLead_CreateBranchOpportunity() throws InterruptedException, ParseException, IOException {
			
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		opp.deleteOpportunity();
		createLead createlead = new createLead();
		createlead.createnewlead(0);
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		opp.createBranchOpportunity();
		opp.verifyBranchOpportunity();	
		verifylead.verifyBranchLead();
		
	}
	
	@Test()
	public void createBranchOpportunity() throws InterruptedException, ParseException, IOException {
	
		homePage.clickSearchInput();
		opp.deleteOpportunity();
		opp.createBranchOpportunity();
		opp.verifyBranchOpportunity();
		
	}
	
	@Test()
	public void createWorkplaceOpportunity() throws InterruptedException, ParseException, IOException {
	
		homePage.clickSearchInput();
		opp.deleteOpportunity();
		opp.createWorkplaceOpportunity();
		opp.verifyWorkplaceOpportunity();
		
	}
	
	@Test()
	public void businessLead_CreateWorkplaceOpportunity() throws InterruptedException, ParseException, IOException {
			
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		opp.deleteOpportunity();
		createLead createlead = new createLead();
		createlead.createnewlead(1);
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		opp.createWorkplaceOpportunity();
		opp.verifyWorkplaceOpportunity();	
		verifylead.verifyBusinessLead();
		
	}
	
	*/
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
