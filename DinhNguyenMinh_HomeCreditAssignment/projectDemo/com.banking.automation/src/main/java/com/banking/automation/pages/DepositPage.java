package com.banking.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends Dashboard {

	@FindBy(name="accountno")
	WebElement txtAccountNo;	
	
	@FindBy(name="ammount")
	WebElement txtAmount;
	
	@FindBy(name="desc")
	WebElement txtDescription;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement btnSubmit;
	
	
	public DepositPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public TransactionDetailPage makeDeposit(String accountNo, String amount, String description) throws NumberFormatException, IOException {
		enterTextOnElement(txtAccountNo, accountNo);
		enterTextOnElement(txtAmount, amount);
		enterTextOnElement(txtDescription, description);
		clickOnElement(btnSubmit);
		return new TransactionDetailPage(driver);
	}
	
}
