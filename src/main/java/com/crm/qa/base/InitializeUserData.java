package com.crm.qa.base;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.SalesforceRestAPI;
import com.qa.DataProvider.LogaCallDataProvider;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.testcases.*;


public class InitializeUserData extends TestBase{



	SalesforceRestAPI sfdcAPI = new SalesforceRestAPI();
	DetailsPage detailPage = new DetailsPage();
	RetailAccount retailPage = new RetailAccount();
	LogActivityTest logactivityTest = new LogActivityTest();
	BranchOpportunityTest branchOpttyTest = new BranchOpportunityTest();
	
	String RunningTestCaseonDemand;
	
	
	public void initialize(){
		
		
		Map<String, String> Data = new HashMap<String, String>();
		Data = getDetailPageData();
		
		String uid = Data.get("uniqueid");
		SalesforceRestAPI.uid = RetailAccount.uid = DetailsPage.uid = uid;
		
	if (RunningTestCaseonDemand.equalsIgnoreCase("Yes")){}
	else { 	
			SalesforceRestAPI.fname = RetailAccount.fname = "Testf"+ uid; 
			SalesforceRestAPI.lname = RetailAccount.lname = "Testl"+ uid;
	}
		
		
	//----------Temporary to generate Accounts with multiple names------------------	
	//	SalesforceRestAPI.fname = RetailAccount.fname = Fname[logactivityTest.i]; 		
	//	SalesforceRestAPI.lname = RetailAccount.lname = Lname[logactivityTest.j];
	//--------------------------------------------------------------------------
		
		
	//----------Temporary to generate Accounts with Opportunities with multiple names------------------	
	//	SalesforceRestAPI.fname = RetailAccount.fname = Fname[branchOpttyTest.i]; 		
	//	SalesforceRestAPI.lname = RetailAccount.lname = Lname[branchOpttyTest.j];
	//------------------------------------------------------------------------------------------------	
		
		SalesforceRestAPI.bname = "Testb"+ uid;
		
		String aname = SalesforceRestAPI.fname+" "+SalesforceRestAPI.lname;
		RetailAccount.aname = aname;
		
		RetailAccount.spousefname = "spouseTestf"+ uid;
		RetailAccount.spouselname = "spouseTestl"+ uid;		
		DetailsPage.commentsToEnter = "TestingPurpose "+ uid;		
		
		DetailsPage.enteredDate = Data.get("enteredDate");
		DetailsPage.verifyDate = Data.get("verifyDate");
		DetailsPage.meetingDate = Data.get("meetingDate");
		DetailsPage.meetingformattedDate = Data.get("meetingformattedDate");
		DetailsPage.unplannedDate = Data.get("unplannedDate");
		DetailsPage.emailupdate = "testf"+uid+"@updateaccount.com";
				
		SalesforceRestAPI.accountId = RetailAccount.accountId = SalesforceRestAPI.getHashMapData()[0];
		
		
	}
	
	public static Map<String, String> getDetailPageData(){
		
		String[] ret = addDaysToCurrentTime(7);
		
		Map<String, String> detailPageData = new HashMap<String, String>();
		    
		detailPageData.put("enteredDate", ret[0]);
		detailPageData.put("verifyDate", ret[1]);
		detailPageData.put("meetingDate", ret[2]);
		detailPageData.put("meetingformattedDate", ret[3]);
		detailPageData.put("uniqueid", ret[4]);
		detailPageData.put("unplannedDate", ret[6]);
		
		return detailPageData;
	
		}

	
	public void setTestCaseonDemandtoYes()	{RunningTestCaseonDemand = "Yes";}
	public void setTestCaseonDemandtoNo()	{RunningTestCaseonDemand = "No";}

	
	
}
