package com.vfislk.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
	
	/* This is common method for all sheets in datasheet only condition is Sheetname should be
	same to corresponding method fo this we are using Method Class their are lots of functionality
	comes under like getparametercounts*/
	@DataProvider
	public Object[][] commonDataProvider(Method method) throws IOException
	{
		 String testMethodName=method.getName();		
		 Object[][] main= ExcelUtils.getSheetIntoObjectArray("src/test/resources/testdata/OpenEMRData.xlsx", testMethodName);
		 return main;
	}
	
	
	//Below method will required each method for each sheet so use common method i.e above one 
/*	@DataProvider
	public Object[][] addPatientData() throws IOException
	{
		 Object[][] main= ExcelUtils.getSheetIntoObjectArray("src/test/resources/testdata/OpenEMRData.xlsx", "addPatientTest");
		 return main;
	}
	
	@DataProvider
	public Object[][] invalidCredentialData() throws IOException
	{
		 Object[][] main= ExcelUtils.getSheetIntoObjectArray("src/test/resources/testdata/OpenEMRData.xlsx", "invalidCredentialTest");
		 return main;
	}                                    */
	@DataProvider
	public Object[][] validCredentialData()
	{
		Object[][] main=new Object[3][4];
		main[0][0]="admin";
		main[0][1]="pass";
		main[0][2]="English (Indian)";
		main[0][3]="OpenEMR";
		
		main[1][0]="physician";
		main[1][1]="physician";
		main[1][2]="English (Indian)";
		main[1][3]="OpenEMR";
		
		main[2][0]="accountant";
		main[2][1]="accountant";
		main[2][2]="English (Indian)";
		main[2][3]="OpenEMR";
		
		return main;
	}

}
