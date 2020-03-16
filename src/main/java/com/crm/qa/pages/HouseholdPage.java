package com.crm.qa.pages;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import com.crm.qa.pages.DetailsPage;


public class HouseholdPage extends TestBase {

	
	//@FindBy(xpath="//span[@class='title'][contains(text(),'Household')]")
	//WebElement householdTab;
	
	@FindBy(xpath="//a[text()='Household']")
	WebElement householdTab;
	
	@FindBy(xpath="(//div[contains(@class,'col main-col slds-size--6-of-12')]//li)[2]")
	WebElement householdTablink;
	
	@FindBy(xpath="//button[contains(text(),'Household')]")
	WebElement householdBtn;
	
	@FindBy(xpath="//a[contains(text(),'Co-Client')]")
	WebElement co_clientlink;
	
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

	
	//@FindBy(xpath = "((//input[contains (@name ,'End_Date_and_Time')])[1])[last()]")
	//WebElement meetingEndDate1;

	@FindBy(xpath = "(//span[contains(text(),'Start Date and Time')]/../../..//input)[1]")
	WebElement meetingEndDate1;
	
	//@FindBy(xpath = "((//input[contains (@name ,'End_Date_and_Time')])[2])[last()]")
	//WebElement meetingEndTime1;
	
	@FindBy(xpath = "(//span[contains(text(),'Start Date and Time')]/../../..//input)[2]")
	WebElement meetingEndTime1;
	
	@FindBy(xpath = "(//div[contains(text(),'How Did You Meet With Client')]/../../../following-sibling::div/select)[last()]")
	WebElement meetwithClient;
	
	@FindBy(xpath = "(//div[contains(text(),'Select Meeting Outcome')]/../../../following-sibling::div/select)[last()]")
	WebElement meetingOutcome;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/..//following-sibling::button)[last()]")
	WebElement nextButton1;
	
	@FindBy(xpath="//div[contains(@class, 'modal-body')]//button[contains(@class, 'slds-button')]")
	WebElement nextButton;
	
	@FindBy(xpath="//div[contains(text(),'GST$')]/ancestor::div[@class='content']//button")
	WebElement gstNextBtn;
	
	@FindBy(xpath = "(//span[contains(text(),'Create Opportunity')])[last()]")
	WebElement CreateOpportunityLabel;
	
	@FindBy(xpath="//button[contains(text(),'Add Co-Client')]")
	WebElement addCoclient;
	
	@FindBy(xpath="//span[contains(text(),'Add Household Member')]")
	WebElement householdMember;
	
	@FindBy(xpath="//span[contains(text(),'Create New Account')]/../../..//span[@class='slds-checkbox_faux']")
	WebElement createNewAccount;
		
	@FindBy(xpath="//div[contains(@class, 'modal-body')]//input[contains(@name,'Partner_Spouse_First_Name')]")
	WebElement spouseFirstName;
		
	@FindBy(xpath="//div[contains(@class, 'modal-body')]//input[contains(@name,'Partner_Spouse_Last_Name')]")
	WebElement spouseLastName;
	
	@FindBy(xpath="//div[contains(@class, 'modal-body')]//div[contains(@class,'slds-form-element')]//input[@name ='DOB']")
	WebElement spouseDOB;
	
	@FindBy(xpath="//div[contains(text(),'Female')]")
	WebElement genderSelection;
		
	@FindBy(xpath="(//a[contains(text(),'Not Set')])[1]")
	WebElement genderdropdown;
		
	@FindBy(xpath="//label[contains(@class, 'slds-radio__label')]//div[contains(text(), 'Spouse')]")
	WebElement relationshipSelection;
	
	@FindBy(xpath="//a[contains(text(),'Co-Client')]")
	WebElement coClientButton;
	
	@FindBy(xpath="//button[contains(text(),'Finish')]")
	WebElement coClientFinishButton;
	
	//------------------------------------------------------------------------
	
	@FindBy(xpath="//span[@class='test-id__field-label'][text()='User Number']/../..//lightning-formatted-text")
	WebElement userNumber;
	
	@FindBy(xpath="//input[@placeholder='Search Salesforce']")
	WebElement searchSalesForceInput;
	
	@FindBy(xpath="(//a[contains(text(),'Accounts')])[last()]")
	WebElement accountSummaryHeader;
	
	//******************************Primary Account Details Update**********************************************************
	@FindBy(xpath="(//span[contains(text(),'Client Provided Email')])[last()]/..//button")
	WebElement emailEditBtn;
	
	@FindBy(xpath="//label[contains(text(),'Client Provided Email')]/..//input")
	WebElement emailEditInput;

	
	@FindBy(xpath = "//button[@name='submit']")
	WebElement updateSaveBtn;
	
	
	
	
	
	//------------------------------------------------------------------------
	
	
	
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	DetailsPage detailsPage = new DetailsPage();
	
	
	
	public HouseholdPage() {
		 
		PageFactory.initElements(driver, this);
		
		}
	
	

	public void gotoHouseholdviaAcctScreen() throws InterruptedException, ParseException{
		
		TestUtil.waitUntilElementVisible(userNumber);
		String usernumber = userNumber.getText();
		
		if (usernumber == null || usernumber.isEmpty()){ 
			driver.navigate().refresh();
			TestUtil.waitUntilElementVisible(userNumber);
			usernumber = userNumber.getText();
		}
		
		TestUtil.waitUntilElementVisible(searchSalesForceInput);
		TestUtil.clickElement(searchSalesForceInput);
		searchSalesForceInput.sendKeys(usernumber);Thread.sleep(5000);
		searchSalesForceInput.sendKeys(Keys.ENTER);
		
		/*
		for (int i=0; i<=4; i++){
			List<WebElement> dynamicElement = driver.findElements(By.xpath("(//a[contains (@title, ('Household'))][@data-refid='recordId'])[last()]"));
				if(dynamicElement.size() == 0){Thread.sleep(3000);driver.navigate().refresh();i++;}
				else {break;}
		}
		*/
		
		for (int i=0; i<=4; i++){
			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Boolean isPresent = driver.findElements(By.xpath("(//a[contains (@title, ('Household'))][@data-refid='recordId'])[last()]")).size()>0;
			
				if(isPresent.equals(false)){driver.navigate().refresh();i++;}
				else {driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);break;}
		}
		
		
		
		TestUtil.waitUntilElementVisible(accountSummaryHeader);
		WebElement houseHoldAccount = driver.findElement(By.xpath("(//a[contains (@title, ('Household'))][@data-refid='recordId'])[last()]"));
		TestUtil.clickElement(houseHoldAccount);
	
	}
	
	
	public void switchtoCoClient() throws InterruptedException{
	
		TestUtil.waitUntilElementVisible(householdTab);
		//Thread.sleep(3000);
		TestUtil.clickElement(householdTab);
		
		TestUtil.waitUntilElementVisible(co_clientlink);
		//Thread.sleep(3000);
		TestUtil.clickElement(co_clientlink);
		
		//Thread.sleep(3000);
	}
	

/*	
	@SuppressWarnings("static-access")
	public void unplannedAppointment() throws InterruptedException, ParseException, IOException {
			
		
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "No-Show", "MeetingExistNO");
		
		
			
	}
	*/
	
	
	public void gotoHousehold() throws InterruptedException, ParseException{
		TestUtil.waitUntilElementVisible(householdTab);
		TestUtil.clickElement(householdTab);Thread.sleep(2000);
		TestUtil.clickElement(householdBtn);//Thread.sleep(2000);
	
	}

	
	
	public void addSpouse(String SpouseFirstName, String SpouseLastName) throws InterruptedException {
		
		TestUtil.waitUntilElementVisible(householdTab);
		TestUtil.clickElement(householdTab);
		
		Thread.sleep(3000);
		TestUtil.waitUntilElementVisible(addCoclient);
		TestUtil.clickElement(addCoclient);
		
		TestUtil.clickElement(createNewAccount);
		TestUtil.clickElement(nextButton);
		
		TestUtil.waitUntilElementVisible(spouseFirstName);
		spouseFirstName.sendKeys(SpouseFirstName);
		spouseLastName.sendKeys(SpouseLastName);
		spouseDOB.sendKeys("10/16/1958");
		TestUtil.clickElement(genderSelection);
		TestUtil.clickElement(relationshipSelection);
		
		TestUtil.clickElement(nextButton1);
		TestUtil.clickElement(coClientFinishButton);
		
		
		TestUtil.waitUntilElementVisible(householdTab);	Thread.sleep(5000);
		TestUtil.clickElement(householdTab);
		TestUtil.clickElement(coClientButton);Thread.sleep(5000);
	
		String spouseUrl = driver.getCurrentUrl();
		String []url = spouseUrl.split("/");
		String spousesfdcId = url[6];
		
		SalesforceRestAPI.objMap.put("spousesfdcId", spousesfdcId);
		
	}
	
	

	//******************************Primary Account Details Update**********************************************************
		
	@SuppressWarnings("static-access")
	public void updateAccountDetails() throws InterruptedException {
		
		WebElement importantClientDates = driver.findElement(By.xpath("(//span[contains(text(),'Important Client Dates')])[last()]"));
		TestUtil.scrollintoView(importantClientDates);
				
		TestUtil.waitUntilElementVisible(emailEditBtn);
		TestUtil.clickElement(emailEditBtn);
		TestUtil.waitUntilElementVisible(emailEditInput);
		emailEditInput.clear();	Thread.sleep(2000);
		emailEditInput.sendKeys(detailsPage.emailupdate);Thread.sleep(3000);
		
		TestUtil.waitUntilElementVisible(detailsPage.dobEditInput);
		//detailsPage.dobEditInput.click();
		detailsPage.dobEditInput.clear();
		detailsPage.dobEditInput.sendKeys("12/11/1972");
		detailsPage.dobEditInput.sendKeys(Keys.TAB);
		
		TestUtil.waitUntilElementVisible(detailsPage.genderDropDown);
		detailsPage.genderDropDown.click();	detailsPage.genderMale.click();
			
		TestUtil.clickElement(updateSaveBtn);Thread.sleep(5000);
		
	}
	
		
	public void verifyAccountDetails(String cEmail, String cDateofBirth, String cGender) throws InterruptedException {
			
		TestUtil.waitUntilElementVisible(emailEditBtn);
			
		String clientEmailUpdate = driver.findElement(By.xpath("(//span[contains(text(),'Client Provided Email')])[last()]/..//lightning-formatted-email")).getText();
		softAssertion.assertEquals(clientEmailUpdate, cEmail, "Email not matched.....");
			
		String dateOfBirthUpdate = driver.findElement(By.xpath("(//span[contains(text(),'Date of Birth')])[last()]/..//lightning-formatted-text")).getText();
		softAssertion.assertEquals(dateOfBirthUpdate, cDateofBirth, "DOB not matched.....");
			
		String genderUpdate = driver.findElement(By.xpath("(//span[contains(text(),'Gender')])[last()]/..//lightning-formatted-text")).getText();
		softAssertion.assertEquals(genderUpdate, cGender, "Gender not matched....");
			
		//softAssertion.assertAll();
			
	}

		

/*
	public void selectOutcome(int i) throws InterruptedException, ParseException {
		
		if (i==0){TestUtil.SelectDropDownOption(outcome, "Phone Call - Not Reached");}
		else if(i==1){TestUtil.SelectDropDownOption(outcome, "Phone Call - Reached");}
		else if(i==2){TestUtil.SelectDropDownOption(outcome, "Meeting");}
		
		}	
	
	public void selectOutcome(int i) throws InterruptedException, ParseException {
		
		if (i==0){TestUtil.SelectDropDownOption(outcome, "Not Reached");}
		else if(i==1){TestUtil.SelectDropDownOption(outcome, "Reached");}
		else if(i==2){TestUtil.SelectDropDownOption(outcome, "Meeting");}
		
		}		
*/	
	
}
