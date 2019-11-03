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

	@FindBy(xpath = "//b[contains(text(),'Create Opportunity')]")
	WebElement CreateOpportunityLabel;

	
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
	
	
	@FindBy(xpath = "//input[@name='Create_Follow_up_Phone_Call' and @type='checkbox']//..")
	WebElement scheduleType;
	
	//@FindBy(xpath = "//div[contains(text(),'Schedule Appointment')]")
	//WebElement scheduleApp;
	
	//@FindBy(xpath = "//input[@name='Create_Appointment' and @type='checkbox']//..")
	//WebElement scheduleApp;
	
	
	@FindBy(xpath = "//input[@name='Create_Appointment']/following-sibling::label//span")
	WebElement scheduleApp;

	
	@FindBy(xpath = "//input[@name='Create_To_Do' and @type='checkbox']//..")
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
	
	@FindBy(xpath = "//div[contains(text(),'Subject')]/../../../following-sibling::div//input")
	WebElement subjectArea;
	
	@FindBy(xpath = "(//div[contains(text(),'End Date and Time')]/../../../following-sibling::div//input)[1]")
	WebElement meetingEndDate1;
	
	@FindBy(xpath = "(//div[contains(text(),'End Date and Time')]/../../../following-sibling::div//input)[2]")
	WebElement meetingEndTime1;
	

	@FindBy(xpath = "//div[contains(text(),'How Did You Meet With Client')]/../../../following-sibling::div/select")
	WebElement meetwithClient;
	
	@FindBy(xpath = "//div[contains(text(),'Select Meeting Outcome')]/../../../following-sibling::div/select")
	WebElement meetingOutcome;
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement NextBtn;
	
	
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
		

		static String[] ret = addDaysToCurrentTime(7);
	    String enteredDate = ret[0];
	    static String verifyDate = ret[1];
	    static String meetingDate = ret[2];
	    static String meetingformattedDate = ret[3];
	    static String uniqueid = ret[4];
	    static String unplannedDate = ret[6];
	    
	    String schedule1 = "Phone Call";
		String schedule2 = "ToDo";
		String schedule3 = "Appointment";
		
	 
		static String commentsToEnter = "TestingPurpose " + uniqueid;
		static String[] splitStr1 = timeStamp.split("\\s+");


		public DetailsPage() {
		PageFactory.initElements(driver, this);
		
		}
	
//	SoftAssert softAssertion = new SoftAssert();
//	SoftAssert softAssertion2 = new SoftAssert();
//	SoftAssert softAssertion3 = new SoftAssert();
	
	/*
	String schedule1 = "Phone Call";
	String schedule2 = "ToDo";
	String schedule3 = "Appointment";
	*/

	public void enterComments(int i) throws InterruptedException, IOException, ParseException {
		
	
		
			//Eleminate Thread sleep via check
			//Thread.sleep(5000);
	
		
		
			TestUtil.waitForElement("Comments", comments);
		
		
			System.out.println("TimeStamp......................" + timeStamp );
			prop.setProperty("Call Start Time", timeStamp);
			
			for(int j=0; j<5; j++){		
				
			//See if we can remove it just incase if it doesnot help
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.COMMAND,Keys.SUBTRACT));		
		}

		//Thread.sleep(5000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		prop.setProperty("EnteredComments", commentsToEnter);
		
		Thread.sleep(2000);
		
		selectOutcome(i);
		
		
		TestUtil.waitForElement("Management", solutionsDiscussed );
		//Thread.sleep(5000);
		
		solutionsDiscussed.click();
		
		//Thread.sleep(5000);
		
		
		
		clickNextButton();	
		
		
		TestUtil.waitForElement("Comments", comments);
		
		Thread.sleep(5000);
		
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
	

	public void scheduleworkflow(String schedule) throws InterruptedException {
		
		if (schedule.equals(schedule1)) {
			
			//Thread.sleep(2000);		
			
			//TestUtil.waitForElement("Future Phone Call", futurePhoneCall);
			//assertTrue(TestUtil.isElementPresent(enterSubject_Phone));
			
			//TestUtil.waitForElement("DueDate_ToDo", enterDate1);
			
			TestUtil.waitForElement("Future Phone Call", futurePhoneCall);
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
	}

	
	public void createFutureMeeting() {
		//To Do......
		}


	public void reached_schedule(int i, String sched) throws InterruptedException, Exception {
		
		//Thread.sleep(5000);
		
		TestUtil.waitForElement("Comments", comments);
		commentsTextarea.sendKeys(commentsToEnter);
		Thread.sleep(2000);
		
		prop.setProperty("EnteredComments", commentsToEnter);
		prop.setProperty("Call Start Time", timeStamp);
		
		solutionsDiscussed.click();
		System.out.println(i);
		
		selectOutcome(i);
		System.out.println("index : " +i);
	
		
		if      (sched.equals(schedule3)) {CreateOpportunityLabel.click(); 	scheduleApp.click();} 
		else if (sched.equals(schedule2)) {CreateOpportunityLabel.click();	toDo.click();} 
		else if (sched.equals(schedule1)) {CreateOpportunityLabel.click();	scheduleType.click();}
		
		
		clickNextButton();	
		
		
		if (driver.findElements(By.xpath("//div[contains(text(),'Open Tasks')]")).size() > 0){
			 NextBtn.getSize();	{ clickNextButton();}
		}
		
		scheduleworkflow(sched);
		
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
	


public String[] reached_scheduleAppointment() throws InterruptedException, ParseException {
	
	commentsTextarea.sendKeys(commentsToEnter);
	//Select outcome1 = new Select(outcome);
	//outcome1.selectByIndex(1);
	 //selectOutcome(1);
	TestUtil.SelectDropDownOption(outcome, "Reached");
	
	solutionsDiscussed.click();
	scheduleApp.click();
	clickNextButton();
	Thread.sleep(5000);	
	String[] meetingLinks = createBDAppointment(meetingDate);
	nextButton1.click();
	return meetingLinks;
}


public void reached_scheduleAppointment1() throws InterruptedException, ParseException, AWTException {
	
	
	jse2.executeScript("arguments[0].scrollIntoView()", commentsTextarea);
	
	commentsTextarea.sendKeys(commentsToEnter);
	//Select outcome1 = new Select(outcome);
	//outcome1.selectByIndex(1);
	//selectOutcome(1);
	TestUtil.SelectDropDownOption(outcome, "Reached");
	
	//TestUtil.waitforelement(SchedulePanelRecognize);
	//TestUtil.waitforelement(scheduleApp);
	
	solutionsDiscussed.click();
	
	//TestUtil.clickElement(scheduleApp);
	
	//JavascriptExecutor jsExec = (JavascriptExecutor) driver; 
	//jsExec.executeScript("document.getElementsByClassName('col right-col slds-size--3-of-12 ').scrollDown += 100");
	
	//Thread.sleep(5000);
	
	//driver.findElement(By.xpath("//span[@class='slds-card__header-link slds-text-heading_small']")).click();
	
	//JavascriptExecutor js;
	//js = (JavascriptExecutor) driver;
	//Dimension d = new Dimension(800,480);
	//driver.manage().window().maximize();
	//driver.findElement(By.xpath("//span[@class='slds-card__header-link slds-text-heading_small']")).click();
	//js.executeScript("window.scrollTo(0,17)");
    
	
	
	
	
	//driver.findElement(By.xpath("//div[@class='slds-card__body slds-card__body_inner centerWrapper flowruntimeBody']//div[@class='body']")).click();
	//driver.findElement(By.xpath("//b[contains(text(),'Schedule')]")).click();
	//driver.findElement(By.xpath("//b[contains(text(),'Create Opportunity')]")).click();
	
	//TestUtil.clickvisibleElement(CreateOpportunityLabel);
	
	CreateOpportunityLabel.click();
	Thread.sleep(3000);
	
	scheduleApp.click();
	Thread.sleep(3000);
	
	clickNextButton();
	Thread.sleep(5000);

/*	
	//If Next Button is present on the screen then click Next Button 
    NextBtn.getSize();
	{
   	 clickNextButton();
    }

*/		
	createFutureAppointment();
	
	
	NextBtn.getSize();
	{
	 clickNextButton();
	}
	
}

public void unplannedAppointment() throws InterruptedException, ParseException {
	Thread.sleep(5000);
	commentsTextarea.sendKeys(commentsToEnter);
	//Select outcome1 = new Select(outcome);
	//outcome1.selectByIndex(2);
	//selectOutcome(2);
	TestUtil.SelectDropDownOption(outcome, "Meeting");
	solutionsDiscussed.click();

	clickNextButton();
	Thread.sleep(5000);
	subjectArea.sendKeys(commentsToEnter);
	meetingEndDate1.sendKeys(unplannedDate);
	meetingEndTime1.click();
	meetingEndTime1.clear();
	meetingEndTime1.sendKeys("8:00 PM");
	nextButton1.click();
	Thread.sleep(5000);
	
	Select mclient = new Select(meetwithClient);
	mclient.selectByIndex(1);
	
	Select moutcome = new Select(meetingOutcome);
	moutcome.selectByIndex(1);
	
	nextButton1.click();
	

	
}

private void createFutureAppointment() throws InterruptedException {
	
	jse2.executeScript("arguments[0].scrollIntoView()", meetingClient);

	//Select mClient = new Select(meetingClient);
	//mClient.selectByIndex(1);
	
	TestUtil.SelectDropDownOption(meetingClient, "On-Phone");
	Thread.sleep(3000);
	meetingStartDate.sendKeys(enteredDate);
	meetingStartTime.click();
	meetingStartTime.clear();
	meetingStartTime.sendKeys("12:00 PM");
	//meetingEndDate.sendKeys(enteredDate);
	//meetingEndTime.click();
	//meetingEndTime.clear();
	//meetingEndTime.sendKeys("12:30 PM");
//	assignedTo.sendKeys("Rhonda Kemp");
//	meetingLocation.sendKeys("AZ - Phoenix - Chandler (Appt Only)");
	
	
	meetingDuration.sendKeys("60");
	
	nextButton1.click();
	Thread.sleep(3000);
	
	jse2.executeScript("arguments[0].click()", nextButton1);
	//nextButton1.click();
	
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
	
	if (i==0){TestUtil.SelectDropDownOption(outcome, "Not Reached");}
	else if(i==1){TestUtil.SelectDropDownOption(outcome, "Reached");}
	else if(i==2){TestUtil.SelectDropDownOption(outcome, "Meeting");}
	
	}


public void setuniqueId() throws InterruptedException, ParseException {
	
	uniqueid = generateRndmNum(uniqueid); 
	}


public static String generateRndmNum(String range) {
    
	 int intrange = Integer.parseInt(range);
	 Random rand = new Random(System.currentTimeMillis());
	 int num = rand.nextInt(intrange);
	 String snum = Integer.toString(num); 
	 
	  return snum;
	
	}



}
