package com.orange.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orange.qa.base.TestBase;
import com.orange.qa.pages.DashboardPage;
import com.orange.qa.pages.LoginPage;
import com.orange.qa.util.TestUtil;

public class AssignLeavePageTest extends TestBase{
	Logger log = Logger.getLogger(AssignLeavePageTest.class);
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public AssignLeavePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initilazation();
		loginPage = new LoginPage();
		dashboardPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 1)
	public void verifyAssignLeaveComponentes() {
		//boolean componentsDisplayed = ;
	//	Assert.assertEquals(componentsDisplayed, true);
	}
	@Test(priority = 2)
	public void verifyleaveForm() {
//		assignLeavePage = dashboardPage.verifyAssignLeavePageLoads();
//		assignLeavePage.assignLeaveFormEntry("abc", "CAN - Personal", "2020-04-02", "2021-04-05","All Days", "test leave");
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			TestUtil.captureScreenshotTest();;
		}
		driver.quit();
	}
}
