package com.guru99.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest {
	
	@Parameters({"username", "pass"})
	
	@Test
	public void verifyLoginWithCorrectCredentials(String user, String pass) {
		
		reportUtils.createTestCase("Verify Login With Correct Credentials");
		reportUtils.addTestLog(Status.INFO, "Performing Log");
		
		loginpage.loginToApp(user, pass);
		
		String expectedTitle = "Guru99 Bank Manager Home Page";
		String actualTitle = cmnDriver.getTitleOfThePage();
		
		reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
