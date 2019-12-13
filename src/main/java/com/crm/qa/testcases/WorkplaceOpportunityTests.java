package com.crm.qa.testcases;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DetailsPage__exp2;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;
import com.crm.qa.pages.VerifyAccount;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.util.TestUtil;

public class WorkplaceOpportunityTests extends TestBase {
	
	DetailsPage__exp2 detailsPage;
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
		detailsPage = new DetailsPage__exp2();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test()
	public void lead_reachedWithOpportunity() throws InterruptedException{
		
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		createLead createlead = new createLead();
		createlead.createnewlead();
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		Opportunities opp = new Opportunities();
		opp.createWorkplaceOpportunity(1, "test");	
		verifylead.navigateLeadReached(1);
		opp.verifyWorkplaceOpportunity();		
		detailsPage.verifyCommunications(1);	
	}
	
	
	@Test()
	public void lead_reachedWithOpportunity_scheduleAppointment() throws InterruptedException{
		
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		createLead createlead = new createLead();
		createlead.createnewlead();
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		Opportunities opp = new Opportunities();
		opp.createWorkplaceOpportunity(1, "Appointment");	
		verifylead.navigateLeadReached(1);
		opp.verifyWorkplaceOpportunity();		
		detailsPage.verifyCommunications(1);	
	}
	
	@Test()
	public void lead_reachedWithOpportunity_Todo() throws InterruptedException{
		
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		createLead createlead = new createLead();
		createlead.createnewlead();
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		Opportunities opp = new Opportunities();
		opp.createWorkplaceOpportunity(1, "ToDo");	
		verifylead.navigateLeadReached(1);
		opp.verifyWorkplaceOpportunity();		
		detailsPage.verifyCommunications(1);	
	}
	
	@Test()
	public void lead_reachedWithOpportunity_Phonecall() throws InterruptedException{
		
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		createLead createlead = new createLead();
		createlead.createnewlead();
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		Opportunities opp = new Opportunities();
		opp.createWorkplaceOpportunity(1, "Phone Call");	
		verifylead.navigateLeadReached(1);
		opp.verifyWorkplaceOpportunity();		
		detailsPage.verifyCommunications(1);	
	}
	
	@Test()
	public void nolead_Reached_createWorkplaceOpportunity() throws InterruptedException {
		
		homePage.clickSearchInput();
		Opportunities opp = new Opportunities();
		opp.createWorkplaceOpportunity(1, "test");		
		opp.verifyWorkplaceOpportunity();		
		detailsPage.verifyCommunications(1);
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
