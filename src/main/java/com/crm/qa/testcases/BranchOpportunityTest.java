package com.crm.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.pages.SalesforceTestRestAPI;
import com.crm.qa.pages.VerifyAccount;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.pages.RetailAccount__exp2;
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.pages.SalesforceRestAPI_exp2;
import com.crm.qa.util.Log;
import com.crm.qa.util.RetailUserdetails;
import com.crm.qa.util.TestUtil;
import com.qa.ExtentReport.*;
import com.crm.qa.testcases.LogActivityTest;

public class BranchOpportunityTest extends TestBase {
	

	DetailsPage detailsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	createLead createlead;
	verifyLead verifylead;
	Opportunities opp;
	ReferralAppointment ref;
	RetailAccount__exp2 retailAccount;
	
	
	SoftAssert softAssertion = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		detailsPage = new DetailsPage();
		loginPage = new LoginPage();
		retailAccount = new RetailAccount__exp2();
		opp = new Opportunities();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	

	public static void Initialize() throws InterruptedException, ParseException, IOException, InvalidFormatException{
		
		Map<String, String> Data = new HashMap<String, String>();
		Data = RetailUserdetails.getDetailPageData();
		String uid = Data.get("uniqueid");
		SalesforceRestAPI.uid = RetailAccount.uid = DetailsPage.uid = uid;
		
		SalesforceRestAPI.fname = "Testf"+ uid;
		SalesforceRestAPI.lname = "Testl"+ uid;
		SalesforceRestAPI.bname = "Testb"+ uid;
		
		String aname = SalesforceRestAPI.fname+" "+SalesforceRestAPI.lname;
		RetailAccount.aname = aname;
		
		DetailsPage.enteredDate = Data.get("enteredDate");
		DetailsPage.verifyDate = Data.get("verifyDate");
		DetailsPage.meetingDate = Data.get("meetingDate");
		DetailsPage.meetingformattedDate = Data.get("meetingformattedDate");
		DetailsPage.unplannedDate = Data.get("unplannedDate");
		
		
		
	}	
	
	
	
	@Test()

	public void createBranchOptty_viaAPI() throws Exception {
		
		
		Initialize();
		HomePage.navigateToUser("advisor");
		SalesforceTestRestAPI.APIConnection();
		SalesforceTestRestAPI.dataCreation4(SalesforceRestAPI.getFirstName(), SalesforceRestAPI.getLastName());
		opp.navigateTouser("primary");
		opp.validateOpttyCounter(1);
		
	}
	
	
	@Test()
	public void opttyClosedLost_viaAPI() throws Exception {
		
		TestUtil.print("Newly created Opportunity - Mark Opportunity as Closed Lost ");
		
		
		createBranchOptty_viaAPI();
		opp.opportunityClosedLost();
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("Closed Lost", 6);
		opp.validateOpttyforStageStatus("Closed Lost");
		
		
	}
	
	
	
	@Test()
	public void moveStageStatusManually() throws Exception {
		
		TestUtil.print("Newly created Opportunity - Move Stage Status Manually ");
		
		
		createBranchOptty_viaAPI();
		opp.moveOpttyStageManually();
		
	}
	
	
	@Test()
	public void logacall_notReached_Optty() throws Exception {
		
		TestUtil.print("Newly created Opportunity - Log a Call / Not Reached ");
		
		
		createBranchOptty_viaAPI();
		opp.logacall_NotReached();
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("Attempting", 6);
		opp.validateOpttyforStageStatus("Attempting");
		
	}
	
	
	@Test()
	public void logacall_Reached_Optty() throws Exception {
		
		TestUtil.print("Newly created Opportunity - Log a Call / Reached  ");
		
		
		createBranchOptty_viaAPI();
		opp.logacall_Reached();
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("Attempting", 6);
		opp.validateOpttyforStageStatus("Attempting");
		
	}
	

	@Test()
	public void logacall_Reached_StageClosedLost() throws Exception {
		
		TestUtil.print("Newly created Opportunity - Log a Call / Reached - Move Stage to Closed ");
		
		
		createBranchOptty_viaAPI();
		opp.logacall_Reached_StageClosedLost();
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("Closed Lost", 6);
		opp.validateOpttyforStageStatus("Closed Lost");
		
	}
	
	
	@Test()
	public void scheduleMeetingandthenCloseMeeting() throws Exception {
		
		TestUtil.print("Newly created Opportunity - Schedule Meeting and then Close Meeting ");
		
	
		createBranchOptty_viaAPI();
		opp.scheduleandCloseMeeting();
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("Initial Appointment", 6);
		opp.validateOpttyforStageStatus("Initial Appointment");
		
	}
	
	
	@Test()
	public void scheduleMeetingviaNextAction() throws Exception {
		
		TestUtil.print("Newly created Opportunity - Schedule Meeting through Next Action Section ");
		
		
		createBranchOptty_viaAPI();
		opp.scheduleMeetingusingNextAction();
		SalesforceTestRestAPI.validateBranchOpportunity_Stage("Initial Appointment", 6);
		opp.validateOpttyforStageStatus("Initial Appointment");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
