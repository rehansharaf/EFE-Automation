package com.crm.qa.testcases;

import java.text.ParseException;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;
import com.crm.qa.pages.SalesforceTestRestAPI;
import com.crm.qa.pages.VerifyAccount;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.util.TestUtil;
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
	RetailAccount retailAccount;
	
	
	SoftAssert softAssertion = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		detailsPage = new DetailsPage();
		loginPage = new LoginPage();
		retailAccount = new RetailAccount();
		opp = new Opportunities();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	@Test()
	
	public void createBranchOptty() throws Exception {
		
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
	
	public void createandverifyBranchOptty() throws Exception {
		
		TestUtil.print("create and verify Branch Opportunity ");
		
		createBranchOptty();
		
		opp.verifyBranchOppty("New");
		
		TestUtil.closeAllOpenTabs(driver);
		
	}
	
	@Test()
	public void opttyClosedLost() throws Exception {
		
		TestUtil.print("Newly created Opportunity - Mark Opportunity as Closed Lost ");
		
		createBranchOptty();
		
		opp.opportunityClosedLost();
		
		TestUtil.closeAllOpenTabs(driver);
		
	}
	
	
	
	
	
	
	
	
	
	
	@Test()
	public void nolead_Reached_createBranchOpportunity() throws InterruptedException, ParseException {
		
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
	
	
	
	
	
	
	
	@Test()
	public void createBranchOpportunity_Schedulerefapp() throws InterruptedException, ParseException {
			
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
	public void businessLead_CreateBranchOpportunity() throws InterruptedException, ParseException {
			
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
	public void branchLead_CreateBranchOpportunity() throws InterruptedException, ParseException {
			
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
	public void createBranchOpportunity() throws InterruptedException, ParseException {
	
		homePage.clickSearchInput();
		opp.deleteOpportunity();
		opp.createBranchOpportunity();
		opp.verifyBranchOpportunity();
		
	}
	
	@Test()
	public void createWorkplaceOpportunity() throws InterruptedException, ParseException {
	
		homePage.clickSearchInput();
		opp.deleteOpportunity();
		opp.createWorkplaceOpportunity();
		opp.verifyWorkplaceOpportunity();
		
	}
	
	@Test()
	public void businessLead_CreateWorkplaceOpportunity() throws InterruptedException, ParseException {
			
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
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
