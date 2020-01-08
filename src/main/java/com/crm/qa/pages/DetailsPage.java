package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
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
import org.openqa.selenium.interactions.Action;
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
import com.crm.qa.util.RetailUserdetails;
import com.crm.qa.util.TestUtil;
import com.crm.qa.pages.SalesforceRestAPI_exp2;

public class DetailsPage extends TestBase {
	
	
	@FindBy(xpath = "//div[contains(text(),'Comments')]/../../../following-sibling::div/div/textarea")
	WebElement commentsTextarea;

	@FindBy(xpath = "//div[contains(text(),'Comments')]")
	WebElement comments;

	@FindBy(xpath = "//div[contains(text(),'Management')]")
	WebElement solutionsDiscussed;
	
	@FindBy(xpath = "//div[contains(text(),'Create Workplace Opportunity')]")
	WebElement createWorkplaceOpportunity;
	
	
	@FindBy(xpath = "//div[contains(text(),'Outcome')]/../../../following-sibling::div/select")
	WebElement outcome;

	@FindBy(xpath = "//span[contains(text(),'Create Opportunity')]")
	WebElement CreateOpportunityLabel;

	//check if this element is used anywhere in any scripts if not..delete it
	@FindBy(xpath = "(//b[contains(text(),'Create Opportunity')])[2]")
	WebElement CreateOpportunityLabel1;
	
	@FindBy(xpath = "//span[@class='title'][contains(text(),'Communications')]")
	WebElement Communications;
	
	@FindBy(xpath = "//li[@title='Conversations']")
	WebElement conversations;

	@FindBy(xpath = "//li[@title='All']")
	WebElement all;

	@FindBy(xpath = "//li[@title='Future Phone Communication Details']")
	WebElement phone;
	
	@FindBy(xpath = "//li[@title='Task Details']")
	WebElement ToDo;
	
	@FindBy(xpath = "//li[@title='Event Communication Details']")
	WebElement meetings;
	

	@FindBy(xpath = "//article[@class='slds-card cCurrentPhoneCommunication']//tbody//tr[1]//td[2]//lightning-formatted-text[1]")
	WebElement commentsCellData;

	@FindBy(xpath = "//article[@class='slds-card cCurrentPhoneCommunication']//tbody//tr[1]//td[1]//lightning-formatted-text[1]")
	WebElement assignCellData;

	@FindBy(xpath = "//article[@class='slds-card cCurrentPhoneCommunication']//tbody//tr[1]//lightning-formatted-url[1]")
	WebElement callData;

	@FindBy(xpath = "//article[@class='slds-card cCurrentCommunicationAll']")
	WebElement allCommunications;

	@FindBy(xpath = "//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr[1]//td[2]//lightning-formatted-text[1]")
	WebElement assignedtoData;

	@FindBy(xpath = "//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr[1]//td[3]//lightning-formatted-text[1]")
	WebElement subjectData;

	@FindBy(xpath = "//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr[1]//td[4]//lightning-formatted-text[1]")
	WebElement typeData;

	@FindBy(xpath = "//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr[1]//lightning-formatted-url[1]")
	WebElement callDate1;

	@FindBy(xpath = "//article[@class='slds-card cCallDetails']//tbody//tr[1]//td[1]//lightning-formatted-text[1]")
	WebElement assignedData;

	@FindBy(xpath = "//article[@class='slds-card cCallDetails']//tbody//tr[1]//td[2]//lightning-formatted-text[1]")
	WebElement commentsData;

	@FindBy(xpath = "//article[@class='slds-card cCallDetails']//tbody//tr[1]//td[3]//lightning-formatted-text[1]")
	WebElement outcomeData;

	@FindBy(xpath = "//article[@class='slds-card cCallDetails']//tbody//tr[1]//lightning-formatted-url[1]")
	WebElement callDate2;
	
	@FindBy(xpath = "(//span[contains(text(),'Subject')])[2]/../following-sibling::div/span/span")
	WebElement taskSubject;	
	
//	@FindBy(xpath = "(//span[contains(text(),'Harshal Sakpal')])[5]")
//	WebElement navigateUser;	

	@FindBy(xpath = "//span[contains(text(),'Call Outcome')]/../following-sibling::div/span/span")
	WebElement calloutcomeText;	
	
	
	@FindBy(xpath = "//span[contains(text(),'Call Type')]/../following-sibling::div/span/span")
	WebElement callType;	
	
	@FindBy(xpath = "//span[contains(text(),'Solutions Discussed')]/../following-sibling::div/span/span")
	WebElement solutions;
	
	@FindBy(xpath = "(//a[@data-refid='recordId'])[1]")
	WebElement oppLink;
	
//	@FindBy(xpath = "(//a[contains(text(),'Harshal Sakpal')])[1]")
//	WebElement accountLink;
	
	@FindBy(xpath = "(//a[contains(text(),'Ford-401K Roll-in')])")
	WebElement oppLink1;
	
	@FindBy(xpath = "(//a[contains(text(),'Ford-IRA-Roth IRA-401K Roll-in')])[1]")
	WebElement oppLink2;

	
	@FindBy(xpath = "(//span[contains(text(),'Last Activity Date')])[2]/../following-sibling::div/span/span")
	WebElement lastActivityDate;
	
	@FindBy(xpath = "(//span[contains(text(),'Stage')])[2]/../following-sibling::div/span/span")
	WebElement stage;
	
	//@FindBy(xpath = "//div[contains(text(),'Schedule a Phone Call')]")
	//WebElement scheduleType;
	
	
	@FindBy(xpath = "//div[contains(text(),'Schedule a Phone Call')]")
	WebElement scheduleType;
	
	//@FindBy(xpath = "//div[contains(text(),'Schedule Appointment')]")
	//WebElement scheduleApp;
	
	//@FindBy(xpath = "//input[@name='Create_Appointment' and @type='checkbox']//..")
	//WebElement scheduleApp;
	
	
	@FindBy(xpath = "//div[contains(text(),'Schedule/Close a Meeting')]")
	WebElement scheduleApp;

	
	@FindBy(xpath = "//div[contains(text(),'Schedule a To-Do')]")
	WebElement toDo;

	
	@FindBy(xpath = "//div[contains(text(),'Future Phone Call')]")
	WebElement futurePhoneCall;
	
	@FindBy(xpath = "//span[contains(text(),'Due Date')]")
	WebElement dueDate;
	
	@FindBy(xpath = "//div[contains(text(),'Open Tasks')]")
	WebElement openTasks;
	
	
	@FindBy(xpath = "//lightning-datepicker//input")
	WebElement enterDate1;
	
	
	@FindBy(xpath = "//input[@name='Meeting_Start_Date_And_Time_0' and @type='text' and @class = 'slds-input']")
	WebElement meetingStartDate;
	
	
	@FindBy(xpath = "//input[@name='Meeting_Start_Date_And_Time_0' and @type='text' and @class = 'slds-input slds-combobox__input']")
	WebElement meetingStartTime;
	
	
	@FindBy(xpath = "//input[@name='Meeting_End_Date_And_Time' and @type='text' and @class = 'slds-input']")
	WebElement meetingEndDate;
	
	
	@FindBy(xpath = "//input[@name='Meeting_End_Date_And_Time' and @type='text' and @class = 'slds-input slds-combobox__input']")
	WebElement meetingEndTime;
	
	@FindBy(xpath = "//div[contains(@class,'col right-col slds-size')]//div[3]//select[contains(@class, 'select uiInput uiInputSelect')]")
	WebElement meetingDuration;
	
	
	
	@FindBy(xpath = "//label[contains(text(),'Assigned To')]/following-sibling::div//input")
	WebElement assignedTo;
	
	@FindBy(xpath = "//label[contains(text(),'Meeting Location')]/following-sibling::div//input")
	WebElement meetingLocation;
	
	
	@FindBy(xpath = "//input[@name='Subject_ToDo' and @type='text']")
	WebElement enterSubject_ToDo;
	
	@FindBy(xpath = "//input[@name='Subject_Phone' and @type='text']")
	WebElement enterSubject_Phone;
	
	@FindBy(xpath = "//div[contains(text(),'Due Date')]/../../following-sibling::div/div/input")
	WebElement enterDate2;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]/..//following-sibling::button")
	WebElement nextButton1;
	
	//@FindBy(xpath = "(//button[contains(text(),'Next')])[2]")
	//WebElement nextButton1;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Last Modified By')]/../following-sibling::div/span/span")
	WebElement taskLastModifiedDate;
	
	@FindBy(xpath = "//button[contains(@title,'Edit Comments')]/preceding-sibling::span/span")
	WebElement taskComments;
	
	@FindBy(xpath = "//span[contains(text(),'Current Meeting Status')]/../following-sibling::div/span/span")
	WebElement meetingStatus;
	
	@FindBy(xpath = "//div[contains(text(),'Do not close any existing tasks')]")
	WebElement createNewTask;

	@FindBy(xpath = "//div[contains(text(),'Close existing task(s)')]")
	WebElement closeTask;
	
	@FindBy(xpath = "//div[@class='uiOutputRichText']//div[3]//font//a")
	WebElement bdAppointment;	
	
	@FindBy(xpath = "(//td[@class='labelContainer'])[3]")
	WebElement randomAdvisor;
		
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//div[contains(text(),'How do you intend to meet with the client?')]/../../../following-sibling::div/select")
	WebElement meetingClient;
	
	@FindBy(xpath = "//span[contains(text(),'Call Outcome')]/../following-sibling::div/span/span")
	WebElement taskStatus;	
	
	@FindBy(xpath = "//li[@title='To-Do']")
	WebElement todoTab;
	
	//@FindBy(xpath = "//div[contains(text(),'Subject')]/../../../following-sibling::div//input")
	//WebElement subjectArea;
	
	@FindBy(xpath = "//input[contains (@name ,'Subject')]")
	WebElement subjectArea;
	
	
	//@FindBy(xpath = "(//div[contains(text(),'End Date and Time')]/../../../following-sibling::div//input)[1]")
	//WebElement meetingEndDate1;
	
	@FindBy(xpath = "(//input[contains (@name ,'Start_Date_and_Time')])[1]")
	WebElement meetingStartDate1;
	
	//@FindBy(xpath = "(//div[contains(text(),'End Date and Time')]/../../../following-sibling::div//input)[2]")
	//WebElement meetingEndTime1;
	
	@FindBy(xpath = "(//input[contains (@name ,'Start_Date_and_Time')])[2]")
	WebElement meetingStartTime1;

	
	@FindBy(xpath = "(//input[contains (@name ,'End_Date_and_Time')])[1]")
	WebElement meetingEndDate1;

	@FindBy(xpath = "(//input[contains (@name ,'End_Date_and_Time')])[2]")
	WebElement meetingEndTime1;
	
	
		
	@FindBy(xpath = "//div[contains(text(),'How Did You Meet With Client')]/../../../following-sibling::div/select")
	WebElement meetwithClient;
	
	
	//@FindBy(xpath = "(//select[contains(@class,'select uiInput')])[2]")
	//WebElement meetwithClient;
	
	
	
	@FindBy(xpath = "//div[contains(text(),'Select Meeting Outcome')]/../../../following-sibling::div/select")
	WebElement meetingOutcome;
	
	//@FindBy(xpath = "(//select[contains(@class,'select uiInput')])[3]")
	//WebElement meetingOutcome;
	
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement NextBtn;
	
	@FindBy(xpath = "//font[contains(text(),'Please select an Advisor')]")
	WebElement plsSelectAdvisor;
	
	@FindBy(xpath = "(//*[contains(@class,'slds-form slds-form_stacked')])[4]//button[contains (@title, 'Edit Assigned Planner')]")
	WebElement editAssignedPlanner;
	
	@FindBy(xpath = "(//input[contains (@title, 'Search People')])[1]")
	WebElement assignedPlannerSelection;
	
	@FindBy(xpath = "((//*[contains(@class,'slds-form slds-form_stacked')]/div[2]/div[2]/div[1]/div[2]/span[1])[3]")
	WebElement assignedPlannerComboBox;
	
	
	@FindBy(xpath = "(//button[contains(@class,' forceActionButton')])[2]")
	WebElement saveBtnAssignedPlanner;
	
	@FindBy(xpath = "(//a[contains(text(),'Log out')])")
	WebElement LoggedUser;
	
	@FindBy(xpath = "//span[contains (text(), 'Reload')]")
	WebElement Reload;
	
	@FindBy(xpath = "//input[contains (@name, 'assignedToNotDefaulted')]")
	WebElement assignedtoDropDown;
	
	@FindBy(xpath = "(//div[contains (@class,('forcePageBlockSectionRow'))])[5]")
	WebElement scrolltoClientInformation;
	
	@FindBy(xpath = "(//div[contains (@class,('forcePageBlockSectionRow'))])[20]")
	WebElement scrolltoAccountDetails;
	
	@FindBy(xpath = "//button[contains (@title, ('Edit Client Provided Email'))]")
	WebElement emailEditBtn;
	
	@FindBy(xpath = "//button[contains (@title, ('Edit Work Phone'))]")
	WebElement workphoneEditBtn;
	
	@FindBy(xpath = "//button[contains (@title, ('Edit Date of Birth'))]")
	WebElement dobEditBtn;
	
	@FindBy(xpath = "//button[contains (@title, ('Edit Gender'))]")
	WebElement genderEditBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Male')]")
	WebElement genderMale;
	
	@FindBy(xpath = "//button[contains (@title, ('Edit Mailing Address'))]")
	WebElement addressEditBtn;
	
	@FindBy(xpath = "(//input[contains (@type, ('email'))])[1]")
	WebElement emailEditInput;
	
	@FindBy(xpath = "(//*[contains (@class, ('datePicker'))])[1]/..")
	WebElement dobEditInput;
	
	//@FindBy(xpath = "//span[contains(text(),'Today')]")
	//WebElement dobAsToday;
	
	@FindBy(xpath = "(//a[contains (@class, 'datePicker')]/..//input[contains (@class, ('input'))])[1]")
	WebElement dobInput;
	
	@FindBy(xpath = "(//span[contains (text(), ('Work Phone'))]/../..//input)[1]")
	WebElement workphoneEditInput;
	
	@FindBy(xpath = "(//a[contains(@class,'select')][contains(@role,'button')])[5]")
	WebElement genderDropDown;
	
	@FindBy(xpath = "(//div[contains (@class,('forcePageBlockSectionRow'))])[30]")
	WebElement scrolltoAddressInformation;
	
	@FindBy(xpath = "//*[contains (@placeholder, ('Mailing Street'))]")
	WebElement textMailingStreet;
	
	@FindBy(xpath = "//*[contains (@placeholder, ('Mailing City'))]")
	WebElement textMailingCity;
	
	@FindBy(xpath = "//*[contains (@placeholder, ('Mailing State/Province'))]")
	WebElement textMailingState;
	
	@FindBy(xpath = "//*[contains (@placeholder, ('Mailing Zip/Postal Code'))]")
	WebElement textMailingZipCode;
	
	@FindBy(xpath = "//button[contains (@title, ('Save'))]")
	WebElement updateSaveBtn;
	
	
	//**************************************
	
	//@FindBy(xpath = "(//button[contains(text(),'Next')])[1]")
	//WebElement houseHoldNextButton;
	
	//@FindBy(xpath = "(//button[contains(text(),'Next')])[1]")
	//WebElement logCallNextButton;
	
	@FindBy(xpath = "//div[@data-component-id = 'flowruntime_interview']//button[contains(text(),'Next')]")
	WebElement logCallNextButton;
	
	//@FindBy(xpath = "(//button[contains(text(),'Next')])[2]")
	//WebElement futureActivityNextButton;
	
	@FindBy(xpath = "//div[@data-component-id = 'flowruntime_interview4']//button[contains(text(),'Next')]")
	WebElement futureActivityNextButton;
	
	
	//@FindBy(xpath = "(//button[contains(text(),'Next')])[3]")
	//WebElement opttyNextButton;
	
	@FindBy(xpath ="//div[@data-component-id = 'flowruntime_interview5']//button[contains(text(),'Next')]")
	WebElement opttyNextButton;
	
	@FindBy(xpath = "//label[contains (@for, ('No_Selected'))]")
	WebElement noOpttyRdBtn;
	
	
	//***********************
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;


//	String timeStamp1 = "AUG 31, 2018";
	
	

	// article[@class='slds-card
	// cCurrentPhoneCommunication']//tbody//tr[1]//lightning-formatted-url[1]
	// article[@class='slds-card cCallDetails']
	//yyMMddhhmmssMs

		static SimpleDateFormat timestamp = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		static String timeStamp = timestamp.format(new Date());
		 
		SimpleDateFormat timestamp12 = new SimpleDateFormat("MM/dd/yyyy");
		String timeStamp12 = timestamp12.format(new Date());

	 
		SimpleDateFormat timestamp11 = new SimpleDateFormat("M/d/yyyy");
		String timeStamp11 = timestamp11.format(new Date());
		String[] dateStr12 = timeStamp11.split("\\s+");
		
/*
		static String[] ret = addDaysToCurrentTime(7);
	    String enteredDate = ret[0];
	    static String verifyDate = ret[1];
	    static String meetingDate = ret[2];
	    static String meetingformattedDate = ret[3];
	    public static String uid = ret[4];
	    static String unplannedDate = ret[6];
	    
*/
		public static String enteredDate;
		public static String  verifyDate;
		public static String  meetingDate;
		public static String  meetingformattedDate;
	    public static String uid ;
	    public static String  unplannedDate;
	    public static String emailupdate;
	    
	    
	    String schedule1 = "Phone Call";
		String schedule2 = "ToDo";
		String schedule3 = "Appointment";
		
		//static String commentsToEnter = "TestingPurpose " + uid;
		static String commentsToEnter;
		static String[] splitStr1 = timeStamp.split("\\s+");

		
		
		public DetailsPage() {
		PageFactory.initElements(driver, this);
		
		}
	
	SoftAssert softAssertion = new SoftAssert();
//	SoftAssert softAssertion2 = new SoftAssert();
//	SoftAssert softAssertion3 = new SoftAssert();
	
	/*
	String schedule1 = "Phone Call";
	String schedule2 = "ToDo";
	String schedule3 = "Appointment";
	*/

	public void enterComments(int i) throws InterruptedException, IOException, ParseException {
		
		//uid= SalesforceRestAPI.uid;
		 
		String commentsToEnter = "TestingPurpose " + uid;
		
		TestUtil.waitForElement("Comments", comments);
	
		System.out.println("TimeStamp......................" + timeStamp );
		prop.setProperty("Call Start Time", timeStamp);
	
		
		Thread.sleep(2000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		//Thread.sleep(5000);
		prop.setProperty("EnteredComments", commentsToEnter);
		
		Thread.sleep(2000);
		selectOutcome(i);
		
		//TestUtil.waitForElement("Management", solutionsDiscussed );
		
		solutionsDiscussed.click();
		
		if (i!=0){ CreateOpportunityLabel.click();}
		
		//clickNextButton();
		logCallNextButton.click();
		
		Thread.sleep(5000);
		
		noOpttyRdBtn.click();
		
		logCallNextButton.click();
		
		
	}
		 


	public void scheduleworkflow(String schedule) throws InterruptedException {
		
		Thread.sleep(2000);
		
		String commentsToEnter = "TestingPurpose " + uid;
		
		//String LoggedinUser = LoggedUser.getText().substring(11);
		
		if (schedule.equals(schedule1)) {
			
			
			TestUtil.waitForElement("Future Phone Call", futurePhoneCall);

			
		/*		
			String getdrop = driver.findElement(By.xpath("(//input[contains (@placeholder, ('Select an Option'))])[1]")).getText();
			String getdrop1 = driver.findElement(By.xpath("//*[contains (@href , ('/lightning/r/User'))][contains(@title, ('" + LoggedinUser + "'))]")).getText().substring(4).trim();
			
			if (driver.findElement(By.xpath("//*[contains (@href , ('/lightning/r/User'))][contains(@title, ('" + LoggedinUser + "'))]")).getText() != null){
			assignedtoDropDown.click();
			assignedtoDropDown.sendKeys(LoggedinUser);
			driver.findElement(By.xpath("(//*[contains (@title, '" +LoggedinUser+ "')])[5]")).click();			
			}
		*/
	
			enterDate1.sendKeys(enteredDate);
			enterSubject_Phone.sendKeys(commentsToEnter);
			nextButton1.click();
					
		} else if (schedule.equals(schedule2)) {
			
			//Thread.sleep(2000);	
			TestUtil.waitForElement("Due Date", dueDate);
			enterDate1.sendKeys(enteredDate);
			enterSubject_ToDo.sendKeys(commentsToEnter);
			nextButton1.click();
			
		} else {
				//Thread.sleep(2000);	
				createFutureMeeting();
				nextButton1.click();
		}
	
	/*		
		if(driver.findElements(By.xpath("(//*[contains(@class,'slds-form slds-form_stacked')]/div[2]/div[2]/div[1]/div[2]/span[1])[3]")).isEmpty()){	
		
			String advisorsfdcId1 = prop.getProperty("advisorsfdcId1");
			editAssignedPlanner.click();
			assignedPlannerSelection.sendKeys(LoggedinUser);
		
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//*[contains (@title, ('" +LoggedinUser+ "'))])[5]")).click();
		
			for (String currentWindow: driver.getWindowHandles())
		       driver.switchTo().window(currentWindow);
			{System.out.println(driver.getCurrentUrl()); driver.findElement(By.xpath("(//*[contains (@href, ('" + advisorsfdcId1 + "'))])[2]")).click();}
		
			Thread.sleep(3000);
			saveBtnAssignedPlanner.click();
			
			Reload.click();
		
		}
	*/

	
	}

	
	public void createFutureMeeting() {
		//To Do......
		}


	public void reached_schedule(int i, String sched) throws InterruptedException, Exception {
		
		String commentsToEnter = "TestingPurpose " + uid;
		
		Thread.sleep(5000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		//Thread.sleep(5000);
		
		prop.setProperty("EnteredComments", commentsToEnter);
		
		Thread.sleep(5000);
		prop.setProperty("Call Start Time", timeStamp);
		
		//Thread.sleep(5000);
		solutionsDiscussed.click();
		System.out.println(i);
		
		selectOutcome(i);
		System.out.println("index : " +i);
		
		//CreateOpportunityLabel.click();
		
		logCallNextButton.click();
		
		Thread.sleep(5000);
		
		noOpttyRdBtn.click();
		
		logCallNextButton.click();
	
		//driver.findElement(By.xpath("//span[contains(text(),'Create Opportunity')]")).click();
		
		if      (sched.equals(schedule3)) {CreateOpportunityLabel.click(); 	scheduleApp.click();} 
		else if (sched.equals(schedule2)) {CreateOpportunityLabel.click();	toDo.click();} 
		else if (sched.equals(schedule1)) {CreateOpportunityLabel.click();	scheduleType.click();}
		
		Thread.sleep(2000);
		//clickNextButton();
		futureActivityNextButton.click();
		
		/*
		if (driver.findElements(By.xpath("//div[contains(text(),'Open Tasks')]")).size() > 0){
			 NextBtn.getSize();	{ clickNextButton();}
		}
		*/
		
		scheduleworkflow(sched);
		
	}

	

	public String[] reached_scheduleAppointment() throws InterruptedException, ParseException {
	
		String commentsToEnter = "TestingPurpose " + uid;
		
		TestUtil.waitForElement("Comments", comments);
		
		Thread.sleep(5000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		TestUtil.SelectDropDownOption(outcome, "Phone Call - Reached");
		
		solutionsDiscussed.click();
		
		scheduleApp.click();
		
		//clickNextButton();
		
		futureActivityNextButton.click();
		
		Thread.sleep(5000);
		
		
		String[] meetingLinks = createBDAppointment(meetingDate);
		nextButton1.click();
		return meetingLinks;
	}


	public void reached_scheduleAppointment1() throws InterruptedException, ParseException, AWTException {
	
	
		//jse2.executeScript("arguments[0].scrollIntoView()", commentsTextarea);
		
		String commentsToEnter = "TestingPurpose " + uid;
		
		//TestUtil.waitForElement("Comments", comments);
		
		Thread.sleep(3000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		TestUtil.SelectDropDownOption(outcome, "Phone Call - Reached");
		solutionsDiscussed.click();
		
		logCallNextButton.click();
		
		Thread.sleep(3000);
		
		noOpttyRdBtn.click();
		logCallNextButton.click();
		
		Thread.sleep(2000);
		
		CreateOpportunityLabel.click();
		scheduleApp.click();

		Thread.sleep(2000);
		//clickNextButton();
		futureActivityNextButton.click();
		
		Thread.sleep(5000);
	
	/*	
		//If Next Button is present on the screen then click Next Button 
	    NextBtn.getSize();{ clickNextButton(); }
	
	*/		
		createFutureAppointment();
		
		//NextBtn.getSize();{clickNextButton();}
		
	}

	public void unplannedAppointment() throws InterruptedException, ParseException {
		
		String commentsToEnter = "TestingPurpose " + uid;
		
		Thread.sleep(3000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		Thread.sleep(3000);
		TestUtil.SelectDropDownOption(outcome, "Meeting");
		solutionsDiscussed.click();
	
		//clickNextButton();
		
		logCallNextButton.click();
		
		Thread.sleep(3000);
		subjectArea.sendKeys(commentsToEnter);
		
		meetingEndDate1.sendKeys(unplannedDate);
		meetingEndTime1.click();
		meetingEndTime1.clear();
		meetingEndTime1.sendKeys("8:00 PM");
		subjectArea.click();
		nextButton1.click();
		
		Thread.sleep(3000);
		TestUtil.SelectDropDownOption(meetwithClient, "In-Person Meeting");
		
		TestUtil.SelectDropDownOption(meetingOutcome, "No-Show");
		
		nextButton1.click();
			
	}
	

	public void createFutureAppointment() throws InterruptedException {
		
		jse2.executeScript("arguments[0].scrollIntoView()", meetingClient);
	
		TestUtil.SelectDropDownOption(meetingClient, "On-Phone Meeting");
		Thread.sleep(2000);
		meetingStartDate.sendKeys(enteredDate);
		meetingStartTime.click();
		meetingStartTime.clear();
		meetingStartTime.sendKeys("12:00 PM");
		
		meetingDuration.sendKeys("60");
		
		//nextButton1.click();
		
		futureActivityNextButton.click();
		Thread.sleep(3000);
		
		jse2.executeScript("arguments[0].click()", nextButton1);
		//nextButton1.click();
		
	}
	
	

	public void updateAccountDetails() throws InterruptedException {
		
		Thread.sleep(10000);
		emailEditBtn.click();

		//Thread.sleep(3000);
		emailEditInput.clear();
		
		emailEditInput.sendKeys(emailupdate);
		
		//Thread.sleep(3000);
		workphoneEditInput.clear();
		workphoneEditInput.sendKeys("9998887777");
		
		Thread.sleep(3000);
		updateSaveBtn.click();
		
		Thread.sleep(5000);
		scrolltoAccountDetails.click();
		
		genderEditBtn.click();
		Thread.sleep(3000);
		genderDropDown.click();
		genderMale.click();
	
		dobEditInput.click();
		//dobAsToday.click();
		dobInput.clear();
		dobInput.sendKeys("12/11/1972");
		
		updateSaveBtn.click();
		
		Thread.sleep(5000);
		scrolltoAddressInformation.click();
		
		//Thread.sleep(3000);
		addressEditBtn.click();
		Thread.sleep(3000);
		textMailingStreet.clear();
		textMailingStreet.sendKeys("1234 Test Street");
		textMailingCity.clear();
		textMailingCity.sendKeys("Scottsdale");
		textMailingState.clear();
		textMailingState.sendKeys("AZ");
		textMailingZipCode.clear();
		textMailingZipCode.sendKeys("85254");
		
		updateSaveBtn.click();
		Thread.sleep(10000);
		driver.navigate().refresh();
	}
	
	
	public void verifyAccountDetails(String cEmail, String wPhone, String cGender, String cDateofBirth, String mAddress ) throws InterruptedException {
		
		Thread.sleep(5000);
		
		//scrolltoClientInformation.click();
		
		String clientEmail = getFieldData("Edit Client Provided Email");
		//clientEmail = clientEmail.substring(clientEmail.indexOf("@")+ 1);
		softAssertion.assertEquals(clientEmail, cEmail, "Email not matched.....");
		
		
		String workPhone = getFieldData("Edit Work Phone");
		softAssertion.assertEquals(workPhone, wPhone, "Workphone not matched.....");
		
		scrolltoAccountDetails.click();
		
		Thread.sleep(3000);
		
		//scrolltoGenderInformation.click();
		
		String gender = getFieldData("Edit Gender");
		softAssertion.assertEquals(gender, cGender, "Gender not matched....");
		
		
		String dateOfBirth = getFieldData("Edit Date of Birth");
		softAssertion.assertEquals(dateOfBirth, cDateofBirth, "DOB not matched.....");
		
		scrolltoAddressInformation.click();
		
		Thread.sleep(3000);
		
		String mailingAddress = getFieldData("Edit Mailing Address").substring(0,37).trim();
		mailingAddress = mailingAddress.replace("\n", "").replace("\r", "");
		softAssertion.assertEquals(mailingAddress, mAddress, "Mailing Address not matched.....");
		
		softAssertion.assertAll();
		
	}
	
	
	
	public String getFieldData(String field) throws InterruptedException {
		
		String fielddata = driver.findElement(By.xpath("//button[contains (@title, ('" +field+ "'))]/..//span[contains (@class, ('test-id'))]")).getText();
		
		return fielddata;
	}
	
	
	
	public void clickNextButton() throws InterruptedException {
		List<WebElement> nextButtonCount = driver.findElements(By.xpath("//button[contains(text(),'Next')]"));
	    int nextButtonSize = nextButtonCount.size();
	    //WebElement nextButton = driver.findElement(By.xpath("(//button[contains(text(),'Next')])[" + nextButtonSize+ "]"));
	   // Thread.sleep(5000);
	    WebElement myelement = driver.findElement(By.xpath("(//button[contains(text(),'Next')])[" + nextButtonSize+ "]"));
	    JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	    jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
		//nextButton.click();
		//Thread.sleep(5000);
	    myelement.click();
	    Thread.sleep(10000);
	}
	
	
	
	public void closeExistingTask(int i) throws InterruptedException {
		
		for(int j=0; j<10; j++){		
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.COMMAND,Keys.ADD));		
		}
		
			String commentsToEnter = "TestingPurpose " + uid;
			
			commentsTextarea.sendKeys(commentsToEnter);
			solutionsDiscussed.click();
			Select outcome1 = new Select(outcome);
			System.out.println(outcome);
			outcome1.selectByIndex(i);
			
			Thread.sleep(5000);
			clickNextButton();		
			Thread.sleep(5000);
			closeTask.click();		
			nextButton1.click();
			
			List<WebElement> taskList = driver.findElements(By.xpath("//div[@class='uiBlock flowruntimeInputWrapper']//div[@class='slds-form-element__control']//div"));		
		    System.out.println(taskList.size());
		    int s = taskList.size()-1 ;
		    WebElement taskData = driver.findElement(By.xpath("(//div[@class='uiBlock flowruntimeInputWrapper']//div[@class='slds-form-element__control']//div)["+ s+"]"));
		    System.out.println(taskData.getText());
		    String taskName = taskData.getText();
		    String status = verifyTaskDetails(taskName);
		    softAssertion.assertEquals(status,"Open", "Status mismatch in open task");
		    
		    taskData.click();
		    
		    nextButton1.click();
		    
		    String status1 = verifyTaskDetails(taskName);
		    softAssertion.assertEquals(status1,"Completed", "Status mismatch in open task");
		    
		    softAssertion.assertAll();
		    	    
		}
	

	
	
	public void exp() throws InterruptedException {
		Thread.sleep(5000);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String verifyTaskDetails(String taskName) throws InterruptedException {
		// TODO Auto-generated method stub
		Communications.click();
		Thread.sleep(2000);
		
		todoTab.click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//lightning-formatted-text[contains(text(),'"+taskName+"')])[1]/ancestor::td/preceding-sibling::th//a")).click();
		
		
		String oldTab = driver.getWindowHandle();
   	 	ArrayList tabs = new ArrayList (driver.getWindowHandles());
		 System.out.println(tabs.size());
		 String newTab = (String) tabs.get(1);
		 driver.switchTo().window(newTab);
		 
		 String tStatus = taskStatus.getText();
		 
		 return tStatus;
		
	}

	public void verifyCommunications(int i, String schedule) throws InterruptedException, ParseException {		
		
		Thread.sleep(5000);
		Communications.click();
		
				
		if (schedule.equals(schedule1)) {
			
			Thread.sleep(5000);
								
		} else if (schedule.equals(schedule2)) {
			Thread.sleep(5000);
						
		} else if (schedule.equals(schedule3)) {
			Thread.sleep(5000);			
		} else {
			Thread.sleep(5000);
			verifyAll(i);
		}
		
		
		Thread.sleep(5000);
		Communications.click();
		Thread.sleep(5000);
		verifyPhone(i);
		
//		Communications.click();
		Thread.sleep(5000);
		
		

//		if (i == 1) {
//			verifyConversations(1);
//		} 

//		return softAssertion;
		softAssertion.assertAll();

	}
	


	public void verifyConversations(int i) throws InterruptedException, ParseException {

		conversations.click();
		String cText1 = commentsCellData.getText();
		String cText2 = callData.getText();
		String cText3 = assignCellData.getText();

//		System.out.println("comments:" + cText1);

		String cText111 = commentsArray(cText1);
//		String[] splitStr2 = str2.split("\\s+");
//		System.out.println("Date1:" + splitStr2[5]);
//		System.out.println("Date2:" + splitStr1[0]);

//		softAssertion.assertEquals(splitStr2[5], splitStr1[0], "Date mismatch under comments in Conversations Tab");
		softAssertion.assertEquals(cText2, timeStamp, "call date mismatch in Conversations Tab");
		softAssertion.assertEquals(cText3, "Ramakiran Nalam", "AssignedName mismatch in Conversations Tab");
		softAssertion.assertEquals(cText111, commentsToEnter, "Comments Data mismatch in Task Tab");

		System.out.println("Conversations Data......................" + cText111 + cText2 + cText3 );
		
		callData.click();
		verifyTask(i);
	
	}

	public void verifyAll(int i) throws InterruptedException, ParseException {
		
		Thread.sleep(5000);
		Communications.click();
		Thread.sleep(5000);
		all.click();
		
		
		List<WebElement> allList = driver.findElements(By.xpath("//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr"));		
	    System.out.println(allList.size());
	    
//		java.util.Iterator<WebElement> i1 = allList.iterator();
		
		for (int i1=1; i1<=allList.size(); i1++)
		{ 
			
		    WebElement callData1 = driver.findElement(By.xpath("//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr[" + i1+ "]//lightning-formatted-url[1]"));
		    WebElement subjectData1 = driver.findElement(By.xpath("//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr[" + i1+ "]//td[3]//lightning-formatted-text[1]"));
		    System.out.println(callData1.getText());
		    System.out.println(subjectData1.getText());
		    
		    String cText51 = callData1.getText();
		    String cText52 = subjectData1.getText();
			String[] callData11 = cText51.split("\\s+");
		    
		    if(callData11[0].equals(dateStr12[0]) && cText51.equals(cText52) ) {
		    	
		    	callData1.click();
		    	verifyTask(i);
		    	Thread.sleep(5000);
				Communications.click();
				Thread.sleep(5000);
				all.click();
		    	
		 }		    
	   }		
	}
	
public void verifyMeeting_All(int i, String meetingDate) throws InterruptedException, ParseException {
		
		Thread.sleep(5000);
		Communications.click();
		Thread.sleep(5000);
		all.click();

		
		
		List<WebElement> allList = driver.findElements(By.xpath("//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr"));		
	    System.out.println(allList.size());
	    
//		java.util.Iterator<WebElement> i1 = allList.iterator();
		
		for (int i1=1; i1<=allList.size(); i1++)
		{ 
			
		    WebElement callData1 = driver.findElement(By.xpath("//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr[" + i1+ "]//lightning-formatted-url[1]"));
		    WebElement subjectData1 = driver.findElement(By.xpath("//article[@class='slds-card cCurrentCommunicationAll']//tbody//tr[" + i1+ "]//td[3]//lightning-formatted-text[1]"));
		    System.out.println(callData1.getText());
		    System.out.println(subjectData1.getText());
		    
		    String cText51 = callData1.getText();
		    String cText52 = subjectData1.getText();
			String[] callData11 = cText51.split("\\s+");
		    
		    if(callData11[0].equals(dateStr12[0]) && cText51.equals(cText52) ) {
		    	
		    	callData1.click();
		    	verifyTask(i);
		    	Thread.sleep(5000);
				Communications.click();
				Thread.sleep(5000);
				all.click();
		    	
		 }		    
	   }		
	}


	public void verifyTask(int i) throws InterruptedException, ParseException {
		

		 String oldTab = driver.getWindowHandle();
    	 ArrayList tabs = new ArrayList (driver.getWindowHandles());
		 System.out.println(tabs.size());
		 String newTab = (String) tabs.get(1);
		 driver.switchTo().window(newTab);
		 
//		 driver.navigate().refresh();
		 
		 Thread.sleep(5000);		 
		
		String cText13 = calloutcomeText.getText();
		String cText14 = callType.getText();
		String cText15 = solutions.getText();
		String cText16 = taskLastModifiedDate.getText();
		String cText17 = taskComments.getText();
		String cText171 = commentsArray(cText17);
					
		softAssertion.assertEquals(cText16, timeStamp, "Date mismatch for Last modified tab in task Tab");
		softAssertion.assertEquals(cText14, "Call", "Call Type mismatch in Task Tab");
		softAssertion.assertEquals(cText15, "Management", "solutions data mismatch in task Tab");
		softAssertion.assertEquals(cText171, commentsToEnter, "Comments Data mismatch in Task Tab");
		
		if (i == 1) {			
			softAssertion.assertEquals(cText13, "Reached", "Outcome mismatch in Task Tab");
		} else {
			softAssertion.assertEquals(cText13, "Not Reached", "Outcome mismatch in Task Tab");
		}
		
//		softAssertion.assertTrue(cText17.contains(timeStamp), "Latest comment not visible under comments in Task Tab");
		
		
		
//		oppLink.click();
//		accountLink.click();
		System.out.println("Task Data......................................." + cText16 + cText14 + cText13 + cText15 + cText17);
		
		//driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/r/Account/0010R00000IZ3R7QAL/view");
		
		driver.close();
		// Switch driver control to focused tab window
		driver.switchTo().window(oldTab);
		
//		driver.navigate().to(prop.getProperty("url"));
		
		
		
	}



	public void verifyPhone(int i) throws InterruptedException, ParseException {

		phone.click();

//		SoftAssert softAssertion = new SoftAssert();

		String cText8 = assignedData.getText();
		String cText9 = callDate2.getText();
		String cText10 = commentsData.getText();
		String cText11 = outcomeData.getText();
		
		String cText101 = commentsArray(cText10);
		
		System.out.println("Comments:" + cText101);
		
		String[] phoneDate = cText9.split("\\s+");
		

		softAssertion.assertEquals(phoneDate[0], timeStamp12, "Date mismatch in Phone Tab");
		// softAssertion.assertEquals(cText10, splitStr2[5]);
		softAssertion.assertEquals(cText8, "Ramakiran Nalam", "Assigned Name mismatch in Phone Tab");

//		String str3 = cText10;
//		String[] splitStr3 = str3.split("\\s+");
//		System.out.println("Comments2:" + splitStr3[4]);
		
		softAssertion.assertEquals(cText101, commentsToEnter , "Comments Data mismatch in Phone Tab");

//		softAssertion.assertTrue(cText10.contains(splitStr3[4]), "Date mismatch in Phone Tab");
	//	String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND,"n"); 
	//	callDate2.sendKeys(selectLinkOpeninNewTab);
		callDate2.click();
		verifyTask(i);
		Communications.click();
		Thread.sleep(2000);
		phone.click();
				
		if (i == 0) {
			softAssertion.assertEquals(cText11,"Not Reached", "Outcome mismatch in Phone Tab");
		
		} else {
			
			softAssertion.assertEquals(cText11,"Reached", "Outcome mismatch in Phone Tab");
			Thread.sleep(2000);
			verifyConversations(i);

		}
			System.out.println("Phone Data............................................" + cText8 + cText9 + cText10 + cText11);
		
		
	}
	
		
	public void verifyOpportunity() throws InterruptedException {
						
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
				oppLink2.sendKeys(selectLinkOpeninNewTab);
				ArrayList tabs = new ArrayList (driver.getWindowHandles());
				System.out.println(tabs.size());
			    String newTab = (String) tabs.get(1);
			    String oldTab = driver.getWindowHandle();
			    
				driver.switchTo().window(newTab);
						 	 
				softAssertion.assertEquals(stage, "New", "Stage Mismatch");
				 
				driver.switchTo().window(oldTab);
		}
	


	public void verifyLeadOpportunity() throws InterruptedException {
	
				
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		oppLink2.sendKeys(selectLinkOpeninNewTab);
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
	    String newTab = (String) tabs.get(2);
	    String oldTab = driver.getWindowHandle();
	    
		driver.switchTo().window(newTab);
				 	 
		softAssertion.assertEquals(stage, "New", "Stage Mismatch");
		 
		driver.switchTo().window(oldTab);
	}

	
	
private String[] createBDAppointment(String meetingDate) throws InterruptedException, ParseException {
	
	bdAppointment.click();
	
	String oldTab = driver.getWindowHandle();
	Thread.sleep(3000);
	
	ArrayList tabs = new ArrayList (driver.getWindowHandles());
		 System.out.println(tabs.size());
		 String newTab = (String) tabs.get(1);
		 driver.switchTo().window(newTab);
		 Thread.sleep(2000);	
		 
//		 randomAdvisor.click();
//		 continueButton.click();
		 
		 ReferralAppointment ref = new ReferralAppointment();
		 String meetingLinks[] = ref.selectDate1(meetingDate);
		  
		 
		 driver.close();
		 driver.switchTo().window(oldTab);
		return meetingLinks;
		 
		 
		 
	
}

public void VerifyMeetings(String meetingLink) throws InterruptedException {
	
	Thread.sleep(5000);
	Communications.click();
	Thread.sleep(5000);
	meetings.click();
	Thread.sleep(5000);
	verifyMeeting(meetingLink);
	
}

public void VerifyMeetingAll(String meetingLink) throws InterruptedException {
	
	Thread.sleep(5000);
	Communications.click();
	Thread.sleep(5000);
	all.click();
	Thread.sleep(5000);
	verifyMeeting(meetingLink);
	
}

public void verifyMeetingAll(String meetingLink) throws InterruptedException {
	
	Thread.sleep(5000);
	Communications.click();
	Thread.sleep(5000);
	all.click();
	Thread.sleep(5000);
	verifyMeeting(meetingLink);
	
}


public void verifyMeeting(String Link) throws InterruptedException {
	
	Thread.sleep(5000);
	driver.findElement(By.linkText(Link)).click();
	
	String cText18 = meetingStatus.getText();
				
	softAssertion.assertEquals(cText18, "Scheduled", "Meeting Status data mismatch in meetings Tab");
	
	
	System.out.println("Meeting Data......................................." + cText18);
	
	driver.navigate().to(prop.getProperty("url"));	
	
}


public void navigateToCoClient() throws InterruptedException{
	
	
	
}



public String[] scheduleReferralAppointment() throws InterruptedException, ParseException {
	
	ReferralAppointment ref = new ReferralAppointment();
	String[] meetingLinks = ref.scheduleAppointment(meetingDate);
	return meetingLinks;
	
}


public String commentsArray(String commentText) throws InterruptedException, ParseException {
	
	
	String[] splitStr2 = commentText.split("\\s+");
	int commentLength = splitStr2.length;
	String[] time1 = Arrays.copyOfRange(splitStr2, commentLength-4,commentLength);
	String commentsData = time1[0] +" "+ time1[1] +" "+ time1[2]+" "+time1[3];
	System.out.println("commentsData......................................." + commentsData);
	return commentsData;	
}

//index didnt work so i replaced this with se by text
public void selectOutcome(int i) throws InterruptedException, ParseException {
	
	if (i==0){TestUtil.SelectDropDownOption(outcome, "Phone Call - Not Reached");}
	else if(i==1){TestUtil.SelectDropDownOption(outcome, "Phone Call - Reached");}
	else if(i==2){TestUtil.SelectDropDownOption(outcome, "Meeting");}
	
	}

public void verifyExistingTasks() throws InterruptedException {
	
	clickNextButton();
	Thread.sleep(5000);
	
	if(!driver.findElements(By.xpath("//div[contains(text(),'Do not close any existing tasks')]")).isEmpty()){
		createNewTask.click();
    }else{
    	System.out.println("No Previous Tasks screen displayed");
    }

}
	

public String emailupdate() throws InterruptedException {
	
	 return emailupdate;	
	
	
}






}
