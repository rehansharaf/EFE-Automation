package com.crm.qa.testcases;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DetailsPage__exp2;
import com.crm.qa.pages.Enrollment;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MeetingFlow;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;
import com.crm.qa.pages.RetailAccount__exp2;
import com.crm.qa.pages.SalesforceRestAPI_exp2;
import com.crm.qa.pages.SalesforceTestRestAPI;
import com.crm.qa.pages.VerifyAccount;
import com.crm.qa.pages.VerifyTodo;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.util.TestUtil;


public class APITests extends TestBase {
	
	DetailsPage__exp2 detailsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	createLead createlead;
	verifyLead verifylead;
	Opportunities opp;
	ReferralAppointment ref;
	SalesforceTestRestAPI sfdc;
	MeetingFlow meetingflow;
	
	VerifyTodo verifyTodo = new VerifyTodo();
	
	
	
	
	SoftAssert softAssertion = new SoftAssert();
	
	
	
	@Test()
	public void createService() throws InterruptedException {
		
		SalesforceTestRestAPI.dataCreation2();
	}
	
	
	
	
	
	

}

