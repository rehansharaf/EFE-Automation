package com.crm.qa.validation;


import java.text.ParseException;

import org.json.JSONArray;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
import java.util.HashMap;

import com.crm.qa.base.TestBase;


public class APIValidation extends SalesforceRestAPI {

	static SalesforceRestAPI APIValidation = new SalesforceRestAPI();
	
	public static void prereq (){
		
		
		
	}
}
