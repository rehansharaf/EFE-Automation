package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class createLead extends TestBase{
	
	
	public createLead() {
		PageFactory.initElements(driver, this);
	}
	
			
	@FindBy(xpath="(//*[@class='slds-icon slds-icon-text-default slds-icon_x-small'])[1]")
	WebElement leadsdropdown;
	
	@FindBy(xpath = "(//span[contains(text(),'Leads')])[1]")
	WebElement leadsLink;
	
	@FindBy(xpath = "(//div[@title='New'])[1]")
	WebElement newLead;
	
	@FindBy(xpath = "//span[contains(text(),'New Business')]")
	WebElement newBusiness;
	
	@FindBy(xpath = "//span[contains(text(),'New Business')]")
	WebElement newBranch;
	
	@FindBy(xpath = "(//span[contains(@class,'label bBody')][contains(text(),'Next')])[1]")
	WebElement nextButton;
	
	@FindBy(xpath = "(//input[@title='Search Accounts'])[1]")
	WebElement searchAccounts;
	
//	@FindBy(xpath = "//div[@title=prop.getProperty("userXpath")]")
//	WebElement selectUser;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(xpath = "(//label//span[contains(text(),'Company')])[1]")
	WebElement company;
	
	@FindBy(xpath = "(//span[contains(text(),'Company')]/../following-sibling::input)[1]")
	WebElement companyName;
	
	@FindBy(xpath = "//button[3]//span[1]")
	WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(text(),'New Business')]")
	WebElement text;
	
	@FindBy(xpath = "(//span[contains(@class,'title')][contains(text(),'Lead')])[1]")
	WebElement lead;
	
	
	@FindBy(xpath = "//a[@title='Delete']")
	WebElement deleteLead;
	
	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	WebElement deleteConfirmation;
	
	@FindBy(xpath = "(//span[contains(text(),'View All')])[2]")
	WebElement leadViewAll;	
		

	
	public void createnewlead(int i) throws InterruptedException {
		

		driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/page/home");
		Thread.sleep(5000);	
		leadsLink.click();
		Thread.sleep(5000);	
		newLead.click();
//		text.getText();
		
		if (i == 1) {
			newBusiness.click();
		} else {
			newBranch.click();
		}
		
		nextButton.click();
		searchAccounts.click();
		String user = prop.getProperty("searchuser");
		String xpath ="//div[@title='"+user+"']";
		driver.findElement(By.xpath(xpath)).click();
		lastName.sendKeys("test");
		companyName.sendKeys("test");
		saveButton.click();
		
		driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/page/home");
		
	}
	
	
	public void deletelead() throws InterruptedException {
		
		Thread.sleep(5000);			
		WebElement dropdownElement;			
		lead.click();
		leadViewAll.click();
		List <WebElement> listlead = driver.findElements(By.xpath("(//div[@class='uiVirtualDataTable indicator'])[2]/following-sibling::table/tbody/tr"));			
		
		for (int i=1; i<=listlead.size(); i++) {				
			dropdownElement = driver.findElement(By.xpath("(//div[@class='uiVirtualDataTable indicator'])[2]/following-sibling::table/tbody/tr[1]/td[4]"));				
			dropdownElement.click();
			deleteLead.click();
			deleteConfirmation.click();				
		}		
	
	}
	
	
	public void debuglead() {
		
		String user1 = prop.getProperty("searchuser");
		
			
		String xpath1 ="//div[@title='"+user1+"']";
		
		
		driver.findElement(By.xpath(xpath1)).click();
		
	}
}
