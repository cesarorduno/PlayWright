package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	//1. String Locators - OR
	private String emailId = "//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";
	
	//2. page constructor
	public LoginPage(Page page) {
		this.page = page;
	}
	
	//3/ page action/methods:
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotPwsLinkExist() {
		return page.isVisible(forgotPwdLink);
	}
	
	public boolean doLogin(String appUserName, String appPassword) {
		boolean res = false;
		System.out.println("App creds: " + appUserName +  ":" + appPassword);
		page.fill(emailId, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
		if(page.isVisible(logoutLink)) {
			System.out.println("User is logged in successfully....");
			res = true;
		}
		return res;
	}
}
