package com.crm.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;




public class CommunicationPage extends TestBase {

	@FindBy(xpath="//a[contains (@class, ('tabHeader'))][contains (@data-tab-name, ('customTab8'))]")
	WebElement communicationTab;
	
	@FindBy(xpath="//a[contains (@data-label, ('All'))]")
	WebElement allTab;
	
	@FindBy(xpath="//lightning-formatted-text[contains(text(),'Call')]")
	WebElement loggedCall;
	
	@FindBy(xpath="//*[@class='slds-button__icon slds-button__icon--large']")
	WebElement notificationMsg;
	
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	public CommunicationPage() {
		 
		PageFactory.initElements(driver, this);
		
		}
	
	
	public void validateCallonCommunication() throws InterruptedException{
	
		Thread.sleep(2000);
		 if (driver.findElements(By.xpath("//*[@class='slds-button__icon slds-button__icon--large']")).size() != 0){
			 	Thread.sleep(3000);
			 	driver.findElement(By.xpath("//*[@class='slds-button__icon slds-button__icon--large']")).click();
			 	Thread.sleep(2000);
			 }
		
		jse2.executeScript("arguments[0].click()", communicationTab);
		Thread.sleep(2000);
		jse2.executeScript("arguments[0].click()", allTab);
		Thread.sleep(2000);
		
		
		if ((loggedCall.getText()).contains("Call") ){
			
			System.out.println( "Passed.................");
		}
		
	}
	
	
	
	
	
	
}
