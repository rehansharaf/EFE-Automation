
package com.crm.qa.pages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class SalesforceTestRestAPI extends TestBase {

	static OutputStream output = null;
	private static String taskId;
	private static String taskName;
	private static String taskCreatedDate;
	private static String taskCallOutcome;
	private static String taskDescription;
	private static Object taskCallType;
	private static Object taskType;
	private static Object taskStatus;
	private static Object taskSolutionsDiscussed;
	private static Object taskActivityDate;
	private static Object meetingId;
	private static Object meetingMedium;
	private static Object meetingStatus;
	public static Object leadId;
	private static Object leadStatus;
	private static Object leadCallAttempts;
	private static Object leadCustomerContact;
	private static Object leadIsConverted;
	private static Object meetingType;
	private static Object meetingSubType;
	private static Object meetingStartDate;
	private static Object meetingEndDate;
	private static Object appointmentStartDateText;
	static String retailId;
	static String busleadId;
	static String branchleadId;
	static String callTime;
	static String timeData = "true";
	static boolean tData = Boolean.valueOf(timeData);
	static String descData = "true";
	static boolean dData = Boolean.valueOf(descData);
	static String description;
	static String Outcome;
	static String enteredDate;
	static String schedule;
	
	static HomePage hpage = new HomePage();
	static DetailsPage detailsPage= new DetailsPage();
	static SalesforceRestAPI sfAPI = new SalesforceRestAPI();
	//public static SoftAssert softAssertion = new SoftAssert();
	//SalesforceRestAPI restapi = new SalesforceRestAPI();
	

	public static void APIConnection() {

		try {output = new FileOutputStream(prop.getProperty("QAconfig_path"));} 
		catch (FileNotFoundException e) {e.printStackTrace();}

		dataCreation_basic();

	}

	public static void dataCreation() {

		SalesforceRestAPI.APIConnection();
		SalesforceRestAPI.createRetailRecord();
		SalesforceRestAPI.updateRetailRecord();
		SalesforceRestAPI.updateBrancAccountRelationship();
		SalesforceRestAPI.createBusinessLead();
		SalesforceRestAPI.createBranchLead();

	}
	
	
	public static void dataCreation_basic() {

		SalesforceRestAPI.APIConnection();
		SalesforceRestAPI.createRetailRecord();
		SalesforceRestAPI.updateRetailRecord();
		SalesforceRestAPI.updateBrancAccountRelationship();
	}
	
	
	public static void dataCreation_businesslead() {

		SalesforceRestAPI.APIConnection();
		SalesforceRestAPI.createRetailRecord();
		SalesforceRestAPI.updateRetailRecord();
		SalesforceRestAPI.updateBrancAccountRelationship();
		SalesforceRestAPI.createBusinessLead();
		
	}
	
	
	
	
	public static void dataCreation3(String FirstName, String LastName, String Email) {

		SalesforceRestAPI.APIConnection();
		//String FirstName = null, LastName = null, DOB = null, Email = null;
		SalesforceRestAPI.createRetailRecord_ExternalData(FirstName, LastName, Email);
		SalesforceRestAPI.updateRetailRecord();
		SalesforceRestAPI.updateBrancAccountRelationship();
		

	}
	
	public static void dataCreation4(String firstName, String lastName) throws InterruptedException {

	
		
		SalesforceRestAPI.createBranchOpp(firstName, lastName);
		//SalesforceRestAPI.createRPAccount(SalesforceRestAPI.objMap.get("sfdcId") );
		//SalesforceRestAPI.createCTAccount();
		//SalesforceRestAPI.createRegularAccount();
		//SalesforceRestAPI.createService();

	}
	
	public static void dataCreation1() {

		SalesforceRestAPI.APIConnection();
		SalesforceRestAPI.createRetailRecord();
		SalesforceRestAPI.updateRetailRecord1();
		SalesforceRestAPI.updateBrancAccountRelationship();

	}
	
	public static void dataCreation2() {
		
		/* This method creates retail record, updates record with advisor and set branch Account Relationships. In addition to that, it creates service record and RP, CT< regular accounts.   */

		SalesforceRestAPI.APIConnection();
		SalesforceRestAPI.createRetailRecord();
		SalesforceRestAPI.updateRetailRecord();
		SalesforceRestAPI.updateBrancAccountRelationship();
		SalesforceRestAPI.createRPAccount(SalesforceRestAPI.objMap.get("sfdcId") );
		SalesforceRestAPI.createCTAccount();
		SalesforceRestAPI.createRegularAccount();
		SalesforceRestAPI.createService();
	}

	@SuppressWarnings("static-access")
	public static void validateTaskData(int i) throws InterruptedException {
		
		Thread.sleep(10000);
		callTime = prop.getProperty("Call Start Time");
		
		description = detailsPage.get_commentsToEnter();
		Outcome = detailsPage.get_Outcome();
		

		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			taskId = task.getJSONObject(0).getString("Id");
			taskName = task.getJSONObject(0).getString("AccountId");
			taskCreatedDate = task.getJSONObject(0).getString("Call_Start_Time__c");
			taskDescription = (String) task.getJSONObject(0).get("Description");
			taskCallOutcome = task.getJSONObject(0).getString("Call_Outcome__c");
			taskCallType = task.getJSONObject(0).getString("Call_Type__c");
			taskStatus = task.getJSONObject(0).getString("Status");
			
			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){}
			else {taskSolutionsDiscussed = task.getJSONObject(0).getString("Solutions_Discussed__c");}
			
			boolean descriptionComparison = hpage.validateDescriptionData(taskDescription, description);
			softAssertion.assertEquals(descriptionComparison, dData , "Task description mismatch");
			softAssertion.assertEquals(taskCallOutcome, Outcome, "Call Outcome mismatch");
			softAssertion.assertEquals(taskCallType, "Call", "Call Type mismatch");
			softAssertion.assertEquals(taskStatus, "Completed", "Call Status mismatch");
		
			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){
				System.out.println("Task record is----------------------------------------------------- " + taskId + " "
						+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus);}
				else {System.out.println("Task record is----------------------------------------------------- " + taskId + " "
						+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus +taskSolutionsDiscussed);}
				
			softAssertion.assertAll();
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("static-access")
	public static void validateTaskData1(int i) throws InterruptedException {

		Thread.sleep(15000);	
		callTime = prop.getProperty("Call Start Time");
		
		description = detailsPage.get_commentsToEnter();
		Outcome = detailsPage.get_Outcome();

		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			taskId = task.getJSONObject(0).getString("Id");
			taskName = task.getJSONObject(0).getString("AccountId");
			taskCreatedDate = task.getJSONObject(0).getString("Call_Start_Time__c");
			taskDescription = (String) task.getJSONObject(0).get("Description");
			taskCallOutcome = task.getJSONObject(0).getString("Call_Outcome__c");
			taskCallType = task.getJSONObject(0).getString("Call_Type__c");
			taskStatus = task.getJSONObject(0).getString("Status");
			
			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){}
			else {taskSolutionsDiscussed = task.getJSONObject(0).getString("Solutions_Discussed__c");}

			
			boolean descriptionComparison = hpage.validateDescriptionData(taskDescription, description);
			softAssertion.assertEquals(descriptionComparison, dData , "Task description mismatch");
			softAssertion.assertEquals(taskCallOutcome, Outcome, "Call Outcome mismatch");
			softAssertion.assertEquals(taskCallType, "Call", "Call Type mismatch");
			softAssertion.assertEquals(taskStatus, "Completed", "Call Status mismatch");

			System.out.println(taskDescription);
			
			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){
			System.out.println("Task record is----------------------------------------------------- " + taskId + " "
					+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus);}
			else {System.out.println("Task record is----------------------------------------------------- " + taskId + " "
					+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus +taskSolutionsDiscussed);}
			
			softAssertion.assertAll();
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("static-access")
	public static void validateTaskData2(int i) throws InterruptedException {

		Thread.sleep(10000);	
		callTime = prop.getProperty("Call Start Time");
		//description = "added " + callTime +" "+ prop.getProperty("EnteredComments");
		description = detailsPage.get_commentsToEnter();
		Outcome = detailsPage.get_Outcome();
		

		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			taskId = task.getJSONObject(1).getString("Id");
			taskName = task.getJSONObject(1).getString("AccountId");
			//taskCreatedDate = task.getJSONObject(0).getString("Call_Start_Time__c");
			taskDescription = (String) task.getJSONObject(1).get("Description");
			taskCallOutcome = task.getJSONObject(1).getString("Call_Outcome__c");
			taskCallType = task.getJSONObject(1).getString("Call_Type__c");
			taskStatus = task.getJSONObject(1).getString("Status");
			//taskSolutionsDiscussed = task.getJSONObject(1).getString("Solutions_Discussed__c");

			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){}
			else {taskSolutionsDiscussed = task.getJSONObject(1).getString("Solutions_Discussed__c");}
			
			//boolean timeComparison = hpage.validateCallDate(taskCreatedDate, callTime);
			//softAssertion.assertEquals(timeComparison, tData , "call date mismatch");
			boolean descriptionComparison = hpage.validateDescriptionData(taskDescription, description);
			softAssertion.assertEquals(descriptionComparison, dData , "Task description mismatch");
			softAssertion.assertEquals(taskCallOutcome, Outcome, "Call Outcome mismatch");
			softAssertion.assertEquals(taskCallType, "Call", "Call Type mismatch");
			softAssertion.assertEquals(taskStatus, "Completed", "Call Status mismatch");

			System.out.println(taskDescription);

			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){
			System.out.println("Task record is----------------------------------------------------- " + taskId + " "
					+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus);}
			else {System.out.println("Task record is----------------------------------------------------- " + taskId + " "
					+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus +taskSolutionsDiscussed);}
			
			softAssertion.assertAll();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
	
	@SuppressWarnings("static-access")
	public static void validateTaskScheduleData(int i) throws InterruptedException, ParseException {

		Thread.sleep(5000);
		
		description = detailsPage.get_commentsToEnter();
		Outcome = detailsPage.get_Outcome();
		enteredDate = detailsPage.get_enteredDate();
		schedule = detailsPage.get_schedule();
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			taskId = task.getJSONObject(1).getString("Id");
			taskName = task.getJSONObject(1).getString("AccountId");
			taskCreatedDate = task.getJSONObject(1).getString("Call_Start_Time__c");
			taskDescription = (String) task.getJSONObject(1).get("Description");
			taskCallOutcome = task.getJSONObject(1).getString("Call_Outcome__c");
			//taskType = task.getJSONObject(1).getString("Type");
			taskStatus = task.getJSONObject(1).getString("Status");
			taskActivityDate = task.getJSONObject(0).getString("ActivityDate");
			
			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){}
			else {taskSolutionsDiscussed = task.getJSONObject(1).getString("Solutions_Discussed__c");}
			

			// softAssertion.assertEquals(taskCreatedDate, prop.getProperty("Call Start
			// Time"), "call date mismatch");
			//softAssertion.assertEquals(taskDescription, prop.getProperty("EnteredComments"),"Task description mismatch");
			boolean descriptionComparison = hpage.validateDescriptionData(taskDescription, description);
			softAssertion.assertEquals(descriptionComparison, dData , "Task description mismatch");
			softAssertion.assertEquals(taskCallOutcome, "Reached", "Call Outcome mismatch");
			//softAssertion.assertEquals(taskType, "Task", "Call type mismatch");
			softAssertion.assertEquals(taskStatus, "Completed", "Call Status mismatch");
			softAssertion.assertEquals(taskActivityDate, TestUtil.changeDateFormat(enteredDate), "Entered Date mismatch");

			System.out.println(taskDescription);
			
			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){
			System.out.println("Task record is----------------------------------------------------- " + taskId + " "
					+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus);}
			else {System.out.println("Task record is----------------------------------------------------- " + taskId + " "
					+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus
					+ taskSolutionsDiscussed);}
			
			softAssertion.assertAll();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	/*
	@SuppressWarnings("static-access")
	public static void validateTaskScheduleData1(int i) throws InterruptedException {

		Thread.sleep(5000);
		
		description = detailsPage.get_commentsToEnter();
		Outcome = detailsPage.get_Outcome();
		enteredDate = detailsPage.get_enteredDate();
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			taskId = task.getJSONObject(1).getString("Id");
			taskName = task.getJSONObject(1).getString("AccountId");
			taskCreatedDate = task.getJSONObject(1).getString("Call_Start_Time__c");
			taskDescription = (String) task.getJSONObject(1).get("Description");
			 taskCallOutcome = task.getJSONObject(1).getString("Call_Outcome__c");
			taskType = task.getJSONObject(0).getString("Type");
			taskStatus = task.getJSONObject(1).getString("Status");
			//taskSolutionsDiscussed = task.getJSONObject(1).getString("Solutions_Discussed__c");
			taskActivityDate = task.getJSONObject(0).getString("ActivityDate");
			
			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){}
			else {taskSolutionsDiscussed = task.getJSONObject(1).getString("Solutions_Discussed__c");}
			

			// softAssertion.assertEquals(taskCreatedDate, prop.getProperty("Call Start
			// Time"), "call date mismatch");
			//softAssertion.assertEquals(taskDescription, prop.getProperty("EnteredComments"),"Task description mismatch");
			boolean descriptionComparison = hpage.validateDescriptionData(taskDescription, description);
			softAssertion.assertEquals(descriptionComparison, dData , "Task description mismatch");
			// softAssertion.assertEquals(taskCallOutcome, "Follow Up", "Call Outcome
			// mismatch");
			softAssertion.assertEquals(taskType, "Call", "Call Type mismatch");
			softAssertion.assertEquals(taskStatus, "Open", "Call Status mismatch");
			softAssertion.assertEquals(taskActivityDate, enteredDate, "Entered Date mismatch");

			System.out.println(taskDescription);
			
			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){
			System.out.println("Task record is----------------------------------------------------- " + taskId + " "
					+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus);}
			else {System.out.println("Task record is----------------------------------------------------- " + taskId + " "
					+ taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType + taskStatus
					+ taskSolutionsDiscussed);}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
*/
	
	public static void validateMeetingData(int i, String meetType) throws InterruptedException {

		Thread.sleep(5000);	
		
		String mClient = detailsPage.get_futureMeetingwithClient();	if (mClient==null){mClient="None";}
		String mtClient = detailsPage.get_meetingClient();if (mtClient==null){mtClient="None";}
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			meetingId = task.getJSONObject(0).getString("Id");
			meetingMedium = task.getJSONObject(0).getString("Meeting_Medium__c");
			meetingType = task.getJSONObject(0).getString("Type");
			meetingSubType = task.getJSONObject(0).getString("Meeting_Sub_Type__c");
			meetingStartDate = task.getJSONObject(0).getString("StartDateTime");
			meetingEndDate = task.getJSONObject(0).getString("EndDateTime");
			//appointmentStartDateText = task.getJSONObject(0).getString("Appointment_Start_Date_Time_Text__c");
			
			
			softAssertion.assertEquals(meetingType, meetType, "Meeting Type mismatch");
			softAssertion.assertEquals(meetingSubType, "Follow-up", "Meeting Sub Type mismatch");
			
			if (mtClient.contains(meetingMedium.toString())){softAssertion.assertTrue(mtClient.contains(meetingMedium.toString()), "Meeting Medium mismatch");}
			else {softAssertion.assertEquals(meetingMedium,"Virtual", "Meeting Medium mismatch");}
	
			System.out.println("Event record is----------------------------------------------------- " + meetingId + " "
					+ meetingMedium + " " + meetingType + meetingSubType);
			 
			softAssertion.assertAll();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
/*	
	public static void validateUnplannedMeetingData(int i) throws InterruptedException {

		Thread.sleep(10000);	
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			Thread.sleep(3000);
			
			meetingId = task.getJSONObject(0).getString("Id");
			meetingMedium = task.getJSONObject(0).getString("Meeting_Medium__c");

			meetingStatus = task.getJSONObject(0).get("Meeting_Status__c");

			meetingType = task.getJSONObject(0).getString("Type");
			meetingSubType = task.getJSONObject(0).getString("Meeting_Sub_Type__c");
			meetingStartDate = task.getJSONObject(0).getString("StartDateTime");
			meetingEndDate = task.getJSONObject(0).getString("EndDateTime");
			appointmentStartDateText = task.getJSONObject(0).getString("Appointment_Start_Date_Time_Text__c");
			
			softAssertion.assertEquals(meetingType, "Prospect Meeting", "Meeting Type mismatch");
			
			softAssertion.assertEquals(meetingSubType, "Initial", "Meeting Sub Type mismatch");
			softAssertion.assertEquals(meetingMedium, "On-Phone", "Meeting Medium mismatch");
			softAssertion.assertEquals(meetingStatus, "Completed", "Meeting Medium mismatch");
			System.out.println(taskDescription);
			System.out.println("Event record is----------------------------------------------------- " + meetingId + " "
					+ meetingMedium + " " + meetingType + meetingSubType);
			
			softAssertion.assertAll();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
*/
	
	
	public static void validateUnplannedMeetingData(int i) throws InterruptedException {

		Thread.sleep(10000);
		
		String mClient = detailsPage.get_meetingClient();//In person meeting
		String mOutcome = detailsPage.get_meetingOutcome();//No Show
		String meetingExist = detailsPage.get_meetingExist();if (meetingExist ==null){meetingExist = "No";}
		
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			Thread.sleep(3000);
			
			meetingId = task.getJSONObject(0).getString("Id");
			meetingMedium = task.getJSONObject(0).getString("Meeting_Medium__c");
			meetingType = task.getJSONObject(0).getString("Type");
			meetingStartDate = task.getJSONObject(0).getString("StartDateTime");
			meetingStatus = task.getJSONObject(0).get("Meeting_Status__c");
			meetingSubType = task.getJSONObject(0).getString("Meeting_Sub_Type__c");
			meetingEndDate = task.getJSONObject(0).getString("EndDateTime");
			appointmentStartDateText = task.getJSONObject(0).getString("Appointment_Start_Date_Time_Text__c");
			
			softAssertion.assertTrue(mClient.contains(meetingMedium.toString()), "Meeting Medium mismatch");
			softAssertion.assertEquals(meetingType, "Prospect Meeting", "Meeting Type mismatch");
			softAssertion.assertEquals(meetingStatus, mOutcome, "Meeting Medium mismatch");
			
			if (meetingExist.equalsIgnoreCase("Yes")){softAssertion.assertEquals(meetingSubType, "Follow-up", "Meeting Sub Type mismatch");} 
			else {softAssertion.assertEquals(meetingSubType, "Initial", "Meeting Sub Type mismatch");}
			
	
			System.out.println("Event record is----------------------------------------------------- " + meetingId + " "
					+ meetingMedium + " " + meetingType + meetingSubType);
			
			softAssertion.assertAll();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

	public static void validateLeadData(int i) throws InterruptedException {

		Thread.sleep(5000);	
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			leadId = task.getJSONObject(0).getString("Id");
			leadCallAttempts = task.getJSONObject(0).getInt("Call_attempts_made__c");
			leadStatus = task.getJSONObject(0).getString("Status");

			softAssertion.assertEquals(leadStatus, "Attempting", "Lead Status mismatch");
			//softAssertion.assertEquals(leadCallAttempts, "1", "Lead Call Attempts mismatch");
			softAssertion.assertTrue(leadCallAttempts.equals(1));

			System.out.println("Lead record is----------------------------------------------------- " + leadId + " "
					+ leadStatus + " " + leadCallAttempts);
			
			softAssertion.assertAll();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void validateLeadDataReached(int i) throws InterruptedException {

		Thread.sleep(5000);	
		
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			leadId = task.getJSONObject(0).getString("Id");
			leadCallAttempts = task.getJSONObject(0).getInt("Call_attempts_made__c");
			leadStatus = task.getJSONObject(0).getString("Status");
			leadCustomerContact = task.getJSONObject(0).getString("Customer_Contact__c");
			leadIsConverted = task.getJSONObject(0).getBoolean("IsConverted");

			softAssertion.assertEquals(leadStatus, "Closed without opportunity", "Lead Status mismatch");
			softAssertion.assertTrue(leadCallAttempts.equals(1));
			softAssertion.assertEquals(leadCustomerContact, "Reached", "Lead CustomerContact mismatch");
			softAssertion.assertTrue(leadIsConverted.toString().contains("true"), "Lead Converted mismatch");
			

			System.out.println("Lead record is----------------------------------------------------- " + leadId + " "
					+ leadStatus + " " + leadCallAttempts + " " + leadIsConverted);
		
			softAssertion.assertAll();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void validateBranchOpportunity(int i) throws InterruptedException {

		Thread.sleep(10000);	
		int expectedAmount = 250000;
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			String oppId = task.getJSONObject(0).getString("Id");
			String oppLeadSource = task.getJSONObject(0).getString("LeadSource");
			String oppCreatedDate = task.getJSONObject(0).getString("CreatedDate");
			String oppStageName = task.getJSONObject(0).getString("StageName");

			int oppTotalAmount = task.getJSONObject(0).getInt("Total_Expected_Amount__c");

			
			if (RetailAccount.userProfile.contains("Field Advisor")|| RetailAccount.userProfile.contains("Field CSM")){
					softAssertion.assertEquals(oppLeadSource, "Benefits Fair", "Opp Lead Source mismatch");}
			else{	softAssertion.assertEquals(oppLeadSource, "NAC Outbound", "Opp Lead Source mismatch");}
					
			softAssertion.assertEquals(oppTotalAmount, expectedAmount, "Opp Total Amount Call Attempts mismatch");
			//softAssertion.assertTrue(oppTotalAmount 250000);
			
			
			softAssertion.assertEquals(oppStageName, "New", "Opp Stage Name mismatch");

			System.out.println("Opportunity record is----------------------------------------------------- " + oppId
					+ " " + oppLeadSource + " " + oppTotalAmount);
			
			softAssertion.assertAll();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static void validateBranchOpportunity_Stage(String stageStatus, int i) throws InterruptedException {

		Thread.sleep(5000);	
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			String oppId = task.getJSONObject(0).getString("Id");
			String oppLeadSource = task.getJSONObject(0).getString("LeadSource");
			String oppCreatedDate = task.getJSONObject(0).getString("CreatedDate");
			String oppStageName = task.getJSONObject(0).getString("StageName");

			int oppTotalAmount = task.getJSONObject(0).getInt("Total_Expected_Amount__c");

			softAssertion.assertEquals(oppLeadSource, "NAC Outbound", "Opp Lead Source mismatch");
			softAssertion.assertEquals(oppTotalAmount, "250000", "Opp Total Amount Call Attempts mismatch");
			softAssertion.assertEquals(oppStageName, stageStatus, "Opp Stage Name mismatch");

			System.out.println("Opportunity record is----------------------------------------------------- " + oppId
					+ " " + oppLeadSource + " " + oppTotalAmount);
			// softAssertion.assertAll();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
	
	public static void validateWorkPlaceOpportunity(int i) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread.sleep(5000);	
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			String oppId = task.getJSONObject(0).getString("Id");
			String oppLeadSource = task.getJSONObject(0).getString("LeadSource");
			String oppCreatedDate = task.getJSONObject(0).getString("CreatedDate");
			String oppStageName = task.getJSONObject(0).getString("StageName");

			int oppTotalAmount = task.getJSONObject(0).getInt("Total_Expected_Amount__c");

			softAssertion.assertEquals(oppLeadSource, "NAC Outbound", "Opp Lead Source mismatch");
			softAssertion.assertEquals(oppTotalAmount, "250000", "Opp Total Amount Call Attempts mismatch");
			softAssertion.assertEquals(oppStageName, "New", "Opp Stage Name mismatch");

			System.out.println("Opportunity record is----------------------------------------------------- " + oppId
					+ " " + oppLeadSource + " " + oppTotalAmount);
			// softAssertion.assertAll();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void verifyFinancialAccount(int i, String j, int Status) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread.sleep(5000);	
		
		try {
			JSONArray task = SalesforceRestAPI.queryTaskObject(i);
			String finAccId = task.getJSONObject(0).getString("Id");
	
			Boolean finAccStatus = task.getJSONObject(0).getBoolean("Deactivated__c");
			String finAccType = task.getJSONObject(0).getString("FinServ__FinancialAccountType__c");
			softAssertion.assertEquals(finAccStatus, Status, "Financial Account Status mismatch");
			softAssertion.assertEquals(finAccType, j, "Financial Account Type mismatch");
			System.out.println("Financial Account record is----------------------------------------------------- " + finAccId
					+ " " + finAccStatus);
			 //softAssertion.assertAll();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
}
