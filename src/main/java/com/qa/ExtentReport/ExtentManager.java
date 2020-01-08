//**********************************************************************************************************
//Description: ExtentReports related operations are done by this class. I added extra functionality such as
//"getCurrentPlatform". In this way, framework can create a report folder and file based on OS.
//Reference: http://extentreports.com/docs/versions/3/java/
//**********************************************************************************************************

package com.qa.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
 
  static String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	
  private static ExtentReports extent;
  private static Platform platform;
  private static String reportFileName = "Test-Automaton-Report_"+timeStamp+".html" ;
 
  private static String scrshotFileWinPath = System.getProperty("user.dir")+ "\\ScreenShot";
  
  private static String macPath = System.getProperty("user.dir")+ "/TestReport";
  private static String windowsPath = System.getProperty("user.dir")+ "\\TestReport";
  
  private static String macReportFileLoc = macPath + "/" + reportFileName;
  private static String winReportFileLoc = windowsPath + "\\" + reportFileName;

  public static ExtentReports getInstance() {
      if (extent == null)
          createInstance();
      return extent;
  }

  //Create an extent report instance
  public static ExtentReports createInstance() {
      platform = getCurrentPlatform();
      String fileName = getReportFileLocation(platform);
      ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
      htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
      htmlReporter.config().setChartVisibilityOnOpen(true);
      htmlReporter.config().setTheme(Theme.DARK);
      htmlReporter.config().setDocumentTitle(fileName);
      htmlReporter.config().setEncoding("utf-8");
      htmlReporter.config().setReportName(fileName);
      htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);

      return extent;
  }

  //Select the extent report file location based on platform
  private static String getReportFileLocation (Platform platform) {
      String reportFileLocation = null;
      switch (platform) {
          case MAC:
              reportFileLocation = macReportFileLoc;
              createReportPath(macPath);
              System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
              break;
          case WINDOWS:
              reportFileLocation = winReportFileLoc;
              createReportPath(windowsPath);
              System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
              break;
          default:
              System.out.println("ExtentReport path has not been set! There is a problem!\n");
              break;
      }
      return reportFileLocation;
  }


  
  
  
  //Create the report path if it does not exist
  private static void createReportPath (String path) {
      File testDirectory = new File(path);
      if (!testDirectory.exists()) {
          if (testDirectory.mkdir()) {
              System.out.println("Directory: " + path + " is created!" );
          } else {
              System.out.println("Failed to create directory: " + path);
          }
      } else {
          System.out.println("Directory already exists: " + path);
      }
  }

  //Get current platform
  private static Platform getCurrentPlatform () {
      if (platform == null) {
          String operSys = System.getProperty("os.name").toLowerCase();
          if (operSys.contains("win")) {
              platform = Platform.WINDOWS;
          } else if (operSys.contains("nix") || operSys.contains("nux")
                  || operSys.contains("aix")) {
              platform = Platform.LINUX;
          } else if (operSys.contains("mac")) {
              platform = Platform.MAC;
          }
      }
      return platform;
  }

  
  

  
  
  
  
  
}



