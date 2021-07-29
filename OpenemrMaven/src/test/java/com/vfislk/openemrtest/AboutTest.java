package com.vfislk.openemrtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vfislk.com.openemrPage.AboutOpenEMRPage;
import com.vfislk.com.openemrPage.DashboardPage;
import com.vfislk.com.openemrPage.LoginPage;
import com.vfislk.openemrbase.WebDriverWrapper;
import com.vfislk.utils.DataProviderUtils;


public class AboutTest extends WebDriverWrapper {
	
	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "commonDataProvider")
	public void checkHeaderAndVersionTest(String username,String password,String language,String expectedHeader,String expectedVersionNumber)
	{
		LoginPage login=new LoginPage(driver);	
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanguageByText(language);
		login.clickOnLogin();
		
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.clickOnAbout();

		AboutOpenEMRPage aboutPage=new AboutOpenEMRPage(driver);
		Assert.assertEquals(aboutPage.getHeaderText(), expectedHeader,"Assertion on header");
		Assert.assertEquals(aboutPage.getVersionNumberText(), expectedVersionNumber,"Assertion on version number");
	}
}
