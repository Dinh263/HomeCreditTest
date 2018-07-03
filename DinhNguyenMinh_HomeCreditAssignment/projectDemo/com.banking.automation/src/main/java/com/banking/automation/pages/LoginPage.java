package com.banking.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.banking.automation.base.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(name="uid")
	WebElement txtUserName;	
	
	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(xpath="//input[@value='LOGIN']")
	WebElement btnLogin;
	
	public LoginPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public Dashboard loginToApplication(String username, String password) throws NumberFormatException, IOException {
		enterTextOnElement(txtUserName, username);
		enterTextOnElement(txtPassword, password);
		clickOnElement(btnLogin);
		return new Dashboard(driver);
	}
	
	

}
