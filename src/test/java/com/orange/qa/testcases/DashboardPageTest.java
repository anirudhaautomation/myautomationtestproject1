package com.orange.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orange.qa.base.TestBase;
import com.orange.qa.pages.ApplyLeave;
import com.orange.qa.pages.DashboardPage;
import com.orange.qa.pages.LoginPage;
import com.orange.qa.pages.MyLeavePage;
import com.orange.qa.pages.MyTimeSheetPage;

public class DashboardPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MyLeavePage myLeavePage;
	ApplyLeave applyLeave;
	MyTimeSheetPage myTimeSheet;
	public DashboardPageTest() {
		super();
	} 
	@BeforeMethod
	public void setup() {
		initilazation();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		myLeavePage = new MyLeavePage();
		myTimeSheet = new MyTimeSheetPage();
		dashboardPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 1)
	public void verifyDashboardPageTitle() {
		String dashboardTitle= dashboardPage.dashboardPageTitle();
		Assert.assertEquals(dashboardTitle, "OrangeHRM");
	}
	@Test(priority = 2)
	public void verifyApplyLeavePageLoad() {
		applyLeave = dashboardPage.verifyApplyLeaveLoads();
	}
	@Test(priority = 3)
	public void verifyMyLeavePageLoad() {
		myLeavePage = dashboardPage.verifyMyLeaveLoads();
	}
	@Test(priority = 4)
	public void verifyMyTimeSheetPageLoad() {
		myTimeSheet = dashboardPage.verifyMyTimeSheetLoad();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
