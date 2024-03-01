package com.mystore.TestCases;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.PageObject.*;

import junit.framework.Assert;
public class TC_001_MyAccountPageTest extends BaseClass 
{
	@Test(enabled=false)// suppose u want to disable any test case then use (enabled=false)
	public void verifyRegistrationAndLogin()
	{
		
		
		// now we have to click on signIn btn
		// we already inspect sign in btn in indexPage class
		// so first create object of that class and call all methods 
		indexPage ip = new indexPage(driver);
		ip.ClickOnSignIn();
		Logger.info("Click on SignIn Btn");
		
		// now we are switched to myAccount page
		//in that page we have to enter email address in textbox
		//so in myAccount class we already inspect text box and create methods so call directly
		myAccount ma = new myAccount(driver);
		ma.enterEmailId("sanket7@gmail.com");
		Logger.info("Email is Entered");
		ma.clickOnCreateAnAccount();
		Logger.info("Click on CreateAnAccount Btn");
		
		//account creation details page
		accountCreationDetails accountCreation = new accountCreationDetails(driver);
		accountCreation.ClickOnTitle();
		Logger.info("Clicked on MR");
		
		accountCreation.EnterFirstName("Tony");
		Logger.info("First Name is Entered");
		
		accountCreation.EnterLastName("Stark");
		Logger.info("Last Name is Entered");
		
		accountCreation.EnterPassword("Jarves@1234");
		Logger.info("Password is Entered");
		
		accountCreation.EnterDays("11");
		Logger.info("Days Entered");
		
		accountCreation.EnterMonths("10");
		Logger.info("Months Entered");
		
		accountCreation.EnterYears("2000");
		Logger.info("Year is Entered");
		
		accountCreation.ClickOnRegisterdBtn();
		Logger.info("Successfully Clicked On Register Btn");
	
	
		// Registered user page
		registerdUserAccount registerdUser = new registerdUserAccount(driver);
		String username = registerdUser.getUser(); // Because it return username so we stored in ref variable
		Logger.info(username);
		//for validation use assertion concept
		Assert.assertEquals("Tony Stark", username);
	
	}
	@Test
	public void VerifyLogin() throws IOException
	{
		indexPage ip = new indexPage(driver);
		ip.ClickOnSignIn();
		Logger.info("Click on SignIn Btn");
		
		
		myAccount myAcc = new myAccount(driver);
		myAcc.enterEmailInAlreadySignInPage("sanket7@gmail.com");
		Logger.info("Email is Entered");
		
		myAcc.enterPasswordInAlreadySignInPage("Jarves@1234");
		Logger.info("Password is Entered");
		
		myAcc.clickOnSignInBtn();
		Logger.info("Clicked on SignIn Btn");
		

		// Registered user page
		registerdUserAccount registerdUser = new registerdUserAccount(driver);
		String username = registerdUser.getUser();
		if(username.equals("Tony Stark"))
		{
			Logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
		}
		else
		{
			Logger.info("VerifyLogin - Failed");
			captureScreenShot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}