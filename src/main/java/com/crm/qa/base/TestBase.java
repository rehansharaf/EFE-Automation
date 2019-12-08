package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public  static WebDriverWait wait ;

	
	public TestBase(){
		try {
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/QAconfig.properties");
			
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static SoftAssert softAssertion = new SoftAssert();
			
	//   Map<String, String> sfdcData = new HashMap<String, String>();
	public static HashMap<String, String> sfdcData = new HashMap<String, String>();
		
	 public WebDriver getDriver() {
	        return driver;
	    }
	
	
	public static String[] addDaysToCurrentTime(int days){
		String timestamp1, timestamp2, timestamp3, timestamp4, timestamp5, timestamp6, timestamp7;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE,days);
		Date date = calendar.getTime();
		Calendar calendar1 = Calendar.getInstance();
		Date date1 = calendar1.getTime();
		Format formatter = new SimpleDateFormat("MMM dd, yyyy");
		timestamp1 = formatter.format(date);
		Format formatter1 = new SimpleDateFormat("MM/dd/yyyy");
		timestamp2 = formatter1.format(date);
		Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		timestamp3 = formatter2.format(date);
		Format formatter3 = new SimpleDateFormat("MM/dd/yyyy h:mm a");
		timestamp4 = formatter3.format(date);
		Format formatter4 = new SimpleDateFormat("Mdhmm");
		prop.setProperty("Call Start Time", timestamp4);
		timestamp5 = formatter4.format(date);
		Format formatter5 = new SimpleDateFormat("Mdhmm");
		timestamp6 = formatter5.format(date);
		Format formatter6 = new SimpleDateFormat("MM/dd/yyyy");
		timestamp7 = formatter1.format(date1);
		return new String[] {timestamp1, timestamp2, timestamp3, timestamp4, timestamp5, timestamp6, timestamp7};
	}
	
	
	public static void initialization(){
			String browserName = prop.getProperty("browser");
			final String ExcelFilePath = prop.getProperty("ExcelFilePath");
				
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			
			sfdcData.put("sfdcUsername", username);
			System.out.println(sfdcData.get("sfdcUsername"));
			sfdcData.put("sfdcUserpassword", password);
	
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver_path"));
			
			DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
			
			Map<String, Object> prefs = new HashMap<String, Object>();
	    	prefs.put("profile.default_content_setting_values.notifications", 2);
			
	    
	    
	    	ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("–disable-web-security");
			options.addArguments("–allow-running-insecure-content");
			options.addArguments("--disable-extensions");
			options.addArguments("disable-gpu");
			options.addArguments("incognito");
			options.setExperimentalOption("prefs", prefs);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
		    //options.merge(capabilities);
			
			driver= new ChromeDriver(capabilities);
			//driver= new ChromeDriver();
			
			driver.manage().window().maximize();
			
	
			Properties log4jProp = new Properties();
			log4jProp.setProperty("log4j.rootLogger", "WARN");
			PropertyConfigurator.configure(log4jProp);
			
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox_path"));	
			driver = new FirefoxDriver(); 
		
		}
	
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
	
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	private static void sfdcdata() {
		// TODO Auto-generated method stub
		
	}
	
	
	public static String generateRndmNum(String range) {
	    
		 int intrange = Integer.parseInt(range);
		 Random rand = new Random(System.currentTimeMillis());
		 int num = rand.nextInt(intrange);
		 String snum = Integer.toString(num); 
		 
		  return snum;
		
		}
	
	
	
	

}
