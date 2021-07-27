package com.vfislk.com.openemrPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private By calendarLocator=By.xpath("//span[text()='Calendar']");
	private By patientClientLocator=By.xpath("//div[text()='Patient/Client']");
	private By patientLocator=By.xpath("//div[text()='Patients']");
	
	//VVI Provider WebDriver and WebDriver constructor in each Page class with this keyword to call current class
	private WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void waitForPresenceOfCalendarText()
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(calendarLocator)).click();
		
	}

    public void mousehoverOnPatientClient() 
    {
    	Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(patientClientLocator)).perform();
		driver.findElement(patientClientLocator).click();
	
    }
    
    public void clickpatientElement()
    {
    	driver.findElement(patientLocator).click();
    }
	

}
