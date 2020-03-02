package com.crm.qa.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import com.crm.qa.pages.RetailAccount;


public class DetailsPage extends TestBase {
	
	
	@FindBy(xpath = "//div[contains(text(),'Comments')]/../../../following-sibling::div/div/textarea")
	WebElement commentsTextarea;

	@FindBy(xpath = "//div[contains(text(),'Comments')]")
	WebElement comments;

	@FindBy(xpath = "//div[contains(text(),'Management')]")
	WebElement solutionsDiscussed;
	
	@FindBy(xpath = "//div[contains(text(),'GST$ Conversation')]/ancestor::div[@class='bBody']//select")
	WebElement gtsConversionDrpDwn;
	
	@FindBy(xpath = "//div[contains(text(),'Create Workplace Opportunity')]")
	WebElement createWorkplaceOpportunity;
	
	
	@FindBy(xpath = "//div[contains(text(),'Outcome')]")
	WebElement outcomeLabel;
	
	@FindBy(xpath = "//div[contains(text(),'Outcome')]/../../../following-sibling::div/select")
	WebElement outcome;

	@FindBy(xpath = "//span[contains(text(),'Create Opportunity')]")
	WebElement CreateOpportunityLabel;

	//@FindBy(xpath = "//span[contains(text(),'Create Opportunity')]")
	//WebElement CreateOpportunityLabel;
	
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
	
	@FindBy(xpath = "//span[contains(text(),'Call Outcome')]/../following-sibling::div/span/span")
	WebElement calloutcomeText;	
	
	@FindBy(xpath = "//span[contains(text(),'Call Type')]/../following-sibling::div/span/span")
	WebElement callType;	
	
	@FindBy(xpath = "//span[contains(text(),'Solutions Discussed')]/../following-sibling::div/span/span")
	WebElement solutions;
	
	@FindBy(xpath = "(//a[@data-refid='recordId'])[1]")
	WebElement oppLink;
	
	@FindBy(xpath = "(//a[contains(text(),'Ford-401K Roll-in')])")
	WebElement oppLink1;
	
	@FindBy(xpath = "(//a[contains(text(),'Ford-IRA-Roth IRA-401K Roll-in')])[1]")
	WebElement oppLink2;

	
	@FindBy(xpath = "(//span[contains(text(),'Last Activity Date')])[2]/../following-sibling::div/span/span")
	WebElement lastActivityDate;
	
	@FindBy(xpath = "(//span[contains(text(),'Stage')])[2]/../following-sibling::div/span/span")
	WebElement stage;
	
	
	@FindBy(xpath = "//span[contains(text(),'Schedule a Future Activity')]/ancestor::div[@class='content']//label[contains(@for, 'Future_Phone')]")
	WebElement schedulePhoneCall;
	

	@FindBy(xpath = "//span[contains(text(),'Schedule a Future Activity')]/ancestor::div[@class='content']//label[contains(@for, 'Future_Todo')]")
	WebElement scheduleToDo;
	
	@FindBy(xpath = "//span[contains(text(),'Schedule a Future Activity')]/ancestor::div[@class='content']//label[contains(@for, 'Future_Appointment')]")
	WebElement scheduleMeeting;
	
	@FindBy(xpath = "//span[contains(text(),'Log an Interaction')]/ancestor::div[@class='content']//label[contains(@for, 'Future_Phone')]")
	WebElement schedulePhoneCall_LoganActivity;
	

	@FindBy(xpath = "//span[contains(text(),'Log an Interaction')]/ancestor::div[@class='content']//label[contains(@for, 'Future_Todo')]")
	WebElement scheduleToDo_LoganActivity;
	
	@FindBy(xpath = "//span[contains(text(),'Log an Interaction')]/ancestor::div[@class='content']//label[contains(@for, 'Future_Appointment')]")
	WebElement scheduleMeeting_LoganActivity;
	
	
	
	
	
	
	@FindBy(xpath = "//div[contains(text(),'Future Phone Call')]")
	WebElement futurePhoneCall;
	
	
	@FindBy(xpath = "//div[contains(text(),'Personal Advisor')]")
	WebElement futureToDo;
	
	@FindBy(xpath = "//div[contains(text(),'Future To-Do')]")
	WebElement futureToDo1;

	
	@FindBy(xpath = "//div[contains(text(),'Personal Advisor')]")
	WebElement scheduleTeamMeetingScroll;
	
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
	
	@FindBy(xpath = "//div[contains(text(),'Meeting Duration (Minutes)')]//ancestor::div[@class='bBody']//div//select")
	WebElement meetingDuration;
	
	@FindBy(xpath = "//label[contains(text(),'Assigned To')]/following-sibling::div//input")
	WebElement assignedTo;
	
	@FindBy(xpath = "//label[contains(text(),'Meeting Location')]/following-sibling::div//input")
	WebElement meetingLocation;
	
	
	@FindBy(xpath = "//input[@name='Subject_ToDo' and @type='text']")
	WebElement enterSubject_ToDo;
	
	@FindBy(xpath = "//input[@name='Subject_Phone' and @type='text']")
	WebElement enterSubject_Phone;
	
	@FindBy(xpath = "//input[@name='Subject0' and @type='text']")
	WebElement enterSubject_Meeting;
	
	
	@FindBy(xpath = "//div[contains(text(),'Open Meetings')]")
	WebElement openMeetings;
	
	
	@FindBy(xpath = "//div[contains(text(),'Due Date')]/../../following-sibling::div/div/input")
	WebElement enterDate2;
	
	@FindBy(xpath = "(//button[contains(text(),'Previous')]/..//following-sibling::button)[last()]")
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
	
	@FindBy(xpath = "//b[contains(text(),'Schedule a Meeting with yourself or the team')]")
	WebElement scheduleteammeetingLbl;
	
	@FindBy(xpath = "//span[contains(text(),'Call Outcome')]/../following-sibling::div/span/span")
	WebElement taskStatus;	
	
	@FindBy(xpath = "//li[@title='To-Do']")
	WebElement todoTab;
	
	@FindBy(xpath = "//input[contains (@name ,'Subject')]")
	WebElement subjectArea;
	
	@FindBy(xpath = "(//input[contains (@name ,'Start_Date_and_Time')])[1]")
	WebElement meetingStartDate1;
	
	@FindBy(xpath = "(//input[contains (@name ,'Start_Date_and_Time')])[2]")
	WebElement meetingStartTime1;
	
	@FindBy(xpath = "(//span[contains(text(),'Start Date and Time')]/../../..//input)[1]")
	WebElement meetingEndDate1;
	
	@FindBy(xpath = "(//span[contains(text(),'Start Date and Time')]/../../..//input)[2]")
	WebElement meetingEndTime1;
	
	@FindBy(xpath = "//div[contains(text(),'How Did You Meet With Client')]/../../../following-sibling::div/select")
	WebElement meetwithClient;
	
	@FindBy(xpath = "//div[contains(text(),'Select Meeting Outcome')]/../../../following-sibling::div/select")
	WebElement meetingOutcome;
	
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
	
	
	@FindBy(xpath = "//span[contains(text(),'Account Details')]")
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
	
	@FindBy(xpath = "(//a[contains (@class, 'datePicker')]/..//input[contains (@class, ('input'))])[1]")
	WebElement dobInput;
	
	@FindBy(xpath = "(//span[contains (text(), ('Work Phone'))]/../..//input)[1]")
	WebElement workphoneEditInput;
	
	
	@FindBy(xpath = "//span[text()= 'Gender'] /../../..//a[contains (@role, ('button'))]")
	WebElement genderDropDown;
	
	
	@FindBy(xpath = "//span[contains(text(),'Address & Other Contact Information')]")
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
	
	@FindBy(xpath = "//div[contains(text(),'Outcome')]/ancestor::div[contains (@class, ('slds-tabs_card'))]//button[contains(text(),'Next')]")
	WebElement logCallNextButton;
	
	@FindBy(xpath = "//span[contains(text(),'Schedule a Future Activity')]/ancestor::div[@class ='content']//button[contains(text(),'Next')]")
	WebElement futureActivityNextButton;
	
	@FindBy(xpath = "//div[contains (@class, ('content'))]//button[contains(text(),'Previous')]/following-sibling::button[contains(text(),'Next')]")
	WebElement futureActivityNextButton1;

	@FindBy(xpath ="//span[contains(text(),'Create Opportunity')]/ancestor::div[@class= 'content']//button[contains(text(),'Next')]")
	WebElement opttyNextButton;
	
	@FindBy(xpath = "//div[contains(text(),'Do you want to create an Opportunity?')]/ancestor::div[@class ='bBody']//label[contains (@for, ('No_Selected'))]")
	WebElement noOpttyRdBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Do you want to create an Opportunity?')]/ancestor::div[@class ='bBody']//label[contains (@for, ('Yes_Selected'))]")
	WebElement yesOpttyRdBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Do you want to create an Opportunity?')]/ancestor::div[@class ='content']//button[contains(text(),'Next')]")
	WebElement noOpttyNxtBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Do you want to schedule a future activity')]/ancestor::div[@class ='bBody']//label[contains (@for, ('No_Selected'))]")
	WebElement noScheduleFutureActivityRdBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Do you want to schedule a future activity')]/ancestor::div[@class ='bBody']//label[contains (@for, ('Yes_Selected'))]")
	WebElement yesScheduleFutureActivityRdBtn;
	
	@FindBy(xpath = "//div[contains (@class, ('content'))]//button[contains(text(),'Previous')]/following-sibling::button[contains(text(),'Next')]")
	WebElement scheduleMeetingNextButton;
	
	@FindBy(xpath = "//div[contains (@class, ('content'))]//button[contains(text(),'Previous')]/following-sibling::button[contains(text(),'Finish')]")
	WebElement scheduleMeetingFinishButton;
	
	@FindBy(xpath = "(//button[@title = 'More Tabs'])[last()]")
	WebElement moreTab;
	
	@FindBy(xpath = "//lightning-menu-item[1]//a[1]//span[1]")
	WebElement emailOption;
	
	@FindBy(xpath = "//a[text()='Email']")
	WebElement emailTab;
	
	@FindBy(xpath = "//span[contains(text(),'Compose')]")
	WebElement composeEmailBtn;
	
	@FindBy(xpath = "//div[contains (@class, ('container needOauth'))]//span[text()='No, Send through Salesforce']")
	WebElement sendEmailthroughSalesForceBtn;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Subject...'])[1]")
	WebElement emailSubject;
	
	
	
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;


		static SimpleDateFormat timestamp = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		static String timeStamp = timestamp.format(new Date());
		 
		SimpleDateFormat timestamp12 = new SimpleDateFormat("MM/dd/yyyy");
		String timeStamp12 = timestamp12.format(new Date());

	 
		SimpleDateFormat timestamp11 = new SimpleDateFormat("M/d/yyyy");
		String timeStamp11 = timestamp11.format(new Date());
		String[] dateStr12 = timeStamp11.split("\\s+");
		

		public static String  enteredDate;
		public static String  verifyDate;
		public static String  meetingDate;
		public static String  meetingformattedDate;
	    public static String  uid ;
	    public static String  unplannedDate;
	    public static String  emailupdate;
	    
	    
	    String schedule_PhoneCall = "PhoneCall";
		String schedule_ToDo = "ToDo";
		String schedule_Meeting = "Meeting";
		
		public String reached = "Reached";
		public String notReached = "Not Reached";
		public String meeting = "Meeting";
		
		public static String commentsToEnter;
		static String[] splitStr1 = timeStamp.split("\\s+");

		
		
		SoftAssert softAssertion = new SoftAssert();
		
		
		public DetailsPage() {PageFactory.initElements(driver, this);}
	
		
		

	
	
//*********************************Log a Call Interaction for Reach/Not Reached****************************************************
/*		
	public void logacallInteraction(String Outcome, String gtsConversion, String createOptty, String createFutureAtivity) throws InterruptedException, IOException, ParseException {	
	
		enterComments (Outcome, gtsConversion);
		
		if (!"Not Reached".equals(Outcome)&& ((!"Field Advisor".contains(RetailAccount.userProfile)) || (!"Field CSM".contains(RetailAccount.userProfile))))
		{
			loganInteractionCreateOptty(createOptty);
			loganInteractionFutureActivity(createFutureAtivity);
		
			if (RetailAccount.userProfile.contains("Field Advisor")||RetailAccount.userProfile.contains("Field CSM")){jse2.executeScript("arguments[0].click()", logCallNextButton);Thread.sleep(5000);}
			else {jse2.executeScript("arguments[0].click()", noOpttyNxtBtn);Thread.sleep(5000);}
			
		}
		
	}	
*/		
	public void logacallInteraction(String Outcome, String gtsConversion, String createOptty, String createFutureAtivity) throws InterruptedException, IOException, ParseException {	
		
		enterComments (Outcome, gtsConversion);
		
		if ((RetailAccount.userProfile.contains("Field Advisor") || (RetailAccount.userProfile.contains("Field CSM"))))
		{
			loganInteractionCreateOptty(createOptty);
			loganInteractionFutureActivity(createFutureAtivity);
			jse2.executeScript("arguments[0].click()", logCallNextButton);Thread.sleep(5000);
		}
		else if (!"Not Reached".equals(Outcome)){
			loganInteractionCreateOptty(createOptty);
			loganInteractionFutureActivity(createFutureAtivity);
			jse2.executeScript("arguments[0].click()", noOpttyNxtBtn);Thread.sleep(5000);
		}
		else {
			//jse2.executeScript("arguments[0].click()", noOpttyNxtBtn);Thread.sleep(5000);
			loganInteractionFutureActivity(createFutureAtivity);
			jse2.executeScript("arguments[0].click()", futureActivityNextButton1);
		}	
		
		
		//	if (RetailAccount.userProfile.contains("Field Advisor")||RetailAccount.userProfile.contains("Field CSM")){jse2.executeScript("arguments[0].click()", logCallNextButton);Thread.sleep(5000);}
		//	else {jse2.executeScript("arguments[0].click()", noOpttyNxtBtn);Thread.sleep(5000);}
			
		
		
	}	
	
	
	
	
	public void enterComments(String Outcome, String gtsConversion) throws InterruptedException, IOException, ParseException {
		
		String commentsToEnter = "TestingPurpose " + uid; Thread.sleep(8000);
			
		if (RetailAccount.userProfile.contains("Field Advisor")||RetailAccount.userProfile.contains("Field CSM")){
			
			commentsTextarea.sendKeys(commentsToEnter);Thread.sleep(2000);
			TestUtil.SelectDropDownOption(outcome, Outcome);
		
		}
		
		else {
		
			if (gtsConversion.toLowerCase().equals("gtsconversionno")){ gtsConversion = "No";}
			else if (gtsConversion.toLowerCase().equals("gtsconversionyes")){ gtsConversion = "Yes";}
		
		
			commentsTextarea.sendKeys(commentsToEnter);Thread.sleep(2000);
			TestUtil.SelectDropDownOption(outcome, Outcome);
			jse2.executeScript("arguments[0].click()", solutionsDiscussed);
			TestUtil.SelectDropDownOption(gtsConversionDrpDwn, gtsConversion);
			jse2.executeScript("arguments[0].click()", logCallNextButton);Thread.sleep(5000);
			
		}
		
		
	}
	
	
	
	public void loganInteractionCreateOptty(String createOptty) throws InterruptedException {
	
		if (createOptty.toLowerCase().equals("createopttyno")){jse2.executeScript("arguments[0].click()", noOpttyRdBtn);}
		else if(createOptty.toLowerCase().equals("createopttyyes")){jse2.executeScript("arguments[0].click()", yesOpttyRdBtn);}
	}
	
	public void loganInteractionFutureActivity(String createFutureActivity) throws InterruptedException {
		
		if (createFutureActivity.toLowerCase().equals("futureactivityno")){jse2.executeScript("arguments[0].click()", noScheduleFutureActivityRdBtn);}
		else if(createFutureActivity.toLowerCase().equals("futureactivityyes")){jse2.executeScript("arguments[0].click()", yesScheduleFutureActivityRdBtn);}
	}

//*********************************Log a Call Interaction for Unplanned Meeting****************************************************
	
	public void logacallInteractionforMeeting(String Outcome, String gtsConversion, String meetClient, String meetOutcome, String meetingExist) throws InterruptedException, IOException, ParseException {	
		
		enterComments (Outcome, gtsConversion);
		
		if (RetailAccount.userProfile.contains("Field Advisor")||RetailAccount.userProfile.contains("Field CSM")){	
			loganInteractionCreateOptty("createopttyno");
			loganInteractionFutureActivity("futureactivityno");
			jse2.executeScript("arguments[0].click()", noOpttyNxtBtn);Thread.sleep(5000);
			
		}
		
		
		if (meetingExist.toLowerCase().equals("meetingexistyes")){
	
			jse2.executeScript("arguments[0].click()",nextButton1);
				
			TestUtil.SelectDropDownOption(meetwithClient, meetClient);
			TestUtil.SelectDropDownOption(meetingOutcome, meetOutcome);
			jse2.executeScript("arguments[0].click()", nextButton1);	}
			
		else {
			unplannedAppointment(meetClient,meetOutcome);
				if ((!"Field Advisor".contains(RetailAccount.userProfile)||(!"Field CSM".contains(RetailAccount.userProfile)))){
					loganInteractionCreateOptty("createopttyno");
					loganInteractionFutureActivity("futureactivityno");
					jse2.executeScript("arguments[0].click()", noOpttyNxtBtn);Thread.sleep(5000);
			}
		}
	}
	
	
//***********************************Unplanned Appointment************************************************************

	public void unplannedAppointment(String meetClient, String meetOutcome) throws InterruptedException, ParseException, IOException {	
		
		Thread.sleep(3000);
		subjectArea.sendKeys(commentsToEnter);
		
		meetingEndDate1.clear();meetingEndDate1.sendKeys(unplannedDate);
		jse2.executeScript("arguments[0].click()",meetingEndTime1);meetingEndTime1.clear();meetingEndTime1.sendKeys("8:00 PM", Keys.TAB);
		subjectArea.click(); jse2.executeScript("arguments[0].click()", nextButton1);
				
		Thread.sleep(3000);
		TestUtil.SelectDropDownOption(meetwithClient, meetClient);
		TestUtil.SelectDropDownOption(meetingOutcome, meetOutcome);
				
		jse2.executeScript("arguments[0].click()", nextButton1);

	}
	

//*********************************Reached Schedule***************************************************************	

	public void scheduleFutureActivity(String schedule) throws InterruptedException, Exception {
		
		if (RetailAccount.userProfile.equals("Field Advisor")||RetailAccount.userProfile.equals("Field CSM")){	
			
			Thread.sleep(10000);
			if (schedule.toLowerCase().equals("phonecall")) {Thread.sleep(2000); jse2.executeScript("arguments[0].click()", schedulePhoneCall);}
			else if (schedule.toLowerCase().equals("todo")) {Thread.sleep(2000);jse2.executeScript("arguments[0].click()",scheduleToDo);}
			else if (schedule.toLowerCase().equals("meeting")) {Thread.sleep(2000);jse2.executeScript("arguments[0].click()", scheduleMeeting);} 
			
			//jse2.executeScript("arguments[0].scrollIntoView()",schedulePhoneCall);
			Thread.sleep(2000);jse2.executeScript("arguments[0].click()",futureActivityNextButton);
			
		}
		
	/*	
		else {
			if (schedule.toLowerCase().equals("phonecall")) {Thread.sleep(2000);jse2.executeScript("arguments[0].click()", schedulePhoneCall);}
			else if (schedule.toLowerCase().equals("todo")) {Thread.sleep(2000);jse2.executeScript("arguments[0].click()",scheduleToDo);}
			else if (schedule.toLowerCase().equals("meeting")) {Thread.sleep(2000);jse2.executeScript("arguments[0].click()", scheduleMeeting);} 
			
			
			Thread.sleep(2000);
			//jse2.executeScript("arguments[0].click()",futureActivityNextButton);
			jse2.executeScript("arguments[0].click()",nextButton1);
			
		}
	*/	
		else {
			if (schedule.toLowerCase().equals("phonecall")) {Thread.sleep(2000);jse2.executeScript("arguments[0].click()", schedulePhoneCall_LoganActivity);}
			else if (schedule.toLowerCase().equals("todo")) {Thread.sleep(2000);jse2.executeScript("arguments[0].click()",scheduleToDo_LoganActivity);}
			else if (schedule.toLowerCase().equals("meeting")) {Thread.sleep(2000);jse2.executeScript("arguments[0].click()", scheduleMeeting_LoganActivity);} 
			
			
			Thread.sleep(2000);
			//jse2.executeScript("arguments[0].click()",futureActivityNextButton);
			jse2.executeScript("arguments[0].click()",nextButton1);
			
		}
		
		
		
		
		/*-------------Keep this part of the code, might need it in future----------------------
			if (driver.findElements(By.xpath("//div[contains(text(),'Open Tasks')]")).size() > 0){ NextBtn.getSize();{ clickNextButton();}}
			---------------------------------------------------------------------------------------*/
				
		
		futureActivityScheduleWorkflow(schedule);
		
	}
	
	
//************************************Schedule WorkFlow***************************************************************
		
	public void futureActivityScheduleWorkflow(String schedule) throws InterruptedException {
			
		//Thread.sleep(2000);
			
		String commentsToEnter = "TestingPurpose " + uid;
			
		if (schedule.toLowerCase().equals("phonecall")){
			enterSubject_Phone.clear(); enterSubject_Phone.sendKeys(commentsToEnter);
			enterDate1.sendKeys(enteredDate, Keys.TAB);
			jse2.executeScript("arguments[0].scrollIntoView()", futurePhoneCall);
			jse2.executeScript("arguments[0].click()",nextButton1);
			
		}
		
		else if(schedule.toLowerCase().equals("todo")) {
			enterSubject_ToDo.clear(); enterSubject_ToDo.sendKeys(commentsToEnter);
			enterDate1.sendKeys(enteredDate, Keys.TAB);
			jse2.executeScript("arguments[0].scrollIntoView()", futureToDo1);
			jse2.executeScript("arguments[0].click()",nextButton1);
				
		}
			
	
		else if (schedule.toLowerCase().equals("meeting")) { createFutureAppointment(); }
		
	}


		public void createFutureAppointment() throws InterruptedException {
			
			//jse2.executeScript("arguments[0].scrollIntoView()", scheduleTeamMeetingScroll);
		
			TestUtil.SelectDropDownOption(meetingClient, "On-Phone Meeting");
			
			String LoggedinUser;
			
			try{LoggedinUser = LoggedUser.getText().substring(11);}
			catch (Exception e){LoggedinUser = "Aaron Rich";}
			
			meetingStartDate.sendKeys(enteredDate);
			meetingStartTime.click();meetingStartTime.clear();meetingStartTime.sendKeys("12:00 PM");meetingStartTime.sendKeys(Keys.TAB);
			meetingDuration.sendKeys("60");
			
			jse2.executeScript("arguments[0].click()", assignedTo);
			assignedTo.sendKeys(LoggedinUser, Keys.ENTER);
			
			jse2.executeScript("arguments[0].click()", scheduleMeetingNextButton);Thread.sleep(2000);
			jse2.executeScript("arguments[0].click()", scheduleMeetingFinishButton);
			
			
		}
		
		
//**********************************************************************************************************************
	
	
	
	
	
	

	public String[] reached_scheduleAppointment(int i) throws InterruptedException, ParseException {
	
		String commentsToEnter = "TestingPurpose " + uid;
		
		//TestUtil.waitForElement("Comments", comments);
		
		Thread.sleep(3000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		//TestUtil.SelectDropDownOption(outcome, "Phone Call - Reached");
		selectOutcome(i);
		solutionsDiscussed.click();
		
		scheduleMeeting.click();
		
		jse2.executeScript("arguments[0].click()",futureActivityNextButton);
		Thread.sleep(5000);
		
		
		String[] meetingLinks = createBDAppointment(meetingDate);
		jse2.executeScript("arguments[0].click()",nextButton1);
		return meetingLinks;
	}


	public void reached_scheduleAppointment1(int i) throws InterruptedException, ParseException, AWTException {
	
		String commentsToEnter = "TestingPurpose " + uid;
		
		Thread.sleep(3000);
		commentsTextarea.sendKeys(commentsToEnter);
		
		//TestUtil.SelectDropDownOption(outcome, "Phone Call - Reached");
		
		//solutionsDiscussed.click();
		//jse2.executeScript("arguments[0].click()", solutionsDiscussed);
		
		selectOutcome(i);
		
		jse2.executeScript("arguments[0].scrollIntoView()", commentsTextarea);
		//logCallNextButton.click();
		jse2.executeScript("arguments[0].click()", logCallNextButton);
		
		Thread.sleep(3000);
		
		
		jse2.executeScript("arguments[0].click()", noOpttyRdBtn);Thread.sleep(2000); 
		jse2.executeScript("arguments[0].click()", noOpttyNxtBtn);Thread.sleep(2000);
		
		Thread.sleep(2000);
		jse2.executeScript("arguments[0].scrollIntoView()", CreateOpportunityLabel);
		//CreateOpportunityLabel.click();
		//scheduleApp.click();
		jse2.executeScript("arguments[0].click()", scheduleMeeting);
		
		Thread.sleep(2000);
		//futureActivityNextButton.click();
		jse2.executeScript("arguments[0].click()", futureActivityNextButton);
		
	
		/*-------------Keep this part of the code, might need it in future----------------------
			
			If Next Button is present on the screen then click Next Button 
	    	NextBtn.getSize();{ clickNextButton(); }
	
		---------------------------------------------------------------------------------------*/		
	
		Thread.sleep(5000);
		createFutureAppointment();
		
		
	}

	
	
	public void updateAccountDetails() throws InterruptedException {
		
		Thread.sleep(5000);
		jse2.executeScript("arguments[0].click()",emailEditBtn);
		emailEditInput.clear();
		Thread.sleep(2000);
		emailEditInput.sendKeys(emailupdate);
		Thread.sleep(3000);
		workphoneEditInput.clear();
		workphoneEditInput.sendKeys("9998887777");
		workphoneEditInput.sendKeys(Keys.TAB);
		
		Thread.sleep(5000);
		jse2.executeScript("arguments[0].click()",updateSaveBtn);
		
		Thread.sleep(8000);
		jse2.executeScript("arguments[0].scrollIntoView()", scrolltoAccountDetails);
		
		
		Thread.sleep(3000);
		jse2.executeScript("arguments[0].click()",genderEditBtn);
		Thread.sleep(3000);
		genderDropDown.click();
		genderMale.click();
	
		dobEditInput.click();
		dobInput.clear();
		dobInput.sendKeys("12/11/1972");
		dobInput.sendKeys(Keys.TAB);
		
		
		jse2.executeScript("arguments[0].click()",updateSaveBtn);
		Thread.sleep(5000);
		jse2.executeScript("arguments[0].scrollIntoView()", scrolltoAddressInformation);
		Thread.sleep(3000);
		jse2.executeScript("arguments[0].click()",addressEditBtn);
		Thread.sleep(3000);
		textMailingStreet.clear();
		textMailingStreet.sendKeys("1234 Test Street");
		textMailingCity.clear();
		textMailingCity.sendKeys("Scottsdale");
		textMailingState.clear();
		textMailingState.sendKeys("AZ");
		textMailingZipCode.clear();
		textMailingZipCode.sendKeys("85254");
		
		jse2.executeScript("arguments[0].click()",updateSaveBtn);
		Thread.sleep(10000);
		driver.navigate().refresh();
	}
	
	
	public void verifyAccountDetails(String cEmail, String wPhone, String cGender, String cDateofBirth, String mAddress ) throws InterruptedException {
		
		Thread.sleep(5000);
		
		String clientEmail = getFieldData("Edit Client Provided Email");
		softAssertion.assertEquals(clientEmail, cEmail, "Email not matched.....");
		
		
		String workPhone = getFieldData("Edit Work Phone");
		softAssertion.assertTrue(workPhone.contains(wPhone), "Workphone not matched.....");
		
		
		jse2.executeScript("arguments[0].scrollIntoView()", scrolltoAccountDetails);
		Thread.sleep(3000);
		
		String gender = getFieldData("Edit Gender");
		softAssertion.assertEquals(gender, cGender, "Gender not matched....");
		
		String dateOfBirth = getFieldData("Edit Date of Birth");
		softAssertion.assertEquals(dateOfBirth, cDateofBirth, "DOB not matched.....");
		Thread.sleep(3000);

		jse2.executeScript("arguments[0].scrollIntoView()", scrolltoAddressInformation);
		Thread.sleep(2000);
		
		String mailingAddress = getFieldData("Edit Mailing Address").substring(0,42).trim();
		mailingAddress = mailingAddress.replace("\n", "").replace("\r", "");
		softAssertion.assertTrue(mailingAddress.contains(mAddress),  "Mailing Address not matched.....");
		
		softAssertion.assertAll();
		
	}
	
	public void validateEmail() throws InterruptedException, ParseException {

		
		jse2.executeScript("arguments[0].click()",moreTab);
		jse2.executeScript("arguments[0].click()",emailOption);
		
		//jse2.executeScript("arguments[0].click()",emailTab);
		jse2.executeScript("arguments[0].click()",composeEmailBtn);
		//jse2.executeScript("arguments[0].click()",sendEmailthroughSalesForceBtn);
		
		List<WebElement> dynamicElement = driver.findElements(By.xpath("(//input[@placeholder='Enter Subject...'])[1]"));
		if(dynamicElement.size() != 0){System.out.println("Element present");}
		
	
	}
	
	
	public void selectOutcome(int i) throws InterruptedException, ParseException {
				
		if (i==0){TestUtil.SelectDropDownOption(outcome, "Not Reached");}
		else if(i==1){TestUtil.SelectDropDownOption(outcome, "Reached");}
		else if(i==2){TestUtil.SelectDropDownOption(outcome, "Meeting");}
				
	}
	

/*	
	
	public void selectOutcome(int i) throws InterruptedException, ParseException {
			
		if (i==0){TestUtil.SelectDropDownOption(outcome, "Phone Call - Not Reached");}
		else if(i==1){TestUtil.SelectDropDownOption(outcome, "Phone Call - Reached");}
		else if(i==2){TestUtil.SelectDropDownOption(outcome, "Meeting");}
			
	}
*/	
		
	
	
	
	/*-------------Keep this part of the code, might need it in future----------------------
 	
 	String getdrop = driver.findElement(By.xpath("(//input[contains (@placeholder, ('Select an Option'))])[1]")).getText();
	String getdrop1 = driver.findElement(By.xpath("//*[contains (@href , ('/lightning/r/User'))][contains(@title, ('" + LoggedinUser + "'))]")).getText().substring(4).trim();
	
	if (driver.findElement(By.xpath("//*[contains (@href , ('/lightning/r/User'))][contains(@title, ('" + LoggedinUser + "'))]")).getText() != null){
	assignedtoDropDown.click();	assignedtoDropDown.sendKeys(LoggedinUser);
	driver.findElement(By.xpath("(//*[contains (@title, '" +LoggedinUser+ "')])[5]")).click();			
	}
	--------------------------------------------------------------------------------------------*/

	
	/*-------------Keep this part of the code, might need it in future----------------------

		if(driver.findElements(By.xpath("(//*[contains(@class,'slds-form slds-form_stacked')]/div[2]/div[2]/div[1]/div[2]/span[1])[3]")).isEmpty()){	
		
			String advisorsfdcId1 = prop.getProperty("advisorsfdcId1");
			editAssignedPlanner.click();assignedPlannerSelection.sendKeys(LoggedinUser);Thread.sleep(5000);
			driver.findElement(By.xpath("(//*[contains (@title, ('" +LoggedinUser+ "'))])[5]")).click();
		
			for (String currentWindow: driver.getWindowHandles())
		       driver.switchTo().window(currentWindow);
			{System.out.println(driver.getCurrentUrl()); driver.findElement(By.xpath("(//*[contains (@href, ('" + advisorsfdcId1 + "'))])[2]")).click();}
		
			Thread.sleep(3000);saveBtnAssignedPlanner.click();Reload.click();
	}

--------------------------------------------------------------------------------------------*/	
	
	
	
	
	public String getFieldData(String field) throws InterruptedException {
		
		//String fielddata = driver.findElement(By.xpath("//button[contains (@title, ('" +field+ "'))]/..//span[contains (@class, ('test-id'))]")).getText();
		String fielddata = driver.findElement(By.xpath("//span[contains(text(),('" +field+ "'))]/../..//span[contains(@class,'field-value')]")).getText();
		
		
		//span[contains(text(),'Date of Birth')]/../..//span[contains(@class,'field-value')]
		return fielddata;
	}
	
	
	
	public void closeExistingTask(int i) throws InterruptedException {
		
		for(int j=0; j<10; j++){driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.COMMAND,Keys.ADD));	}
		
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
	
	
	
	public String emailupdate() throws InterruptedException {return emailupdate;}

	
	
	
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

	
	
	private String[] createBDAppointment(String meetingDate) throws InterruptedException, ParseException {
		
		bdAppointment.click();
		
		String oldTab = driver.getWindowHandle();
		Thread.sleep(3000);
		
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		String newTab = (String) tabs.get(1);
		driver.switchTo().window(newTab);
		Thread.sleep(2000);	

		ReferralAppointment ref = new ReferralAppointment();
		String meetingLinks[] = ref.selectDate1(meetingDate);
			 
		driver.close();
		driver.switchTo().window(oldTab);
		return meetingLinks;
			 
		
	}

	
	
	public void clickNextButton() throws InterruptedException {
		List<WebElement> nextButtonCount = driver.findElements(By.xpath("//button[contains(text(),'Next')]"));
	    int nextButtonSize = nextButtonCount.size();

	    WebElement myelement = driver.findElement(By.xpath("(//button[contains(text(),'Next')])[" + nextButtonSize+ "]"));
	    JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	    jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
	    myelement.click();
	    Thread.sleep(10000);
	}
	
	
	public void exp() throws InterruptedException {
		Thread.sleep(5000);
	
	}
	
	
	
	
	
/*	======================================================================================================================	
	========================================================================================================================	
 	****OLD SCRIPTS  - Need to keep so they can be used in the future
  	========================================================================================================================	
  	========================================================================================================================*/	
	
	
	

	/*
	
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
	
*/

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



public void verifyExistingTasks() throws InterruptedException {
	
	clickNextButton();
	Thread.sleep(5000);
	
	if(!driver.findElements(By.xpath("//div[contains(text(),'Do not close any existing tasks')]")).isEmpty()){
		createNewTask.click();
    }else{
    	System.out.println("No Previous Tasks screen displayed");
    }

}
	








}
