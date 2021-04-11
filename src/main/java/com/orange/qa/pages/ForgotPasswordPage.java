package com.orange.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.orange.qa.base.TestBase;

public class ForgotPasswordPage extends TestBase{
	
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
}
