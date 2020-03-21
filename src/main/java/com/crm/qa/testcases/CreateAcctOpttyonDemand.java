package com.crm.qa.testcases;

import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.pages.SalesforceTestRestAPI;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.util.Log;
import com.crm.qa.util.TestUtil;
import com.qa.DataProvider.*;
import com.qa.ExtentReport.*;
import com.crm.qa.base.*;



public class CreateAcctOpttyonDemand extends TestBase {
	
		DetailsPage 		detailsPage;
		LoginPage 			loginPage;
		HomePage 			homePage;
		TestUtil 			testUtil;
		createLead 			createlead;
		verifyLead 			verifylead;
		Opportunities 		opp;
		ReferralAppointment ref;
		RetailAccount 		retailAccount;
		InitializeUserData 	initializeData;
		
		
		//Variables to generate Specific name Accounts
		//public static int i=-1, j= -1;
		
		
		SoftAssert softAssertion = new SoftAssert();
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
	
		testUtil 		= new TestUtil();
		detailsPage 	= new DetailsPage();
		loginPage 		= new LoginPage();
		retailAccount 	= new RetailAccount();
		opp 			= new Opportunities();
		initializeData 	= new InitializeUserData();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		//Variables counters to generate Specific name Accounts
		//i=i+1; j=j+1;
		
		initializeData.setTestCaseonDemandtoYes();
		initializeData.initialize();
	}

	
	@Test()
	public void createBranchOptty_viaAPI() throws Exception {

		SalesforceTestRestAPI.APIConnection();
		SalesforceTestRestAPI.dataCreation4(SalesforceRestAPI.fname, SalesforceRestAPI.lname);
		homePage.navigateToRetailuser("Primary");
		opp.validateOpttyCounter(1);
		
		
	}
	

	@Test(dataProvider = "excelData", dataProviderClass = DataloadFromExcel.class)
	public void creatAccountsWithOpttyOnDemand(String FirstName, String LastName) throws Exception {
		
		TestUtil.print("Create new accounts with opportunity on Demand ");
		
		SalesforceRestAPI.fname = RetailAccount.fname =FirstName;
		SalesforceRestAPI.lname = RetailAccount.lname = LastName;
		
		createBranchOptty_viaAPI();
		
		
	}
	
	
	

}

