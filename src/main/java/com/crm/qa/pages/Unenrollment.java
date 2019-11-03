package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Unenrollment extends TestBase{

	public Unenrollment() {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//div[contains(text(),'Unenrollment Reason')]/../../../following-sibling::div/select")
	WebElement unenrollmentReason;
	
	@FindBy(xpath = "//div[contains(text(),'Terminate All FE Services')]")
	WebElement terminateAll;
	
	@FindBy(xpath = "//div[contains(text(),'Delink Selected Accounts')]")
	WebElement deLink;
	
	@FindBy(xpath = "//div[contains(text(),'No')]")
	WebElement noButton;
	
	@FindBy(xpath = "//a[contains(text(),'Click on this link to go to the case in order to s')]")
	WebElement delinkCaseLink;
	
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]/..//following-sibling::button")
	WebElement nextButton1;

	@FindBy(xpath = "//span[contains(text(),'Final Review')]/..//following-sibling::button//span[contains(text(),'Edit Status')]")
	WebElement editStatus;
	
	@FindBy(xpath = "//a[contains(text(),'Enrollment')]")
	WebElement enrollment;
	
	@FindBy(xpath = "//a[contains(text(),'Final Review')]")
	WebElement finalreview;
	
	
	@FindBy(xpath = "//span[contains(text(),'Cancel')]/../following-sibling::button//span[contains(text(),'Save')]")
	WebElement saveButton;
	
	@FindBy(xpath = "(//button[contains(text(),'Next')])[4]")
	WebElement nextButton2;
	
	@FindBy(xpath = "//span[@class='slds-checkbox_faux']")
	WebElement allcheckBox;
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	
	
	
	
	public boolean verifyUnenrollment() {
		
		if(unenrollmentReason.isDisplayed()) {
			return true;
		}	
		
		else {
		return false;
		}
		
	}
	
	public void unenrollmentFlow(int i, String fAccount) throws InterruptedException {
		
		Thread.sleep(5000);
		
		Select unenroll = new Select(unenrollmentReason);
		unenroll.selectByIndex(3);
		clickNextButton();
		
		if (i == 1) {
		terminateAll.click();
		nextButton1.click();
		
		} else if (i == 2) {
			deLink.click();
			nextButton1.click();
			selectFinancialAccount(fAccount);
			nextButton1.click();
		}
		Thread.sleep(5000);
		noButton.click();
		nextButton1.click();
		
	}
	
	public void updateUnenrollCase() throws InterruptedException {
		
		
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Click on this link to go to the case in order to s')]")));
		
		jse2.executeScript("arguments[0].click()", delinkCaseLink);
		//delinkCaseLink.click();
		
		
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
	    String newTab = (String) tabs.get(1);
	    String oldTab = driver.getWindowHandle();
	    
		driver.switchTo().window(newTab);
		
		
		Thread.sleep(5000);
		
		//JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click()", editStatus);
		
		//editStatus.click();
		jse2.executeScript("arguments[0].click()", finalreview);
		//finalreview.click();
		jse2.executeScript("arguments[0].click()", enrollment);
		//enrollment.click();
		Thread.sleep(5000);
		jse2.executeScript("arguments[0].click()", saveButton);
		//saveButton.click();
		nextButton2.click();
		driver.close();
		driver.switchTo().window(oldTab);
	
		Thread.sleep(10000);
		
	}
	
	
	private void selectFinancialAccount(String fAccount) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Thread.sleep(5000);
		
		 jse2.executeScript("arguments[0].scrollIntoView()", allcheckBox);
			
		
		if (fAccount == "Regular") {
			
			
			driver.findElement(By.xpath("(//lightning-formatted-text[contains(text(),'Regular')]/ancestor::td/preceding-sibling::td)[1]")).click();
			
		} else if (fAccount == "RP") {
			
			driver.findElement(By.xpath("(//lightning-formatted-text[contains(text(),'Retirement Paycheck (Blended ETF/MF)')]/ancestor::td/preceding-sibling::td)[1]")).click();
			
			
		} else if (fAccount == "CT") {
			
			driver.findElement(By.xpath("(//lightning-formatted-text[contains(text(),'Centralized Trading (Blended ETF/MF)')]/ancestor::td/preceding-sibling::td)[1]")).click();
			
			
		}
		
	}

	public void clickNextButton() throws InterruptedException {
		List<WebElement> nextButtonCount = driver.findElements(By.xpath("//button[contains(text(),'Next')]"));
	    int nextButtonSize = nextButtonCount.size();
	    //WebElement nextButton = driver.findElement(By.xpath("(//button[contains(text(),'Next')])[" + nextButtonSize+ "]"));
	    //Thread.sleep(5000);
	    WebElement myelement = driver.findElement(By.xpath("(//button[contains(text(),'Next')])[1]"));
	    JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	    jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
		//nextButton.click();
		//Thread.sleep(5000);
	    myelement.click();
	    
	}
	
		

}
