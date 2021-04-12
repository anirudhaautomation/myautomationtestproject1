package com.orange.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orange.qa.base.TestBase;
import com.orange.qa.pages.ApplyLeavesPage;
import com.orange.qa.pages.AssignLeavePage;
import com.orange.qa.pages.DashboardPage;
import com.orange.qa.pages.LeaveListPage;
import com.orange.qa.pages.LoginPage;
import com.orange.qa.pages.MyLeavePage;
import com.orange.qa.pages.MyTimeSheet;
import com.orange.qa.pages.TimeSheetsPage;

public class DashboardPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AssignLeavePage assignLeavePage;
	LeaveListPage leaveListPage;
	TimeSheetsPage timeSheetsPage;
	ApplyLeavesPage applyLeavesPage;
	MyLeavePage myLeavePage;
	MyTimeSheet myTimeSheet;
	public DashboardPageTest() {
		super();
	} 
	@BeforeMethod
	public void setup() {
		initilazation();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		assignLeavePage = new AssignLeavePage();
		leaveListPage = new LeaveListPage();
		timeSheetsPage = new TimeSheetsPage();
		applyLeavesPage = new ApplyLeavesPage();
		myLeavePage = new MyLeavePage();
		myTimeSheet = new MyTimeSheet();
		dashboardPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority = 1)
	public void verifyDashboardPageTitle() {
		String dashboardTitle= dashboardPage.dashboardPageTitle();
		Assert.assertEquals(dashboardTitle, "OrangeHRM");
	}
	@Test(priority = 2)
	public void verifyAssignLeavePageLoad() {
		assignLeavePage = dashboardPage.verifyAssignLeavePageLoads();
		String assignLeavePageURL = driver.getCurrentUrl();
		Assert.assertEquals(assignLeavePageURL, "https://opensource-demo.orangehrmlive.com/index.php/leave/assignLeave");
	}
	@Test(priority = 3)
	public void verifyLeaveList() {
		leaveListPage = dashboardPage.verifyLeaveListLoads();
		String leaveListURL = driver.getCurrentUrl();
		Assert.assertEquals(leaveListURL, "https://opensource-demo.orangehrmlive.com/index.php/leave/viewLeaveList");
	}
	@Test(priority = 4)
	public void verifyTimeSheets() {
		timeSheetsPage = dashboardPage.verifyTimeSheetsLoads();
		String timeSheetsURL = driver.getCurrentUrl();
		Assert.assertEquals(timeSheetsURL, "https://opensource-demo.orangehrmlive.com/index.php/time/viewEmployeeTimesheet");
	}
	@Test(priority = 5)
	public void verifyApplyLeave() {
		applyLeavesPage = dashboardPage.verifyApplyLeaveLoads();
		String applyLeavesURL = driver.getCurrentUrl();
		Assert.assertEquals(applyLeavesURL, "https://opensource-demo.orangehrmlive.com/index.php/leave/applyLeave");
	}
	@Test(priority = 6)
	public void verifyMyLeave() {
		myLeavePage = dashboardPage.verifyMyLeaveLoads();
		String myLeaveURL = driver.getCurrentUrl();
		Assert.assertEquals(myLeaveURL, "https://opensource-demo.orangehrmlive.com/index.php/leave/viewMyLeaveList");
	}
	@Test(priority = 7)
	public void verifyMyTimeSheetLoads() {
		myTimeSheet = dashboardPage.verifyMyTimeSheetLoad();
		String myTimeSheetURL = driver.getCurrentUrl();
		Assert.assertEquals(myTimeSheetURL, "https://opensource-demo.orangehrmlive.com/index.php/time/viewMyTimesheet");
	}
	@Test(priority = 8)
	public void verifyEmployeeDistributionDisplayed() {
		Boolean empDistributionDisplayed = dashboardPage.verifyEmployeeDistributionLoads();
		Assert.assertTrue(empDistributionDisplayed, "Employee Distribution did not Displayed");
	}
	@Test(priority = 9)
	public void verifyLegendLoad() {
		Boolean isLegendDisplayed = dashboardPage.verifyLegendDisplayed();
		Assert.assertTrue(isLegendDisplayed, "Legend did not displayed");
	}
	@Test(priority = 10)
	public void verifyPendingLeaveDisplayed() {
		Boolean isPendingLeaveDisplayed = dashboardPage.verifyPendingLeavesDisplayed();
		Assert.assertTrue(isPendingLeaveDisplayed, "Pending Leave Request did not Displayed");
	}
	
}
