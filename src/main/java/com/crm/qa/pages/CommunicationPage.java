package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.LogActivityTest;
import com.crm.qa.util.Validation;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.google.common.base.Function;
import com.crm.qa.util.TestUtil;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.base.TestBase;



public class CommunicationPage extends TestBase {

	@FindBy(xpath="//a[contains (@class, ('tabHeader'))][contains (@data-tab-name, ('customTab8'))]")
	WebElement communicationTab;
	
	@FindBy(xpath="//a[contains (@data-label, ('All'))]")
	WebElement allTab;
	
	@FindBy(xpath="//lightning-formatted-text[contains(text(),'Call')]")
	WebElement loggedCall;
	
	
	
	
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	
	public CommunicationPage() {
		 
		PageFactory.initElements(driver, this);
		
		}
	
	
	public void validateCallonCommunication() throws InterruptedException{
	
		Thread.sleep(2000);
		communicationTab.click();
		Thread.sleep(2000);
		allTab.click();
		Thread.sleep(2000);
		if (loggedCall.getText() == "Call"){
			
			System.out.println( "Passed.................");
		}
		
	}
	
	
	
	
	
	
}
