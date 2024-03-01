package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount 
{
	WebDriver ldriver;
	
	public myAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//inspect all web element
	@FindBy(id="email_create")
	WebElement emailId;
	
	@FindBy(id="SubmitCreate")
	WebElement createAccount;
	
	
	//now perform action on them
	public void enterEmailId(String emailAddress)
	{
		emailId.sendKeys(emailAddress);
	}
	
	public void clickOnCreateAnAccount()
	{
		createAccount.click();
	}
	
	
	// inspect web element on already registered
		@FindBy(id="email")
		WebElement email;
		
		
		@FindBy(id="passwd")
		WebElement password;
		
		@FindBy(id="SubmitLogin")
		WebElement signInBtn;

		// now perform action on them
		public void enterEmailInAlreadySignInPage(String emailid)
		{
			email.sendKeys(emailid);
		}
		
		public void enterPasswordInAlreadySignInPage(String enterpassword)
		{
			password.sendKeys(enterpassword);
		}

		public void clickOnSignInBtn()
		{
			signInBtn.click();
		}









}

