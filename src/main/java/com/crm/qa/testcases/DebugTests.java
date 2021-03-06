package com.crm.qa.testcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Random;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Opportunities;
import com.crm.qa.pages.ReferralAppointment;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.util.TestUtil;


public class DebugTests extends TestBase {
	
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
	
	String sheetName = "sfdcid";
	static String sfdcid;
	
//	public void getCRMTestData(){
//		
//		
//	}
	
	Object[] data1;

	public static String getRandom1(Object[] data) {
		Random rand = new Random();
	   	int randomNumber=rand.nextInt(data.length);
	 	System.out.println(data[randomNumber]);
	    String sfdcid = Arrays.toString((Object[]) data[randomNumber]);
		return sfdcid;
	}
	
	@Test()
	public void notReached1() throws InterruptedException{
		
		Object data[] = TestUtil.getTestData(sheetName);
		String sfdc = getRandom1(data);
	 	System.out.println(sfdc);		
				
		
	}
		
	
		
	
	@Test()
	public void notReached() throws InterruptedException, IOException, ParseException{
		
		homePage.clickSearchInput();			
		//detailsPage.enterComments(0);
		//detailsPage.verifyCommunications(0);
		softAssertion.assertAll();
				
	}
	
	public void test() throws InterruptedException, IOException, ParseException{
		
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

