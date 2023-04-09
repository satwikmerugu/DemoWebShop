package com.demowebshop.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement login_Link;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement Email;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Log in']")
	private WebElement Login_Btn;
	
	@FindBy(xpath="//a[text()='Log out']")
	private WebElement LogOut;
	
	@FindBy(xpath="//span[contains(text(),'Login was unsuccessful.')]")
	private WebElement Login_Failed_Error;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void ClickOnLogin()
	{
		login_Link.click();
    }
	
	public void ClickOnLogout()
	{
		LogOut.click();
    }
	
	public void EnterLoginCredentials(String UsernameValue, String PasswordValue)
	{
		
		//Enter Email
		Email.sendKeys(UsernameValue);
        //Enter Password
		Password.sendKeys(PasswordValue);
        //Click Login Button
        Login_Btn.click();
	}
	
	public void ValidateErrorMsg()
	{
		Assert.assertTrue(Login_Failed_Error.isDisplayed());
	}
	
	public void validateLogOut()
	{
		Assert.assertTrue(LogOut.isDisplayed());
	}
}
