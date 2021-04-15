package com.orange.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.qa.base.TestBase;

public class DashboardPage extends TestBase{
	@FindBy(xpath = "//img[@src='/webres_5fee89a90600f2.94309009/orangehrmLeavePlugin/images/ApplyLeave.png']")
	WebElement applyLeave;
	@FindBy(xpath = "//img[@src='/webres_5fee89a90600f2.94309009/orangehrmLeavePlugin/images/MyLeave.png']")
	WebElement myLeave;
	@FindBy(xpath = "//img[@src='/webres_5fee89a90600f2.94309009/orangehrmTimePlugin/images/MyTimesheet.png']")
	WebElement myTimesheet;	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	public String dashboardPageTitle() {
		return driver.getTitle();
	}
	public ApplyLeave verifyApplyLeaveLoads() {
		applyLeave.click();
		return new ApplyLeave();
	}
	public MyLeavePage verifyMyLeaveLoads() {
		myLeave.click();
		return new MyLeavePage();
	}
	public MyTimeSheetPage verifyMyTimeSheetLoad() {
		myTimesheet.click();
		return new MyTimeSheetPage();
	}	
}
