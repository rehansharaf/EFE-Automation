package com.crm.qa.base;


import java.util.HashMap;
import java.util.Map;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.util.RetailUserdetails;
import com.crm.qa.pages.RetailAccount;


public class InitializeUserData extends TestBase{



	SalesforceRestAPI sfdcAPI = new SalesforceRestAPI();
	DetailsPage detailPage = new DetailsPage();
	RetailAccount retailPage = new RetailAccount();
	
	
	
	public void initialize(){
		
		Map<String, String> Data = new HashMap<String, String>();
		//Data = RetailUserdetails.getDetailPageData();
		Data = getDetailPageData();
		
		String uid = Data.get("uniqueid");
		SalesforceRestAPI.uid = RetailAccount.uid = DetailsPage.uid = uid;
		
		SalesforceRestAPI.fname = RetailAccount.fname = "Testf"+ uid;
		SalesforceRestAPI.lname = RetailAccount.lname = "Testl"+ uid;
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
		
	 
	
}
