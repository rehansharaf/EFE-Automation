package com.qa.DataProvider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.util.ReadFromExcel;

public class DataloadFromExcel {

	//public class DataProviderDemo {

	 //   private String filePath = "C:\\Users\\ISharaf\\Desktop\\RandomFirstLastNames.xlsx";
	 //   private String sheetName = "Names";

/*	    
	    @Test(dataProvider = "excelData")
	    public void read(String username, String password) {
	        System.out.println(username + ":" + password);

	    }
*/
	    @DataProvider(name="excelData")
	    public Object[][] readExcel() throws InvalidFormatException, IOException {
	        return ReadFromExcel.readExcel();
	    }

	}
//}