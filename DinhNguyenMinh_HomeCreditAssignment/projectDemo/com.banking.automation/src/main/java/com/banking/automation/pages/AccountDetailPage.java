package com.banking.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.banking.automation.libs.Account;
import com.banking.automation.libs.Customer;

public class AccountDetailPage extends Dashboard {

	@FindBy(xpath = "//td[text()='Account ID']/../td[2]")
	WebElement lbelAccountId;
	
	@FindBy(xpath = "//td[text()='Customer ID']/../td[2]")
	WebElement lbelCustomerId;

	@FindBy(xpath = "//td[text()='Customer Name']/../td[2]")
	WebElement lbelCustomerName;
	
	@FindBy(xpath = "//td[text()='Email']/../td[2]")
	WebElement lbelEmail;
	
	@FindBy(xpath = "//td[text()='Account Type']/../td[2]")
	WebElement lbelAccountType;
	
	@FindBy(xpath = "//td[text()='Date of Opening']/../td[2]")
	WebElement lbelDateOfOpening;
	
	@FindBy(xpath = "//td[text()='Current Amount']/../td[2]")
	WebElement lbelCurrentAmount;
	
	public AccountDetailPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getAccountId() {
		return getTextOfElement(lbelAccountId);
	}
	
	public boolean checkAccountDetailCorrect(Customer cus, Account acc) {
		if(pageShouldContain("Account Generated Successfully!!!") 
				&& getTextOfElement(lbelCustomerId).equals(cus.getCustomerId())
				&& getTextOfElement(lbelCustomerName).equals(cus.getCustomerName())
				&& getTextOfElement(lbelEmail).equals(cus.getEmail()) 
				&& getTextOfElement(lbelAccountType).equals(acc.getAccountType())
				&& getTextOfElement(lbelDateOfOpening).equals(acc.getDateOfOpening())
				&& getTextOfElement(lbelCurrentAmount).equals(acc.getCurrentAmount())
				) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
