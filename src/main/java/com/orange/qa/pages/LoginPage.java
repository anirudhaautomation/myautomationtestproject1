package com.orange.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Login Page Repositories
	@FindBy(id = "txtUsername")
	WebElement userName;
	@FindBy(id = "txtPassword")
	WebElement password;
	@FindBy(id = "btnLogin")
	WebElement loginBtn;
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPasswordLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Loging Page Actions Methods
	public String validateURL() {
		return driver.getCurrentUrl();
	}
	public String validateTitle() {
		return driver.getTitle();
	}
	public DashboardPage validateLogin(String user, String pass) {
		userName.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		return new DashboardPage();
	}
	public ForgotPasswordPage validateForgotPasswordLink() {
		forgotPasswordLink.click();
		return new ForgotPasswordPage();
	}
}