package com.crm.qa.pages;



import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.*;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.util.TestUtil;


public class FinancialPage extends TestBase {
	
	@FindBy(xpath="//a[text()='Details']")
	WebElement detailsTab;
	
	@FindBy(xpath="//a[text()='Financials']")
	WebElement financialsTab;
	
	@FindBy(xpath="//a[text()='Workplace Details']")
	WebElement workplaceDetailsTab;
	
	@FindBy(xpath="//a[contains(text(),'Branch Accounts')]")
	WebElement branchAccountsTab;
	
	@FindBy(xpath="//a[contains (@class,'outputLookupLink')]")
	WebElement financialAccountsLink;
	
	@FindBy(xpath="//span[contains(text(),'System Information')]")
	WebElement systemInformationSection;
	

	
	
	
	
	
	SoftAssert softAssertion = new SoftAssert();
	
	DetailsPage detailsPage = new DetailsPage();
	RetailAccount retailAccount = new RetailAccount();
	Opportunities opp = new Opportunities();
	HomePage homePage = new HomePage();
	
	int countFinancialAccountDLINK = 0;
	
	
	
	public FinancialPage() {
		 
		PageFactory.initElements(driver, this);
		
	}
	

	public void clickFinancialTab() throws InterruptedException {TestUtil.clickElement(financialsTab);}
	public void clickWorkplaceDetailsTab() throws InterruptedException{TestUtil.clickElement(workplaceDetailsTab);}
	public void clickBranchAccountsTab() throws InterruptedException{TestUtil.clickElement(workplaceDetailsTab);}

	

//************************************Create Financial Account**************************************************************************	
	
	public void createFinancialAccountviaUI() throws Exception {
		
		opp.createBranchOptty_viaAPI();
		detailsPage.logacallInteraction(detailsPage.reached, "GTSconversionNo", "CreateOpttyNO", "FutureActivityNO");
		opp.clickOpportunity();
		opp.enrollinBM();
		opp.addFinancialAccount();
		opp.validateFinancialAccount();
		homePage.navigateToRetailuser("primary");Thread.sleep(5000);
	}

	
	public void createFinancialAccountviaAPI() throws Exception{
		

		SalesforceTestRestAPI.APIConnection();
		SalesforceTestRestAPI.dataCreation4(SalesforceRestAPI.fname, SalesforceRestAPI.lname);
		SalesforceRestAPI.createCTAccount();
		homePage.navigateToRetailuser("Primary");Thread.sleep(3000);
	}
	
	
//************************************Validate Financial Account**************************************************************************		
	
	public void validateFinancialBranchAcct() throws InterruptedException{
		
		clickFinancialTab();
		clickBranchAccountsTab();
		clickBranchAccountsTab();
		
	}

	@SuppressWarnings("static-access")
	public void financialAccountLink() throws Exception{
		
		List<WebElement> elements = driver.findElements(By.xpath("//a[contains (@class,'" +retailAccount.fname+ "')]"));
		
		for (WebElement element:elements){
			if (element.getText().contains("DELINK")){
				countFinancialAccountDLINK = countFinancialAccountDLINK+1;
				element.click();Thread.sleep(2000);
				validateFinancialDlinkAccount("DLINK","Draft","Branch Management","Former Client");
				
			}
		} 
	}


	
	public void validateFinancialDlinkAccount(String financialAcctNameDLINK, String stage, String businessLineDetail, String clientProgression) throws InterruptedException, Exception{
		
		TestUtil.validatePageFieldthatContains("Financial Account Name", financialAcctNameDLINK, "Fincial Account Name doesnot contain DLINK");
		TestUtil.validatePageField("Stage", stage, "Stage Field value mismatch");
		TestUtil.validatePageField("Business Line Details", businessLineDetail, "Business Line Details Field value mismatch");
		
		homePage.navigateToRetailuser("primary");Thread.sleep(3000);
		TestUtil.waitUntilElementVisible(detailsTab);
		TestUtil.validatePageField("Client Progression", clientProgression, "Client Progression Value mismatch");
	
	}

	
	public void validatecheckflags(String checkBox) throws Exception {
		
		TestUtil.scrollintoView(systemInformationSection); Thread.sleep(2000);
		WebElement CheckBox = driver.findElement(By.xpath("(//span[text()='" +checkBox+ "'])[1]/../..//label[contains(@class, (checkbox__label))]//span[@class='slds-checkbox_faux']"));
		softAssertion.assertTrue(CheckBox.isSelected(), checkBox+" checkbox is not selected");
	}
		


	
//************************************Validate WorkplaceDetails Screen**************************************************************************		
		
		
		public void validateWorkplaceDetailsScreen() throws InterruptedException{
			
			clickFinancialTab();
			clickWorkplaceDetailsTab();
			
			List<WebElement> dynamicElement = driver.findElements(By.xpath("(//b[contains(text(),'Retirement Snapshot')])[1]"));
			if(dynamicElement.size() != 0){Assert.fail();} 
				
		}
		








}