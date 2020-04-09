package com.crm.qa.pages;

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
import java.util.concurrent.TimeUnit;

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
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.*;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.RetailUserdetails;



public class UnenrollmentDelink extends TestBase {

	public UnenrollmentDelink() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//u[contains(text(),'Unenrollment-Delink')]")
	WebElement unerollmentDelinkLbl;
	
	@FindBy(xpath = "//u[contains(text(),'Unenrollment-Delink')]/ancestor::div[@class='content']//button[@title='Next']")
	WebElement unerollmentDelinkNxtBtn;

	@FindBy(xpath = "//div[contains(text(),'Terminate All Accounts')]/../..//span[contains (@class,'radio')]")
	WebElement terminateAllAccountsRdBtn;
	
	@FindBy(xpath = "//span[contains (text(), 'Unenrollment-Delink')]/ancestor::div[@class='content']//button[@title='Next']")
	WebElement unerollDlinkSalesProcessNxtBtn;
	
	@FindBy(xpath="(//span[contains(text(),'Services')])[last()]")
	WebElement servicesLink;
	
	
	
	
	
	
	
	DetailsPage detailsPage = new DetailsPage();
	Opportunities opp = new Opportunities();
	FinancialPage financialPage = new FinancialPage();
	RetailAccount retailaccount = new RetailAccount();
	HomePage homePage = new HomePage();
	
	InitializeUserData initialize = new InitializeUserData();
	
	SoftAssert softAssertion = new SoftAssert();

	

//************************************Terminate all Financial Account via UI**************************************************************************	
	
	public void terminateAllAccounts() throws Exception {	
		
		homePage.navigateToRetailuser("primary");
		
		validateDelinkComponent("Client Progression", "Branch Management");
		
		TestUtil.waitUntilElementVisible(unerollmentDelinkLbl);TestUtil.scrollintoView(unerollmentDelinkLbl);
		TestUtil.clickElement(unerollmentDelinkNxtBtn);
		TestUtil.clickElement(terminateAllAccountsRdBtn);
		TestUtil.clickElement(unerollmentDelinkNxtBtn);
		
		TestUtil.clickElement(unerollDlinkSalesProcessNxtBtn);Thread.sleep(2000);
		TestUtil.clickElement(unerollDlinkSalesProcessNxtBtn);Thread.sleep(2000);
		TestUtil.clickElement(unerollDlinkSalesProcessNxtBtn);Thread.sleep(15000);
		TestUtil.waitUntilElementVisible(servicesLink);
		
	}
	
	

	
//************************************Validate Client Progression Field on Detail Page**************************************************************************	

	 public void validationforNoDlink(String fieldName, String expectedValue) throws InterruptedException, AWTException {
	 		
	 	String actualValue = driver.findElement(By.xpath("(//span[(text()='" +fieldName+ "')]/../..//lightning-formatted-text)[last()]")).getText();
		softAssertion.assertTrue(actualValue.equalsIgnoreCase(expectedValue), "Client Progression is not Prospect");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		List <WebElement> elmentNoFound = driver.findElements(By.xpath("//u[contains(text(),'Unenrollment-Delink')]"));
		softAssertion.assertTrue(elmentNoFound.size()<1);
		
 		softAssertion.assertAll();
	 }
	 	 

	 public void validateNoDelinkOption(String fieldName, String expectedValue) throws InterruptedException, AWTException {
		 
		 
		 
	 }
	 
	 
	 
//************************************Validate Detail Page Fields**************************************************************************	
		
		
		public void validateDelinkComponent(String Field, String expectedValue) throws Exception {
			TestUtil.validatePageField(Field, expectedValue, Field+ " value doesnot match");
			
		}



}
