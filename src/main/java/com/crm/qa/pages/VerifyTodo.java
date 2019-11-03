package com.crm.qa.pages;

import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.LogActivityTest;

public class VerifyTodo extends TestBase {
	
	
	@FindBy(xpath = "//span[contains(text(),'Last Modified By')]/../following-sibling::div/span/span")
	WebElement taskLastModifiedDate;
	
	@FindBy(xpath = "//span[contains(text(),'Comments')]/../following-sibling::div/span/span")
	WebElement taskComments;
	
	@FindBy(xpath = "//span[contains(text(),'Call Outcome')]/../following-sibling::div/span/span")
	WebElement calloutcomeText;		
	
	@FindBy(xpath = "//span[contains(text(),'Call Type')]/../following-sibling::div/span/span")
	WebElement callType;	
	
	@FindBy(xpath = "(//span[contains(text(),'Solutions Discussed')]/../following-sibling::div/span/span)[2]")
	WebElement solutions;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[3]/following-sibling::div//tbody//tr[1]//td[2]//lightning-formatted-text[1]")
	WebElement assignedTo1;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[3]/following-sibling::div//tbody//tr[1]//td[3]//lightning-formatted-text[1]")
	WebElement description1;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[3]/following-sibling::div//tbody//tr[1]//td[4]//lightning-formatted-text[1]")
	WebElement event1;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[3]/following-sibling::div//tbody//tr[1]//lightning-formatted-url[1]")
	WebElement dueDate1;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[2]/following-sibling::div//tbody//tr[1]//td[2]//lightning-formatted-text[1]")
	WebElement assignedTo2;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[2]/following-sibling::div//tbody//tr[1]//td[3]//lightning-formatted-text[1]")
	WebElement description2;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[2]/following-sibling::div//tbody//tr[1]//td[4]//lightning-formatted-text[1]")
	WebElement event2;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[2]/following-sibling::div//tbody//tr[1]//lightning-formatted-url[1]")
	WebElement dueDate2;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[2]/following-sibling::div//tbody//tr[1]//td[2]//lightning-formatted-text[1]")
	WebElement assignedTo3;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[2]/following-sibling::div//tbody//tr[1]//td[3]//lightning-formatted-text[1]")
	WebElement description3;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[2]/following-sibling::div//tbody//tr[1]//td[4]//lightning-formatted-text[1]")
	WebElement event3;
	
	@FindBy(xpath = "(//header[@class= 'slds-card__header slds-grid'])[2]/following-sibling::div//tbody//tr[1]//lightning-formatted-url[1]")
	WebElement dueDate3;
	
	
	@FindBy(xpath = "//span[contains(text(),'Status')]/../following-sibling::div/span/span")
	WebElement status;
	
	@FindBy(xpath = "//span[contains(text(),'Due Date')]/../following-sibling::div/span/span")
	WebElement dueDate4;
	
	@FindBy(xpath = "//span[@class='title'][contains(text(),'Communications')]")
	WebElement Communications;
	
	@FindBy(xpath = "//li[@title='To-Do']")
	WebElement todoTab;
	
	@FindBy(xpath = "//li[@title='Meetings']")
	WebElement meeting;
	
	@FindBy(xpath = "//span[contains(text(),'Start')]/../following-sibling::div/span/span")
	WebElement meetingStartTime;
		
	@FindBy(xpath = "//span[contains(text(),'End')]/../following-sibling::div/span/span")
	WebElement meetingEndTime;

	@FindBy(xpath = "(//span[contains(text(),'Type')]/../following-sibling::div/span/span)[1]")
	WebElement meetingType;
	
	@FindBy(xpath = "(//span[contains(text(),'Type')]/../following-sibling::div/span/span)[2]")
	WebElement meetingSubType;
	
	@FindBy(xpath = "//span[contains(text(),'Meeting Medium')]/../following-sibling::div/span/span")
	WebElement meetingMedium;
	
	@FindBy(xpath = "//span[contains(text(),'Subject')]/../following-sibling::div/span/span")
	WebElement meetingSubject;
	
	

	
	
	String apptType = prop.getProperty("searchuser") + "-" +"Prospect Meeting-Initial";
	
	
	public VerifyTodo() {
		PageFactory.initElements(driver, this);
				
	}
	
	


	public void verifyTask() throws InterruptedException {		
		
	
	}
	
	DetailsPage detailspage = new DetailsPage();
	String comments = DetailsPage.commentsToEnter;
	String timeStamp = DetailsPage.timeStamp;
	String taskDate = DetailsPage.verifyDate;
	String meetingDate = DetailsPage.meetingformattedDate;
	
	
	
	

	public void verifyPhoneFutureTask() throws InterruptedException {
		
		Thread.sleep(5000);
		Communications.click();
		Thread.sleep(5000);	
		todoTab.click();
		Thread.sleep(5000);
		
		String cText1 = assignedTo1.getText();
		String cText2 = description1.getText();
		String cText3 = event1.getText();
		String cText4 = dueDate1.getText();
		
		softAssertion.assertEquals(cText1, "Rhonda Kemp", "Assigned to mismatch in TODO Tab");
		softAssertion.assertEquals(cText2, comments, "Description mismatch in TODO Tab");
		softAssertion.assertEquals(cText3, "Future", "Event data mismatch in TODO Tab");
		softAssertion.assertEquals(cText4, taskDate, "Due Date mismatch in TODO Tab");
				
		dueDate1.click();
		
		
		String oldTab = driver.getWindowHandle();
   	 	ArrayList tabs = new ArrayList (driver.getWindowHandles());
		 System.out.println(tabs.size());
		 String newTab = (String) tabs.get(1);
		 driver.switchTo().window(newTab);
		
		String cText5 = calloutcomeText.getText();
		String cText6 = taskLastModifiedDate.getText();
		String cText7 = taskComments.getText();
		String cText8 = status.getText();
		String cText9 = dueDate4.getText();
					
		softAssertion.assertEquals(cText5, "Follow Up", "Call Outcome mismatch in  Scheduled task Tab");
		softAssertion.assertEquals(cText6, timeStamp, "Last modified date mismatch in Scheduled task Tab");
		softAssertion.assertEquals(cText7, comments, "Comments data mismatch in Scheduled task Tab");
		softAssertion.assertEquals(cText8, "Open", "Status mismatch in Scheduled task Tab");
		softAssertion.assertEquals(cText9, taskDate, "Due Date mismatch in Scheduled task Tab");
		
		System.out.println("Task Data........................." + cText5 + cText6 + cText7 + cText8 + cText9 + taskDate);
		
		driver.close();
		// Switch driver control to focused tab window
		driver.switchTo().window(oldTab);
		
//		driver.navigate().to(prop.getProperty("url"));
		softAssertion.assertAll();
		
}
	

	
	


public void verifyTodoFutureTask() throws InterruptedException {
	
	Thread.sleep(5000);
	Communications.click();
	Thread.sleep(5000);	
	todoTab.click();
	Thread.sleep(5000);
	
	String cText11 = assignedTo2.getText();
	String cText12 = description2.getText();
	String cText13 = event2.getText();
	String cText14 = dueDate2.getText();
	
	softAssertion.assertEquals(cText11, "Rhonda Kemp", "Assigned to mismatch in TODO Tab");
	softAssertion.assertEquals(cText12, comments, "Description mismatch in TODO Tab");
	softAssertion.assertEquals(cText13, "Future", "Event data mismatch in TODO Tab");
	softAssertion.assertEquals(cText14, taskDate, "Due Date mismatch in TODO Tab");
			
	dueDate2.click();
	
	 String oldTab = driver.getWindowHandle();
	 ArrayList tabs = new ArrayList (driver.getWindowHandles());
	 System.out.println(tabs.size());
	 String newTab = (String) tabs.get(1);
	 driver.switchTo().window(newTab);
	
	
	String cText15 = calloutcomeText.getText();
	String cText16 = taskLastModifiedDate.getText();
	String cText17 = taskComments.getText();
	String cText18 = status.getText();
	String cText19 = dueDate3.getText();
				
	softAssertion.assertEquals(cText15, "Follow Up", "Call Outcome mismatch in  Scheduled task Tab");
	softAssertion.assertEquals(cText16, timeStamp, "Last modified date mismatch in Scheduled task Tab");
	softAssertion.assertEquals(cText17, comments, "Comments data mismatch in Scheduled task Tab");
	softAssertion.assertEquals(cText18, "Open", "Status mismatch in Scheduled task Tab");
	softAssertion.assertEquals(cText19, taskDate, "Due Date mismatch in Scheduled task Tab");
	
	System.out.println("Task Data........................." + cText15 + cText16 + cText17 + cText18 + cText19 + taskDate);
	
	
	
	driver.close();
	// Switch driver control to focused tab window
	driver.switchTo().window(oldTab);
	
//	driver.navigate().to(prop.getProperty("url"));
	softAssertion.assertAll();
	
	
}


public void verifyFutureMeetingTask() throws InterruptedException {
	
	Thread.sleep(5000);
	Communications.click();
	Thread.sleep(5000);	
	meeting.click();
	Thread.sleep(5000);
	
	String cText21 = assignedTo3.getText();
	String cText22 = description3.getText();
//	String cText23 = event1.getText();
	String cText24 = dueDate3.getText();
	
	String mStartDate = taskDate + " 12:00 PM";
	String mEndDate = taskDate + " 12:30 PM";
	
	softAssertion.assertEquals(cText21, "Rhonda Kemp", "Assigned to mismatch in TODO Tab");
	softAssertion.assertEquals(cText22, apptType, "Appointment Type mismatch in TODO Tab");
//	softAssertion.assertEquals(cText23, comments, "Description data mismatch in TODO Tab");
	softAssertion.assertEquals(cText24, mStartDate, "Due Date mismatch in TODO Tab");
			
	dueDate3.click();
	
	
	String oldTab = driver.getWindowHandle();
	 ArrayList tabs = new ArrayList (driver.getWindowHandles());
	 System.out.println(tabs.size());
	 String newTab = (String) tabs.get(1);
	 driver.switchTo().window(newTab);
	
	String cText25 = meetingStartTime.getText();
	String cText26 = meetingEndTime.getText();
	String cText27 = meetingType.getText();
	String cText28 = meetingSubType.getText();
	String cText29 = meetingMedium.getText();
	String cText30 = meetingSubject.getText();
	

	softAssertion.assertEquals(cText25, mStartDate, "Meeting Start time mismatch in  Scheduled task Tab");
	softAssertion.assertEquals(cText26, mEndDate, "Meeting End time mismatch in Scheduled task Tab");
	softAssertion.assertEquals(cText27, "Prospect Meeting", "Meeting Type mismatch in Scheduled task Tab");
	softAssertion.assertEquals(cText28, "Initial", "Meeting Sub Type mismatch in Scheduled task Tab");
	softAssertion.assertEquals(cText29, "On-Site Event", "Meeting Medium mismatch in Scheduled task Tab");
	softAssertion.assertEquals(cText30, apptType, "Meeting Subject mismatch in Scheduled task Tab");
	
	System.out.println("Task Data........................." + cText25 + cText26 + cText27 + cText28 + cText29 + cText30);
	
	driver.close();
	// Switch driver control to focused tab window
	driver.switchTo().window(oldTab);
	
//	driver.navigate().to(prop.getProperty("url"));
	softAssertion.assertAll();
	
}




}
