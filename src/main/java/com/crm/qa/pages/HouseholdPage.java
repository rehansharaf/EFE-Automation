package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.LogActivityTest;
import com.crm.qa.util.Validation;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.google.common.base.Function;
import com.crm.qa.util.TestUtil;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;


public class HouseholdPage extends TestBase {

	DetailsPage detailsPage= new DetailsPage();
	
	
	
	@FindBy(xpath="//span[@class='title'][contains(text(),'Household')]")
	WebElement householdTab;
	
	@FindBy(xpath="(//div[contains(@class,'col main-col slds-size--6-of-12')]//li)[2]")
	WebElement householdTablink;
	
	@FindBy(xpath="//a[contains(text(),'Co-Client')]")
	WebElement co_clientlink;
	
	@FindBy(xpath="//button[contains(text(),'Household')]")
	WebElement householdBtn;
	
	@FindBy(xpath = "(//div[contains(text(),'Comments')]/../../../following-sibling::div/div/textarea)[last()]")
	WebElement commentsTextarea;
	
	@FindBy(xpath = "(//div[contains(text(),'Outcome')]/../../../following-sibling::div/select)[last()]")
	WebElement outcome;
	
	@FindBy(xpath = "(//div[contains(text(),'Management')])[last()]")
	WebElement solutionsDiscussed;
	
	@FindBy(xpath = "(//div[@data-component-id = 'flowruntime_interview']//button[contains(text(),'Next')])[last()]")
	WebElement logCallNextButton;
	
	@FindBy(xpath = "(//label[contains (@for, ('No_Selected'))])[last()]")
	WebElement noOpttyRdBtn;
	
	
	@FindBy(xpath = "(//input[contains (@name ,'Subject')])[last()]")
	WebElement subjectArea;
	
	@FindBy(xpath = "((//input[contains (@name ,'Start_Date_and_Time')])[1])[last()]")
	WebElement meetingStartDate1;
	
	
	@FindBy(xpath = "((//input[contains (@name ,'Start_Date_and_Time')])[2])[last()]")
	WebElement meetingStartTime1;

	
	@FindBy(xpath = "((//input[contains (@name ,'End_Date_and_Time')])[1])[last()]")
	WebElement meetingEndDate1;

	@FindBy(xpath = "((//input[contains (@name ,'End_Date_and_Time')])[2])[last()]")
	WebElement meetingEndTime1;
		
	@FindBy(xpath = "(//div[contains(text(),'How Did You Meet With Client')]/../../../following-sibling::div/select)[last()]")
	WebElement meetwithClient;
	
	@FindBy(xpath = "(//div[contains(text(),'Select Meeting Outcome')]/../../../following-sibling::div/select)[last()]")
	WebElement meetingOutcome;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/..//following-sibling::button)[last()]")
	WebElement nextButton1;
	
	@FindBy(xpath = "(//span[contains(text(),'Create Opportunity')])[last()]")
	WebElement CreateOpportunityLabel;
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	public HouseholdPage() {
		 
		PageFactory.initElements(driver, this);
		
		}
	
	
	public void switchtoCoClient() throws InterruptedException{
	
		TestUtil.waitForElement("Household", householdTab);
		Thread.sleep(3000);
		householdTab.click();
		
		TestUtil.waitForElement("Co-Client", co_clientlink);
		Thread.sleep(3000);
		co_clientlink.click();
		
		Thread.sleep(3000);
	}
	
	public void enterComments(int i) throws InterruptedException, ParseException{
		
		@SuppressWarnings("static-access")
		String commentsToEnter = "TestingPurpose " + detailsPage.uid;
		
	
		householdTab.click();
		
		Thread.sleep(2000);
		householdBtn.click();
		Thread.sleep(3000);
		
		commentsTextarea.sendKeys(commentsToEnter);
		
		Thread.sleep(2000);
		selectOutcome(i);
		
		solutionsDiscussed.click();
		
		logCallNextButton.click();
		
		Thread.sleep(5000);
		
		noOpttyRdBtn.click();
		
		logCallNextButton.click();
		
		
	}
	
	
@SuppressWarnings("static-access")
public void unplannedAppointment() throws InterruptedException, ParseException {
		
		String commentsToEnter = "TestingPurpose " + detailsPage.uid;
		
        householdTab.click();
				
		Thread.sleep(2000);
		householdBtn.click();
		
		Thread.sleep(3000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		Thread.sleep(3000);
		TestUtil.SelectDropDownOption(outcome, "Meeting");
		solutionsDiscussed.click();
	
		//clickNextButton();
		
		logCallNextButton.click();
		
		Thread.sleep(3000);
		subjectArea.sendKeys(commentsToEnter);
		
		meetingEndDate1.sendKeys(detailsPage.unplannedDate);
		meetingEndTime1.click();
		meetingEndTime1.clear();
		meetingEndTime1.sendKeys("8:00 PM");
		meetingEndTime1.sendKeys(Keys.TAB);
		
		nextButton1.click();
		
		Thread.sleep(3000);
		TestUtil.SelectDropDownOption(meetwithClient, "In-Person Meeting");
		
		TestUtil.SelectDropDownOption(meetingOutcome, "No-Show");
		
		nextButton1.click();
			
	}
	
	
	
	
	
	
	
	
	
	
	
	public void selectOutcome(int i) throws InterruptedException, ParseException {
		
		if (i==0){TestUtil.SelectDropDownOption(outcome, "Phone Call - Not Reached");}
		else if(i==1){TestUtil.SelectDropDownOption(outcome, "Phone Call - Reached");}
		else if(i==2){TestUtil.SelectDropDownOption(outcome, "Meeting");}
		
		}	
	
	
}
