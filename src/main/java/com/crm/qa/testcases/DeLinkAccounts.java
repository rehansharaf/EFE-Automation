package com.crm.qa.testcases;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.*;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import com.qa.DataProvider.LogaCallDataProvider;
import com.crm.qa.util.RetailUserdetails;

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
		
		//HomePage.navigateToMultipleUser("advisor", advisorId);
		//financialPage.createFinancialAccountviaUI();
		HomePage.navigateToMultipleUser("advisor", advisorId);
		financialPage.createFinancialAccountviaAPI();
		
	}
	
	
	
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void prospectCustomer_NoDelink(String advisorId) throws Exception {
		
		TestUtil.print("No Delink Component for Prospect Customer ");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		financialPage.createFinancialAccountviaAPI();
		unenrollDelink.validationforNoDlink("Client Progression","Prospect" );
	
	}
	
	
	@Test(dataProvider = "multipleUsers", dataProviderClass = LogaCallDataProvider.class)
	public void oneAccountTerminateAll(String advisorId) throws Exception {
		
		TestUtil.print("One Financial Account and select Terminate All Option ");
		
		HomePage.navigateToMultipleUser("advisor", advisorId);
		financialPage.createFinancialAccountviaUI();
		servicesPage.validateServicePage("Enrolled", "Branch Management");
		unenrollDelink.terminateAllAccounts();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
