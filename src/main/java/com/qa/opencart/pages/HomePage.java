package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	Page page;
	
	//1. String Locator = OR
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "//a[normalize-space()='Login']";
	private String myAccountLink = "a[title='My Account']";
	
	//2. page constructor
	public HomePage(Page page) {
		this.page = page;
	}
	
	//3. page action/methods:
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("page title: " + title);
		return title;
	}
	
	public String getHomePageURL() {
		String url = page.url();
		System.out.println("url: " + url);
		return url;
	}
	
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String header = page.textContent(searchPageHeader);
		System.out.println("search header: " + header);
		return header;
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}
}

