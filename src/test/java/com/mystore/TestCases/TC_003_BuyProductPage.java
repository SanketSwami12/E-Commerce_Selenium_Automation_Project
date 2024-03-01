package com.mystore.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.PageObject.indexPage;
import com.mystore.PageObject.myAccount;
import com.mystore.PageObject.registerdUserAccount;
import com.mystore.PageObject.searchResultPage;

public class TC_003_BuyProductPage extends BaseClass
{
	@Test(enabled=true)
	public void VerifyBuyProduct() throws IOException
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
		Logger.info("Test case is Finished");

		

}
}
