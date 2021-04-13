package com.orange.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.orange.qa.base.TestBase;
import com.orange.qa.pages.DashboardPage;
import com.orange.qa.pages.LoginPage;
import com.orange.qa.util.TestUtil;


public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initilazation();
		loginPage = new LoginPage();
	}
	@Test(priority = 1)
	public void verifyPageTitle() {
		log.info("-------------VerifyPageTitle Test Case-----");
		String loginPageTitle = loginPage.validateTitle();
		Assert.assertEquals(loginPageTitle, "OrangeHRM");
		
	}
	@Test(priority = 2)
	public void validateLogin() {
		log.info("-------------VerifyLogin Test Case-----");
		dashboardPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 3)
	public void verifyForgotLink() {
		log.info("-------------VerifyForgotLink Test Case-----");
		loginPage.validateForgotPasswordLink();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtil.captureScreenshotTest();;
		}
		driver.quit();
	}
}