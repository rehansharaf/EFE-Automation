
package com.crm.qa.pages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

import com.crm.qa.base.TestBase;
 
public class RestAPI extends TestBase {
 
    static final String USERNAME     = "rnalam@fe.com.fscfull";
    static final String PASSWORD     = "Efe1234*bxjSDMP3xWqOb57OkopmU9LD";
    static final String LOGINURL     = "https://test.salesforce.com";
    static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
    static final String CLIENTID     = "3MVG9qbIpUScOGtYABP3g246J0TP_jQjzSMgl8SMHmxFFTNtZamxl_LVwYt1GLG4r6YJI.cjj.yrc9iTSsa6W";
    static final String CLIENTSECRET = "BEFB05E7596B2FCF9FDB131F4D9C5E3F4B1188BC71C0748601E828E71F5CBC59";
    private static String REST_ENDPOINT = "/services/data" ;
    private static String API_VERSION = "/v45.0" ;
    private static String baseUri;
    private static Header oauthHeader;
    private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");
    private static String taskId ;
    private static String taskAccountId ;
    private static String taskCallType ;
    private static String taskStatus ;
    private static String taskSolutionsDiscussed ;
    private static String taskName;
    private static String leadId ;
    private static String leadStatus;
    private static String taskCreatedDate;
    private static String taskCallOutcome;
    private static Object taskDescription;
    static String retailId;
    static String busleadId;
    static String branchleadId;
    
   // static String uid = DetailsPage.uniqueid;
	
	static String fname = "Testf"+ "f123";
	static String lname = "Testl"+ "f123";
	static String bname = "Testb"+ "f123";
	
	static OutputStream output = null;

 
  static Map<String, String> objMap = new HashMap<String, String>();
  
  //public static void APIConnection() {
	 
	
	  
	   
    
  public static void main(String[] args) {
 
        HttpClient httpclient = HttpClientBuilder.create().build();
        
        try {
			output = new FileOutputStream("/Users/rnalam/Downloads/Sampleproject/PageObjectModel/QAconfig.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
 
        // Assemble the login request URL
        String loginURL = LOGINURL +
                          GRANTSERVICE +
                          "&client_id=" + CLIENTID +
                          "&client_secret=" + CLIENTSECRET +
                          "&username=" + USERNAME +
                          "&password=" + PASSWORD;
 
        // Login requests must be POSTs
        HttpPost httpPost = new HttpPost(loginURL);
        HttpResponse response = null;
 
        try {
            // Execute the login POST request
            response = httpclient.execute(httpPost);
        } catch (ClientProtocolException cpException) {
            cpException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
 
        // verify response is HTTP OK
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to Force.com: "+statusCode);
            // Error is in EntityUtils.toString(response.getEntity())
            return;
        }
 
        String getResult = null;
        try {
            getResult = EntityUtils.toString(response.getEntity());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
 
        JSONObject jsonObject = null;
        String loginAccessToken = null;
        String loginInstanceUrl = null;
 
        try {
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
 
        baseUri = loginInstanceUrl + REST_ENDPOINT + API_VERSION ;
        oauthHeader = new BasicHeader("Authorization", "OAuth " + loginAccessToken) ;
        System.out.println("oauthHeader1: " + oauthHeader);
        System.out.println("\n" + response.getStatusLine());
        System.out.println("Successful login");
        System.out.println("instance URL: "+loginInstanceUrl);
        System.out.println("access token/session ID: "+loginAccessToken);
        System.out.println("baseUri: "+ baseUri);        
 
        // Run codes to query, isnert, update and delete records in Salesforce using REST API
      //queryTaskObject("0010R00000UlPkFQAV");
   createRetailRecord();
   queryTaskObject1();
   //   updateRetailRecord();
    //  updateBrancAccountRelationship();
    //validateTaskData("0010R00000s4OM9QAM");     
 
        // release connection
        httpPost.releaseConnection();
    }
    
   
   public static void dataCreation() {
	   //APIConnection();
	   
	  	   
   }
   
   
    
    public void releaseConnection() {
    	
      //  httpPost.releaseConnection();
    	
    }
    
    public static void createRetailRecord() {
   	 
    	System.out.println("\n_______________ Creating Retail Record _______________");
    	
    	String uri = baseUri + "/quickActions/Create_Retail_Account";
    	
        try {
        	 
            //create the JSON object containing the new lead details.
            JSONObject retail = new JSONObject();
          
			retail.put("FirstName", fname);
            retail.put("LastName", lname);
            retail.put("Gender__c", "Female");
            retail.put("DOB__c", "1967-06-03");
            retail.put("Email__c", fname+"@testaccount.com");
            retail.put("Phone", "408-555-1234");
            retail.put("BillingStreet", "1050 Enterprise Way");
            retail.put("BillingCity", "Sunnyvale");
            retail.put("BillingState", "CA");
            retail.put("BillingPostalCode", "94089");
            retail.put("BillingCountry", "USA");
            retail.put("Type", "Branch Retail");
     
            
            System.out.println("JSON for retail record to be inserted:\n" + retail.toString(1));

            //Construct the objects needed for the request
            HttpClient httpClient = HttpClientBuilder.create().build();
            JSONObject retail1 = new JSONObject();
            retail1.put("record", retail);
            
            System.out.println("JSON for retail record to be inserted:\n" + retail1.toString(1));
            
            HttpPost httpPost = new HttpPost(uri);
            httpPost.addHeader(oauthHeader);
            httpPost.addHeader(prettyPrintHeader);
            // The message we are going to post
            
            StringEntity body = new StringEntity(retail1.toString(1));
            body.setContentType("application/json");
            httpPost.setEntity(body);

            //Make the request
            HttpResponse response = httpClient.execute(httpPost);

            //Process the results
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201) {
                String response_string = EntityUtils.toString(response.getEntity());
                JSONObject json = new JSONObject(response_string);
                // Store the retrieved retail id to use when we update the retail.
               retailId = json.getString("id");
                System.out.println("New Retail id from response: " + retailId);
              
            } else {
                System.out.println("Insertion unsuccessful. Status code returned is " + statusCode);
            }
        } catch (JSONException e) {
            System.out.println("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        
        
       // prop.setProperty("retailsfdcID", retailId);
        
        objMap.put("sfdcId", retailId);
        
          	 
      
     }   
      
    
    public static void validateTaskData(String sfdcID) {
		 
		 String description = "added";
		 //+ prop.getProperty("Call Start Time") + prop.getProperty("EnteredComments");
		 System.out.println(description);
	    	
	    	
	    	try {
	    		JSONArray task = queryTaskObject(sfdcID);
				taskId = task.getJSONObject(0).getString("Id");
				taskName = task.getJSONObject(0).getString("AccountId");
		        taskCreatedDate = task.getJSONObject(0).getString("CreatedDate");
		        taskDescription = task.getJSONObject(0).get("Description");
		        taskCallOutcome = task.getJSONObject(0).getString("Call_Outcome__c");
		        taskCallType = task.getJSONObject(0).getString("Call_Type__c");
               taskStatus = task.getJSONObject(0).getString("Status");
               taskSolutionsDiscussed = task.getJSONObject(0).getString("Status");
		        
				softAssertion.assertEquals(taskCreatedDate, prop.getProperty("Call Start Time"), "call date mismatch in Conversations Tab");
				softAssertion.assertEquals(taskDescription, description, "call date mismatch in Conversations Tab");
				softAssertion.assertEquals(taskCallOutcome, "Not Reached", "call date mismatch in Conversations Tab");
				softAssertion.assertEquals(taskCallType, "Call", "call date mismatch in Conversations Tab");
				softAssertion.assertEquals(taskStatus, "Completed", "call date mismatch in Conversations Tab");
				
				
		        System.out.println(taskDescription);
		        System.out.println("Task record is----------------------------------------------------- " + taskId + " " + taskName + " " + taskCreatedDate + taskDescription+ taskCallOutcome + taskCallType + taskStatus+ taskSolutionsDiscussed );
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    	
	    }
    
    
    
    
    
    
    
 
    // Query Leads using REST HttpGet
    public static JSONArray queryTaskObject(String sfdcId) {
    	
    	JSONArray j = null;
    	
        System.out.println("\n_______________ Task QUERY _______________");
        try {
 
            //Set up the HTTP objects needed to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();
            
            //'0010R00000UlPkFQAV'
 
            String uri = baseUri + "/query?q=select+Id+,+AccountId+,+Call_Start_Time__c+,+Description+from+Task+where+AccountId+='" +sfdcId+"'+ORDER+BY+CreatedDate+Desc";
            System.out.println("Query URL: " + uri);
            HttpGet httpGet = new HttpGet(uri);
            System.out.println("oauthHeader2: " + oauthHeader);
            httpGet.addHeader(oauthHeader);
            httpGet.addHeader(prettyPrintHeader);
 
            // Make the request.
            HttpResponse response = httpClient.execute(httpGet);
 
            // Process the result
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String response_string = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject json = new JSONObject(response_string);
                    System.out.println("JSON result of Query:\n" + json.toString(1));
                    j = json.getJSONArray("records");
                    for (int i = 0; i < j.length(); i++){
                    	
                        taskId = json.getJSONArray("records").getJSONObject(i).getString("Id");
                        taskAccountId = json.getJSONArray("records").getJSONObject(i).getString("AccountId");
                        taskCreatedDate = json.getJSONArray("records").getJSONObject(i).getString("Call_Start_Time__c");
                        taskDescription = json.getJSONArray("records").getJSONObject(i).get("Description");
                        taskCallOutcome = json.getJSONArray("records").getJSONObject(i).getString("Call_Outcome__c");
                        taskCallType = json.getJSONArray("records").getJSONObject(i).getString("Call_Type__c");
                        taskStatus = json.getJSONArray("records").getJSONObject(i).getString("Status");
                        taskSolutionsDiscussed = json.getJSONArray("records").getJSONObject(i).getString("Solutions_Discussed__c");
                        
                        //System.out.println(taskDescription);
                        System.out.println("Task record is: " + i + ". " + taskId + " " + taskName + " " + taskCreatedDate + taskDescription + taskCallOutcome + taskCallType +taskStatus + taskSolutionsDiscussed);
                       // return j;
                    }
                } catch (JSONException je) {
                    je.printStackTrace();
                }
               
                
            } else {
                System.out.println("Query was unsuccessful. Status code returned is " + statusCode);
                System.out.println("An error has occured. Http status: " + response.getStatusLine().getStatusCode());
                System.out.println(getBody(response.getEntity().getContent()));
                System.exit(-1);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
		return j;
    }
 
    
 
    
 
    // Extend the Apache HttpPost method to implement an HttpPatch
    private static class HttpPatch extends HttpPost {
        public HttpPatch(String uri) {
            super(uri);
        }
 
        public String getMethod() {
            return "PATCH";
        }
    }
    
 public static void queryTaskObject1() {
    	
    	
    	String sfdcid = objMap.get("sfdcId");
    			
    	//String leadid = prop.getProperty("BusinessLeadsfdcID");
    //	System.out.println(leadid);
    	System.out.println(sfdcid);
 }
 
    
 
    private static String getBody(InputStream inputStream) {
        String result = "";
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inputStream)
            );
            String inputLine;
            while ( (inputLine = in.readLine() ) != null ) {
                result += inputLine;
                result += "\n";
            }
            in.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }
    
 
 
}

