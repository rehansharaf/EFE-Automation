package com.crm.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

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
import com.crm.qa.pages.VerifyAccount;
import com.crm.qa.pages.VerifyTodo;
import com.crm.qa.pages.createLead;
import com.crm.qa.pages.verifyLead;
import com.crm.qa.util.TestUtil;


public class LogActivityTests extends TestBase {
	
	DetailsPage detailsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	createLead createlead;
	verifyLead verifylead;
	Opportunities opp;
	ReferralAppointment ref;
	SalesforceRestAPI sfdc;
	
	VerifyTodo verifyTodo = new VerifyTodo();
	
	
//	SoftAssert softAssertion = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		detailsPage = new DetailsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("(//a[@id='appTile'])[8]")).click();
		SalesforceRestAPI.APIConnection();
		
	}
	
	@Test()
	public void reached() throws InterruptedException, ParseException, IOException{
		
		homePage.clickSearchInput();			
		detailsPage.enterComments(1);
		detailsPage.verifyCommunications(1,"Schedule");
//		softAssertion.assertAll();
		
	}
	
	
	@Test()
	public void reachedCloseExistingTask() throws InterruptedException, ParseException{
		
		homePage.clickSearchInput();			
		detailsPage.closeExistingTask(1);
		softAssertion.assertAll();
		
	}
	
	@Test()
	public void notReachedCloseExistingTask() throws InterruptedException, ParseException{
		
		homePage.clickSearchInput();			
		detailsPage.closeExistingTask(0);
		softAssertion.assertAll();
		
	}
	
	
	@Test()
	public void notReached() throws InterruptedException, ParseException, IOException{
		
		homePage.clickSearchInput();			
		detailsPage.enterComments(0);
		detailsPage.verifyCommunications(0,"Schedule");
//		detailsPage.verifyAll(0);
//		softAssertion.assertAll();
							
	}
	
	@Test()
	public void notReached1() throws InterruptedException, ParseException, IOException{
		
		homePage.clickSearchInput();			
		detailsPage.enterComments(0);
		
		//Added by Imran since queryTaskObject is expecting an integer not a String.
		int i = Integer.parseInt(prop.getProperty("retailsfdcId"));
		
		//old command
		//SalesforceRestAPI.queryTaskObject(prop.getProperty("retailsfdcId"));
		
		SalesforceRestAPI.queryTaskObject(i);
		
//		detailsPage.verifyAll(0);
//		softAssertion.assertAll();
							
	}
	
	@Test()
	public void reached_Schedule_Phonecall() throws Exception{
		
		homePage.clickSearchInput();			
		detailsPage.reached_schedule(1, "Phone Call");
		VerifyTodo verifyTodo = new VerifyTodo();
		verifyTodo.verifyPhoneFutureTask();
		detailsPage.verifyCommunications(1, "Phone Call");
	
							
	}
	
	@Test()
	public void reached_Schedule_ToDo() throws Exception{
		
		homePage.clickSearchInput();			
		detailsPage.reached_schedule(1,"ToDo");
		VerifyTodo verifyTodo = new VerifyTodo();
		verifyTodo.verifyTodoFutureTask();
		detailsPage.verifyCommunications(1,"ToDo");
							
	}
	
	
	@Test()
	public void reached_Schedule_Appointment() throws InterruptedException, ParseException, AWTException{
		
		homePage.clickSearchInput();			
		detailsPage.reached_scheduleAppointment1();
		VerifyTodo verifyTodo = new VerifyTodo();
		verifyTodo.verifyFutureMeetingTask();
											
	}
	
	
	@Test()
	public void notReachedWithLead() throws InterruptedException, ParseException, IOException{
				
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		createLead createlead = new createLead();
		//createlead.createnewlead();
		homePage.clickSearchInput();
		detailsPage.enterComments(0);
		verifylead.navigateLeadNotReached();
		homePage.clickSearchInput();
		detailsPage.verifyCommunications(0, "Schedule");
		softAssertion.assertAll();
	
	}
	
	
	@Test()
	public void debugTest() {
		
		createLead createlead = new createLead();
		createlead.debuglead();
	}
	
	

	@Test()
	public void debugTest1() throws InterruptedException {
		
		RetailAccount ret = new RetailAccount();
		//ret.createRetailuser();
		ret.validRetailuser();
	}
	
	@Test()
	public void debugTest3() throws InterruptedException {
		
		RetailAccount ret = new RetailAccount();
	//	ret.createRetailuser();
		//ret.addSpouse();
	}
	

	@Test()
	public void debugTest2() throws InterruptedException {
		
		homePage.clickRetailSearchInput();
		Enrollment enr = new Enrollment();
		enr.navigateToForms();
		enr.createRegularAccount();
		enr.processCase();
		
	}
	
	
	@Test()
	public void debugTest4() throws Exception {
		
		RetailAccount ret = new RetailAccount();
		ret.createRetailuser(1);
		ret.validRetailuser();
	}
	
	
	@Test()
	public void reachedWithLead() throws InterruptedException, ParseException, IOException{
		
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		createLead createlead = new createLead();
		//createlead.createnewlead();
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		detailsPage.enterComments(1);
		verifylead.navigateLeadReached(1);
		homePage.clickSearchInput();
		detailsPage.verifyCommunications(1, "Schedule");
		
	}
	
	@Test()
	public void reachedWithLead_SchedulePhonecall() throws Exception{
		
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		createLead createlead = new createLead();
		//createlead.createnewlead();
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		detailsPage.reached_schedule(1, "Phone Call");
		verifylead.navigateLeadReached(1);
		homePage.clickSearchInput();
		detailsPage.verifyCommunications(1, "Phone Call");
		
	}
	
	/*
	@Test()
	public void reachedWithLead_ScheduleToDo() throws InterruptedException, ParseException{
		
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		createLead createlead = new createLead();
		createlead.createnewlead();
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		detailsPage.reached_schedule(1, "ToDo");
		verifylead.navigateLeadReached(1);
		detailsPage.verifyCommunications(1, "ToDo");
		
	}
	
	@Test()
	public void reachedWithLead_ScheduleAppointment() throws InterruptedException, ParseException{
		
		homePage.clickSearchInput();
		verifyLead verifylead = new verifyLead();
		verifylead.deleteLead();
		createLead createlead = new createLead();
		createlead.createnewlead();
		homePage.clickSearchInput();
		verifylead.clickLeadLink();
		detailsPage.reached_schedule(1, "Appointment");
		verifylead.navigateLeadReached(1);
		homePage.clickSearchInput();
		detailsPage.verifyCommunications(1, "Appointment");
		
	}
	
*/	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		sfdc.releaseConnection();
	}

}

