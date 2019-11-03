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
import com.crm.qa.pages.VerifyAccount;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.util.TestUtil;

public class BranchOpportunityTest extends TestBase {
	
	DetailsPage detailsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	createLead createlead;
	verifyLead verifylead;
	Opportunities opp;
	ReferralAppointment ref;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		detailsPage = new DetailsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
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
	public void createBranchOpportunity() throws InterruptedException {
	
		homePage.clickSearchInput();
		opp.deleteOpportunity();
		opp.createBranchOpportunity();
		opp.verifyBranchOpportunity();
		
	}
	
	@Test()
	public void createWorkplaceOpportunity() throws InterruptedException {
	
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
