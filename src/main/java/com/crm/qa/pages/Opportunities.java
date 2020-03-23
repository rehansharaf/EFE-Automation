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

public class Opportunities extends TestBase{

	

	public Opportunities() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@title='Lead Status:']/../../..//preceding-sibling::h3/div/a")
	WebElement leadLink1;
	
	@FindBy(xpath = "//span[@title='Opportunities']/following-sibling::span")
	WebElement oppCount;
	
	
	@FindBy(xpath = "//span[contains(@class,'title slds-truncate')][contains(text(),'test')]")
	WebElement leadLink2;


	@FindBy(xpath = "(//span[contains(text(),'Lead Status')])[1]/../following-sibling::div/span/span")
	WebElement leadStatus;

	
	@FindBy(xpath = "//span[contains(@class,'title')][contains(text(),'Lead')]")
	WebElement lead;
	
	@FindBy(xpath = "//span[contains(@class,'title')][contains(text(),'Opportunity')]")
	WebElement opportunity;

	@FindBy(xpath = "(//span[contains(text(),'Opportunities')])[last()]")
	WebElement opportunityLink_OutBound;
	
	
	@FindBy(xpath ="//span[@class='title slds-truncate'][contains(text(),'test')]")
	WebElement link;
	
	@FindBy(xpath = "(//span[contains(@class,'label bBody')][contains(text(),'Next')])[2]")
	WebElement nextButton;

	@FindBy(xpath = "//div[contains(text(),'Comments')]")
	WebElement comments;

	@FindBy(xpath = "//div[contains(text(),'Management')]")
	WebElement solutionsDiscussed;
	
	@FindBy(xpath = "(//span[contains(text(),'Stage')])[2]/../following-sibling::div/span/span")
	WebElement oppViewAll1;
	
	@FindBy(xpath = "//span[contains(text(),'View All')]")
	WebElement oppViewAll;	
	
	@FindBy(xpath = "(//span[text()='Create Opportunity'])[last()]")
	WebElement CreateOpportunityLabel;
	
	@FindBy(xpath = "(//div[contains(text(),'BM/PA Opportunity')])[last()]")
	WebElement opttyBMRdBtn;
	
	
	@FindBy(xpath = "(//div[contains(text(),'Workplace Opportunity')][last()])")
	WebElement opttyWPRdBtn;
	
	
	
	@FindBy(xpath = "(//div[text()='Create BM/PA Opportunity']/ancestor::div[@class='content']//button)[last()]")
	WebElement createOpttySectionNxtBtn;
		
	@FindBy(xpath = "//div[contains(text(),'Do you want to create an Opportunity?')]/ancestor::div[@class ='bBody']//label[contains (@for, ('Yes_Selected'))]")
	WebElement yesOpttyRdBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Do you want to create an Opportunity?')]/ancestor::div[@class ='bBody']//label[contains (@for, ('No_Selected'))]")
	WebElement noOpttyRdBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Do you want to schedule a future activity')]/ancestor::div[@class ='bBody']//label[contains (@for, ('No_Selected'))]")
	WebElement noScheduleFutureActivityRdBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Do you want to schedule a future activity')]/ancestor::div[@class ='bBody']//label[contains (@for, ('Yes_Selected'))]")
	WebElement yesScheduleFutureActivityRdBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Do you want to create an Opportunity?')]/ancestor::div[@class ='content']//button[contains(text(),'Next')]")
	WebElement opttyNextBtn;
	
	@FindBy(xpath ="//span[contains(text(),'Create Opportunity')]/ancestor::div[@class= 'content']//button[contains(text(),'Next')]")
	WebElement createopttyNextButton;
	
	@FindBy(xpath ="//span[contains(text(),'Interaction')]/ancestor::div[contains (@class, ('content'))]//button[contains(text(),'Previous')]/following-sibling::button")
	WebElement logacallOpttyNextButton;
	
	@FindBy(xpath ="//div[contains(text(),'Total Unmanaged Assets')]//ancestor::div[contains (@class, ('content'))]//button[contains(text(),'Previous')]/following-sibling::button")
	WebElement logacallCreateBranchopttyNextButton;
			
	@FindBy(xpath = "(//span[(text()='Log an Interaction')]/ancestor::div[contains (@class, ('content'))])[last()]//label[contains (@for,'Workplace')]")
	WebElement createWorkplaceOpportunity;
	
	@FindBy(xpath = "(//span[(text()='Log an Interaction')]/ancestor::div[contains (@class, ('content'))])[last()]//button[(text()='Next')]")
	WebElement createOpportunityNextBtn;
	
	@FindBy(xpath = "//b[contains(text(),'401k Roll')]/ancestor::div[contains (@class, ('content'))]//button[contains(text(),'Previous')]/following-sibling::button")
	WebElement logacallWorkplaceOppttyNextBtn;
	
	@FindBy(xpath = "(//span[(text()='Log an Interaction')]/ancestor::div[contains (@class, ('content'))])[last()]//label[contains (@for,'BM')]")
	WebElement createBranchOpportunity;
	
	@FindBy(xpath = "//div[contains(text(),'Please type the number of 401k Roll-In Accounts being transferred')]/../../../following-sibling::div/input")
	WebElement oppField1;
	
	@FindBy(xpath = "//div[contains(text(),'Total Combined Expected Amount of 401k Roll-In Assets')]/../../../following-sibling::div/input")
	WebElement oppField2;
	
	@FindBy(xpath = "//div[contains(text(),'Total Expected Amount of Traditional IRA')]/../../../following-sibling::div/input")
	WebElement oppField3;
	
	@FindBy(xpath = "//div[contains(text(),'Total Expected Amount of Roth IRA')]/../../../following-sibling::div/input")
	WebElement oppField4;
	
	@FindBy(xpath = "//div[contains(text(),'Total Expected Amount of SEP IRA')]/../../../following-sibling::div/input")
	WebElement oppField5;
	
	@FindBy(xpath = "//div[contains(text(),'Total Unmanaged Assets')]/../../../following-sibling::div/input")
	WebElement tMAssets;
	
	
	@FindBy(xpath = "//div[contains(text(),'Comments')]/../../../following-sibling::div/div/textarea")
	WebElement commentsTextarea;
	
	@FindBy(xpath = "//span[@class='title'][contains(text(),'Opportunity')]")
	WebElement oppTab;
	
	@FindBy(xpath = "(//a[contains (@class, ('textUnderline'))][contains(@href, ('/lightning/'))])[1]")
	WebElement oppLink;
	
	@FindBy(xpath = "//span[contains(text(),'Opportunities (')]")
	WebElement oppLinkSection_Advsr2;
	
	@FindBy(xpath = "//a [contains (@href, ('/lightning/r/'))][contains (text(), ('Retail - Branch Management'))]")
	WebElement oppLink_Advsr2;
	
	@FindBy(xpath = "//div[contains(text(),'Outcome')]/../../../following-sibling::div/select")
	WebElement outcome;
	
	@FindBy(xpath = "//div[contains(text(),'Lead Source')]/../../following-sibling::div/select")
	WebElement leadSource1;
	
	@FindBy(xpath = "(//a[contains(text(),'Ford-401K Roll-in')])")
	WebElement oppLink1;
	
	@FindBy(xpath = "(//a[contains(text(),'Boeing-IRA-Roth IRA-401K Roll-in')])[1]")
	WebElement oppLink2;
	
	@FindBy(xpath = "(//span[contains(text(),'Last Activity Date')])[2]/../following-sibling::div/span/span")
	WebElement lastActivityDate;
	
	@FindBy(xpath = "(//span[contains(text(),'Stage')])[2]/../following-sibling::div/span/span")
	WebElement stage;
	
	@FindBy(xpath = "(//span[contains(text(),'Lead Source')])[1]/../following-sibling::div/span/span")
	WebElement leadSource;
	
	@FindBy(xpath = "//span[text()='Lead Source']")
	WebElement leadSourceLbl;
	
	
	@FindBy(xpath = "//span[contains(text(),'Total Expected Amount')]/../following-sibling::div/span/span")
	WebElement totalExpectedAmount;
	
	@FindBy(xpath = "//div[@class= 'uiVirtualDataTable indicator']/following-sibling::table/tbody/tr")
	WebElement noOpportunities;
	
	@FindBy(xpath = "//a[@title='Delete']")
	WebElement deleteOpportunity;
	
	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	WebElement deleteConfirmation;
	
	@FindBy(xpath = "//div[contains(text(),'Schedule a Phone Call')]")
	WebElement scheduleType;
	
	@FindBy(xpath = "//div[contains(text(),'Schedule Appointment')]")
	WebElement scheduleApp;
	
	@FindBy(xpath = "//div[contains(text(),'Schedule a To-Do')]")
	WebElement toDo;
	
	@FindBy(xpath = "//div[contains(text(),'Enter a Date for Phone Call')]/../../following-sibling::div/div/input")
	WebElement enterDate1;
	
	@FindBy(xpath = "//div[contains(text(),'Due Date')]/../../following-sibling::div/div/input")
	WebElement enterDate2;
	
	@FindBy(xpath = "//span[contains(text(),'Previous')]/../following-sibling::button/span")
	WebElement nextButton1;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]/following-sibling::button")
	WebElement nextButton2;
	
	@FindBy(xpath = "//div[contains(text(),'Do not close any existing tasks')]")
	WebElement createNewTask;
	
	@FindBy(xpath = "(//footer[@class='slds-card__footer actionButtonBar slds-grid slds-grid_align-spread'])[2]")
	WebElement scrolltofooter;
	
	@FindBy(xpath = "(//footer[@class='slds-card__footer actionButtonBar slds-grid slds-grid_align-spread'])[3]")
	WebElement scrolltoOpttyfooter;
	
	
//-------------------------------------------------------------	
	
	@FindBy(xpath = "(//label[contains (@for, ('closeOpportunityChoice'))]//span[contains (@class, ('slds-radio--faux'))])[last()]")
	WebElement closeOpptyasLostRadioBtn ;
	
	@FindBy(xpath = "(//div[contains(text(),'Close Opportunity as Lost')]/ancestor::div[@class ='content']//button)[last()]")
	WebElement closeOpptyasLostNextBtn ;
	
	@FindBy(xpath = "//select[ contains (@id, ('dropdownInput1:'))]")
	WebElement lossReasonDropDown ;
	
	@FindBy(xpath = "//font[contains(text(),'Loss Notes')]/ancestor::div[@class='bBody']//textarea[@aria-required = 'true']")
	WebElement lossReasonNotes ;
	
	@FindBy(xpath = "(//div[contains (@class, ('actionsRight'))]//button[contains (@title,'Previous')]/following-sibling::button)[last()]")
	WebElement CloseOpptyRightNextBtn ;
	
	@FindBy(xpath = "(//label[contains (@for, ('scheduleAnAppointmentChoice'))]//span[contains (@class, ('slds-radio--faux'))])[last()]")
	WebElement scheduleanApptRadioBtn;
	
	@FindBy(xpath = "//span[contains(@class,'test-id')][contains(text(),'Lead Source')]/../..//button")
	WebElement opptyPgEdit;
	
	@FindBy(xpath = "//div[contains(@class,'col main-col slds-size--6-of-12')]//*[contains(text(),'Close Opportunity as Lost')]")
	WebElement closeOpttyLostDetailsPage;
	
	@FindBy(xpath = "//div[@class='row region-subheader']//*[contains(text(),'Close Opportunity as Lost')]")
	WebElement closeOpttyLostOpttyPage;
	
	@FindBy(xpath = "((//div[contains(@class,'stacked slds-is-editing')])[2]//a[contains (@class,'select')])[2]")
	WebElement stageStatus ;
	
	@FindBy(xpath = "(//span[text()='Stage']/../..//lightning-formatted-text)[last()]")
	WebElement stageStatusOptty ;
	
	@FindBy(xpath = "//span[contains(text(),'Mark Stage as Complete')]")
	WebElement markStageasComplete;
	
	@FindBy(xpath = "//span[contains (@class,('toastMessage'))]")
	WebElement validationMessage;
	
	@FindBy(xpath = "//div[contains (@class,('slds-box'))]//footer//button[contains (@title,'Next')]")
	WebElement NextBtn;
	
	
	//-------------------------------------------------------
	
	@FindBy(xpath = "(//span[contains(text(),'Mark as Current Stage')])[last()]")
	WebElement markascurrentstageBtn;
	
	@FindBy(xpath = "(//span[text()='Select Closed Stage'])[last()]")
	WebElement selectClosedStageBtn;
	
	
	@FindBy(xpath = "(//label[contains (@for, ('clientSetupChoice'))]//span[contains (@class,('radio'))])[last()]")
	WebElement clientsetupRdBtn;
			
	@FindBy(xpath = "(//a[contains (@class,('tabHeader'))][@title ='Client Setup'])[last()]")
	WebElement clientsetupTab;
	
	@FindBy(xpath = "//label[contains (@for, ('PrimaryBM'))]/..//span[contains(@class, ('checkbox'))]")
	WebElement enrollBranchMgmntCheckbox;

	@FindBy(xpath = "//div[@class='row region-subheader']//button[contains(text(),'Next')]")
	WebElement nextBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Branch Management')]/ancestor::div[@class='content']//button")
	WebElement branchMngmntNextBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Please click next button')]/ancestor::div[@class='content']//button")
	WebElement addFinancialAcctNextBtn;
	
	
	
	//-------------------------------------------------------
	@FindBy(xpath = "//label[contains (@for, ('AccountOwnerRecordChoice'))]//span[contains (@class, ('radio'))]")
	WebElement primaryownerIdRdBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Business Line Details')]/ancestor::div[@class='bBody']//select")
	WebElement buslinedetailsDrpDwn;
	
	@FindBy(xpath = "//select[contains (@class, ('slds-select'))]")
	WebElement custodianDrpDwn;
	
	@FindBy(xpath = "//div[contains(text(),'Program')]/ancestor::div[@class='bBody']//select")
	WebElement accountregistrDrpDwn;
	
	@FindBy(xpath = "//div[contains(text(),'Program')]/ancestor::div[@class='bBody']//select")
	WebElement programDrpDwn;

	@FindBy(xpath = "//div[contains(text(),'Primary Owner')]/ancestor::div[@class='content']//button[text()='Next']")
	WebElement primaryOwnerNextBtn;
	
	@FindBy(xpath = "//span[contains (text(), ('Account Registration'))]")
	WebElement accountregisterationlbl;
	
	@FindBy(xpath = "//span[contains (text(), ('Account Registration'))]/ancestor::label/following-sibling::div//select")
	WebElement accountregisterationDrpDwn;
	
	@FindBy(xpath = "//div[contains(text(),'Investment Objective')]/ancestor::div[@class='bBody']//select")
	WebElement investmentobjectiveDrpDwn;
	
	@FindBy(xpath = "//div[contains(text(),'Portfolio Risk Tolerance')]/ancestor::div[@class='bBody']//select")
	WebElement portfolioriskDrpDwn;
	
	@FindBy(xpath = "//input[@name ='Trade_Hold']/..//label//span")
	WebElement tradeholdkChkBx;
	
	@FindBy(xpath = "//span[contains(text(),'Trade Hold')]/ancestor::div[@class='content']//button[text()='Next']")
	WebElement tradeholdNextBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Add Another Financial Account?')]/ancestor::div[@class='content']//button")
	WebElement addanotherFinancialAcctNextBtn;
	
	
	@FindBy(xpath = "//span[contains(text(),'Add Financial Account')]")
	WebElement addfinancialaccountTitle;
	
	@FindBy(xpath = "(//a[text()='Financial Account'])[last()]")
	WebElement financialaccountTab;
	
	@FindBy(xpath = "//a[contains(text(), ('Individual'))]")
	WebElement financialaccountLink;
	
	@FindBy(xpath = "//span[(text()='Custodian')]/../..//lightning-formatted-text")
	WebElement custodianField;
	
	@FindBy(xpath = "//span[(text()='Account Registration Type')]/../..//lightning-formatted-text")
	WebElement accountRegistrationTypeField;
	
	
	@FindBy(xpath = "//span[contains (@class,('test-id'))][contains(text(),'Primary Owner')]/../following-sibling::div//a")
	WebElement primaryownerField;
	
	//-----------------------------------------------------------
	
	@FindBy(xpath = "//a[@class='subjectLink slds-truncate']")
	WebElement upcomingMeetingLink;
	
	@FindBy(xpath = "//a[@class='forceActionLink']")
	WebElement upcomingMeetingEditBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Meeting Information')]")
	WebElement meetingInfo;
	
	@FindBy(xpath = "(//span[text()='Meeting Status'])[last()]/../..//a")
	WebElement meetingStatusUpdtDrpDwn;
	
	@FindBy(xpath = "//span[contains(@class,'field-label')][text()='Meeting Status']/../..//button")
	WebElement meetingStatusEditBtn;
	
	@FindBy(xpath = "//span[text()='Save']/..")
	WebElement saveBtn;
	
	@FindBy(xpath = "(//a[contains (text(), ('Branch Management'))])[last()]")
	WebElement OpttyLink;
	
	//-------------------------------------------------------------------------
	
	//@FindBy(xpath = "//span[@class='title'][contains(text(),'Financial Account')]")
	//WebElement financialAcctTab;
	
	@FindBy(xpath = "(//a[@data-label='Financial Account'])[1]")
	WebElement financialAcctTab;
		
	//@FindBy(xpath = "//a[@class='forceActionLink'][@title='New']")
	//WebElement newfinancialAcctBtn;
		
	@FindBy(xpath = "(//div[contains(@class, 'avatar')]/../..//div[text()='New'])[1]")
	WebElement newfinancialAcctBtn;
	
	
	@FindBy(xpath = "//span[contains(text(),'Financial Account Name')]/../..//input")
	WebElement financialAcctNameInput;
		
	@FindBy(xpath = "//span[contains(text(),'Primary Owner')]/../..//input[@title='Search Accounts']")
	WebElement searchPrimaryOwnerAcct;
		
	@FindBy(xpath = "//span[contains(@class,'PicklistLabel')]//span[contains(text(),'Stage')]/../..//div//a")
	WebElement stageFinancial;
	
	@FindBy(xpath = "//span[contains(@class,'PicklistLabel')]//span[contains(text(),'Registration')]/../..//div//a")
	WebElement registrationTypeFinancial;
	
	@FindBy(xpath = "//span[contains(@class,'PicklistLabel')]//span[text()='Type']/../..//div//a")
	WebElement typeFinancial;
	
	@FindBy(xpath = "//span[contains(@class,'PicklistLabel')]//span[contains(text(),'Enrollment')]/../..//div//a")
	WebElement currentEnrolFinancial;
	
	
	
	//-----------------------------------------------------------
	
	
	DetailsPage detailsPage = new DetailsPage();
	RetailAccount retailaccount = new RetailAccount();
	InitializeUserData initialize = new InitializeUserData();
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	SoftAssert softAssertion = new SoftAssert();


	String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm a").format(new Date());
	@SuppressWarnings("static-access")
	String commentsToEnter = detailsPage.commentsToEnter;
	
	
//*************************************************** Create WP/BM Opportunities (via Log a Call) ********************************************************************************	
	
	
	public void createWorkplaceOpportunity() throws InterruptedException, ParseException, IOException {
				
		TestUtil.clickElement(createWorkplaceOpportunity);
		TestUtil.clickElement(createOpportunityNextBtn);
		
		TestUtil.waitUntilElementVisible(oppField1);
		oppField1.sendKeys("2");
		oppField2.sendKeys("50000", Keys.TAB);
		TestUtil.clickElement(logacallWorkplaceOppttyNextBtn);Thread.sleep(8000);
	}


	public void createBranchOpportunity(String opttyPath) throws InterruptedException, ParseException, IOException {
	
		if(opttyPath.equalsIgnoreCase("vialogaCall")|| RetailAccount.userProfile.contains("Outbound")){
		
			TestUtil.clickElement(createBranchOpportunity);
			TestUtil.clickElement(createOpportunityNextBtn);
		}
		
		TestUtil.waitUntilElementVisible(tMAssets);
		tMAssets.sendKeys("250000", Keys.TAB);
		TestUtil.clickElement(logacallCreateBranchopttyNextButton);Thread.sleep(8000);
		
	}
	
	
//*************************************************** Create WP/BM Opportunities (via Optty section) ********************************************************************************	
	
	public void createOpttyviaOpportunitySection(String opttyType) throws InterruptedException, ParseException, IOException {
		if (RetailAccount.userProfile.contains("Field Advisor")||RetailAccount.userProfile.contains("Field CSM")){
			
			TestUtil.waitUntilElementVisible(CreateOpportunityLabel);
			TestUtil.scrollintoView(CreateOpportunityLabel);
			
			if (opttyType.equalsIgnoreCase("BranchOptty")){TestUtil.clickElement(opttyBMRdBtn);}
			else if (opttyType.equalsIgnoreCase("WorkplaceOptty")){TestUtil.clickElement(opttyWPRdBtn);}
			
			TestUtil.clickElement(createOpttySectionNxtBtn);
		
		}else {
			detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyYes", "FutureActivityNO");
		}
			
	}
	
	
	//*************************************************** Optty Status Closed/Lost ********************************************************************************	

	
	public void opportunityClosedLost() throws InterruptedException, AWTException {
		
		TestUtil.waitUntilElementVisible(closeOpptyasLostRadioBtn);
		TestUtil.clickElement(closeOpptyasLostRadioBtn);Thread.sleep(2000);
		TestUtil.clickElement(closeOpptyasLostNextBtn);Thread.sleep(3000);
		TestUtil.clickElement(lossReasonDropDown);
		TestUtil.SelectDropDownOption(lossReasonDropDown, "Duplicate");
		TestUtil.clickElement(lossReasonDropDown);
		lossReasonNotes.sendKeys("Automation Testing - Dont bother", Keys.TAB);
		
		TestUtil.clickElement(CloseOpptyRightNextBtn);Thread.sleep(3000);
		
		driver.navigate().refresh();//Thread.sleep(5000);
		TestUtil.waitUntilPageLoad(driver);
		
	}

	
//*************************************************** Manually Change Optty Status and validate error message ********************************************************************************	

	public void moveOpttyStageManually() throws InterruptedException, AWTException {

		clickOpportunity();		
		
		TestUtil.clickElement(markStageasComplete);
		softAssertion.assertEquals(validationMessage.getText(), "You are not allowed to change the status manually.", "Validation Message is incorrect or didnt appear");
	
	}


//*************************************************** Schedule Meeting using Next Action********************************************************************************	

	public  void scheduleMeetingusingNextAction() throws InterruptedException, AWTException, IOException, ParseException {
	
		TestUtil.waitUntilElementVisible(leadSourceLbl);
		
		if (stageStatusOptty.getText().equalsIgnoreCase("New")) {driver.navigate().refresh();TestUtil.waitUntilElementVisible(leadSourceLbl);}
		
		TestUtil.clickElement(scheduleanApptRadioBtn);
		TestUtil.clickElement(closeOpptyasLostNextBtn);
		detailsPage.createFutureAppointment(); 
		
		driver.navigate().refresh(); Thread.sleep(8000);
		
		TestUtil.waitUntilElementVisible(upcomingMeetingLink);
		TestUtil.clickElement(upcomingMeetingLink);  
		TestUtil.scrollintoView(meetingInfo);
		TestUtil.clickElement(meetingStatusEditBtn);Thread.sleep(2000); 
		TestUtil.clickElement(meetingStatusUpdtDrpDwn);
		meetingStatusUpdtDrpDwn.sendKeys("Completed", Keys.ENTER); 
		TestUtil.clickElement(saveBtn); Thread.sleep(5000);
		TestUtil.clickElement(OpttyLink); 
		
		driver.navigate().refresh(); Thread.sleep(5000);
		
	}


//*************************************************** Enroll BM ********************************************************************************	
	
	public  void enrollinBM() throws InterruptedException, AWTException, IOException, ParseException {
		
		TestUtil.waitUntilElementVisible(leadSourceLbl);Thread.sleep(2000);
		TestUtil.clickElement(clientsetupRdBtn);
		
		Thread.sleep(2000);
		TestUtil.clickElement(closeOpptyasLostNextBtn);
		TestUtil.clickElement(enrollBranchMgmntCheckbox);
		TestUtil.clickElement(branchMngmntNextBtn);
	
	}
	
//*************************************************** Add/Validate Financial Account ********************************************************************************
	
	public  void addFinancialAccount() throws InterruptedException, AWTException, IOException, ParseException {
	
		TestUtil.waitUntilElementVisible(addFinancialAcctNextBtn);
		TestUtil.clickElement(addFinancialAcctNextBtn);
	
		TestUtil.clickElement(primaryownerIdRdBtn);
		
		TestUtil.waitUntilElementVisible(custodianDrpDwn);
		TestUtil.SelectDropDownOption(custodianDrpDwn, "Fidelity");
		TestUtil.SelectDropDownOption(accountregisterationDrpDwn, "Individual");
		TestUtil.SelectDropDownOption(programDrpDwn, "Falcon");
		TestUtil.SelectDropDownOption(buslinedetailsDrpDwn, "Branch Management");
	
		TestUtil.clickElement(primaryOwnerNextBtn);
		
		TestUtil.waitUntilElementVisible(investmentobjectiveDrpDwn);
		TestUtil.SelectDropDownOption(investmentobjectiveDrpDwn, "Growth");
		TestUtil.SelectDropDownOption(portfolioriskDrpDwn, "Moderate");
		TestUtil.clickElement(tradeholdkChkBx);
		
		TestUtil.clickElement(tradeholdNextBtn);
		TestUtil.clickElement(addanotherFinancialAcctNextBtn);
		
	}
	
	
	
	public void validateFinancialAccount() throws InterruptedException, AWTException {

		TestUtil.waitUntilElementVisible(financialaccountTab);
		TestUtil.clickElement(financialaccountTab);
		TestUtil.clickElement(financialaccountLink);
		
		validateField("Custodian", "Fidelity", "Custodian Value is not correct");
		validateField("Account Registration Type", "Individual", "Account Registration Type Value is not correct");
		validateField("Business Line Details", "Branch Management", "Business Line Details Value is not correct");
		validateField("Program", "Falcon", "Program Value is not correct");
				
		softAssertion.assertAll();
	
	}


//********************************************Create New Financial Account***************************************************	
	
	@SuppressWarnings("static-access")
	public  void createFinancialAccount() throws InterruptedException, AWTException, IOException, ParseException {
		
		TestUtil.waitUntilElementVisible(financialAcctTab);
		
		TestUtil.clickElement(financialAcctTab);
		TestUtil.clickElement(newfinancialAcctBtn);
		
		//Thread.sleep(2000);
		TestUtil.waitUntilElementVisible(financialAcctNameInput);
		financialAcctNameInput.sendKeys("FinanceAcct"+ detailsPage.uid, Keys.ENTER);
		
		TestUtil.waitUntilElementVisible(searchPrimaryOwnerAcct);
		searchPrimaryOwnerAcct.sendKeys(RetailAccount.aname);Thread.sleep(2000);
		driver.findElement(By.xpath("//section[contains(@class,'tabContent active')]//li[1]//a[1]")).click();
		
		
		TestUtil.waitUntilElementVisible(stageFinancial);
		stageFinancial.sendKeys("Proposal", Keys.ENTER, Keys.TAB);
		
		
		TestUtil.waitUntilElementVisible(registrationTypeFinancial);
		registrationTypeFinancial.sendKeys("Individual", Keys.ENTER, Keys.TAB, Keys.TAB);
		//TestUtil.SelectDropDownOption(registrationTypeFinancial, "Individual");
		
		TestUtil.waitUntilElementVisible(typeFinancial);
		typeFinancial.sendKeys("Regular", Keys.ENTER, Keys.TAB);
		//TestUtil.SelectDropDownOption(typeFinancial, "Regular");
		
		TestUtil.waitUntilElementVisible(currentEnrolFinancial);
		currentEnrolFinancial.sendKeys("Personal Advisor", Keys.ENTER, Keys.TAB);
		//TestUtil.SelectDropDownOption(currentEnrolFinancial, "Personal Advisor");
		
		
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//ul[contains(@class,'visible')]")).click();
		
		driver.findElement(By.xpath("(//span[contains(text(),'Save')])[2]")).click();
		Thread.sleep(2000);
		
		validateField("Financial Account Name", "FinanceAcct"+ detailsPage.uid, "Financial Account Name is not correct");
		validateField("Custodian", "Charles Schwab", "Custodian Value is not correct");
		validateField("Stage", "Proposal", "Stage Value is not correct");
		validateField("Account Registration Type", "Individual", "Account Registration Type Value is not correct");
		validateField("Type", "Regular", "Type Value is not correct");
		validateField("Current Enrollment", "Personal Advisor", "Current Enrollment Value is not correct");
	
	
	}

	
		
	
	
	
	
//********************************************Click Optty Link based on Profile***************************************************	

	public void clickOpttyforOutbound2Advisor() throws InterruptedException, AWTException {
		
		TestUtil.waitUntilElementVisible(oppLinkSection_Advsr2);
		TestUtil.clickElement(oppLinkSection_Advsr2);	
		TestUtil.clickElement(oppLink_Advsr2);
		
	}
	
	public void clickOpportunity() throws InterruptedException, AWTException {
		
		Thread.sleep(3000);
	/*	
		if (RetailAccount.userProfile.contains("Field Advisor")||RetailAccount.userProfile.contains("Field CSM")|| (RetailAccount.userProfile.equals("Outbound 1 Advisor"))){
			TestUtil.clickElement(oppLink);
		}
		
		else {clickOpttyforOutbound2Advisor();}
	*/
		clickOpttyforOutbound2Advisor();
		Thread.sleep(3000);
	
	}
	
	
//********************************************Validate Optty Counter***************************************************		

	public void validateOpttyCounter(int expectedcounter) throws InterruptedException, AWTException {
			
		Thread.sleep(10000);
		String counter = driver.findElement(By.xpath("//span[contains(text(),'("+expectedcounter+")')]")).getText();
		softAssertion.assertTrue(counter.contains(Integer.toString(expectedcounter)));
			
	}
		
	
//********************************************Validate Optty Stage***************************************************	
	
	public void validateOpttyforStageStatus(String stageStatus) throws InterruptedException, AWTException {
	
		//if (RetailAccount.userProfile.contains("Field Advisor")||RetailAccount.userProfile.contains("Field CSM")){clickOpportunity();}
		
		TestUtil.waitUntilElementVisible(leadSourceLbl);
		
		validateField("Lead Source", "NAC Outbound", "Lead Source Value is not correct");
		validateField("Stage", stageStatus, "Stage Status Value is not correct");
		validateField("Estimated Expected Amount", "$125,000", "Expected Amount Value is not correct");
		
		if (stageStatus == "Closed Lost") {validateField("Loss Reason", "Duplicate", "Loss Reason Value is not correct");}
	
		softAssertion.assertAll();
		
		
	}

	
	public void validateField(String fieldName, String expectedValue, String errorMessage) throws InterruptedException, AWTException {
		
		String actualValue = driver.findElement(By.xpath("(//span[(text()='" +fieldName+ "')]/../..//lightning-formatted-text)[last()]")).getText();
		softAssertion.assertEquals(actualValue, expectedValue, errorMessage);
		
	}
	
	
	
	public void changeStatusTo(String valField, String status) throws InterruptedException, AWTException {
		
		jse2.executeScript("arguments[0].click()", driver.findElement(By.xpath ("(//a[@title='"+ status +"'])[last()]")));
		
		if (!(status.equalsIgnoreCase("Closed"))){jse2.executeScript("arguments[0].click()",markascurrentstageBtn);Thread.sleep(3000);}
		else {
			
			TestUtil.clickElement(selectClosedStageBtn);
			WebElement option = driver.findElement(By.xpath("//select[contains(@class, ('stepAction'))]"));
			TestUtil.SelectDropDownOption(option, "Closed Won");
			driver.findElement(By.xpath ("//span[contains(text(),'Save')]")).click();
			
			}
		
		validateField(valField, status, "Status Validation is failed!!" );
		
	}
	

	

	
//----------------------------------------------------------------------------------------------------------------------------------------------------

	

	/*
	public static void selectDrpDwnOptionViaClick(WebElement dropdown, WebElement Option ) {
		
		dropdown.click();	Option.click();
		
	}
	
	*/
	
	
	
	
	/*	
	public void navigateTouser(String User) throws InterruptedException{
		
		if (User == "primary"){
			
			String userId = SalesforceRestAPI.getHashMapData()[0];
			String url = "https://fei--fscfull.lightning.force.com/lightning/r/Account/"+userId+"/view";
			System.out.println(url);
		  	
			driver.navigate().to(url);
	  	}
		
		else if (User == "spouse"){
			String userId = prop.getProperty(User);
			String url = "https://fei--fscfull.lightning.force.com/lightning/r/Account/"+userId+"/view";
			System.out.println(url);
			  	
			driver.navigate().to(url);
		}
		
	}
*/
	
	
	/*
	public void verifyBranchOppty() throws InterruptedException, AWTException {

		String status = "Closed Lost";
		
		Thread.sleep(2000);
		String stage = driver.findElement(By.xpath("//div[contains (@class, ('recordCell'))]//span[contains(text(),'" +status+ "')]")).getText();
		softAssertion.assertEquals(stage, status, "Stage doesnot match");
		
		String closeOpttyasLostonDetailsPage = closeOpttyLostDetailsPage.getText();
		softAssertion.assertEquals(closeOpttyasLostonDetailsPage, "Close Opportunity as Lost", "Action doesnot exist on Detail Page");
			
		oppLink.click();
		Thread.sleep(2000);
	
		String closeOpttyasLostonOpttyPage = closeOpttyLostOpttyPage.getText();
		softAssertion.assertEquals(closeOpttyasLostonOpttyPage, "Close Opportunity as Lost", "Action doesnot exist opportunity Page");
		
		softAssertion.assertAll();
	
	}



	public String markStageStatus() throws InterruptedException, AWTException {
	
		markStageasComplete.click();
		opptyPgEdit.click();
		String stageStatusTxt = stageStatus.getText();
			
		return stageStatusTxt;
		
	}
*/











public void verifyWorkplaceOpportunity() throws InterruptedException {
	
	Thread.sleep(5000);
	oppLink.click();	
	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
	String oppLink = prop.getProperty("searchuser") + " - " +"Boeing - IRA";
	driver.findElement(By.xpath("//a[contains(text(),'"+oppLink+"')]")).sendKeys(selectLinkOpeninNewTab);
	ArrayList tabs = new ArrayList (driver.getWindowHandles());
	System.out.println(tabs.size());
    String newTab = (String) tabs.get(1);
    String oldTab = driver.getWindowHandle();
    
	driver.switchTo().window(newTab);
			 	 
	 softAssertion.assertEquals(stage, "New", "Stage Mismatch");
	 
	 driver.switchTo().window(oldTab);
	 
	 softAssertion.assertEquals(stage, "New", "Stage Mismatch");
	 softAssertion.assertEquals(leadSource, "NAC Outbound", "Lead Source Mismatch");
	 
	 driver.close();
	 driver.switchTo().window(oldTab);
}


public void verifyBranchOpportunity() throws InterruptedException {
	
	Thread.sleep(2000);
	oppLink.click();
	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
	String oppLink = prop.getProperty("searchuser") + " - " +"Boeing - Personal Advisor";
	driver.findElement(By.xpath("//a[contains(text(),'"+oppLink+"')]")).sendKeys(selectLinkOpeninNewTab);
	ArrayList tabs = new ArrayList (driver.getWindowHandles());
	System.out.println(tabs.size());
    String newTab = (String) tabs.get(1);
    String oldTab = driver.getWindowHandle();
    
	driver.switchTo().window(newTab);
			 	 
	 softAssertion.assertEquals(stage, "New", "Stage Mismatch");
	 softAssertion.assertEquals(leadSource, "Benefits Fair", "Lead Source Mismatch");
	 softAssertion.assertEquals( totalExpectedAmount, "$25,000.00", "Lead Source Mismatch");
	 	 
	 driver.close();
	 driver.switchTo().window(oldTab);
}




	
public String leadURL() throws InterruptedException {
		
		Thread.sleep(5000);
		lead.click();		
		String url = leadLink1.getAttribute("href");			
		return url;
		
	}
	
	
public void deleteOpportunity() throws InterruptedException {
		
		String count = oppCount.getText();
		
		
		if ("(0)".equals(count)) {
			softAssertion.assertEquals(count, "(0)", "There are no opportunities");	
		} else {
			 deleteOpportunities();
		}
	}
		
public void deleteOpportunities() throws InterruptedException {
			
//			Thread.sleep(5000);			
			WebElement dropdownElement;			
			oppViewAll.click();			
			List <WebElement> listopp = driver.findElements(By.xpath("//div[@class='uiVirtualDataTable indicator']/following-sibling::table/tbody/tr"));			
			
			for (int i=1; i<=listopp.size(); i++) {	
				Thread.sleep(5000);	
				dropdownElement = driver.findElement(By.xpath("(//div[@class='uiVirtualDataTable indicator']/following-sibling::table/tbody/tr[1]/td[5])[2]"));				
				dropdownElement.click();
				deleteOpportunity.click();
				deleteConfirmation.click();				
			}		
			
//			driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/r/Account/0010R00000IZ3R7QAL/view");
			driver.navigate().to(prop.getProperty("url"));
		}
	
	
	public void clickLeadLink() throws InterruptedException {
		
		String oldTab = driver.getWindowHandle();
		
		Thread.sleep(5000);	
		lead.click();
//		leadLink1.click();
		
		//For opening window in New Tab
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		leadLink1.sendKeys(selectLinkOpeninNewTab);

//		// Perform Ctrl + Tab to focus on new Tab window
//		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, Keys.TAB)).perform();
		
//		Actions action= new Actions(driver);
//		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
//		
	ArrayList tabs = new ArrayList (driver.getWindowHandles());
	 System.out.println(tabs.size());
	 String newTab = (String) tabs.get(1);
		driver.switchTo().window(newTab);

		// Switch driver control to focused tab window
		driver.switchTo().window(oldTab);
			
		
	}
	
	
	
public void clickOpportunityLink() throws InterruptedException {
		
		String oldTab = driver.getWindowHandle();
		
		Thread.sleep(5000);	
		opportunity.click();
		
		//For opening window in New Tab
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		oppLink1.sendKeys(selectLinkOpeninNewTab);

		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		String newTab = (String) tabs.get(1);
		driver.switchTo().window(newTab);
		
		

		// Switch driver control to focused tab window
		driver.switchTo().window(oldTab);
			
		
	}
	
	
	
	public boolean isLeadLinkVisible(){
	    WebDriverWait zeroWait = new WebDriverWait(driver, 0);
	    ExpectedCondition<WebElement> c = ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Create New Application']"));
	    try {
	        zeroWait.until(c);
	        return true;
	    } catch (TimeoutException e) {
	        return false;
	    }
	}




public void test() throws InterruptedException, AWTException {
	
	
}










}
