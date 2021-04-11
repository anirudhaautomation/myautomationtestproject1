package com.orange.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.qa.base.TestBase;

public class DashboardPage extends TestBase{
	@FindBy(xpath = "(//img[@src='/webres_5fee89a90600f2.94309009/orangehrmLeavePlugin/images/ApplyLeave.png'])[1]")
	WebElement assignLeave;
	@FindBy(xpath = "(//img[@src='/webres_5fee89a90600f2.94309009/orangehrmLeavePlugin/images/MyLeave.png'])[1]")
	WebElement leaveList;
	@FindBy(xpath = "(//img[@src='/webres_5fee89a90600f2.94309009/orangehrmTimePlugin/images/MyTimesheet.png'])[1]")
	WebElement timesheets;
	@FindBy(xpath = "(//img[@src='/webres_5fee89a90600f2.94309009/orangehrmLeavePlugin/images/ApplyLeave.png'])[2]")
	WebElement applyLeave;
	@FindBy(xpath = "(//img[@src='/webres_5fee89a90600f2.94309009/orangehrmLeavePlugin/images/MyLeave.png'])[2]")
	WebElement myLeave;
	@FindBy(xpath = "(//img[@src='/webres_5fee89a90600f2.94309009/orangehrmTimePlugin/images/MyTimesheet.png'])[2]")
	WebElement myTimesheet;
	@FindBy(xpath = "//canvas[@class=\'flot-overlay\']")
	WebElement employeeDistribution;
	@FindBy(xpath = "//div[@id='div_legend_pim_employee_distribution_legend']")
	WebElement legend;
	@FindBy(xpath = "//div[@id='task-list-group-panel-menu_holder']")
	WebElement pendingLeaveRequest;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	public String dashboardPageTitle() {
		return driver.getTitle();
	}
	public AssignLeavePage verifyAssignLeavePageLoads() {
		assignLeave.click();
		return new AssignLeavePage();
	}
	public LeaveListPage verifyLeaveListLoads() {
		leaveList.click();
		return new LeaveListPage();
	}
	public TimeSheetsPage verifyTimeSheetsLoads() {
		timesheets.click();
		return new TimeSheetsPage();
	}
	public ApplyLeavesPage verifyApplyLeaveLoads() {
		applyLeave.click();
		return new ApplyLeavesPage();
	}
	public MyLeavePage verifyMyLeaveLoads() {
		myLeave.click();
		return new MyLeavePage();
	}
	public MyTimeSheet verifyMyTimeSheetLoad() {
		myTimesheet.click();
		return new MyTimeSheet();
	}
	public boolean verifyEmployeeDistributionLoads() {
		Boolean isEmpDisplayed = employeeDistribution.isDisplayed();
		return isEmpDisplayed;
	}
	public boolean verifyLegendDisplayed() {
		Boolean isLegendDisplayed = legend.isDisplayed();
		return isLegendDisplayed;
	}
	public boolean verifyPendingLeavesDisplayed() {
		Boolean isPendingLeavesDisplayed = pendingLeaveRequest.isDisplayed();
		return isPendingLeavesDisplayed;
	}
	
}
