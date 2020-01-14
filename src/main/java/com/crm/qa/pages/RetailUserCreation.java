package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class RetailUserCreation extends TestBase {
	

	
	
	
	
@FindBy(xpath="(//a/div/lightning-icon/lightning-primitive-icon)[1]")
WebElement globalButton;

@FindBy(xpath="//span[contains(text(),'Create Retail Account')]")
WebElement createRetail;

@FindBy(xpath="//span[contains(text(),'Account Name')]/../following-sibling::div//input")
WebElement AccountName;

@FindBy(xpath="//span[contains(text(),'First Name')]/../following-sibling::input")
WebElement firstName;

@FindBy(xpath="//span[contains(text(),'Last Name')]/../following-sibling::input")
WebElement lastName;

@FindBy(xpath="(//span[contains(text(),'Date of Birth')]/../following-sibling::div/input)[2]")
WebElement dateofBirth;

@FindBy(xpath="//span[contains(text(),'Client Provided Phone')]/../following-sibling::input")
WebElement phone;

@FindBy(xpath="//span[contains(text(),'Client Provided Email')]/../following-sibling::input")
WebElement email;

@FindBy(xpath="//span[contains(text(),'Street')]/../following-sibling::textarea")
WebElement street;

@FindBy(xpath="//span[contains(text(),'City')]/../following-sibling::input")
WebElement city;

@FindBy(xpath="//span[contains(text(),'State/Province')]/../following-sibling::input")
WebElement state;

@FindBy(xpath="//span[contains(text(),'Zip/Postal Code')]/../following-sibling::input")
WebElement zip;

@FindBy(xpath="//span[contains(text(),'Country')]/../following-sibling::input")
WebElement country;

@FindBy(xpath="//div[@class='bottomBarRight slds-col--bump-left']//button[@type='button']")
WebElement saveButton;

@FindBy(xpath = "//ul[@role='presentation']//li//a[@title='Male']")
WebElement gender;

@FindBy(xpath = "//input[@placeholder= 'Search Salesforce']")
WebElement searchInput;

@FindBy(xpath = "//h1[@id='primaryField']/span")
WebElement username;

@FindBy(xpath="(//button[@title='Edit Plan Sponsor Name']//preceding-sibling::span)[2]")
WebElement retailText;

@FindBy(xpath="//button[@title='Edit User Number']//preceding-sibling::span")
WebElement userId;


@FindBy(xpath="//ul[@role='presentation']//li//a[@title='Branch Retail']")
WebElement retailType2;

@FindBy(xpath="//ul[@role='presentation']//li//a[@title='Retail']")
WebElement retailType1;

@FindBy(xpath="//span[contains(@class,'title')][contains(text(),'Household')]")
WebElement householdTab;

@FindBy(xpath="//button[contains(text(),'Add Co-Client')]")
WebElement addCoclient;

@FindBy(xpath="//div[contains(text(),'Create New Account')]")
WebElement createNewAccount;


@FindBy(xpath="//div[contains(text(),'Create New Account')]/following::div//button[contains(text(),'Next')]")
WebElement nextButton;

@FindBy(xpath="//button[contains(text(),'Previous')]/following-sibling::button[contains(text(),'Next')]")
WebElement nextButton1;

@FindBy(xpath="//div[contains(text(),'Partner/Spouse First Name')]/../../../following-sibling::div/input")
WebElement spouseFirstName;

@FindBy(xpath="//div[contains(text(),'Partner/Spouse Last Name')]/../../../following-sibling::div/input")
WebElement spouseLastName;

@FindBy(xpath="//div[contains(text(),'DOB')]/../../../following-sibling::div/lightning-input")
WebElement spouseDOB;

@FindBy(xpath="//div[contains(text(),'Female')]")
WebElement genderSelection;

@FindBy(xpath="(//div[contains(text(),'Spouse')])[3]")
WebElement relationshipSelection;

	
@FindBy(xpath="//button[contains(@type,'button')][contains(text(),'Close All')]")
WebElement closeAll;

@FindBy(xpath="//a[contains(text(),'Co-Client')]")
WebElement coClientButton;

JavascriptExecutor jse2 = (JavascriptExecutor)driver;

public RetailUserCreation() {
	PageFactory.initElements(driver, this);
}

OutputStream output = null;

	
public void createRetailuser(String fname, String lname, String Email) throws InterruptedException {
		
		
		try {
			output = new FileOutputStream("/Users/rnalam/Downloads/Sampleproject/PageObjectModel/QAconfig.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(10000);
		
		if (globalButton.isDisplayed()) {
		globalButton.click();
		}
		createRetail.click();
		//AccountName.sendKeys(aname);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		
 	 	driver.findElement(By.xpath("(//a[contains(text(),'Not Set')])[1]")).click();
		gender.click();
	
		
		phone.sendKeys("5554564564");
		email.sendKeys("test123@test123.com");
		dateofBirth.sendKeys("10/16/1968");
		street.sendKeys("1050 Enterprise way");
		city.sendKeys("Sunnyvale");
		zip.sendKeys("94089");
		state.sendKeys("CA");
		country.sendKeys("USA");
		
	 	driver.findElement(By.xpath("//a[@class='select'][contains(text(),'Retail')]")).click();
	 	
	 /*	if (i == 1) {
	 *	retailType1.click();
	 *	} else if (i == 2) {
	 *	retailType2.click();
	 *	}
	*/	
		saveButton.click();
		prop.put("retailuser", "password"); 
		//System.out.println(aname);
		
		//prop.setProperty("retailuser", aname);
		try {
			prop.store(output, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public void addSpouse(String SpouseFirstName, String SpouseLastName) throws InterruptedException {
	
	//driver.navigate().to("https://fei--fscfull.lightning.force.com/lightning/page/home");
	Thread.sleep(10000);
	
	
	//Actions act = new Actions(driver);
	//act.sendKeys(Keys.SHIFT).sendKeys("W").build().perform();
	//closeAll.click();
	
	/*
	 * String retailsearchuser1 = prop.getProperty("retailsearchuser");
	 * 
	 * searchInput.sendKeys(prop.getProperty("retailsearchuser"));
	 * searchInput.sendKeys(Keys.ENTER); Thread.sleep(5000);
	 * driver.findElement(By.xpath("(//a[contains(text(),'"+retailsearchuser1+
	 * "')])[1]")).click(); Thread.sleep(5000);
	 */
	WebElement myDynamicElement = (new WebDriverWait(driver, 10))
			  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'title')][contains(text(),'Household')]")));
	Thread.sleep(5000);
	//householdTab.click();
	 jse2.executeScript("arguments[0].click()", householdTab);
	addCoclient.click();
	Thread.sleep(5000);
	createNewAccount.click();
	nextButton.click();
	Thread.sleep(5000);
	spouseFirstName.sendKeys(SpouseFirstName);
	spouseLastName.sendKeys(SpouseLastName);
	spouseDOB.sendKeys("10/16/1958");
	genderSelection.click();
	relationshipSelection.click();
	nextButton1.click();
	
	Thread.sleep(10000);
	
	 jse2.executeScript("arguments[0].click()", householdTab);
	//householdTab.click();
	
	if(!coClientButton.isDisplayed()){
	   System.out.println("Co-Client Exists");
	}
	
	coClientButton.click();
	
	String spouseUrl = driver.getCurrentUrl();
	String []url = spouseUrl.split("/");
	String spousesfdcId = url[6];
	prop.setProperty("spousesfdcId", spousesfdcId);
	SalesforceRestAPI.objMap.put("spousesfdcId", spousesfdcId);
	


}





}
