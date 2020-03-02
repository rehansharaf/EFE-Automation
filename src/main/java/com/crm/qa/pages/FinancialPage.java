package com.crm.qa.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;


public class FinancialPage extends TestBase {
	
	@FindBy(xpath="//a[text()='Financials']")
	WebElement financialsTab;
	
	@FindBy(xpath="//a[text()='Workplace Details']")
	WebElement workplaceDetailsTab;
	
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	DetailsPage detailsPage = new DetailsPage();
	
	
	
	public FinancialPage() {
		 
		PageFactory.initElements(driver, this);
		
	}
	

	public void clickFinancialTab() {jse2.executeScript("arguments[0].click()", financialsTab);}
	public void clickWorkplaceDetailsTab(){jse2.executeScript("arguments[0].click()", workplaceDetailsTab);}

	public void validateWorkplaceDetailsScreen() throws InterruptedException{
		
		Thread.sleep(3000);
		clickFinancialTab();Thread.sleep(2000);
		clickWorkplaceDetailsTab();
		
		List<WebElement> dynamicElement = driver.findElements(By.xpath("(//b[contains(text(),'Retirement Snapshot')])[1]"));
		if(dynamicElement.size() != 0){Assert.fail();} 
			
	}
		
	




















}