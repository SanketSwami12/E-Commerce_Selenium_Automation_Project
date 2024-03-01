package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerdUserAccount 
{
	WebDriver ldriver;
	
	public registerdUserAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}

	// find out web elements
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement User;
	
	@FindBy(css="a[title='Log me out']")
	WebElement signOut;
	
	// Search field
		@FindBy(id="search_query_top")
		WebElement SearchProduct;
		@FindBy(css="button[name='submit_search']")
		WebElement SearchBtn;
		public void SearchProductFunctionality(String ProductName)
		{
			SearchProduct.sendKeys(ProductName);
		}
		
		public void ClickOnSearchBtn()
		{
			SearchBtn.click();
		}
		
	
	public void clickOnSignOut()
	{
		signOut.click();
	}
	
	public String getUser()
	{
	 String text = User.getText();
		return text;
	}
	
	
}
