package com.qa.DataProvider;

import org.testng.annotations.DataProvider;

public class LogaCallDataProvider {

	@DataProvider(name = "multipleUsers1")
    public static Object[][] dataProviderMethod1() 
    {
		/*
		Travis Adams 		= 0050R000000tUilQAE
		Andrew Kovalcik  	= 0050R000000XRHEQA4
		Robert Fitzpatrick 	= 0050R000000XRHYQA4
		Rachel Alandzes 	= 0050R000000kTdBQAU 
		Ian Krekelberg 		= 0050R000000XRFmQAO 
		Allison Boyd		= 0050R0000030MXPQA2
		*/
		return new Object[][] { { "0050R000000tUilQAE" }, { "0050R000000XRHEQA4" }, { "0050R000000XRHYQA4" }, { "0050R000000kTdBQAU" }, {"0050R000000XRFmQAO"}, {"0050R0000030MXPQA2"} };
    }

	@DataProvider(name = "multipleUsers")
    public static Object[][] dataProviderMethod() 
    {
		/*
		Ian Krekelberg 		= 0050R000000XRFmQAO
		Travis Adams 		= 0050R000000tUilQAE
		Andrew Kovalcik  	= 0050R000000XRHEQA4
		Robert Fitzpatrick 	= 0050R000000XRHYQA4
		Rachel Alandzes 	= 0050R000000kTdBQAU 
		Allison Boyd		= 0050R0000030MXPQA2 
		*/
		return new Object[][] { { "0050R000000tUilQAE" }, { "0050R000000XRFmQAO" } };
    }


}
