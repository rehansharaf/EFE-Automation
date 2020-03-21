package com.crm.qa.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.crm.qa.base.*;

public class ReadFromExcel extends TestBase {

	InitializeUserData 	initializeData = new InitializeUserData(); 
	Properties cloned = (Properties)prop.clone();

	
	
	
    	public static Object[][] readExcel() throws InvalidFormatException, IOException {
            
    		String filePath = prop.getProperty("ExcelFilePath");
    		String sheetName = prop.getProperty("ExcelSheetName");
  	    
    		FileInputStream file= new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheet(sheetName);
           
            int rowCount = sheet.getLastRowNum();
            int column = sheet.getRow(0).getLastCellNum();
            
            Object[][] data = new Object[rowCount][column];
            
            for (int i = 1; i <= rowCount; i++) {
                XSSFRow row = sheet.getRow(i);
                	
                for (int j = 0; j < column; j++) {
	                   
                	XSSFCell cell = row.getCell(j);
	                DataFormatter formatter = new DataFormatter();
	                String val = formatter.formatCellValue(cell);
	                data[i - 1][j] = val;
	                
	              }
            }

            return data;
        }


}