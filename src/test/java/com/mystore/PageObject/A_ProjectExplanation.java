package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_ProjectExplanation
{
	// 1- we have create a maven project
	// 2- when we create maven Project then folder structure is automatically created
	// Create different folders like:- Configuration, Drivers, Logs, ScreenShot etc.//
	// 3- so in src/test/java folder- we create a PageObject package
	// 4- in that package we create separate pom classes
//************************************************************************************ //	
	
	// 5- first we declared web driver as globally
		// WebDriver ldriver; //(globally declared)
	
	// - in each class very first we create object of web driver
		//  WebDriver ldriver; //(ldriver=localdriver)
//********************************************************************************************//
	
	// 6- then create a constructor of class in that class with the help of pagefactory.initElemetns method we
	  // initialize all the web element methods in every pom class
	
		//	public indexPage(WebDriver rdriver)
		//	{
		//		ldriver = rdriver; //(rdriver: this is webdriver instance which is used for initialized all element via browser)
			
		//		PageFactory.initElements(rdriver, this); (// initialize all the web element methods in every pom class)
	
		//	}
//*******************************************************************************************************//

	// 7- now inspect the web element with the help of @FindBy annotation
	// Ex:- @FindBy(linkText = "Sign in")
			//WebElement signIn;
	
	// 8- then create multiple methods as per the functionality & perform action
		// on web element
		//Ex:- public void ClickOnSignIn()
//	{
//		signIn.click();
//	}
	
	// 9 - now same this way create multiple pom classes.
	
//*************************************************************************************//
	
// 10- now create 1 file in configuration folder file name is config.properties
		// and in that maintained all comman code which are used in everywhere for ex. application url, browsers, ID & passwords etc

	// 11 -in configuration folder properties file has created but now we want to read that file so for that we have already created one package in src/test/java
		// in that we created utilites package so in that package we can read the config.propertis file
	
	//12 - now start creating test cases for that in src/test/java we have created on package, name is com.mystore.TestCases
		// note -before writing test cases first create base class

// 13- in src/main/resources maintain log4j2.properties file
// 14 - now create test cases and extneds base class in it

}
