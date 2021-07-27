package com.vfislk.com;

import org.testng.annotations.Test;

import com.vfislk.com.openemrPage.DashboardPage;
import com.vfislk.com.openemrPage.PatientFinderPage;
import com.vfislk.openemrbase.WebDriverWrapper;
	
public class PatientTest extends WebDriverWrapper {

	@Test
	public void addPatientTest()
	{	
		DashboardPage dashboard=new DashboardPage(driver);
		PatientFinderPage patientfinder=new PatientFinderPage(driver);
		
		dashboard.mousehoverOnPatientClient();
		dashboard.clickpatientElement();
		
		patientfinder.	addnewPatient();
		
	}

}