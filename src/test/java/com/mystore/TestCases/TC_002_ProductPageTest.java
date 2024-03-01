package com.mystore.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mystore.PageObject.indexPage;
import com.mystore.PageObject.myAccount;
import com.mystore.PageObject.registerdUserAccount;
import com.mystore.PageObject.searchResultPage;

public class TC_002_ProductPageTest extends BaseClass
{
	@Test(enabled=true)
	public void VerifySearchProduct() throws IOException
	{
		String ProductName = "T-shirts";
		Logger.info("**********************TestCase Search Product Started*********************************");
		 
		// for SIgnIn
		indexPage ip = new indexPage(driver);
		ip.ClickOnSignIn();
		
		// Enter email & pass
		myAccount myAcc = new myAccount(driver);
		myAcc.enterEmailInAlreadySignInPage("sanket7@gmail.com");
		Logger.info("Email is Entered");
		
		myAcc.enterPasswordInAlreadySignInPage("Jarves@1234");
		Logger.info("Password is Entered");
		
		myAcc.clickOnSignInBtn();
		Logger.info("Clicked on SignIn Btn");
		
		registerdUserAccount registerdUser = new registerdUserAccount(driver);
		
		registerdUser.SearchProductFunctionality(ProductName);
		Logger.info("Entered Product Name");
		registerdUser.ClickOnSearchBtn();
		Logger.info("Clicked on serach btn");

		//get Name of search product
		searchResultPage srp = new searchResultPage(driver);
		String SearchResultProductName = srp.getTshirtProductName();
		
		// verify that correct product is displaying after search
		if(SearchResultProductName.contains(ProductName))
		{
			Logger.info("Search Product Test Case Is Successfully Passed");
			Assert.assertTrue(true);
			registerdUser.clickOnSignOut();
		}
		else
		{
			Logger.info("Search Product Test Case Is Failed");
			captureScreenShot(driver,"VerifySearchProduct");
			Assert.assertTrue(false);
		}
	}
	
	
}
