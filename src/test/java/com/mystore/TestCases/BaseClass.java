package com.mystore.TestCases;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import com.mystore.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass 
{
	//first we have to read config file so that we already created
	// one class for that which is readConfig class, located in Utilities package
	// create object of readconfig class
	
	ReadConfig readconfig = new ReadConfig();
	
	String url = readconfig.getBaseUrl();
	String browser = readconfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger Logger;
	
	
//	@BeforeClass
//	public void setup()
//	{
//		switch(browser.toLowerCase())
//		{
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//	     driver.manage().window().maximize();
//			break;
//		
//		case "msedge" :
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//			break;
//			
//		case "firefox" :
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			break;
//			
//		default :
//			driver = null;
//			break;
//			}
//
//	}
	@BeforeClass
	public void setup()
	{
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		 if ("chrome".equalsIgnoreCase(browser)) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            driver.manage().window().maximize();
	        } else if ("msedge".equalsIgnoreCase(browser)) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        } else if ("firefox".equalsIgnoreCase(browser)) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        } else {
	            System.out.println("Unsupported browser: " + browser);
	            driver = null;
		
	        }
		
		// now add implicit wait- implicit wait is applicable for all element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//now login is also common functionality so we can add them in to it
		// for that we use log4j
	  Logger = LogManager.getLogger("E-commerce_MyShop");
	  
	// first open url
			driver.get(url);
			Logger.info("URL is Opened");
	
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

	// code for screenshot
	public void captureScreenShot(WebDriver driver, String testname) throws IOException
	{
		// step1 :- convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		//step2:- call getScreenshotAs method to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//ScreenShots//" + testname + ".png");
		
		//step3:- copy image file to destination
		FileUtils.copyFile(src, dest);
	}



}
