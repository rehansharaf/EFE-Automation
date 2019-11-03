package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class NASF extends TestBase{

	public NASF() {
		PageFactory.initElements(driver, this);
	} 
	
	
	@FindBy(xpath="//span[contains(@class,'title')][contains(text(),'Household')]")
	WebElement householdTab;
	
	@FindBy(xpath="//span[contains(text(),'Forms')]")
	WebElement formsTab;
	
	@FindBy(xpath="//div[contains(text(),'New Account Setup')]")
	WebElement NASF;
	
	@FindBy(xpath="//div[contains(text(),'New Client')]")
	WebElement newAccount;
	
	@FindBy(xpath="//div[contains(text(),'Existing Client')]")
	WebElement existingAccount;
	
	@FindBy(xpath="//div[contains(text(),'Centralized Trading')]")
	WebElement CTAccount;
	
	@FindBy(xpath="//div[contains(text(),'Retirement Paycheck')]")
	WebElement RPAccount;
	
	@FindBy(xpath="//div[contains(text(),'Regular')]")
	WebElement regularAccount;
	
	@FindBy(xpath="//div[contains(text(),'Falcon')]")
	WebElement falconAccount;
	
	@FindBy(xpath="(//div[contains(text(),'Personal Advisor')])[1]")
	WebElement paAccount;
	
	
	@FindBy(xpath="//div[contains(text(),'Centralized Trading (Blended ETF/MF)')]")
	WebElement CTBlendedETF;
	
	@FindBy(xpath="//div[contains(text(),'Retirement Paycheck (Blended ETF/MF)')]")
	WebElement RPBlendedETF;
	

	@FindBy(xpath="//button[contains(text(),'Previous')]/following-sibling::button")
	WebElement nextButton;
	

	@FindBy(xpath="//div[contains(text(),'Account Registration')]/../../../following-sibling::div/input")
	WebElement accountRegistration;
	
	@FindBy(xpath = "//div[contains(text(),'Allocation Model')]/../../../following-sibling::div/select")
	WebElement allocationModel;
	
	@FindBy(xpath="//div[contains(text(),'Gross Annual Distribution')]/../../../following-sibling::div/input")
	WebElement grossAnnualDistribution;
	
	
	@FindBy(xpath = "//div[contains(text(),'Schwab')]")
	WebElement custodian;
	
	@FindBy(xpath = "//div[contains(text(),'Standard Fee Schedule')]")
	WebElement quarterlyFee;
	
	@FindBy(xpath = "//div[contains(text(),'Yes')]/../../../preceding-sibling::span//div")
	WebElement DCAAccount;
	
	@FindBy(xpath = "//div[contains(text(),'Yes')]/../../../following-sibling::span//div")
	WebElement noAccount;
	
	@FindBy(xpath = "//span[contains(text(),'Final Review')]/..//following-sibling::button//span[contains(text(),'Edit Status')]")
	WebElement editStatus;
	
	@FindBy(xpath = "//a[contains(text(),'Enrollment')]")
	WebElement enrollment;
	
	@FindBy(xpath = "//a[contains(text(),'Final Review')]")
	WebElement finalreview;
	
	
	@FindBy(xpath = "//span[contains(text(),'Cancel')]/../following-sibling::button//span[contains(text(),'Save')]")
	WebElement saveButton;
	
	@FindBy(xpath = "//b[contains(text(),'Click NEXT to complete the enrollment changes.')]/ancestor::div[5]/following-sibling::footer//button[contains(text(),'Next')]")
	WebElement nextButton2;
	
	@FindBy(xpath = "//div[contains(text(),'Yes - Other')]/ancestor::span/following-sibling::span//div[contains(text(),'No')]")
	WebElement noML;
	
	@FindBy(xpath = "(//span[contains(text(),'Branch Management')])[1]")
	String clientProgression;
	
	@FindBy(xpath = "//a[contains(text(),'Branch Management')]")
	WebElement clientProgressionLink;
	
	@FindBy(xpath = "//div[contains(text(),'Status:')]/following-sibling::div//span[contains(text(),'Enrolled')]")
	WebElement enrolled;
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	
	static String uid = DetailsPage.uniqueid;
		
	static String fname = "Testf"+ uid;
	static String lname = "Testl"+ uid;
	String hhName = lname +" "+"Household";
	String aName = "Primary"+" - "+fname+" "+lname;
	String spousefname = "spouseTestf"+ uid;
	String spouselname = "spouseTestl"+ uid;
	String sname = spousefname +" "+spouselname;
	
	//button[contains(text(),'Testl921424 Household')]
	
	
	public void navigatetoForms() throws InterruptedException {
		
		Thread.sleep(5000);
		householdTab.click();
		driver.findElement(By.xpath("//button[contains(text(),'"+hhName+"')]")).click();
		formsTab.click();
		
		
	}
	
public void createAccount(int i) throws InterruptedException {
		
	Thread.sleep(5000);
	navigatetoForms();
	NewAccountSetupForm(i);
	updateEnrollCase();
		
		
	}
	
	
public void NewAccountSetupForm(int i) throws InterruptedException {
		
		
		NASF.click();
		//driver.findElement(By.xpath("//button[contains(text(),'"+hhName+"')]")).click();
		//formsTab.click();
		clickNextButton();
		newAccount.click();
		
		
		if (i == 1) {
			
			
			SubmitCTForm();
			
		} else if (i == 2) {
			
			SubmitRPForm();
			
		} else if (i == 3) {
			
			
			SubmitRegularForm();
			
		} else if (i == 4) {
			
			
			SubmitFalconForm();
			
		} else if (i == 5) {
			
			paAccount.click();
			
		}
		
		
		
		
		
	}


public void verifyFinancialData() {
	
//	 jse2.executeScript("arguments[0].scrollIntoView()", clientProgression); 
	 Boolean isCPPresent = driver.findElements(By.xpath("(//span[contains(text(),'Branch Management')])[1]")).size() > 0;
	
	Actions actions = new Actions(driver);
	actions.moveToElement(clientProgressionLink);
	
	 
	
	// jse2.executeScript("arguments[0].scrollIntoView()", clientProgressionLink); 
	Boolean isCPLinkPresent = driver.findElements(By.xpath("//a[contains(text(),'Branch Management')]")).size() > 0;
	//jse2.executeScript("arguments[0].scrollIntoView()", enrolled); 
	actions.moveToElement(enrolled);
	//actions.perform();
	Boolean isEnrolledPresent = driver.findElements(By.xpath("//div[contains(text(),'Status:')]/following-sibling::div//span[contains(text(),'Enrolled')]")).size() > 0;
	
	
	if (isCPPresent == true && isCPLinkPresent == true && isEnrolledPresent == true ) {
		
		System.out.println("Client Progression Present and Enrolled into Branch Management");
		
	} else {
		
		System.out.println("Accounty not enrolled into Branch Management");
		
	}
	
}
private void SubmitFalconForm() throws InterruptedException {
	// TODO Auto-generated method stub
	falconAccount.click();
	nextButton.click();
	Thread.sleep(5000);
	falconAccount.click();
	 jse2.executeScript("arguments[0].click()", nextButton);
	//nextButton.click();
	driver.findElement(By.xpath("//div[contains(text(),'"+aName+"')]")).click();
	accountRegistration.sendKeys("Registration"+ uid);
	
	Select model = new Select(allocationModel);
	model.selectByIndex(10);
	custodian.click();
	quarterlyFee.click();
	
	//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].click()", DCAAccount);
	
	jse2.executeScript("arguments[0].click()", nextButton);
	//nextButton.click();
	Thread.sleep(5000);
	noAccount.click();
	clickNextButton();
	Thread.sleep(5000);
	clickNextButton();
	Thread.sleep(5000);
	
	driver.navigate().refresh();
	
}

private void SubmitRegularForm() throws InterruptedException {
	
	regularAccount.click();
	nextButton.click();
	Thread.sleep(5000);
	regularAccount.click();
	jse2.executeScript("arguments[0].click()", nextButton);
	//nextButton.click();
	driver.findElement(By.xpath("//div[contains(text(),'"+aName+"')]")).click();
	accountRegistration.sendKeys("Registration"+ uid);
	
	Select model = new Select(allocationModel);
	model.selectByIndex(15);
	custodian.click();
	quarterlyFee.click();
	
	//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	//jse2.executeScript("arguments[0].click()", DCAAccount);
	
	jse2.executeScript("arguments[0].click()", nextButton);
	//nextButton.click();
	Thread.sleep(5000);
	noAccount.click();
	clickNextButton();
	Thread.sleep(5000);
	clickNextButton();
	Thread.sleep(5000);
	
	driver.navigate().refresh();
	
}

private void SubmitCTForm() throws InterruptedException {
	// TODO Auto-generated method stub
	CTAccount.click();
	nextButton.click();
	Thread.sleep(5000);
	CTBlendedETF.click();
	nextButton.click();
	driver.findElement(By.xpath("//div[contains(text(),'"+aName+"')]")).click();
	accountRegistration.sendKeys("Registration"+ uid);
	
	Select model = new Select(allocationModel);
	model.selectByIndex(15);
	custodian.click();
	quarterlyFee.click();
	
	//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].click()", DCAAccount);
	
	//DCAAccount.click();
	
	jse2.executeScript("arguments[0].click()", nextButton);
	//nextButton.click();
	Thread.sleep(5000);
	noAccount.click();
	clickNextButton();
	Thread.sleep(5000);
	clickNextButton();
	Thread.sleep(5000);
	
	driver.navigate().refresh();
	
}

private void SubmitRPForm() throws InterruptedException {
	// TODO Auto-generated method stub
	RPAccount.click();
	nextButton.click();
	RPBlendedETF.click();
	nextButton.click();
	driver.findElement(By.xpath("//div[contains(text(),'"+aName+"')]")).click();
	accountRegistration.sendKeys("Registration"+ uid);
	
	Select model = new Select(allocationModel);
	model.selectByIndex(4);
	custodian.click();
	quarterlyFee.click();
	grossAnnualDistribution.sendKeys("25000");

	
	//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].click()", noML);
	
	//DCAAccount.click();
	
	
	jse2.executeScript("arguments[0].click()", nextButton);
	//nextButton.click();
	Thread.sleep(5000);
	noAccount.click();
	clickNextButton();
	Thread.sleep(5000);
	clickNextButton();
	Thread.sleep(5000);
	//jse2.executeScript("arguments[0].click()", nextButton);
	//WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	//		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Household')]")));
	
	driver.navigate().refresh();
	
}


public void updateEnrollCase() throws InterruptedException {
	
	
	
	//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].click()", editStatus);
	
	//editStatus.click();
	jse2.executeScript("arguments[0].click()", finalreview);
	//finalreview.click();
	jse2.executeScript("arguments[0].click()", enrollment);
	//enrollment.click();
	Thread.sleep(2000);
	jse2.executeScript("arguments[0].click()", saveButton);
	Thread.sleep(2000);
	//saveButton.click();
	jse2.executeScript("arguments[0].click()", nextButton2);
	//nextButton2.click();
	
	Thread.sleep(10000);
	
	
}




public void clickNextButton() throws InterruptedException {
	List<WebElement> nextButtonCount = driver.findElements(By.xpath("//button[contains(text(),'Next')]"));
    int nextButtonSize = nextButtonCount.size();
    //WebElement nextButton = driver.findElement(By.xpath("(//button[contains(text(),'Next')])[" + nextButtonSize+ "]"));
    //Thread.sleep(5000);
    WebElement myelement = driver.findElement(By.xpath("(//button[contains(text(),'Next')])["+nextButtonSize+"]"));
   // JavascriptExecutor jse2 = (JavascriptExecutor)driver;
    jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
	//nextButton.click();
	//Thread.sleep(5000);
    myelement.click();
    
}

}
