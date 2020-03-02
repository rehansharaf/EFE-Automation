package com.crm.qa.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.pages.RetailAccount;
import com.crm.qa.util.*;


import com.crm.qa.base.TestBase;


public class HomePage extends TestBase {

	
	
	
	public static String AccountURL;
	public static String SpouseAccountURL;
	

	@FindBy(xpath = "//div[contains(text(),'User Detail')]")
	static
	WebElement advisorLink;

	@FindBy(xpath = "//span[contains(text(),'Details')]")
	static
	WebElement advisorDetails;
	
	
	@FindBy(xpath = "//input[@placeholder= 'Search Salesforce']")
	WebElement searchInput;
	
	@FindBy(xpath = "(//span[contains(text(),'Account Name')]/ancestor::thead/following-sibling::tbody/tr//th//a)[1]")
	WebElement selectUser;
	

	@FindBy(xpath = "//*[@id='topButtonRow']/input[4]")
	static
	WebElement advisorLogin;
	
	@FindBy(xpath = "//span[@class='title'][contains(text(),'Details')]")
	WebElement detailonDetailPage;
	

	@FindBy(xpath = "(//span[contains(text(),'Home')])[1]")
	WebElement homeLink;
	
	//static
	//@FindBy(xpath="//table[contains (@class,('detailList'))]//td[contains (@class, ('dataCol'))]//a[contains (@href,('/one/one'))]")
	//WebElement usrProfile;

	static
	@FindBy(xpath="//span[(text()= 'Profile')]/../..//a[contains(@href,'/lightning/r/')]")
	WebElement usrProfile;
	
	
	//@FindBy(xpath="//iframe[contains (@name,('vfFrameId'))]")
	//WebElement iframe;
	
	
	
	public static String userProfile;
	SalesforceRestAPI restapi = new SalesforceRestAPI();
	
	
	// Initializing the Page Objects:
	public HomePage() {	PageFactory.initElements(driver, this);	}
	
	public String verifyHomePageTitle(){return driver.getTitle();}
		

	
	public static void navigateToUser(String role) throws InterruptedException{
	
	
		if (role.equalsIgnoreCase("advisor")){
	
			String advisorId = prop.getProperty("advisorsfdcId1");
				
			driver.navigate().to(prop.getProperty("SFDC_TestEnv")+"/lightning/r/User/"+advisorId+"/view");
			userProfile  = RetailAccount.userProfile = usrProfile.getText();
			advisorLink.click();Thread.sleep(5000);
			
			
			WebElement iframe = driver.findElement(By.xpath("//iframe[contains (@name,('vfFrameId'))]"));Thread.sleep(2000);
			driver.switchTo().frame(iframe);
			
			advisorLogin.click();Thread.sleep(3000);
			
			driver.switchTo().defaultContent();Thread.sleep(5000);
			
			driver.navigate().refresh();Thread.sleep(3000);}
	
		else if (role.equalsIgnoreCase("nonadvisor")){String advisorId = prop.getProperty("advisorsfdcId1");}
		
	}

	
	
	public static void navigateToMultipleUser(String role, String advisorId) throws InterruptedException{
	
	
		if (role.equalsIgnoreCase("advisor")){
		
			driver.navigate().to(prop.getProperty("SFDC_TestEnv")+"/lightning/r/User/"+advisorId+"/view");
			
			userProfile  = RetailAccount.userProfile = usrProfile.getText();
			
			Thread.sleep(5000);
			advisorLink.click();
			
			Thread.sleep(5000);
			WebElement iframe = driver.findElement(By.xpath("//iframe[contains (@name,('vfFrameId'))]"));
			driver.switchTo().frame(iframe);
		
			Thread.sleep(5000);
			advisorLogin.click();
			driver.switchTo().defaultContent();
			
			Thread.sleep(5000);
			driver.navigate().refresh();
			
		} else if (role.equalsIgnoreCase("nonadvisor")){}

	
	}

	
	public void navigateToRetailuser(String userType) throws InterruptedException{
		
		String sfdcId = new String();
		
		if (userType.toLowerCase().equals(("primary"))){sfdcId = SalesforceRestAPI.getHashMapData()[0];}
		else if (userType.toLowerCase().equals(("household")))
			{
			sfdcId = SalesforceRestAPI.getHashMapData()[0]; 
			sfdcId = sfdcId.replace(sfdcId.charAt(14), (char)(sfdcId.charAt(14) + 1));
			}
		
		String url = "https://fei--fscfull.lightning.force.com/lightning/r/Account/"+sfdcId+"/view";
		AccountURL = url;
		driver.navigate().to(url);
		Thread.sleep(5000);
	
		/*
		 * String userId = SalesforceRestAPI.getHashMapData()[0];
			String url = "https://fei--fscfull.lightning.force.com/lightning/r/Account/"+userId+"/view";
			System.out.println(url);
		  	
			driver.navigate().to(url);
		 * 
		 */
		
		
		
	}
		
	
	public void navigateToSponsoredClient(String sfdcId) throws InterruptedException{
		
		String url = "https://fei--fscfull.lightning.force.com/lightning/r/Account/"+sfdcId+"/view";
		driver.navigate().to(url);
		Thread.sleep(5000);
	}
	

//This can be commented since it is covered in the above method ---navigateToUser(String role)

	public static void navigateTo_nonAdvisor() throws InterruptedException{
	
	String advisorId = prop.getProperty("advisorsfdcId1");
	
}

	
public void navigateToSpouseuser() throws InterruptedException{
		
		String spouseId = prop.getProperty("spousesfdcId");
		String url = "https://fei--fscfull.lightning.force.com/lightning/r/Account/"+spouseId+"/view";
		System.out.println(url);
      	
		driver.navigate().to(url);
		
	}


public void clickSearchInput() throws InterruptedException{
		
		driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/page/home");

		Thread.sleep(10000);

		searchInput.sendKeys(prop.getProperty("searchuser"));
		Thread.sleep(5000);
		searchInput.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		selectUser.click();
		

	}	
	
public void clickRetailSearchInput() throws InterruptedException{
		
		driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/page/home");
		Thread.sleep(5000);
		searchInput.sendKeys(prop.getProperty("retailuser"));
		Thread.sleep(5000);
		searchInput.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		selectUser.click();
		
	}

public boolean validateCallDate(String taskCreatedDate, String enteredDate) {
	
	
	String[] splitStr1 = taskCreatedDate.split("\\s+");
	String[] splitStr2 = enteredDate.split("\\s+");
	
	boolean timecomp = false;
	//System.out.println(splitStr1.length);
	//System.out.println(splitStr2.length);
	
	if (splitStr1.length == splitStr2.length) {
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm a");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(taskCreatedDate);
			d2 = format.parse(enteredDate);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

		//	System.out.print(diffDays + " days, ");
		//	System.out.print(diffHours + " hours, ");
		//	System.out.print(diffMinutes + " minutes, ");
			
			if (diffMinutes == 0 || diffMinutes == -1) {
				
				//System.out.print(diffMinutes + " minutes, ");
				System.out.print("Difference in Minutes is : " + diffMinutes);
			//	System.out.print("Call Data matched " );
				timecomp= true;
				
			} else {timecomp = false;}
				
			System.out.print(diffSeconds + " seconds.");

	}	catch (Exception e) {e.printStackTrace();}
	
	}	return timecomp;
	
}

public boolean validateDescriptionData(String taskDescription, String description) {
	
	String[] splitStr3 = taskDescription.split("\\s+");
	String[] splitStr4 = description.split("\\s+");
	
	boolean desccomp = true;
//	System.out.println(splitStr3.length);
//	System.out.println(splitStr4.length);
	
	String taskDate = splitStr3[1] + " " + splitStr3[2] + " "+ splitStr3[3];
	String enterDate = splitStr4[1] +  " "+ splitStr4[2] +  " "+splitStr4[3];
	
	Boolean eDate = validateCallDate(taskDate, enterDate);
	
	
	
	if (splitStr3.length == splitStr4.length && eDate && splitStr3[0].equals(splitStr4[0]) && splitStr3[4].equals(splitStr4[4]) && splitStr3[5].equals(splitStr4[5])) {
		
		System.out.print("Description data matched");
		
		return desccomp;
		
	} else {
	
		desccomp = false;
	

	}
	
	return desccomp;
}

public ContactsPage clickOnContactsLink() {
	// TODO Auto-generated method stub
	return null;
}

public void clickOnNewContactLink() {
	// TODO Auto-generated method stub
	
}


public String getAccountURL() {return HomePage.AccountURL;}
public String getSpouseAccountURL() {return HomePage.SpouseAccountURL;}






}
