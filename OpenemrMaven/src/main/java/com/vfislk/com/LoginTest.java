package com.vfislk.com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vfislk.com.openemrPage.DashboardPage;
import com.vfislk.com.openemrPage.LoginPage;
import com.vfislk.openemrbase.WebDriverWrapper;
import com.vfislk.utils.DataProviderUtils;

	
public class LoginTest extends WebDriverWrapper {
	
	
	@Test
	public void invalidCredentialTest()
	{		
        LoginPage login=new LoginPage(driver);
		
		login.enterUsername("admin123");
		login.enterPassword("pass");
		login.selectLanguageByText("English (Indian)");	
		login.clickOnLogin();
		
		Assert.assertEquals(login.getInvalidErrorMessage(), "Invalid username or password");
	}
	
	@Test(description = "Valid Credential Test",dataProviderClass=DataProviderUtils.class,dataProvider= "validCredentialData")
	public void validCredentialTest(String username,String password,String language,String expectedmssg)
	{		
		LoginPage login=new LoginPage(driver);
		
		login.enterUsername("admin");
		login.enterPassword("pass");
		login.selectLanguageByText("English (Indian)");	
		login.clickOnLogin();
		
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.waitForPresenceOfCalendarText();
		
		String actualValue=driver.getTitle();	
		
		
		Assert.assertEquals(actualValue,"OpenEMR");		
			
	}	
		
	
	
	
	
}