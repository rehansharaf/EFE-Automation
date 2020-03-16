package com.qa.EventListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.crm.qa.base.TestBase;
import com.qa.ExtentReport.ExtentManager;


public class TestListener extends TestBase implements ITestListener {

	 //Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
 
    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Automation Script Execution Started!");
    }
 
    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Automation Script Execution Completed!"));
        extent.flush();
    }
 
    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }
 
    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
        
        
        
    }
 
    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
  
      //Get driver from BaseTest and assign to local webDriver variable.
        Object testClass = result.getInstance();
        WebDriver webDriver = ((TestBase) testClass).getDriver();
 
     /*   
        
        
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).
            getScreenshotAs(OutputType.BASE64);
 
        //ExtentReports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
	            ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
        
 */
        	try {
				
        
        		takescreen(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
        
    }
 
    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }


    public void takescreen(ITestResult result) throws IOException {
  	  if (!result.isSuccess()) {
  	  File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  	 String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new java.util.GregorianCalendar().getTime())
  	                 + ".png";
  	         File failureImageFile = new File(System.getProperty("user.dir")+"\\screenshots\\"+failureImageFileName);
  	  FileUtils.copyFile(imageFile, failureImageFile);
  	     }
  	  
    
    
    }



}
