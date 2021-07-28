package com.vfislk.openemrtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vfislk.com.openemrPage.DashboardPage;
import com.vfislk.com.openemrPage.LoginPage;
import com.vfislk.openemrbase.WebDriverWrapper;
import com.vfislk.utils.DataProviderUtils;

	
public class LoginTest extends WebDriverWrapper {
	
	
	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "commonDataProvider")
	public void addPatientTest(String username,String password,String language,String firstname,String lastname,String dob,String gender,String expectedAlertText,String expectedValue)
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanguageByText(language);
		login.clickOnLogin();

		Assert.assertEquals(login.getInvalidErrorMessage(), expectedValue);
	}
	
	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "validCredentialData",description = "Valid Credential Test")
	public void validCredentialTest(String username,String password,String language,String expectedValue) {
	
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanguageByText(language);
		login.clickOnLogin();

		
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.waitForPresenceOfCalendarText();
		
		String actualValue=driver.getTitle();	
		
		
		Assert.assertEquals(actualValue,"OpenEMR");		
			
	}	
		
	
	
	
	
}