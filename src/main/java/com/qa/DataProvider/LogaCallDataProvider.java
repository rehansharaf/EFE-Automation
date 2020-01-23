package com.qa.DataProvider;

import org.testng.annotations.DataProvider;

public class LogaCallDataProvider {

	@DataProvider(name = "multipleUsers1")
    public static Object[][] dataProviderMethod1() 
    {
		/*
		Travis Adams = 0050R000000tUilQAE
		Andrew Kovalcik  = 0050R000000XRHEQA4
		Robert Fitzpatrick = 0050R000000XRHYQA4
		Rachel Alandzes = 0050R000000kTdBQAU  
		*/
		return new Object[][] { { "0050R000000tUilQAE" }, { "0050R000000XRHEQA4" }, { "0050R000000XRHYQA4" }, { "0050R000000kTdBQAU" } };
    }

	@DataProvider(name = "multipleUsers")
    public static Object[][] dataProviderMethod() 
    {
		/*
		Travis Adams = 0050R000000tUilQAE
		Andrew Kovalcik  = 0050R000000XRHEQA4
		Robert Fitzpatrick = 0050R000000XRHYQA4
		Rachel Alandzes = 0050R000000kTdBQAU  
		*/
		return new Object[][] {  { "0050R000000kTdBQAU" } };
    }


}
