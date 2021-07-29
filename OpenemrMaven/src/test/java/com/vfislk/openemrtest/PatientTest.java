package com.vfislk.openemrtest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vfislk.com.openemrPage.DashboardPage;
import com.vfislk.com.openemrPage.LoginPage;
import com.vfislk.com.openemrPage.PatientDashboardPage;
import com.vfislk.com.openemrPage.PatientFinderPage;
import com.vfislk.com.openemrPage.SearchOrAddPatientPage;
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
		
		//DashboardPage
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.mousehoverOnPatientClient();
		dashboard.clickOnPatients();
		
		//PatientFinderPage
		PatientFinderPage pf=new PatientFinderPage(driver);
		pf.clickOnAddPatient();
		
		//SearchOrAddPatientPage
		SearchOrAddPatientPage search=new SearchOrAddPatientPage(driver);
		search.switchToPatFrame();
		
		driver.findElement(By.id("form_fname")).sendKeys(firstname);
		driver.findElement(By.id("form_lname")).sendKeys(lastname);	
		driver.findElement(By.id("form_DOB")).sendKeys(dob);		
		Select selectGender=new Select(driver.findElement(By.id("form_sex")));
		selectGender.selectByVisibleText(gender);
		driver.findElement(By.id("create")).click();
		
		driver.switchTo().defaultContent();
		
		search.clickOnConfirmCreateNewPatient();
		
		String actualAlertText=search.handleAlertAndGetText();
	
		search.clickOnHBDClose();
		
		//PatientDashboardPage
		PatientDashboardPage pdp=new PatientDashboardPage(driver);
		
//		String actualValue= pdp.getAddedPatientName();
		//should be in this test method only
		//assertion on alert
		Assert.assertTrue(actualAlertText.contains(expectedAlertText));
		//assertion on patient name
		Assert.assertEquals(pdp.getAddedPatientName(), expectedValue); 
	}
	
}