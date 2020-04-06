package com.crm.qa.base;


import java.util.HashMap;
import java.util.Map;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.SalesforceRestAPI;
import com.crm.qa.pages.RetailAccount;
import com.crm.qa.testcases.*;


public class InitializeUserData extends TestBase{



	SalesforceRestAPI sfdcAPI = new SalesforceRestAPI();
	DetailsPage detailPage = new DetailsPage();
	RetailAccount retailPage = new RetailAccount();
	LogActivityTest logactivityTest = new LogActivityTest();
	BranchOpportunityTest branchOpttyTest = new BranchOpportunityTest();
	CreateAcctOpttyonDemand creatAcctonDemnd = new CreateAcctOpttyonDemand();
	
	 String RunningTestCaseonDemand;
	
	
	@SuppressWarnings("static-access")
	public  void initialize() throws Exception{
		
		
		Map<String, String> Data = new HashMap<String, String>();
		Data = getDetailPageData();
		
		String uid = Data.get("uniqueid");
		sfdcAPI.set_uid(uid); retailPage.set_uid(uid);detailPage.set_uid(uid);
		
		
		
	if (RunningTestCaseonDemand.equalsIgnoreCase("Yes")){}
	else { 	
			sfdcAPI.set_fname("Testf"+ uid);retailPage.set_fname("Testf"+ uid);
			sfdcAPI.set_lname("Testl"+ uid);retailPage.set_lname("Testl"+ uid);
	
	}
		
		sfdcAPI.set_bname("Testb"+ uid);
		
		retailPage.set_aname(SalesforceRestAPI.fname+" "+SalesforceRestAPI.lname);
		retailPage.set_sposuefname("spouseTestf"+ uid);
		retailPage.set_lname("spouseTestl"+ uid);
		
		detailPage.set_commentsToEnter("TestingPurpose "+ uid);
		detailPage.set_enteredDate(Data.get("enteredDate"));
		detailPage.set_verifyDate(Data.get("verifyDate"));
		detailPage.set_meetingDate(Data.get("meetingDate"));
		detailPage.set_meetingformattedDate(Data.get("meetingformattedDate"));
		detailPage.set_unplannedDate(Data.get("unplannedDate"));
		detailPage.set_emailupdate("testf"+uid+"@updateaccount.com");
		
		sfdcAPI.set_accountId(SalesforceRestAPI.getHashMapData()[0]);retailPage.set_accountId(SalesforceRestAPI.getHashMapData()[0]);
		
		
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
