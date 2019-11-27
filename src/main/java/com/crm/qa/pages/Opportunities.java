package com.crm.qa.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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
	
	//@FindBy(xpath = "//div[contains(text(),'Create Workplace Opportunity')]")
	//WebElement createWorkplaceOpportunity;
	
	@FindBy(xpath = "//input[contains (@name, ('Create_Opportunity'))]/../label/span[contains (@class, ('slds-checkbox'))]")
	WebElement createWorkplaceOpportunity;
	
	
	//@FindBy(xpath = "//div[contains(text(),'Create Branch/PA Opportunity')]")
	//WebElement createBranchOpportunity;
	
	@FindBy(xpath = "//input[contains (@name, ('Create_Referral_Opportunity'))]/../label/span[contains (@class, ('slds-checkbox'))]")
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
	
	
	
	DetailsPage details = new DetailsPage();
	
	SoftAssert softAssertion = new SoftAssert();
//	String timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(new Date());

	String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm a").format(new Date());
	String commentsToEnter = "TestingPurpose " + timeStamp;
	
	String schedule1 = "Phone Call";
	String schedule2 = "ToDo";
	String schedule3 = "Appointment";
	String timeStamp1 = "AUG 25, 2018";
	
public void createWorkplaceOpportunity() throws InterruptedException, ParseException {
		
	Thread.sleep(5000);
	
		commentsTextarea.sendKeys(commentsToEnter);
		
		solutionsDiscussed.click();
		
		details.selectOutcome(1);
		
		scrolltofooter.click();
		
		createWorkplaceOpportunity.click();
		
		details.clickNextButton();
		
		/*
		 * if(!driver.findElements(By.
		 * xpath("//div[contains(text(),'Do not close any existing tasks')]")).isEmpty()
		 * ){ createNewTask.click(); nextButton1.click(); }else{
		 * System.out.println("No Previous Tasks screen displayed"); }
		 */
		
		
		Thread.sleep(2000);
		oppField1.sendKeys("2");
		oppField2.sendKeys("50000");
		//oppField3.sendKeys("10000");
		//oppField4.sendKeys("15000");
		//oppField5.sendKeys("20000");
		
		nextButton2.click();	
		
		Thread.sleep(5000);	
		
	}


public void createBranchOpportunity() throws InterruptedException, ParseException {
	
	Thread.sleep(5000);	
	
	commentsTextarea.sendKeys(commentsToEnter);

	solutionsDiscussed.click();
	
	details.selectOutcome(1);
	
	scrolltofooter.click();
	
	createBranchOpportunity.click();
	
	details.clickNextButton();	
	
	
		/*
		 * if(!driver.findElements(By.
		 * xpath("//div[contains(text(),'Do not close any existing tasks')]")).isEmpty()
		 * ){ createNewTask.click(); nextButton1.click(); }else{
		 * System.out.println("No Previous Tasks screen displayed"); }
		 */
	

	
		/*
		 * Select leadSource2 = new Select(leadSource1); leadSource2.selectByIndex(10);
		 */
	
	tMAssets.sendKeys("250000");
	
	details.clickNextButton();
	
	Thread.sleep(10000);	
	
	
}
	


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



public void verifyBranchOppty(String status) throws InterruptedException {

	Thread.sleep(2000);
	String stage = driver.findElement(By.xpath("//div[contains (@class, ('recordCell'))]//span[contains(text(),'" +status+ "')]")).getText();
	softAssertion.assertEquals(stage, status, "Stage doesnot match");
	
	//Add Page Factory element
	String closeOpttyasLostonDetailsPage = driver.findElement(By.xpath("//div[contains(@class,'col main-col slds-size--6-of-12')]//*[contains(text(),'Close Opportunity as Lost')]")).getText();
	softAssertion.assertEquals(closeOpttyasLostonDetailsPage, "Close Opportunity as Lost", "Action doesnot exist on Detail Page");
	
	oppLink.click();
	
	Thread.sleep(2000);
	//Add Page Factory element
	String closeOpttyasLostonOpttyPage = driver.findElement(By.xpath("//div[@class='row region-subheader']//*[contains(text(),'Close Opportunity as Lost')]")).getText();
	softAssertion.assertEquals(closeOpttyasLostonOpttyPage, "Close Opportunity as Lost", "Action doesnot exist opportunity Page");

	softAssertion.assertAll();
	
	
}


public void opportunityClosedLost() throws InterruptedException {

	Thread.sleep(2000);
	
	
	
	//Click Close Opportunity as Lost Radio button - Add the PageFactory element
	driver.findElement(By.xpath("//label[contains (@for, ('closeOpportunityChoice'))]//span[contains (@class, ('slds-radio--faux'))]")).click();
	
	//Click Close Opportunity as Lost Next button - Add the PageFactory element
	driver.findElement(By.xpath("//div[contains (@class,('slds-box'))]//footer//button[contains (@title,'Next')]")).click();

	//Loss Reason DropDown - Add the PageFactory element
	driver.findElement(By.xpath("//select[ contains (@id, ('dropdownInput1:'))]")).click();
	
	TestUtil.SelectDropDownOption(driver.findElement(By.xpath("//select[ contains (@id, ('dropdownInput1:'))]")), "Duplicate");
	
	driver.findElement(By.xpath("//select[ contains (@id, ('dropdownInput1:'))]")).click();
	
	//Loss Reason Notes - Add the PageFactory element
	driver.findElement(By.xpath("(//textarea[contains (@id, ('longInput'))])[1]")).sendKeys("Automation Testing - Dont bother");

	//Click Close Opportunity as Lost Next button - Add the PageFactory element
	driver.findElement(By.xpath("//div[contains (@class, ('actionsRight'))]//button[contains (@title,'Previous')]/following-sibling::button")).click();


	//driver.navigate().refresh();
	
	//Thread.sleep(2000);
	
	oppLink.click();
	
	//Scroll down ( tracking information)
	//driver.findElement(By.xpath("(//div[contains (@class,('forcePageBlockSectionRow'))])[55]")).getSize();


	
	Thread.sleep(2000);
	//Get stage status - Add the PageFactory element
	String Stagestatus = driver.findElement(By.xpath("//button[contains (@title, ('Edit Stage'))]/parent::div/span/span")).getText();
	
	 
	 
	softAssertion.assertEquals(Stagestatus, "Closed Lost", "Stage is not Closed Lost");




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
	
	
/*	
public void scrollIntoViewClick(WebElement element) { 
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    js.executeScript("arguments[0].click();", element);
}
*/

	
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
}
