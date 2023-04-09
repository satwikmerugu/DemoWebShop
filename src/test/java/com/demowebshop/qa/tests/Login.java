package com.demowebshop.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.demowebshop.qa.base.Base;
import com.demowebshop.qa.pages.LoginPage;
import com.demowebshop.qa.utils.Utilities;

public class Login extends Base{
	
	public WebDriver driver;
	
	public Login() {
		
		//Call to super class i.e., Base.java to use the methods
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		//To initialize the browser instance
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		//To close all browser instances
		driver.quit();
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		//Fetch data from Excel sheet to perform data driven testing
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	@Test(priority=1,dataProvider = "validCredentialsSupplier")
	public void LoginWithValidCredentials(String Email,String Password) {
		
		//To call Page object methods of LoginPage
		LoginPage Login = new LoginPage(driver);
		
		//Login with correct credentials
		Login.ClickOnLogin();
		Login.EnterLoginCredentials(Email, Password);
		
		//Validate if login is successful by validating logout button
		Login.validateLogOut();
		Login.ClickOnLogout();
	}
	
	@Test(priority=2)
	public void LoginWithInvalidCredentials() {
		
		//To call Page object methods of LoginPage
		LoginPage Login = new LoginPage(driver);
		
		//Login with incorrect credentials
		Login.ClickOnLogin();
		Login.EnterLoginCredentials(prop.getProperty("username"), prop.getProperty("invalidPassword"));
		
		//Validate the error message for login failed
		Login.ValidateErrorMsg();
	}
	
	
}
