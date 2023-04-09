package com.demowebshop.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import com.demowebshop.qa.base.Base;
import com.demowebshop.qa.pages.RegisterPage;
import com.demowebshop.qa.utils.Utilities;

public class Register extends Base{
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL("chrome");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void registerUser() {
		
		RegisterPage Register = new RegisterPage(driver);
		
		//Click on Register Link
		Register.ClickOnRegister();
		
		//Enter Registration Details
		Register.EnterRegistrationDetails(prop.getProperty("FirstName"), prop.getProperty("LastName"), Utilities.generateEmailWithTimeStamp(), prop.getProperty("password"), prop.getProperty("password"));
		
		//Validate the confirmation Message
		Register.ConfirmationMessage(prop.getProperty("registrationSuccessMessage"));
		
	}
}
