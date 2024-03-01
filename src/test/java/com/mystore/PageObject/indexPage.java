package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage
{
	// Create object of webdriver
	WebDriver ldriver; //(ldriver=localdriver)
	
	public indexPage(WebDriver rdriver)
	{
		ldriver = rdriver; //(rdriver=remotedriver
		PageFactory.initElements(rdriver, this);
	}
	 
	//now inspect the web-element
	@FindBy(className = "login")
	WebElement signIn;
	
	//perform action on web-element
	public void ClickOnSignIn()
	{
		signIn.click();
	}
	
}
