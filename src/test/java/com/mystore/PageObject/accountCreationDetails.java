package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails 
{
	WebDriver ldriver;
	
	public accountCreationDetails(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}

		// inspect the web-element

	@FindBy(id="id_gender1")
	WebElement Title;
	
	
	@FindBy(id="customer_firstname")
	WebElement FirstName;
	
	
	@FindBy(id="customer_lastname")
	WebElement LastName;
	
	
	@FindBy(id="passwd")
	WebElement Password;
	
	//Date of birth - dropdown
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement month;
	
	@FindBy(id="years")
	WebElement year;
	
	// click on Register btn
	@FindBy(id="submitAccount")
	WebElement RegisterBtn;

	
	public void ClickOnTitle()
	{
		Title.click();
	}
	
	public void EnterFirstName(String fname)
	{
		FirstName.sendKeys(fname);
		
	}
	
	public void EnterLastName(String lname)
	{
		LastName.sendKeys(lname);
	}
	
	public void EnterPassword(String pass)
	{
		Password.sendKeys(pass);
	}
	
	// now handle date of birth dropdown
	public void EnterDays(String value )
	{
		Select s = new Select(days);
		s.selectByValue(value);
	}
	
	public void EnterMonths(String value)
	{
		Select s = new Select(month);
		s.selectByValue(value);
	}

	public void EnterYears(String value)
	{
		Select s = new Select(year);
		s.selectByValue(value);
	}

	public void ClickOnRegisterdBtn()
	{
		RegisterBtn.click();
	}







}
