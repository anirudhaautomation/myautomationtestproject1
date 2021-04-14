package com.orange.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orange.qa.base.TestBase;

public class AssignLeavePage extends TestBase{
	//Leave sub Module list Components Webelements
	@FindBy(xpath = "//a[@id='menu_leave_applyLeave']")
	WebElement leaveApply;
	@FindBy(xpath = "//a[@id='menu_leave_viewMyLeaveList']")
	WebElement leaveMyleave;
	@FindBy(xpath = "//a[@id='menu_leave_Entitlements']")
	WebElement leaveEntitlements;
	@FindBy(xpath = "//a[@id='menu_leave_Reports']")
	WebElement leaveReports;
	@FindBy(xpath = "//a[@id='menu_leave_Configure']")
	WebElement leaveConfigure;
	@FindBy(xpath = "//a[@id='menu_leave_viewLeaveList']")
	WebElement leaveLeavelist;
	@FindBy(xpath = "//a[@id='menu_leave_assignLeave']")
	WebElement leaveAssignleave;
	// Assign leave Form Components webelemnts
	@FindBy(xpath = "//input[@id = 'assignleave_txtEmployee_empName']")
	WebElement employeeName;
	@FindBy(xpath = "//select[@id='assignleave_txtLeaveType']")
	WebElement leaveType;
	@FindBy(xpath = "//div[@id='assignleave_leaveBalance']")
	WebElement leaveBalance;
	@FindBy(xpath = "//input[@id='assignleave_txtFromDate']")
	WebElement formDate;
	@FindBy(xpath = "//input[@id='assignleave_txtToDate']")
	WebElement toDate;
	@FindBy(xpath = "//textarea[@id = 'assignleave_txtComment']")
	WebElement comments;
	@FindBy(xpath = "//select[@id='assignleave_partialDays']")
	WebElement partialDay;
	@FindBy(xpath = "//input[@id='assignBtn']")
	WebElement assignBtn;
	public AssignLeavePage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyAssignLeaveComponentVisible() {
		System.out.println("Employee name =" + employeeName);
		if(employeeName.isDisplayed() && leaveType.isDisplayed() && 
				leaveBalance.isDisplayed() && formDate.isDisplayed() &&
				toDate.isDisplayed() && comments.isDisplayed() && assignBtn.isDisplayed())
		return true;
		return false;
	}
	public void assignLeaveFormEntry(String EmpName, String leaveType, String leaveFrom, 
			String leaveTo, String partialDays,String comments) {
		employeeName.sendKeys(EmpName);
		Select select = new Select(this.leaveType);
		select.selectByVisibleText(leaveType);
		System.out.println("leaveType: " + leaveType);
		formDate.clear();
		formDate.sendKeys(leaveFrom);
		toDate.clear();
		toDate.sendKeys(leaveTo);
		Select select2 = new Select(partialDay);
		select2.selectByVisibleText(partialDays);
		this.comments.sendKeys(comments);
	}
}
