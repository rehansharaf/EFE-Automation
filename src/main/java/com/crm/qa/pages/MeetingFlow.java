package com.crm.qa.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.crm.qa.util.TestUtil;

import com.crm.qa.base.TestBase;

public class MeetingFlow extends TestBase {
	
	DetailsPage details = new DetailsPage();
	
	
	public MeetingFlow()  {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//div[contains(text(),'Comments')]/../../../following-sibling::div/div/textarea")
	WebElement commentsTextarea;
	
	@FindBy(xpath = "(//span[contains(text(),'Next')])[6]")
	WebElement nextButton;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]/..//following-sibling::button")
	WebElement nextButton1;
	
	@FindBy(xpath = "//div[contains(text(),'Management')]")
	WebElement solutionsDiscussed;
	
	@FindBy(xpath = "//div[contains(text(),'Outcome')]/../../../following-sibling::div/select")
	WebElement outcome;
	
	@FindBy(xpath = "//div[contains(text(),'Schedule a Phone Call')]")
	WebElement scheduleType;
	
	@FindBy(xpath = "//div[contains(text(),'Schedule Appointment')]")
	WebElement scheduleApp;
	
	@FindBy(xpath = "//div[contains(text(),'Schedule a To-Do')]")
	WebElement toDo;
	
	@FindBy(xpath = "//div[contains(text(),'Create A New Meeting')]")
	WebElement activityType;
	
	@FindBy(xpath = "//div[contains(text(),'Select Existing Meeting')]")
	WebElement existingActivityType;
	
	@FindBy(xpath = "//div[contains(text(),'Open Meetings')]/../../following-sibling::div/select")
	WebElement existingMeeting;
	
		
	@FindBy(xpath = "//div[contains(text(),'How Did You Meet With Client')]/../../../following-sibling::div/select")
	WebElement meetClient;
	
	@FindBy(xpath = "//*[contains (text(), ('How Did You Meet With Client'))]/../../../../div/select")
	WebElement meetClient2;
	
	
	@FindBy(xpath = "//div[contains(text(),'Select Meeting Outcome')]/../../../following-sibling::div/select")
	WebElement meetingOutcome;
	
	@FindBy(xpath = "//*[contains (text(), ('Select Meeting Outcome'))]/../../../../div/select")
	WebElement meetingOutcome2;
	
	@FindBy(xpath = "//div[contains(text(),'Enter a Date for Phone Call')]/../../following-sibling::div/div/input")
	WebElement enterDate1;
	
	@FindBy(xpath = "//div[contains(text(),'Due Date')]/../../following-sibling::div/div/input")
	WebElement enterDate2;
	
	@FindBy(xpath = "//div[contains(text(),'Financial Plan')]")
	WebElement financialPlan;
	
	@FindBy(xpath = "//div[contains(text(),'Financial Checkup Topics')]")
	WebElement financialCheckupTopics;

	@FindBy(xpath = "//span[contains(text(),'Log Activity')]/../../../../following-sibling::div//select")
	WebElement CheckupTopics;
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	
	
	String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm a").format(new Date());
	//String commentsToEnter = "TestingPurpose " + timeStamp;
	
//	String timeStamp1 = new SimpleDateFormat("MMM dd, YYYY").format(new Date());
	String timeStamp1 = "SEP 25, 2018";

	
	
	public void meetingWorkflow(String ActivityType, String Meetclient, String Meetingoutcome) throws InterruptedException {
		
		Thread.sleep(5000);
		
		
		
		String type1 = "New";
		String type2 = "Existing";
		
		String schedule1 = "Phone Call";
		String schedule2 = "ToDo";
		String schedule3 = "Appointment";
		
		String type21 = "On-Phone";
		String type22 = "In-Person";
		String type23 = "On-Site Event";
		String type24 = "Virtual";
		String type31 = "Rescheduled";
		String type32 = "No-Show";
		String type33 = "Cancelled";
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm a").format(new Date());
		String commentsToEnter = "Regression Testing" + ActivityType + timeStamp;
		
		System.out.println(commentsToEnter);
		
		commentsTextarea.sendKeys(commentsToEnter);
		solutionsDiscussed.click();
		Select outcome1 = new Select(outcome);
		outcome1.selectByIndex(2);
		
		
//		if (ScheduleType.equals(schedule3)) {
//			scheduleApp.click();
//		} else if (ScheduleType.equals(schedule2)) {
//			toDo.click();			
//		} else if (ScheduleType.equals(schedule1)) {
//			scheduleType.click();
//		}
//		
		Thread.sleep(5000);
			
		nextButton.click();
		
		Thread.sleep(5000);
		
		if (ActivityType.equals(type1)) {
			activityType.click();
			}else if (ActivityType.equals(type2)) {
				existingActivityType.click();
				nextButton1.click();
				Select existingmeeting = new Select(existingMeeting);
				existingmeeting.selectByIndex(0);
						
			}
		
		nextButton1.click();
		
		Thread.sleep(5000);
		
		if (Meetclient.equals(type21)) {
			
			Select meetClient1 = new Select(meetClient);
			meetClient1.selectByIndex(2);
		} else if (Meetclient.equals(type22)) {
			Select meetClient1 = new Select(meetClient);
			meetClient1.selectByIndex(1);
		} else if (Meetclient.equals(type23)) {
			Select meetClient1 = new Select(meetClient);
			meetClient1.selectByIndex(3);
		} else if (Meetclient.equals(type24)) {
			Select meetClient1 = new Select(meetClient);
			meetClient1.selectByIndex(4);
		} 
		
		if (Meetingoutcome.equals(type31)) {
			Select meetingOutcome1 = new Select(meetingOutcome);
			meetingOutcome1.selectByIndex(4);
			} else if (Meetingoutcome.equals(type32)) {
				Select meetingOutcome1 = new Select(meetingOutcome);
				meetingOutcome1.selectByIndex(3);
				} else if (Meetingoutcome.equals(type33)) {
					Select meetingOutcome1 = new Select(meetingOutcome);
					meetingOutcome1.selectByIndex(2);
				} else {
					Select meetingOutcome1 = new Select(meetingOutcome);
					meetingOutcome1.selectByIndex(1);
					completeworkflow();
				}
		
		
		nextButton1.click();
					
		
//		if (ScheduleType.equals(schedule1)) {
//			
//			Thread.sleep(5000);		
//			enterDate1.sendKeys(timeStamp1);			
//			nextButton1.click();
//					
//		} else if (ScheduleType.equals(schedule2)) {
//			
//			Thread.sleep(5000);		
//			enterDate2.sendKeys(timeStamp1);			
//			nextButton1.click();
//			
//		} else {
//				Thread.sleep(5000);	
//				nextButton1.click();
//		}
				
		Thread.sleep(5000);
		
//		financialPlan.click();
//		nextButton1.click();
//		
//		Thread.sleep(5000);
		
		Assert.assertEquals(true, commentsTextarea.isDisplayed());
		
		
		
	}
	
	public void completeworkflow() {
		
		nextButton1.click();
		financialPlan.click();
	
	
	}
	
	@SuppressWarnings("static-access")
	public void meetingCompletedFlow() throws InterruptedException {
		
		String commentsToEnter = "TestingPurpose " + details.uid;
		
		commentsTextarea.sendKeys("CompleteWF " + commentsToEnter);
		
		TestUtil.SelectDropDownOption(outcome, "Meeting");
		
		solutionsDiscussed.click();
		
		details.logCallNextButton.click();
		
		nextButton1.click();
		
		TestUtil.SelectDropDownOption(meetClient2, "In-Person Meeting");
		TestUtil.SelectDropDownOption(meetingOutcome2, "Completed");
		
		nextButton1.click();
		
		selectFinacialTopicscheckbox();
		
		nextButton1.click();
		
		selectTopics();
		
		nextButton1.click();	
		
		
	}
	
	@SuppressWarnings("static-access")
	public void meetingCompleteFlowWithOptions() throws InterruptedException {
	
		String commentsToEnter = "TestingPurpose " + details.uid;
		
		commentsTextarea.sendKeys("CompleteWFwithOptions " + commentsToEnter);
		
		TestUtil.SelectDropDownOption(outcome, "Meeting");
		
		solutionsDiscussed.click();
		
		details.logCallNextButton.click();
		
		nextButton1.click();
			
		TestUtil.SelectDropDownOption(meetClient2, "In-Person Meeting");
		TestUtil.SelectDropDownOption(meetingOutcome2, "Completed");
		
		nextButton1.click();
	
		selectFinacialTopicscheckbox();
		
		nextButton1.click();
		
		selectTopics();
		
		nextButton1.click();

	}

public void selectTopics() {
	
		//List<WebElement> selectTopics  = driver.findElements(By.xpath("//span[contains(text(),'Log Activity')]/../../../../following-sibling::div//select"));
		List<WebElement> selectTopics  = driver.findElements(By.xpath("//option[@value='Green']/../../select"));
		
		for(WebElement elem : selectTopics) { TestUtil.SelectDropDownOption(elem, "Green");	}
	
	}

public void selectFinacialTopicscheckbox() {
	
	List<WebElement> selectFinTopicsChkbx  = driver.findElements(By.xpath("//span[contains (@class, ('checkbox--faux'))]"));

	for(WebElement elem : selectFinTopicsChkbx) { elem.click();	}

}

public void verifymeetingInformation() {
	
	DetailsPage detailspage = new DetailsPage();
	//detailspage.verifyMeeting();
		
	}


}
