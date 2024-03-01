package com.mystore.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener
{
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		ReadConfig readconfig = new ReadConfig();
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "E-commerce_MyShop Test_Report-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//ExtentReports//" + reportName);
		//htmlReporter = new ExtentSparkReporter("E-commerce_MyShop Test_Report-");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS", "windows11");
		reports.setSystemInfo("browser:", readconfig.getBrowser());
		reports.setSystemInfo("user name:", "Sanket");
		
		//configuration to change look &  feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("E-comm_MyShop Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("On Start Method Invoked.......");
	}
	
	
	public void onFinish(ITestContext Result)
	{
		System.out.println("On Finish Method Invoked.......");
		reports.flush();
	}
	
	
	
	
	//when test case is failed, this method is called.
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed test case is:" + Result.getName(), ExtentColor.RED));
	
		// if test case get failed then capture screenshot
		String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + Result.getName() + ".png";
		File screenShotFile = new File (screenShotPath);
		
		if (screenShotFile.exists())
		{
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
			
		}
	
	}
	
	
	
	// when test case get skipped, this method is called
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test method skipped:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of skipped test case is:" + Result.getName(), ExtentColor.YELLOW));
	}
	
	// when test case get started, this method is called
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of test method stated:" + Result.getName());
	}
	
	// when test case get passed, this method is called
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of test method sucessfully executed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of passed test case is:" + Result.getName(), ExtentColor.GREEN));

	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
		
	}
}
