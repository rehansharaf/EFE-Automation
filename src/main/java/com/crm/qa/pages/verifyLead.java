package com.crm.qa.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;

public class verifyLead extends TestBase{



	public verifyLead() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@title='Lead Status:']/../../..//preceding-sibling::h3/div/a")
	WebElement leadLink1;
	
	@FindBy(xpath = "//span[@title='Leads']/following-sibling::span")
	WebElement leadCount;
	
	@FindBy(xpath = "(//span[contains(text(),'Ford-401K Roll-in')])[1]")
	WebElement oppLink1;


	@FindBy(xpath = "//span[contains(@class,'title slds-truncate')][contains(text(),'test')]")
	WebElement leadLink2;


	@FindBy(xpath = "//div[contains(text(),'Lead Status')]/following-sibling::div/span")
	WebElement leadStatus;
	
	@FindBy(xpath = "//span[@class='title'][contains(text(),'Closed without opportunity')]")
	WebElement leadver1;
	
	
	@FindBy(xpath = "//span[contains(text(),'Customer Contact')]/../following-sibling::div/span")
	WebElement leadver2;
	
	@FindBy(xpath = "//span[contains(text(),'Last Activity Date')]/../following-sibling::div/span")
	WebElement leadver3;
	
	@FindBy(xpath = "//span[contains(text(),'Lead Status')]/../following-sibling::div/span")
	WebElement leadver4;
	
	@FindBy(xpath = "//div[contains(text(),'Last Activity Date')]/following-sibling::div/span")
	WebElement lastActivityDate;
	
	
	@FindBy(xpath = "//span[contains(@class,'title')][contains(text(),'Lead')]")
	WebElement lead;
	
	@FindBy(xpath = "//span[contains(@class,'title')][contains(text(),'Opportunity')]")
	WebElement opportunity;

	@FindBy(xpath ="//span[@class='title slds-truncate'][contains(text(),'test')]")
	WebElement link;
	
	@FindBy(xpath = "(//span[contains(text(),'View All')])[2]")
	WebElement leadViewAll;		
	
	@FindBy(xpath = "//a[@title='Delete']")
	WebElement deleteLead;
	
	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	WebElement deleteConfirmation;
	
	@FindBy(xpath = "//a[@title='Show 2 more actions']//span[contains(text(),'Show more actions')]")
	WebElement showAll;
	
	@FindBy(xpath = "//a[@title='Delete']")
	WebElement delete;
	
	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	WebElement deleteConf;

	
	
	 

//	SoftAssert softAssertion = new SoftAssert();
	String timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(new Date());


	public void navigateLeadNotReached() {	
		
		lead.click();
		leadLink1.click();
		String lstatus = leadStatus.getText();
		softAssertion.assertEquals("Attempting", lstatus, "Lead Status Mismatch");
		String lActivityDate = lastActivityDate.getText();
		softAssertion.assertEquals(timeStamp, lActivityDate, "Time stamp Mismatch");	
		softAssertion.assertAll();
		
	}
	
	public void navigateLeadReached(int i) throws InterruptedException {
		
		Thread.sleep(5000);		
		
		String oldTab = driver.getWindowHandle();
		
//		driver.navigate().to(leadRecord);
//		link.click();
		
		
		 ArrayList tabs = new ArrayList (driver.getWindowHandles());
		 System.out.println(tabs.size());
		 String newTab = (String) tabs.get(1);
		 driver.switchTo().window(newTab);
		 
		 driver.navigate().refresh();
		 
		 Thread.sleep(5000);		 

						
//		Boolean lstatus1 = leadver1.isDisplayed();
//		
//		String leadver = leadver1.getText();
		
			
//			softAssertion.assertEquals("Closed Without Opportunity", leadver);
			softAssertion.assertEquals("Reached", leadver2);
			softAssertion.assertEquals(timeStamp, leadver3);
			softAssertion.assertEquals("Closed Without Opportunity", leadver4);
		
			
		
//		String lActivityDate = lastActivityDate.getText();
//		softAssertion.assertEquals(timeStamp, lActivityDate);
//		isLeadLinkVisible();
		
		driver.close();
		// Switch driver control to focused tab window
		driver.switchTo().window(oldTab);
		softAssertion.assertAll();
	}
	
public String leadURL() throws InterruptedException {
		
		Thread.sleep(5000);
		lead.click();		
		String url = leadLink1.getAttribute("href");			
		return url;
		
}
	
	
		public void deleteLead() throws InterruptedException {
			
		lead.click();
		Thread.sleep(5000);	
		String count = leadCount.getText();
		
		if ("(0)".equals(count)) {
			softAssertion.assertEquals(count, "(0)", "There are no leads");	
		} else {
			 deleteLeads();
		}
	
	}
		
		

		public void deleteLeads() throws InterruptedException {
			
			Thread.sleep(5000);			
			WebElement dropdownElement;			
			leadViewAll.click();			
			List <WebElement> listopp = driver.findElements(By.xpath("//div[@class='uiVirtualDataTable indicator']/following-sibling::table/tbody/tr"));			
			
			for (int i=1; i<=listopp.size(); i++) {	
				Thread.sleep(5000);	
				dropdownElement = driver.findElement(By.xpath("//div[@class='uiVirtualDataTable indicator']/following-sibling::table/tbody/tr[1]/td[5]"));				
				dropdownElement.click();
				deleteLead.click();
				deleteConfirmation.click();				
			}		
			
			driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/r/Account/0010R00000IZ3R7QAL/view");
		}
	
		
		public void deleteLeads1() throws InterruptedException {
			
			Thread.sleep(5000);			
				
			showAll.click();
			delete.click();
			deleteConf.click();
			
			
			driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/r/Account/0010R00000IZ3R7QAL/view");
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
		

		softAssertion.assertEquals("Not Reached", leadver2);
		softAssertion.assertEquals("", leadver3);
		softAssertion.assertEquals("New", leadver4);
		

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

	public void verifyBusinessLead() throws InterruptedException {
		
		Thread.sleep(5000);		
		
		String oldTab = driver.getWindowHandle();
		
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		 System.out.println(tabs.size());
		 String newTab = (String) tabs.get(1);
		 driver.switchTo().window(newTab);
		 
		 driver.navigate().refresh();
		 
		 Thread.sleep(5000);		 

						
		 softAssertion.assertEquals("New", leadver4);
		
			
		
		driver.close();
		
		driver.switchTo().window(oldTab);
		softAssertion.assertAll();
		
	}

	public void verifyBranchLead() throws InterruptedException {
	
Thread.sleep(5000);		
		
		String oldTab = driver.getWindowHandle();
		
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		 System.out.println(tabs.size());
		 String newTab = (String) tabs.get(1);
		 driver.switchTo().window(newTab);
		 
		 driver.navigate().refresh();
		 
		 Thread.sleep(5000);		 

						
		 softAssertion.assertEquals("New", leadver4);
		
			
		
		driver.close();
		
		driver.switchTo().window(oldTab);
		softAssertion.assertAll();
		
	}
}
