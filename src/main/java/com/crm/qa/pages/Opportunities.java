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

import com.crm.qa.base.TestBase;
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
	
//	@FindBy(xpath = "(//span[contains(text(),'Ford-401K Roll-in')])[1]")
//	WebElement oppLink1;


	@FindBy(xpath = "//span[contains(@class,'title slds-truncate')][contains(text(),'test')]")
	WebElement leadLink2;


	@FindBy(xpath = "(//span[contains(text(),'Lead Status')])[1]/../following-sibling::div/span/span")
	WebElement leadStatus;

//
//	@FindBy(xpath = "(//span[contains(text(),'Last Activity Date')])[2]/../following-sibling::div/span/span")
//	WebElement lastActivityDate;
//	
	
	@FindBy(xpath = "//span[contains(@class,'title')][contains(text(),'Lead')]")
	WebElement lead;
	
	@FindBy(xpath = "//span[contains(@class,'title')][contains(text(),'Opportunity')]")
	WebElement opportunity;

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
	
	@FindBy(xpath = "//b[contains(text(),'Create Opportunity')]")
	WebElement CreateOpportunityLabel;
	
	//@FindBy(xpath = "//div[contains(text(),'Create Workplace Opportunity')]")
	//WebElement createWorkplaceOpportunity;
	
	
	@FindBy(xpath = "//label[contains (@for, ('Yes_Selected'))]")
	WebElement yesOpttyRdBtn;
	
	
	//@FindBy(xpath = "//input[contains (@name, ('Create_Opportunity'))]/../label/span[contains (@class, ('slds-checkbox'))]")
	//WebElement createWorkplaceOpportunity;
	
	@FindBy(xpath = "//label[contains (@for, ('Create_Workplace_Opportunity'))]//span[contains (@class, ('radio'))]")
	WebElement createWorkplaceOpportunity;
	
	//@FindBy(xpath = "//div[contains(text(),'Create Branch/PA Opportunity')]")
	//WebElement createBranchOpportunity;
	
	//@FindBy(xpath = "//input[contains (@name, ('Create_Referral_Opportunity'))]/../label/span[contains (@class, ('slds-checkbox'))]")
	//WebElement createBranchOpportunity;
	
	@FindBy(xpath = "//label[contains (@for, ('Create_BM_PA_Opportunity'))]//span[contains (@class, ('radio'))]")
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
	
	//@FindBy(xpath = "//span[contains(text(),'Opportunity')]")
	//WebElement oppLink;
	
	@FindBy(xpath = "//span[@class='title'][contains(text(),'Opportunity')]")
	WebElement oppTab;
	
	@FindBy(xpath = "(//a[contains (@class, ('textUnderline'))][contains(@href, ('/lightning/'))])[1]")
	WebElement oppLink;

	@FindBy(xpath = "//div[contains(text(),'Outcome')]/../../../following-sibling::div/select")
	WebElement outcome;
	
	@FindBy(xpath = "//div[contains(text(),'Lead Source')]/../../following-sibling::div/select")
	WebElement leadSource1;
	
	@FindBy(xpath = "(//a[contains(text(),'Ford-401K Roll-in')])")
	WebElement oppLink1;
	
	@FindBy(xpath = "(//a[contains(text(),'Boeing-IRA-Roth IRA-401K Roll-in')])[1]")
	WebElement oppLink2;
		
//	@FindBy(xpath = "//a[contains(text(),'Boeing - Referral - Personal Advisor')]")
//	WebElement oppLink3;
	
	@FindBy(xpath = "(//span[contains(text(),'Last Activity Date')])[2]/../following-sibling::div/span/span")
	WebElement lastActivityDate;
	
	@FindBy(xpath = "(//span[contains(text(),'Stage')])[2]/../following-sibling::div/span/span")
	WebElement stage;
	
	@FindBy(xpath = "(//span[contains(text(),'Lead Source')])[1]/../following-sibling::div/span/span")
	WebElement leadSource;
	
	@FindBy(xpath = "//span[contains(text(),'Total Expected Amount')]/../following-sibling::div/span/span")
	WebElement totalExpectedAmount;
	
	@FindBy(xpath = "//div[@class= 'uiVirtualDataTable indicator']/following-sibling::table/tbody/tr")
	WebElement noOpportunities;
	
//	@FindBy(xpath = "(//div[@class= 'uiVirtualDataTable indicator'])[2]/following-sibling::table/tbody/tr/td[5]")
//	WebElement dropdownActions;
	
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
	//button[contains(text(),'Previous')]/following-sibling::button
	
	@FindBy(xpath = "//div[contains(text(),'Do not close any existing tasks')]")
	WebElement createNewTask;
	
	@FindBy(xpath = "(//footer[@class='slds-card__footer actionButtonBar slds-grid slds-grid_align-spread'])[2]")
	WebElement scrolltofooter;
	
	@FindBy(xpath = "(//footer[@class='slds-card__footer actionButtonBar slds-grid slds-grid_align-spread'])[3]")
	WebElement scrolltoOpttyfooter;
	
	
//-------------------------------------------------------------	
	
	@FindBy(xpath = "//label[contains (@for, ('closeOpportunityChoice'))]//span[contains (@class, ('slds-radio--faux'))]")
	WebElement closeOpptyasLostRadioBtn ;
	
	@FindBy(xpath = "//div[contains (@class,('slds-box'))]//footer//button[contains (@title,'Next')]")
	WebElement closeOpptyasLostNextBtn ;
	
	@FindBy(xpath = "//select[ contains (@id, ('dropdownInput1:'))]")
	WebElement lossReasonDropDown ;
	
	@FindBy(xpath = "(//textarea[contains (@id, ('longInput'))])[1]")
	WebElement lossReasonNotes ;
	
	@FindBy(xpath = "//div[contains (@class, ('actionsRight'))]//button[contains (@title,'Previous')]/following-sibling::button")
	WebElement CloseOpptyRightNextBtn ;
	
	@FindBy(xpath = "//label[contains (@for, ('scheduleAnAppointmentChoice'))]//span[contains (@class, ('slds-radio--faux'))]")
	WebElement scheduleanApptRadioBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	WebElement opptyPgEdit;
	
	@FindBy(xpath = "//div[contains(@class,'col main-col slds-size--6-of-12')]//*[contains(text(),'Close Opportunity as Lost')]")
	WebElement closeOpttyLostDetailsPage;
	
	@FindBy(xpath = "//div[@class='row region-subheader']//*[contains(text(),'Close Opportunity as Lost')]")
	WebElement closeOpttyLostOpttyPage;
	
	@FindBy(xpath = "((//div[contains(@class,'stacked slds-is-editing')])[2]//a[contains (@class,'select')])[2]")
	WebElement stageStatus ;
	
	
	@FindBy(xpath = "//span[contains(text(),'Mark Stage as Complete')]")
	WebElement markStageasComplete;
	
	@FindBy(xpath = "//span[contains (@class,('toastMessage'))]")
	WebElement validationMessage;
	
	@FindBy(xpath = "//div[contains (@class,('slds-box'))]//footer//button[contains (@title,'Next')]")
	WebElement NextBtn;
	
	@FindBy(xpath = "//span[@class='title'][contains(text(),'Financial Account')]")
	WebElement financialAcctTab;
	
	@FindBy(xpath = "//a[@class='forceActionLink'][@title='New']")
	WebElement newfinancialAcctBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Financial Account Name')]/../..//input")
	WebElement financialAcctNameInput;
	
	@FindBy(xpath = "//span[contains(text(),'Primary Owner')]/../..//input[@title='Search Accounts']")
	WebElement searchPrimaryOwnerAcct;
	
	
	
	
	
	
	
	DetailsPage details = new DetailsPage();
	
	
	SoftAssert softAssertion = new SoftAssert();


	String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm a").format(new Date());
	String commentsToEnter = "TestingPurpose " + timeStamp;
	
	String schedule1 = "Phone Call";
	String schedule2 = "ToDo";
	String schedule3 = "Appointment";
	String timeStamp1 = "AUG 25, 2018";
	
	
	
	
	public void createWorkplaceOpportunity() throws InterruptedException, ParseException, IOException {
				
		enterCommentsfor("WorkplaceOptty", 1);
				
		Thread.sleep(2000);
		oppField1.sendKeys("2");
		oppField2.sendKeys("50000");
			
		nextButton2.click();	
		Thread.sleep(5000);	
				
	}


	public void createBranchOpportunity() throws InterruptedException, ParseException, IOException {
	
		enterCommentsfor("BranchOptty", 1);
		
		tMAssets.sendKeys("250000");
		details.logCallNextButton.click();
		Thread.sleep(5000);	
	
	}
	


	public void opportunityClosedLost() throws InterruptedException, AWTException {

		Thread.sleep(2000);
		closeOpptyasLostRadioBtn.click();
	
		closeOpptyasLostNextBtn.click();
		
		lossReasonDropDown.click();
		
		TestUtil.SelectDropDownOption(lossReasonDropDown, "Duplicate");
	
		lossReasonDropDown.click();
	
		lossReasonNotes.sendKeys("Automation Testing - Dont bother");
		Thread.sleep(2000);

		CloseOpptyRightNextBtn.click();
	
		Thread.sleep(5000);
		oppLink.click();
	

	}


	public void moveOpttyStageManually() throws InterruptedException, AWTException {

		Thread.sleep(2000);
		oppLink.click();
		
		markStageasComplete.click();
		
		Thread.sleep(2000);
		softAssertion.assertEquals(validationMessage.getText(), "You are not allowed to change the status manually.", "Validation Message is incorrect or didnt appear");
	
	}



	public  void logacall_NotReached() throws InterruptedException, AWTException, IOException, ParseException {
	
		Thread.sleep(2000);
		
		//enterComments(0);
		
		enterCommentsfor("BranchOptty", 0);
		
		Thread.sleep(2000);
		oppLink.click();
		
		
	}


	public  void logacall_Reached() throws InterruptedException, AWTException, IOException, ParseException {
	
		Thread.sleep(2000);
		//enterComments(1);
		
		enterCommentsfor("BranchOptty", 1);
		
		Thread.sleep(2000);
		oppLink.click();
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
	}


	
	public  void logacall_Reached_StageClosedLost() throws InterruptedException, AWTException, IOException, ParseException {
  
		Thread.sleep(2000);
		enterCommentsfor("BranchOptty", 1);
		opportunityClosedLost();
	
	}


	public  void scheduleandCloseMeeting() throws InterruptedException, AWTException, IOException, ParseException {

		unplannedAppointment();
		
		Thread.sleep(2000);
		oppLink.click();
		
		Thread.sleep(2000);
		
	}



	public  void scheduleMeetingusingNextAction() throws InterruptedException, AWTException, IOException, ParseException {
	
		Thread.sleep(2000);
		unplannedAppointment();
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		TestUtil.closeAllOpenTabs(driver);
		
		Thread.sleep(3000);
		scheduleanApptRadioBtn.click();
		
		Thread.sleep(3000);
		closeOpptyasLostNextBtn.click();
	
		Thread.sleep(2000);
		details.createFutureAppointment();
		
		Thread.sleep(2000);
		oppLink.click();
		
		Thread.sleep(2000);
		
			
	}

	@SuppressWarnings("static-access")
	public  void createFinancialAccount() throws InterruptedException, AWTException, IOException, ParseException {
		
		Thread.sleep(2000);
		oppLink.click();
		
		Thread.sleep(2000);
		
		financialAcctTab.click();
		newfinancialAcctBtn.click();
		
		Thread.sleep(2000);
		financialAcctNameInput.sendKeys("FinanceAcct"+ details.uid);
		
		searchPrimaryOwnerAcct.sendKeys(RetailAccount.aname);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[contains(@class,'visible')]")).click();
		
		driver.findElement(By.xpath("(//span[contains(text(),'Save')])[2]")).click();
		Thread.sleep(2000);
		
	}
	
	
	
	

	public void enterCommentsfor(String opttyType, int Outcome) throws InterruptedException, ParseException, IOException {
	
		Thread.sleep(5000);
	
		commentsTextarea.sendKeys(commentsToEnter);
		solutionsDiscussed.click();
		details.selectOutcome(Outcome);
		details.logCallNextButton.click();
		Thread.sleep(5000);
		
		
		yesOpttyRdBtn.click();
		details.logCallNextButton.click();
		Thread.sleep(3000);
		
		if (opttyType =="WorkplaceOptty"){createWorkplaceOpportunity.click();details.logCallNextButton.click();Thread.sleep(2000);}
		else if (opttyType =="BranchOptty"){createBranchOpportunity.click();details.logCallNextButton.click();Thread.sleep(2000);}
	
	}



	
	public void validateOpttyforStageStatus(String stageStatus) throws InterruptedException, AWTException {
	
		Thread.sleep(2000);
		opptyPgEdit.click();
		
		validateLeadSource("NAC Outbound");
		validateStageStatus(stageStatus);
		validateExpectedAmount("$125,000.00");
		
		if (stageStatus == "Closed Lost") {validateLeadReason("Duplicate");}
	
		softAssertion.assertAll();
		
		
		//ALTERNATE METHOD TO VALIDATE DATA
		/*
		**************************************************************************************************************
		TestUtil.closeAllOpenTabs(driver);
		oppLink.click(); 
		
		driver.findElement(By.xpath("(//button[contains (@title, ('Retail'))])[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Set As Workspace Tab')]")).click();
		driver.findElement(By.xpath("//a[contains (@class, ('label-action'))][contains (@href, ('Opportunity'))]")).click();
		  
		try{
		driver.findElement(By.xpath("(//div[contains (@class,('forcePageBlockSectionRow'))])[13]")).click();}
		catch (Exception e)	{}
		
		String closeDate = driver.findElement(By.xpath("//button[contains (@title, ('Edit Close Date'))]/../span")).getText();
		String lossReason = driver.findElement(By.xpath("//button[contains (@title, ('Edit Loss Reason'))]/../span")).getText();
		String stageStatus = driver.findElement(By.xpath("//button[contains (@title, ('Edit Stage'))]/../span")).getText();
		String lossReasonNotes = driver.findElement(By.xpath("//button[contains (@title, ('Edit Other Loss Reason Notes'))]/../span")).getText();
		
		***************************************************************************************************************
		*/
	}



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




	public void validateLeadSource(String expectedleadSource) throws InterruptedException, AWTException {
	
		String leadSource = driver.findElement(By.xpath("(//div[contains(@class,'stacked slds-is-editing')])[1]//a[contains (@class,'select')]")).getText();
		softAssertion.assertEquals(leadSource, expectedleadSource, "Lead Source is not correct");
	}

	public void validateLeadReason(String expectedlossReason) throws InterruptedException, AWTException {
		String lossReason = driver.findElement(By.xpath("(//div[contains(@class,'stacked slds-is-editing')])[2]/div[1]//a[contains (@class,'select')]")).getText();
		softAssertion.assertEquals(lossReason, expectedlossReason, "Loss Reason is not correct");
	}

	public void validateStageStatus(String expectedstageStatus) throws InterruptedException, AWTException {
		String stageStatus = driver.findElement(By.xpath("((//div[contains(@class,'stacked slds-is-editing')])[2]//a[contains (@class,'select')])[2]")).getText();
		softAssertion.assertEquals(stageStatus, expectedstageStatus, "Stage is not Closed Lost");
	}


	public void validateExpectedAmount(String expectedAmount) throws InterruptedException, AWTException {
		String Amount = driver.findElement(By.xpath("((//div[contains(@class,'stacked slds-is-editing')])[5]//span[contains (@class, ('Currency'))])[4]")).getText();
		softAssertion.assertEquals(Amount, expectedAmount, "Expected Amount is not correct");
	}

	public void validateOpttyCounter(int expectedcounter) throws InterruptedException, AWTException {
		
		String counter = driver.findElement(By.xpath("//span[contains(text(),'("+expectedcounter+")')]")).getText();
		softAssertion.assertEquals(counter, "("+expectedcounter+")", "Counter mismatched"); 
	}


	
	public void navigateTouser(String User) throws InterruptedException{
	
	
	
		if (User == "primary"){
		
		String userId = RetailUserdetails.get_sfdcID();
		String url = "https://fei--fscfull.lightning.force.com/lightning/r/Account/"+userId+"/view";
		System.out.println(url);
	  	
		driver.navigate().to(url);}
		
		else if (User == "spouse"){
			String userId = prop.getProperty(User);
			String url = "https://fei--fscfull.lightning.force.com/lightning/r/Account/"+userId+"/view";
			System.out.println(url);
		  	
			driver.navigate().to(url);}
		
	}


	public void enterComments(int i) throws InterruptedException, IOException, ParseException {
		
		Thread.sleep(2000);	
		commentsTextarea.sendKeys(commentsToEnter);
		solutionsDiscussed.click();
		details.selectOutcome(i);
		details.logCallNextButton.click();
		
		Thread.sleep(5000);
		details.noOpttyRdBtn.click();
		details.logCallNextButton.click();
		
	}


	public void unplannedAppointment() throws InterruptedException, ParseException {
		
		Thread.sleep(2000);
		details.commentsTextarea.sendKeys(commentsToEnter);
		
		Thread.sleep(2000);
		TestUtil.SelectDropDownOption(outcome, "Meeting");
		solutionsDiscussed.click();
	
		details.logCallNextButton.click();
		
		Thread.sleep(2000);
		details.subjectArea.sendKeys(commentsToEnter);
		
		details.meetingEndDate1.sendKeys(details.unplannedDate);
		details.meetingEndTime1.click();
		details.meetingEndTime1.clear();
		details.meetingEndTime1.sendKeys("8:00 PM");
		details.meetingEndTime1.sendKeys(Keys.TAB);
		details.nextButton1.click();
		
		Thread.sleep(2000);
		TestUtil.SelectDropDownOption(details.meetwithClient, "In-Person Meeting");
		
		TestUtil.SelectDropDownOption(details.meetingOutcome, "Completed");
		
		details.nextButton1.click();
			
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------












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
