package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.RetailUserdetails;

public class RetailAccount__exp2 extends TestBase {
	
	
	public RetailAccount__exp2() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//a[contains(text(),'Log out')])")
	WebElement LoggedUser;
			
	@FindBy(xpath = "//div[contains(text(),'Comments')]")
	WebElement comments;
	
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
	
	//@FindBy(xpath="(//span[contains(text(),'Date of Birth')]/../following-sibling::div/input)[2]")
	//WebElement dateofBirth;
	@FindBy(xpath="(//a[contains(text(),'Not Set')])[1]")
	WebElement selectGender;
	
	
	
	
	@FindBy(xpath="//div[contains (@class, 'datetime')]//input[contains (@class, 'input')]")
	WebElement dateofBirth;
	
	
	
	//@FindBy(xpath="//span[contains(text(),'Client Provided Phone')]/../following-sibling::input")
	//WebElement phone;
	
	@FindBy(xpath="//div[contains (@class, 'Phone')]//input[contains (@class, 'input')]")
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
	
	@FindBy(xpath = "//ul[@role='presentation']//li//a[@title='Female']")
	WebElement gender;
	
	
	@FindBy(xpath = "//input[@placeholder= 'Search Salesforce']")
	WebElement searchInput;
	
	
	@FindBy(xpath = "//div[contains (text() , 'give up yet')]")
	WebElement msgDontGiveUpYet;
	
		
	//@FindBy(xpath = "//h1[@id='primaryField']/span")
	//WebElement username;
	
	@FindBy(xpath = "//*[@id='primaryField']")
	WebElement username;
	
	//@FindBy(xpath="(//button[@title='Edit Plan Sponsor Name']//preceding-sibling::span)[2]")
	//WebElement retailText;
	
	//@FindBy(xpath="//span [text () = 'Plan Sponsor Name']/parent::div/following-sibling::div/child::span/span")
	//WebElement retailText;
		
	@FindBy(xpath="//span [text () = 'Plan Sponsor Name']/parent::div/following-sibling::div/child::span")
	WebElement retailText;
	
	@FindBy(xpath="//span [text () = 'User Number']/parent::div/following-sibling::div/child::span/span")
	WebElement userId;
	
	@FindBy(xpath="//span[contains (@class, 'test-id')][contains(text(),'User Number')]")
	WebElement userNumberTitle;
	
	
	@FindBy(xpath="//ul[@role='presentation']//li//a[@title='Branch Retail']")
	WebElement retailType2;
	
	@FindBy(xpath="//ul[@role='presentation']//li//a[@title='Retail']")
	WebElement retailType1;
	
	
	@FindBy(xpath="//a[contains (@class, ('tabHeader'))]//span[contains (text(), ('Household'))]")
	WebElement householdTab;
	
	
	@FindBy(xpath="//a[contains (@class, ('tabHeader'))][contains (@data-tab-name, ('customTab8'))]")
	WebElement communicationTab;
	
	
	@FindBy(xpath="(//div[contains(@class,'col main-col slds-size--6-of-12')]//li)[2]")
	WebElement householdTablink;
	
	@FindBy(xpath="//button[contains(text(),'Add Co-Client')]")
	WebElement addCoclient;
	
	
	@FindBy(xpath="//span[contains(text(),'Add Household Member')]")
	WebElement householdMember;
	
	
	@FindBy(xpath="//div[contains(@class, 'modal-body')]//span[@class='slds-checkbox_faux']")
	WebElement createNewAccount;
	
	
	
	@FindBy(xpath="//div[contains(@class, 'modal-body')]//button[contains(@class, 'slds-button')]")
	WebElement nextButton;
	
	
	@FindBy(xpath="//button[contains(text(),'Previous')]/following-sibling::button[contains(text(),'Next')]")
	WebElement nextButton1;
	
	
	@FindBy(xpath="//div[contains(@class, 'modal-body')]//input[contains(@name,'Partner_Spouse_First_Name')]")
	WebElement spouseFirstName;
	
	
	@FindBy(xpath="//div[contains(@class, 'modal-body')]//input[contains(@name,'Partner_Spouse_Last_Name')]")
	WebElement spouseLastName;
	
	
	@FindBy(xpath="//div[contains(@class, 'modal-body')]//div[contains(@class,'slds-form-element')]//input[@name ='DOB']")
	WebElement spouseDOB;
	

	@FindBy(xpath="//div[contains(text(),'Female')]")
	WebElement genderSelection;
	
	
	@FindBy(xpath="(//a[contains(text(),'Not Set')])[1]")
	WebElement genderdropdown;
	
	
	@FindBy(xpath="//label[contains(@class, 'slds-radio__label')]//div[contains(text(), 'Spouse')]")
	WebElement relationshipSelection;
		
	@FindBy(xpath="//button[contains(@type,'button')][contains(text(),'Close All')]")
	WebElement closeAll;
	
	@FindBy(xpath="//a[contains(text(),'Co-Client')]")
	WebElement coClientButton;
	
	@FindBy(xpath="//input[contains (@title, 'Search People')]")
	WebElement assignedPlanner;
	
	@FindBy(xpath="(//a[contains (@role, 'option')])[1]")
	WebElement assignedPlannerOption;
	
	@FindBy(xpath="(//a[contains(@class,'forceOutputLookup')])[1]")
	WebElement plannerAdvisor;
	
	@FindBy(xpath="//div[contains (@class, 'slds-lookup__result-meta')]")
	WebElement assignedPlannerdropdown;
	
	@FindBy(xpath="//input[contains (@placeholder, 'Search People...')]")
	WebElement searchpeopleDropDown;
	
	@FindBy(xpath="//span[contains(@title, 'My Open Opportunities')]")
	WebElement myOpenOptty;
	
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	/*
	DetailsPage detailspage = new DetailsPage();
	String uid = DetailsPage.uniqueid;
	
	String fname = "Testf"+ uid;
	String lname = "Testl"+ uid;
	
	public String spousefname = "spouseTestf"+ uid;
	public String spouselname = "spouseTestl"+ uid;
	String aname = fname+" "+lname;
	*/
	
	
	String uid;
	String aname;
	String fname; 
	String lname;
	String spousefname;
	String spouselname;
	
	String LoggedinUser;
	String AccountId;
	String Accountfor;
	

	
//	Properties prop = new Properties();
	
	OutputStream output = null;
	SalesforceRestAPI_exp2 restapi = new SalesforceRestAPI_exp2();

	
	public void createRetailuser(int i) throws Exception {
		
		if (i==2){LoggedinUser = LoggedUser.getText().substring(11);}
		
		try {output = new FileOutputStream(prop.getProperty("QAconfig_path"));} 
		catch (FileNotFoundException e) {e.printStackTrace();}
		
		Thread.sleep(10000);
		globalButton.click(); 
		
		TestUtil.waitForElement("Create Retail Account", createRetail);
		createRetail.click();
		//AccountName.sendKeys(aname);
		
		/*
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		*/
		
		
		//firstName.sendKeys(RetailUserdetails.getPrimaryFirstName());
		//lastName.sendKeys(RetailUserdetails.getPrimaryLastName());
		
		firstName.sendKeys(SalesforceRestAPI_exp2.fname);
		lastName.sendKeys(SalesforceRestAPI_exp2.lname);
		
		
		
		genderdropdown.click();
		gender.click();
	
		
		phone.sendKeys("5554564564");
		email.sendKeys("test123@test123.com");
		dateofBirth.sendKeys("10/16/1948");
		street.sendKeys("1050 Enterprise way");
		city.sendKeys("Sunnyvale");
		zip.sendKeys("94089");
		state.sendKeys("CA");
		country.sendKeys("USA");
	
		
		if (i==2)      {assignedPlanner.sendKeys(LoggedinUser);assignedPlannerdropdown.click();}
		else if (i==1) {searchpeopleDropDown.click();assignedPlannerOption.click();}
		
	 	//If you logged in as Advisor, Type will be automatically selected for you
	  	if (i == 1) {driver.findElement(By.xpath("//a[@class='select'][contains(text(),'Retail')]")).click();retailType1.click();}
	 
	 	
	  	saveButton.click();
		prop.put("retailuser", "password");
		Thread.sleep(10000);
		System.out.println(aname);
		//System.out.println(RetailUserdetails.getaccountName("primary"));
		
		
		prop.setProperty("retailuser", aname);
		//prop.setProperty("retailuser", RetailUserdetails.getaccountName("primary"));
		Thread.sleep(3000);
		
		try {
			prop.store(output, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void validRetailuser() throws InterruptedException {
		
		//String username1 = prop.getProperty("retailuser");

		Thread.sleep(3000);
		searchInput.sendKeys(aname);
		//searchInput.sendKeys(RetailUserdetails.getaccountName("primary"));
		
		Thread.sleep(5000);
		//searchInput.sendKeys(Keys.ENTER);
		searchInput.sendKeys(Keys.RETURN);
		
		Thread.sleep(10000);
		
		//if (msgDontGiveUpYet.getText() == "Don't give up yet!")	{ driver.navigate().refresh(); Thread.sleep(3000);}
		
		if (driver.findElements(By.xpath("//div[contains (text() , 'give up yet')]")).size() != 0)
		{ driver.navigate().refresh(); Thread.sleep(3000);}
		
		
		driver.findElement(By.xpath("(//a[contains(text(),'"+aname+"')])[1]")).click();
		//driver.findElement(By.xpath("(//a[contains(text(),'"+RetailUserdetails.getaccountName("primary")+"')])[1]")).click();
		//driver.findElement(By.xpath("(//a[contains(text(),'"+RetailUserdetails.getaccountName("primary")+"')])[1]")).click();
		
		Thread.sleep(10000);
		String AccountName = username.getText();
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		String textInsideUserNumber = userId.getText();
		
		// Check whether input field is blank
		if(textInsideUserNumber.isEmpty()){System.out.println("User Number is empty");}
					
		System.out.println(textInsideUserNumber);
		
		System.out.println(prop.getProperty("retailuser"));
		//System.out.println(RetailUserdetails.getaccountName("primary"));
		
		softAssertion.assertEquals(AccountName, prop.getProperty("retailuser"), "Account Name mismatch in open task");
		softAssertion.assertEquals(retailText.getText(), "");
	
	}
	
	public void addSpouse(String SpouseFirstName, String SpouseLastName) throws InterruptedException {
	
		Thread.sleep(10000);
		householdTab.click();
		
		Thread.sleep(3000);
		addCoclient.click();
		
		Thread.sleep(3000);
		createNewAccount.click();
		
		nextButton.click();
		
		Thread.sleep(3000);
		spouseFirstName.sendKeys(SpouseFirstName);
		spouseLastName.sendKeys(SpouseLastName);
		spouseDOB.sendKeys("10/16/1958");
		genderSelection.click();
		relationshipSelection.click();
		nextButton1.click();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
	
		Thread.sleep(10000);
		householdTab.click();
		
		/*
		if(!coClientButton.isDisplayed()){
		   System.out.println("Co-Client Exists");
		}
		*/
		Thread.sleep(2000);
		
		if(!coClientButton.isEnabled()){
			   System.out.println("Co-Client Exists");
			}
		
		coClientButton.click();
		
		Thread.sleep(3000);
		String spouseUrl = driver.getCurrentUrl();
		String []url = spouseUrl.split("/");
		String spousesfdcId = url[6];
		
		prop.setProperty("spousesfdcId", spousesfdcId);
		SalesforceRestAPI_exp2.objMap.put("spousesfdcId", spousesfdcId);
		
		//prop.setProperty("sfdcId", spousesfdcId);
		SalesforceRestAPI_exp2.objMap.put("sfdcId", spousesfdcId);
		
	}
	
	
	public void searchAccount() throws InterruptedException{
	
		String aname = prop.getProperty("retailuser");
		
		/*
		driver.findElement(By.xpath("//button[contains (@title, ('Show Navigation Menu'))]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains (@class,('menuLabel slds-listbox'))][contains(text(),'Accounts')]")).click();
		//driver.findElement(By.xpath("//a[contains (@title, ('" +aname+ "'))]")).click();
		
		*/
		
		changeNavigationMenu("Accounts");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[contains (@title, ('" +RetailUserdetails.getaccountName("primary")+ "'))][contains (@class, ('slds-truncate'))])[1]")).click();
		driver.findElement(By.xpath("(//a[contains (@title, ('" +aname+ "'))][contains (@class, ('slds-truncate'))])[1]")).click();
		
		
		
		Thread.sleep(2000);
		String AccountName = username.getText();
		String textInsideUserNumber = userId.getText();
		
		// Check whether input field is blank
		if(textInsideUserNumber.isEmpty()){System.out.println("User Number is empty");}
					
		System.out.println(textInsideUserNumber);
		System.out.println(prop.getProperty("retailuser"));
		softAssertion.assertEquals(AccountName, prop.getProperty("retailuser"), "Account Name mismatch in open task");
		softAssertion.assertEquals(retailText.getText(), "");
		
		Thread.sleep(2000);
		
		//changeNavigationMenu("Home");
		
		/*
		
		driver.findElement(By.xpath("//button[contains (@title, ('Show Navigation Menu'))]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains (@class,('menuLabel slds-listbox'))][contains(text(),'Home')]")).click();
		*/
	}
	
	public static void changeNavigationMenu(String Menu) throws InterruptedException{
		
		driver.findElement(By.xpath("//button[contains (@title, ('Show Navigation Menu'))]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains (@class,('menuLabel slds-listbox'))][contains(text(),'" +Menu+ "')]")).click();
	}
	
	
	public void clickAccountviaAccountScreen() throws InterruptedException{ 
		
		Thread.sleep(2000);
		changeNavigationMenu("Accounts");
		Thread.sleep(2000);
		TestUtil.closeAllOpenTabs(driver);
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("(//a[contains (@title, ('" +RetailUserdetails.getaccountName("primary")+ "'))][contains (@class, ('slds-truncate'))])[1]")).click();
		driver.findElement(By.xpath("(//a[contains (@title, ('" +aname+ "'))][contains (@class, ('slds-truncate'))])[1]")).click();
		
		Thread.sleep(2000);
		
	}
	
	
	
	public static String getAccountId() throws InterruptedException{
		
		String accountUrl = driver.getCurrentUrl();
		String []url = accountUrl.split("/");
		String accountId = url[6];
		
		//prop.setProperty("sfdcId", accountId);
		//SalesforceRestAPI.objMap.put("sfdcId", accountId);
		
		return accountId;
	}
	


	
	public void set_uid(String userid) {this.uid = userid;}
	public void set_fname(String firstname) {this.fname = firstname;}
	public void set_lname(String lastname) {this.lname = lastname;}
	public void set_aname(String accname) {this.aname = accname;}
	public void set_spousefname(String spfirstname) {this.spousefname = spfirstname;}
	public void set_spouselname(String splastname) {this.spouselname = splastname;}
	

	

	
	
	
	
	
	
	
}
