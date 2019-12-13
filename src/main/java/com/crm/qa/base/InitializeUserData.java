package com.crm.qa.base;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage__exp2;
import com.crm.qa.pages.SalesforceRestAPI_exp2;
import com.crm.qa.pages.RetailAccount__exp2;


public class InitializeUserData extends TestBase{

	
	private  String uid;
	private  String enteredDate;
	private  String verifyDate;
	private  String meetingDate;
	private  String meetingformattedDate;
	private  String unplannedDate;
	
	private  String fname;
	private  String lname;
	private  String bname;
	private  String aname;
	private String spousefname;
	private String spouselname;

	SalesforceRestAPI_exp2 sfdcAPI = new SalesforceRestAPI_exp2();
	DetailsPage__exp2 detailPage = new DetailsPage__exp2();
	RetailAccount__exp2 retailPage = new RetailAccount__exp2();
	
	
	
	public void Init(){
		
		detailPageData();
		
		sfdcAPI.set_uid(uid); detailPage.set_uid(uid);retailPage.set_uid(uid);
		
		sfdcAPI.set_fname(fname);
		sfdcAPI.set_lname(lname);
		sfdcAPI.set_bname(bname);
		
		
		
		retailPage.set_fname(fname);
		retailPage.set_lname(lname);
		retailPage.set_spousefname(spousefname);
		retailPage.set_spouselname(spouselname);
		retailPage.set_aname(aname);
		
		detailPage.set_enteredDate(enteredDate);
		detailPage.set_meetingDate(meetingDate);
		detailPage.set_meetingformattedDate(meetingformattedDate); 
		detailPage.set_verifyDate(verifyDate);
		detailPage.set_unplannedDate(unplannedDate);
		
		
	
		
		/*
				Map<String, String> Data = new HashMap<String, String>();
		Data = RetailUserdetails.getDetailPageData();
		String uid = Data.get("uniqueid");
		SalesforceRestAPI.uid = RetailAccount.uid = DetailsPage.uid = uid;
		
		SalesforceRestAPI.fname = "Testf"+ uid;
		SalesforceRestAPI.lname = "Testl"+ uid;
		SalesforceRestAPI.bname = "Testb"+ uid;
		
		String aname = SalesforceRestAPI.fname+" "+SalesforceRestAPI.lname;
		RetailAccount.aname = aname;
		
		DetailsPage.enteredDate = Data.get("enteredDate");
		DetailsPage.verifyDate = Data.get("verifyDate");
		DetailsPage.meetingDate = Data.get("meetingDate");
		DetailsPage.meetingformattedDate = Data.get("meetingformattedDate");
		DetailsPage.unplannedDate = Data.get("unplannedDate");
		
		*/
		
		
	}
	
	
	 public void detailPageData(){
		
			String[] ret = addDaysToCurrentTime(7);
		    setDetailPageData (ret[4],ret[0],ret[1],ret[2],ret[3],ret[6]);
		    
	
		}
	
	 public void setUserData(){
			
		 	this.fname = "Testf"+ get_uid();
			this.lname = "Testl"+ get_uid();
			this.bname = "Testb"+ get_uid();
			this.aname = fname+" "+lname;
			this.spousefname = "spouseTestf"+ get_uid();
			this.spouselname = "spouseTestl"+ get_uid();
			
		  
		}
	
	 
	 public void setDetailPageData(String uniqueid, String entDt, String verDt, String metDt, String metFmtDt, String unPlndDt){
		 
		 	this. uid = uniqueid; 
		 	this.enteredDate = entDt;
		 	this.verifyDate = verDt;
		 	this.meetingDate = metDt;
		 	this.meetingformattedDate = metFmtDt;
		 	this.unplannedDate = unPlndDt;
		 
	 	}
	
	
	 public String get_uid(){return this.uid;}
	 public String get_enteredDate(){return this.enteredDate;}
	 public String get_verifyDate(){return this.verifyDate;}
	 public String get_meetingDate(){return this.meetingDate;}
	 public String get_meetingformattedDate(){return this.meetingformattedDate;}
	 public String get_unplannedDate(){return this.unplannedDate;}

	 public String get_fname(){return this.fname;}
	 public String get_lname(){return this.lname;}
	 public String get_bname(){return this.bname;}
	 public String get_aname(){return this.aname;}
	 
	 public String get_spousefname(){return this.spousefname;}
	 public String get_spouselname(){return this.spouselname;}
	 
	
	 
	
}
