package com.guru99.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.guru99.pages.LoginPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.util.ConfigUtils;
import commonLibs.util.ReportUtils;
import commonLibs.util.ScreenshotUtils;

public class BaseTest {
	
	CommonDriver cmnDriver;
	WebDriver driver;
	
	String url;
	
	LoginPage loginpage;
	
	String currentWorkingDirectory;
	String configFileName;
	Properties configProperty;
	
	String reportFileName;
	ReportUtils reportUtils;
	
	ScreenshotUtils screenshot;
	
	@BeforeSuite
	public void preSetUp() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");
		
		configFileName = currentWorkingDirectory + "/config/config.properties";
		
		reportFileName = currentWorkingDirectory + "/reports/guru99TestReport.html";
		
		configProperty = ConfigUtils.readProperties(configFileName);
		
		reportUtils = new ReportUtils(reportFileName);
		
	}
	
	@BeforeClass
	public void setUp() throws Exception {
		url = configProperty.getProperty("baseUrl");
		String browserType = configProperty.getProperty("browserType");
		
		cmnDriver = new CommonDriver(browserType);
		driver = cmnDriver.getDriver();
		loginpage = new LoginPage(driver);
		
		screenshot = new ScreenshotUtils(driver);
		
		cmnDriver.navigateToUrl(url);
	}
	
	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception {
		
		String testcasename = result.getName();
		long executionTime = System.currentTimeMillis();
		String screenshotFileName = currentWorkingDirectory + "/screenshots/" + testcasename + executionTime + ".jpeg";
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			reportUtils.addTestLog(Status.FAIL, "One or more steps failed");
			
			screenshot.captureAndSaveScreenshot(screenshotFileName);
			
			reportUtils.attachScreenshot(screenshotFileName);
			
		}
		
	}
	
	
	@AfterClass
	public void tearDown() {
		
		cmnDriver.quitBrowser();
	}
	
	@AfterSuite
	public void postTearDown() {
		reportUtils.flushReport();
		
	}

}
