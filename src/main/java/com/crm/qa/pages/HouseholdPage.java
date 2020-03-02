package com.crm.qa.pages;


import java.io.IOException;
import java.text.ParseException;
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
	
	
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	DetailsPage detailsPage = new DetailsPage();
	
	
	
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
		
		Thread.sleep(3000);
		householdTab.click();
		
		Thread.sleep(2000);
		householdBtn.click();
		Thread.sleep(3000);
		
		commentsTextarea.sendKeys(commentsToEnter);
		
		Thread.sleep(2000);
		selectOutcome(i);
		
		solutionsDiscussed.click();
		
		jse2.executeScript("arguments[0].scrollIntoView()", commentsTextarea);
		logCallNextButton.click();
		
		Thread.sleep(5000);
		
		noOpttyRdBtn.click();
		
		logCallNextButton.click();
		
		
	}
	
	
	@SuppressWarnings("static-access")
	public void unplannedAppointment() throws InterruptedException, ParseException, IOException {
			
		String commentsToEnter = "TestingPurpose " + detailsPage.uid;
		
		/*
		Thread.sleep(3000);
		//jse2.executeScript("arguments[0].click()",householdTab);
				
		//Thread.sleep(2000);
		//householdBtn.click();
		
		Thread.sleep(3000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		Thread.sleep(3000);
		TestUtil.SelectDropDownOption(outcome, "Meeting");
		jse2.executeScript("arguments[0].click()", solutionsDiscussed);
	
		//jse2.executeScript("arguments[0].scrollIntoView()", commentsTextarea);
		jse2.executeScript("arguments[0].click()",gstNextBtn);
	

		
		
		
		Thread.sleep(3000);
		subjectArea.sendKeys(commentsToEnter);
	
	
		//meetingEndDate1.sendKeys(detailsPage.unplannedDate);
		//meetingEndTime1.click();
		//meetingEndTime1.clear();
		//meetingEndTime1.sendKeys("8:00 PM");
		//meetingEndTime1.sendKeys(Keys.TAB);
		//nextButton1.click();
		
		meetingEndDate1.clear();meetingEndDate1.sendKeys(detailsPage.unplannedDate);
		jse2.executeScript("arguments[0].click()",meetingEndTime1);meetingEndTime1.clear();meetingEndTime1.sendKeys("8:00 PM");
		subjectArea.click(); jse2.executeScript("arguments[0].click()", nextButton1);
		
		
		Thread.sleep(3000);
		TestUtil.SelectDropDownOption(meetwithClient, "In-Person Meeting");
		
		TestUtil.SelectDropDownOption(meetingOutcome, "No-Show");
		
		jse2.executeScript("arguments[0].click()",nextButton1);
		
	*/	
		
		detailsPage.logacallInteractionforMeeting(detailsPage.meeting, "GTSconversionNo",  "In-Person Meeting", "No-Show", "MeetingExistNO");
		
		
			
	}
	
	
	public void gotoHousehold() throws InterruptedException, ParseException{
	
		jse2.executeScript("arguments[0].click()",householdTab);Thread.sleep(2000);
		householdBtn.click();Thread.sleep(2000);
	
	}


	public void addSpouse(String SpouseFirstName, String SpouseLastName) throws InterruptedException {
		
		Thread.sleep(10000);
		jse2.executeScript("arguments[0].click()",householdTab);Thread.sleep(3000);
		
		Thread.sleep(3000);
		jse2.executeScript("arguments[0].click()", addCoclient);
		
		Thread.sleep(3000);
		createNewAccount.click();
		
		nextButton.click();
		
		Thread.sleep(3000);
		spouseFirstName.sendKeys(SpouseFirstName);
		spouseLastName.sendKeys(SpouseLastName);
		spouseDOB.sendKeys("10/16/1958");
		genderSelection.click();
		relationshipSelection.click();
		
		nextButton1.click();
		Thread.sleep(3000);
		coClientFinishButton.click();
		
		driver.navigate().refresh();
	
/*
		Thread.sleep(10000);
		householdTab.click();
		
		//if(!coClientButton.isDisplayed()){ System.out.println("Co-Client Exists");}
		
		Thread.sleep(2000);
		
		if(!coClientButton.isEnabled()){System.out.println("Co-Client Exists");}
		
		coClientButton.click();
	
*/		
		Thread.sleep(3000);
		String spouseUrl = driver.getCurrentUrl();
		String []url = spouseUrl.split("/");
		String spousesfdcId = url[6];
		
		prop.setProperty("spousesfdcId", spousesfdcId);
		SalesforceRestAPI.objMap.put("spousesfdcId", spousesfdcId);
		
		//prop.setProperty("sfdcId", spousesfdcId);
		SalesforceRestAPI.objMap.put("sfdcId", spousesfdcId);
		
	}
	
	

/*
	public void selectOutcome(int i) throws InterruptedException, ParseException {
		
		if (i==0){TestUtil.SelectDropDownOption(outcome, "Phone Call - Not Reached");}
		else if(i==1){TestUtil.SelectDropDownOption(outcome, "Phone Call - Reached");}
		else if(i==2){TestUtil.SelectDropDownOption(outcome, "Meeting");}
		
		}	
	*/
	public void selectOutcome(int i) throws InterruptedException, ParseException {
		
		if (i==0){TestUtil.SelectDropDownOption(outcome, "Not Reached");}
		else if(i==1){TestUtil.SelectDropDownOption(outcome, "Reached");}
		else if(i==2){TestUtil.SelectDropDownOption(outcome, "Meeting");}
		
		}		
	
	
}
