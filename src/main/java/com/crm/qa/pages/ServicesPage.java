package com.crm.qa.pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.*;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.util.TestUtil;





public class ServicesPage extends TestBase{

		
	@FindBy(xpath="//span[@title='Branch-Account Relationships']")
	WebElement branchAccountRelationshipLink;
	
	@FindBy(xpath="(//span[contains(text(),'Services')])[last()]")
	WebElement servicesLink;
	
	//@FindBy(xpath="(//a[@data-refid='recordId'][text()='Branch Management'])[1]")
	//WebElement servicesBranchMngmntLink;
	
	@FindBy(xpath="(//a[@data-refid='recordId'][text()='Branch Management'])[last()]")
	WebElement BranchMngmntLink;
	
	@FindBy(xpath="//a[@title = 'Branch Management']")
	WebElement servicesBranchMgmntLink;
	
	@FindBy(xpath="(//span[(text()='Status')])[last()]/../..//span[contains(@class,('test-id__field-value'))]//span")
	WebElement servicesStatus;
	
	@FindBy(xpath="//span[contains(text(),'Asset Record Type')]/../..//div[contains(@class,('recordTypeName'))]//span")
	WebElement servicesAssetRecordType;
	
	
	
	
	
	
	
	
	SoftAssert softAssertion = new SoftAssert();
	Actions action = new Actions(driver);
	
	DetailsPage detailsPage = new DetailsPage();
	RetailAccount retailAccount = new RetailAccount();
	Opportunities opp = new Opportunities();
	HomePage homePage = new HomePage();
	
	
	public ServicesPage() {
		 
		PageFactory.initElements(driver, this);
		
	}
	
	


//************************************Validate Services**************************************************************************		
			
		public void validateServicePage(String status, String assetRcrdType) throws Exception {
			
			
			TestUtil.scrollintoView(branchAccountRelationshipLink);
			
			TestUtil.clickElement(servicesLink);Thread.sleep(2000);
			TestUtil.clickElement(BranchMngmntLink);
			TestUtil.clickElement(servicesBranchMgmntLink);Thread.sleep(2000);
			
			softAssertion.assertEquals(servicesStatus.getText(), status, "Services Status doesnot match");
			softAssertion.assertEquals(servicesAssetRecordType.getText(), assetRcrdType, "Asset Record Type doesnot match");
			
			
			
			
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
