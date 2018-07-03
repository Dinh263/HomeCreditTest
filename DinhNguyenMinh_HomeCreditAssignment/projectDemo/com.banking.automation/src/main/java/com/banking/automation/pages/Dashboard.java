package com.banking.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.banking.automation.base.BasePage;

public class Dashboard extends BasePage {
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement menuNewCustomer;
	

	@FindBy(xpath="//a[text()='New Account']")
	WebElement menuNewAccount;
	

	@FindBy(xpath="//a[text()='Deposit']")
	WebElement menuDeposit;
	
	public Dashboard(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public NewCustomerPage selectMenuNewCustomer() throws NumberFormatException, IOException {
		clickOnElement(menuNewCustomer);
		return new NewCustomerPage(driver);
	}
	
	public NewAccountPage selectMenuNewAccount() throws NumberFormatException, IOException {
		clickOnElement(menuNewAccount);
		return new NewAccountPage(driver);
	}
	
	public DepositPage selectMenuDeposit() throws NumberFormatException, IOException {
		clickOnElement(menuDeposit);
		return new DepositPage(driver);
	}
	
	
}
