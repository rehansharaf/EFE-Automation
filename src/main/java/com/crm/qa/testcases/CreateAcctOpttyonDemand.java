package com.crm.qa.testcases;


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
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.util.TestUtil;
import com.qa.DataProvider.*;
import com.crm.qa.base.*;
import com.crm.qa.util.ReadFromExcel;


public class CreateAcctOpttyonDemand extends TestBase {
	
		SalesforceRestAPI	sfdcAPI;
		DetailsPage 		detailsPage;
		LoginPage 			loginPage;
		HomePage 			homePage;
		TestUtil 			testUtil;
		Opportunities 		opp;
		RetailAccount 		retailAccount;
		ReadFromExcel		readfromExcel;
		InitializeUserData 	initializeData;
		

		SoftAssert softAssertion = new SoftAssert();
	
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
	
		testUtil 		= new TestUtil();
		detailsPage 	= new DetailsPage();
		loginPage 		= new LoginPage();
		//retailAccount 	= new RetailAccount();
		sfdcAPI			= new SalesforceRestAPI();
		opp 			= new Opportunities();
		readfromExcel	= new ReadFromExcel();
		initializeData 	= new InitializeUserData();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	

		
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
	

	@SuppressWarnings("static-access")
	@Test(dataProvider = "excelData", dataProviderClass = DataloadFromExcel.class)
	public void creatAccountsWithOpttyOnDemand(String FirstName, String LastName) throws Exception {
		
		TestUtil.print("Create new accounts with opportunity on Demand ");
		
		SalesforceRestAPI.fname = RetailAccount.fname =FirstName;
		SalesforceRestAPI.lname = RetailAccount.lname = LastName;
		
		createBranchOptty_viaAPI();
				
		readfromExcel.writeExcel(detailsPage.getUserNumber(), sfdcAPI.getHashMapData()[0]);
		
		
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
		
		
	}
	

}

