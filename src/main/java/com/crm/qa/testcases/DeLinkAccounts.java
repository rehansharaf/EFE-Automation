package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.crm.qa.base.*;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import com.qa.DataProvider.LogaCallDataProvider;


	public class DeLinkAccounts extends TestBase{

		DetailsPage 		detailsPage;
		LoginPage 			loginPage;
		HomePage 			homePage;
		TestUtil 			testUtil;
		Opportunities 		opp;
		RetailAccount 		retailAccount;
		UnenrollmentDelink  unenrollDelink;
		FinancialPage 		financialPage;
		ServicesPage		servicesPage;
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
		unenrollDelink	= new UnenrollmentDelink();
		financialPage 	= new FinancialPage();
		servicesPage	= new ServicesPage();
		initializeData 	= new InitializeUserData();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		initializeData.setTestCaseonDemandtoNo();
		initializeData.initialize();
	}


	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void createFinancialAccount(String advisorId) throws Exception {
		
		//homePage.navigateToMultipleUser("advisor", advisorId);
		//financialPage.createFinancialAccountviaUI();
		homePage.navigateToMultipleUser("advisor", advisorId);	log.info("Logged in as : " +advisorType(advisorId));
		financialPage.createFinancialAccountviaAPI();		log.info("Created financial account via API");
		
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void prospectCustomer_NoDelink(String advisorId) throws Exception {
		
		TestUtil.print("No Delink Component for Prospect Customer ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);	log.info("Logged in as : " +advisorType(advisorId));
		financialPage.createFinancialAccountviaAPI();		log.info("Created financial account via API");
		unenrollDelink.validationforNoDlink("Client Progression","Prospect" );
	
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void oneAccountTerminateAll(String advisorId) throws Exception {
		
		TestUtil.print("One Financial Account and select Terminate All Option ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);	log.info("Logged in as : " +advisorType(advisorId));
		financialPage.createNumberofFinancialAccountviaUI(1);	log.info("Created financial account via UI");
		servicesPage.validateServicePage("Enrolled", "Branch Management");			log.info("Completed validation of Services Page");
		unenrollDelink.terminateAllAccounts();			log.info("All financial Accounts Delinked");
		servicesPage.validateServicePage("Unenrolled", "Branch Management");		log.info("Completed validation of Services Page");
		
	}
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void multipleFinancialAccountTerminateOne(String advisorId) throws Exception {
	
		TestUtil.print("Multiple Financial Accounts and select only one to Terminate ");
		
		homePage.navigateToMultipleUser("advisor", advisorId);	log.info("Logged in as : " +advisorType(advisorId));
		financialPage.createNumberofFinancialAccountviaUI(2); 	log.info("Created 2 Financial Accounts");
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
