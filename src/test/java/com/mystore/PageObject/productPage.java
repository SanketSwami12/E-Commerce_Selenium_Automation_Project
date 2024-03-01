package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productPage
{

	WebDriver ldriver;
	
	public productPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="group_1")
	WebElement Size;
	
	@FindBy(id="quantity_wanted")
	WebElement quantityWanted;
	
	@FindBy(linkText="Add to cart")
	WebElement AddToCartBtn;
	
	@FindBy(linkText="Proceed to checkout")
	WebElement ProceedToCheckoutBtn;
	
	public void setQuantity(String qty)
	{
		quantityWanted.clear();
		quantityWanted.sendKeys(qty);
	}

	public void setSize(String sizeType)
	{
		Select s = new Select(Size);
		
		s.selectByValue(sizeType);
	}
	
	public void clickOnAddToCartBtn()
	{
		AddToCartBtn.click();
	}
	
	public void clickOnProceedToCheckOutBtn()
	{
		ProceedToCheckoutBtn.click();
	}
	
}
