package com.vfislk.openemrtest;

import org.testng.annotations.Test;

import com.vfislk.com.openemrPage.DashboardPage;
import com.vfislk.com.openemrPage.LoginPage;
import com.vfislk.com.openemrPage.PatientFinderPage;
import com.vfislk.openemrbase.WebDriverWrapper;
import com.vfislk.utils.DataProviderUtils;
	
public class PatientTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "commonDataProvider")
	public void addPatientTest(String username,String password,String language,String firstname,String lastname,String dob,String gender,String expectedAlertText,String expectedValue)
	{
		//LoginPage
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanguageByText(language);
		login.clickOnLogin();
			
		DashboardPage dashboard=new DashboardPage(driver);
		PatientFinderPage patientfinder=new PatientFinderPage(driver);
		
		dashboard.mousehoverOnPatientClient();
		dashboard.clickpatientElement();
		
		patientfinder.	addnewPatient();
		
	}

}