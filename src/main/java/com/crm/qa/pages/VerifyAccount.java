package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class VerifyAccount extends TestBase{

	public VerifyAccount() {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//div[@title='Verify']")
	WebElement verifyLink;
	
	@FindBy(xpath = "//span[contains(text(),'Finish')]")
	WebElement finishButton;
	
	@FindBy(xpath = "//font[contains(text(),'Boeing')]")
	WebElement companyName;
	@FindBy(xpath = "//font[contains(text(),'Sean Melvin')]")
	WebElement accountName;
	@FindBy(xpath = "//font[contains(text(),'May 3, 1979')]")
	WebElement dob;
	@FindBy(xpath = "//font[contains(text(),'1050 Enterprise Way 3rd Floor')]")
	WebElement addr1;
	@FindBy(xpath = "//font[contains(text(),'Sunnyvale, CA 94089')]")
	WebElement addr2;
	@FindBy(xpath = "//font[contains(text(),'USA')]")
	WebElement addr3;
	@FindBy(xpath = "//font[contains(text(),'smelvin@financialengines.com')]")
	WebElement email;
	
	
	
	public void verifyacc() {
		
		verifyLink.click();
		
		
		if (accountName.isDisplayed() && companyName.isDisplayed() ) {
		System.out.println(accountName.isDisplayed());
		System.out.println(companyName.getSize());
		System.out.println(email.getTagName());
		System.out.println(dob.getText());
		System.out.println(addr1.getText() + addr2.getText() + addr3.getText());
		}		
		
		finishButton.click();
		
		
	}
		

}
