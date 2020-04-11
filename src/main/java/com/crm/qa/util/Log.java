package com.crm.qa.util;

import org.apache.log4j.Logger;
import org.testng.TestListenerAdapter;
import com.relevantcodes.extentreports.LogStatus;
import com.qa.ExtentReport.*;
 
 


public class Log extends TestListenerAdapter{
 
	
	
    //Initialize Log4j instance
    private static Logger Log = Logger.getLogger(Log.class.getName());
    
    
 
    //We can use it when starting tests
    public static void startLog (String testClassName){
        Log.info("Test is Starting...");
        
    }
 
    //We can use it when ending tests
    public static void endLog (String testClassName){
        Log.info("Test is Ending...");
    }
 
    //Info Level Logs
    @SuppressWarnings("static-access")
	public static void info (String message) {
        Log.info(message);
        
    }
 
    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }
 
    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }
 
    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }
 
    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }

}
