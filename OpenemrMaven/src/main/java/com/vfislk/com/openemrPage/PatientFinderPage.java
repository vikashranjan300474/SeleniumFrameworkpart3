package com.vfislk.com.openemrPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientFinderPage {

	private By patFrameLocator=By.xpath("//iframe[contains(@src,'dynamic_finder')]");
	private By addnewPatientLocator=By.xpath("//button[normalize-space()='Add New Patient']");
	
	//VVI Provider WebDriver and WebDriver constructor in each Page class with this keyword to call current class
		private WebDriver driver;
		public PatientFinderPage(WebDriver driver)
		{
			this.driver=driver;
		}
	
	public void addnewPatient()
	{
		driver.switchTo().frame(driver.findElement(patFrameLocator));	
		driver.findElement(addnewPatientLocator).click();	
		driver.switchTo().defaultContent();
	}
	
}
