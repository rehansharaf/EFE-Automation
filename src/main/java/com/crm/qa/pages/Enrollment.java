package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Enrollment extends TestBase {
	
	
	public Enrollment() {
		PageFactory.initElements(driver, this);
	}
	
			
	@FindBy(xpath = "(//span[contains(text(),'Household')])[2]")
	WebElement householdButton;

	@FindBy(xpath = "//span[contains(text(),'Primary Group')]/../preceding-sibling::h3/div/a")
	WebElement householdLink;

	@FindBy(xpath = "(//div/span[contains(text(),'Account Name')]/../following-sibling::div/span/span)[3]")
	WebElement householdName;

	@FindBy(xpath = "//div[contains(text(),'New Account Setup')]")
	WebElement newAccountSetup;
	
	@FindBy(xpath = "(//button//span[contains(text(),'Next')])[4]")
	WebElement next;
	
	@FindBy(xpath = "//div[contains(text(),'Existing Client')]")
	WebElement existingClient;

	@FindBy(xpath = "//div[contains(text(),'Regular')]")
	WebElement regular;
	
	@FindBy(xpath = "(//span[contains(text(),'Forms')])[1]")
	WebElement formsButton;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Previous')]/../following-sibling::button/span")
	WebElement nextButton;

	@FindBy(xpath = "//div[contains(text(),'Account Registration')]/../../following-sibling::div/input")
	WebElement accountRegistration;

	@FindBy(xpath = "//div[contains(text(),'Schwab')]")
	WebElement selectSchwab;
	
	@FindBy(xpath = "//div[contains(text(),'No Fees')]")
	WebElement noFees;
	
	@FindBy(xpath = "//div[contains(text(),'Allocation Model')]/../../following-sibling::div/select")
	WebElement allocationModel;
	

	@FindBy(xpath = "//div[contains(text(),'No')]")
	WebElement selectNo;

	@FindBy(xpath = "//b[contains(text(),'Add Attachments')]")
	WebElement addAttachmentsText;

	@FindBy(xpath = "//nav//li//span[contains(text(),'Case')]")
	WebElement caseButton;
	
	
	@FindBy(xpath="//span//span[contains(text(),'Final Review')]/../following-sibling::button//span")
	WebElement finalReview;
	
	@FindBy(xpath="//a[contains(text(),'Final Review')]")
	WebElement finalReviewButton;
	
	@FindBy(xpath = "//a[@title='Enrollment']")
	WebElement selectEnrollmentStage;
	
	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/../following-sibling::button/span)[1]")
	WebElement saveCase;
	
	@FindBy(xpath = "(//footer//button//span[contains(text(),'Next')])[6]")
	WebElement enrollmentNext;
	
	
	
	DetailsPage__exp2 detailspage = new DetailsPage__exp2();
	String uid = DetailsPage.uid;
	
	String fname = "Testf"+ uid;
	String lname = "Testl"+ uid;
	String aname = fname+" "+lname;
	

	




	
	public void navigateToForms() throws InterruptedException {
		
		Thread.sleep(10000);
		
		householdButton.click();
		householdLink.click();
		
		String HHName = householdName.getText();
		softAssertion.assertEquals(HHName, "Scheduled", "Meeting Status data mismatch in meetings Tab");
		
		formsButton.click();
		newAccountSetup.click();
		next.click();
		
		
	}
	
	
	public void createRegularAccount() throws InterruptedException {
		
		Thread.sleep(5000);
		existingClient.click();
		regular.click();
		nextButton.click();
		Thread.sleep(5000);
		regular.click();
		nextButton.click();
		
		Thread.sleep(5000);
		
		
		String username = "Primary - "+prop.getProperty("retailuser");
		driver.findElement(By.xpath("//div[contains(text(),'"+username+"')]")).click();
		accountRegistration.sendKeys("Testing Purpose");
		selectSchwab.click();
		noFees.click();
		
		Select model = new Select(allocationModel);
		model.selectByIndex(5);
		
		nextButton.click();
		Thread.sleep(5000);
		selectNo.click();
		nextButton.click();
		
		Thread.sleep(5000);
		
		String textValid = addAttachmentsText.getText();
		softAssertion.assertEquals(textValid, "Add Attachments", "Meeting Status data mismatch in meetings Tab");
		
		nextButton.click();
		
		Thread.sleep(5000);

	}
	
	public void processCase() throws InterruptedException {
		
		String caseText = caseButton.getText();
		softAssertion.assertEquals(caseText, "Scheduled", "Meeting Status data mismatch in meetings Tab");
		
		finalReview.click();
		finalReviewButton.click();
		selectEnrollmentStage.click();
		
		saveCase.click();
		
		
	}
	
		
	
}
