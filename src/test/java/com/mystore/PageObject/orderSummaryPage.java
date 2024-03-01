package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderSummaryPage
{

	WebDriver ldriver;
	
	public orderSummaryPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="a[class='button btn btn-default standard-checkout button-medium'] span")
	WebElement proceedToCheckoutBtn;
	
	
	public void clickOnproceedToCheckoutBtn()
	{
		proceedToCheckoutBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
