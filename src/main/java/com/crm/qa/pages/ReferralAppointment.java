package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;

public class ReferralAppointment extends TestBase {
	
	
	public ReferralAppointment () {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@value='scheduleAppointment']")
	WebElement scheduleReferralAppointment;
	
	@FindBy(xpath = "(//accordion-heading)[6]")
	WebElement selectChandler;
		
	@FindBy(xpath = "//a[@class='btn btn-pa-le-primary btn-block']")
	WebElement selectButton;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;
	
	
	@FindBy(xpath = "//iframe[@id='timetrade-iframe']")
	WebElement iframeCalendar;
	
	@FindBy(xpath = "//div[contains(text(),'Select Meeting Outcome')]/../../following-sibling::div/select")
	WebElement meetingDate;
	
	@FindBy(xpath = "//*[@id='awidget']/table[@class='MonthAvailability']/tbody/tr[4]/td[3]/div[2]/select")
	WebElement selectTime;
	
	@FindBy(xpath = "(//div[@class='custom dropdown subtle ChoiceSelect']/select)[10]")
	WebElement selectATime1;
	
	@FindBy(xpath = "(//div[@class='custom dropdown subtle ChoiceSelect']/select)[10]/option[5]")
	WebElement selectATime2;
	
	@FindBy(xpath = "(//div[@class='custom dropdown subtle ChoiceSelect']/select)[10]/../preceding-sibling::div/div")
	WebElement numberDate;	
	
	
	@FindBy(xpath = "//*[@id='awidget']//table[@class='MonthAvailability']/tbody/tr[5]/td[3]/div[2]/select")
	WebElement okButton1;
	
	@FindBy(xpath = "//*[@id='awidget']/table[@class='MonthAvailability']/tbody/tr[5]/td[3]/div[2]")
	WebElement okButton2;
	
	@FindBy(xpath = "//a[contains(text(),'OK')]")
	WebElement okButton;
	
	@FindBy(xpath = "//input[@value='Schedule It']")
	WebElement finalButton;
	
	@FindBy(xpath = "//td[@id='datetime']/div[1]/span")
	WebElement confDateElement;
	@FindBy(xpath = "//td[@id='datetime']/div[2]/span")
	WebElement confTimeElement;
	
	
	
	
	SoftAssert softAssertion = new SoftAssert();
		
	String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm a").format(new Date());
	String[] splitStr = timeStamp.split("\\s+");
	
	public String[] scheduleAppointment(String meetingDate) throws InterruptedException, ParseException {

		
	
	String oldTab = driver.getWindowHandle();
	Thread.sleep(5000);
	scheduleReferralAppointment.click();
	Thread.sleep(5000);
	
ArrayList tabs = new ArrayList (driver.getWindowHandles());
	 System.out.println(tabs.size());
	 String newTab = (String) tabs.get(1);
	 driver.switchTo().window(newTab);
	 
	 Thread.sleep(5000);	
	 selectChandler.click();
	 Thread.sleep(2000);	
	 selectButton.click();
	 
	 Thread.sleep(5000);	
	 
	 continueButton.click();
	 Thread.sleep(7000);	
	 String meetingLinks[] = selectDate1(meetingDate);
	
	 driver.close();
	
    driver.switchTo().window(oldTab);
	return meetingLinks;
		
	}
	
	
	public void selectDate() throws InterruptedException {
		
		
		driver.switchTo().frame(iframeCalendar);
		continueButton.click();
		
		 Thread.sleep(10000);	
		
		Select meetingDate1 = new Select(selectTime);
		meetingDate1.selectByIndex(5);
		
		continueButton.click();
		finalButton.click();
		
		
	}
	
public String[] selectDate1(String mtgDate) throws InterruptedException, ParseException {
		
		driver.switchTo().frame(iframeCalendar);
		continueButton.click();
		
		Thread.sleep(5000);	
		
		Select meetingDate2 = new Select(driver.findElement(By.xpath("//td[@id='" + mtgDate + "']/div[2]/select")));
		meetingDate2.selectByIndex(5);
		
		continueButton.click();
		
		String confDate = confDateElement.getText();
		String[] confDate1 = confDate.split(",");
		String confTime = confTimeElement.getText();
		String[] confDate2 = confTime.split(" - ");
		
		String sDate1= confDate1[1].trim() + ","+ confDate1[2];  
		
	    Date date1= new SimpleDateFormat("MMMM dd, yyyy").parse(sDate1);  
	    
	    SimpleDateFormat timestamp = new SimpleDateFormat("MM/dd/yyyy");
		String timeStamp = timestamp.format(date1);
	    System.out.println(timeStamp);
	    
	    SimpleDateFormat timestamp1 = new SimpleDateFormat("M/d/yyyy");
		String timeStamp1 = timestamp1.format(date1);
	    System.out.println(timeStamp1);
	    
	    Date date2= new SimpleDateFormat("hh:mm a").parse(confDate2[0]);

	    SimpleDateFormat timestamp2 = new SimpleDateFormat("hh:mm a");
		String timeStamp2 = timestamp2.format(date2);
	    System.out.println(timeStamp2);
	    
	       
	    
	    String meetingLink1 = timeStamp + " " + timeStamp2;
	    String meetingLink2 = timeStamp1 + " " + confDate2[0];
		
		System.out.println("Needed Text" + meetingLink1 + meetingLink2);
		
		
		finalButton.click();
		
		String[] meetingLinks = {meetingLink1,meetingLink2};
		return meetingLinks;
		
		
	}
	
}
