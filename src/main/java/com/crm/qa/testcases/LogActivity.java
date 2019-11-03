package com.crm.qa.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.Enrollment;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.pages.SalesforceTestRestAPI;
import com.crm.qa.pages.VerifyAccount;
import com.crm.qa.pages.VerifyTodo;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.ExcelWrite;
import java.util.HashMap;


public class LogActivity extends TestBase {
	
	DetailsPage detailsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	createLead createlead;
	verifyLead verifylead;
	Opportunities opp;
	ReferralAppointment ref;
	SalesforceTestRestAPI sfdc;
	ExcelWrite excelWrite;
	
	VerifyTodo verifyTodo = new VerifyTodo();
	
	
	
	SoftAssert softAssertion = new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		detailsPage = new DetailsPage();
		loginPage = new LoginPage();
		excelWrite = new ExcelWrite();

		String uname = sfdcData.get("sfdcUsername");
		String upwd =  sfdcData.get("sfdcUserpassword");
		
		homePage = loginPage.login(uname, upwd);
	//	homePage = loginPage.login(sfdcData.get("sfdcUsername"), sfdcData.get("sfdcUserpassword"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		
		//driver.findElement(By.xpath("(//a[@id='appTile'])[8]")).click();
		
		
		
	}
	
	
	@Test()
	public void notReached() throws InterruptedException, ParseException, InvalidFormatException, IOException{
		
		/* 
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();
		SalesforceTestRestAPI.validateTaskData(1);
		softAssertion.assertAll();
		*/
		excelWrite.writeTestCaseResults("LogActivity", "Not Reached","1", "GetUsername", "imransharaf", "Pass", "Output1","Output2");
		excelWrite.writeValidationResults("Yes", "This", "works", "Yeeehaww");
	}
	
	@Test()
	public void reached() throws InterruptedException, ParseException{
		
		SalesforceTestRestAPI.APIConnection();
		homePage.navigateToRetailuser();			
		detailsPage.enterComments(1);
		SalesforceTestRestAPI.validateTaskData1(1);
									
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
		
	}

}

