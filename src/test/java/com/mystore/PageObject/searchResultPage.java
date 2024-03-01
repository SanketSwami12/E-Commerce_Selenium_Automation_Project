package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchResultPage 
{
WebDriver ldriver;
	
	public searchResultPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts'][normalize-space()='Faded Short Sleeve T-shirts']")
	WebElement TshirtProduct;
	
	@FindBy(linkText="More")
	WebElement morebtn;
	
	public void ClickOnMoreBtn()
	{
		morebtn.click();
	}
	
	
	public String getTshirtProductName()
	{
		return(TshirtProduct.getText());
	}
	
	
	
	
	
	
	
}
