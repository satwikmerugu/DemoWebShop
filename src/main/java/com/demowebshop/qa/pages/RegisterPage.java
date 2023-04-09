package com.demowebshop.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement Register_Link;
	
	@FindBy(xpath="//input[@id='gender-male']")
	private WebElement Gender_Radio;
	
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement LastName;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement Email;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	private WebElement ConfirmPassword;
	
	@FindBy(xpath="//input[@id='register-button']")
	private WebElement Register_Btn;
	
	@FindBy(xpath="//div[contains(text(),'Your registration completed')]")
	private WebElement RegistrationConfirmationMsg;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void ClickOnRegister() {
		
		Register_Link.click();
		
	}
	
	public void EnterRegistrationDetails(String FirstNameValue,String LastNameValue,String EmailValue,String PasswordValue,String ConfirmPasswordValue) {
		
		Gender_Radio.click();
		
		FirstName.sendKeys(FirstNameValue);
		LastName.sendKeys(LastNameValue);
		//Email.sendKeys(EmailValue);
		Password.sendKeys(PasswordValue);
		ConfirmPassword.sendKeys(ConfirmPasswordValue);
		
		Register_Btn.click();
		
	}
	
	public void ConfirmationMessage(String Message) {
	
		String Msg = RegistrationConfirmationMsg.getText();
		Assert.assertEquals(Msg,Message);
		
	}
}
