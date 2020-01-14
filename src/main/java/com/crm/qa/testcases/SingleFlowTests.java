package com.crm.qa.testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;

import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.util.TestUtil;

public class SingleFlowTests extends TestBase {
	
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

	
/*	
	@Test()
	public void scheduleAppointment() throws InterruptedException {
		
		
		homePage.clickSearchInput();

		
	}
	
	@Test()
	public void CreateLead() throws InterruptedException{
		
		createlead.createnewlead();
	
	}
	
	@Test()
	public void deleteLead() throws InterruptedException{
	
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
	
	}
	
	@Test()
	public void deleteOpportunity() throws InterruptedException{
		
		homePage.clickSearchInput();	
		opp.deleteOpportunity();
	}
	
	
	
	@Test()
	public void createBranchOpportunity() throws InterruptedException, ParseException, IOException {
	
		homePage.clickSearchInput();
		opp.createBranchOpportunity();
		opp.verifyBranchOpportunity();

	}
	

	
	
	
	@Test() 
	public void verifyAccount() throws InterruptedException {
		
		homePage.clickSearchInput();
		VerifyAccount acc = new VerifyAccount();
		acc.verifyacc();		
	}
*/	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
