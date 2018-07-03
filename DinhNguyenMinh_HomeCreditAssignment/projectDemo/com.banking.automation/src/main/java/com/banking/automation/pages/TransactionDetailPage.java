package com.banking.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransactionDetailPage extends Dashboard {
	
	@FindBy(xpath = "//td[text()='Transaction ID']/../td[2]")
	WebElement lbelTransactionId;
	
	@FindBy(xpath = "//td[text()='Account No']/../td[2]")
	WebElement lbelAccountNo;	

	@FindBy(xpath = "//td[text()='Amount Credited']/../td[2]")
	WebElement lbelAmountCredited;
	
	@FindBy(xpath = "//td[text()='Type of Transaction']/../td[2]")
	WebElement lbelTransactionType;
	
	@FindBy(xpath = "//td[text()='Description']/../td[2]")
	WebElement lbelDescription;
	
	@FindBy(xpath = "//td[text()='Current Balance']/../td[2]")
	WebElement lbelCurrentBalance;
	
	public TransactionDetailPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean checkTransactionCorrect(String accountNo, String amountcredit, String transactionType, String description, String currentBalance) {
		if(pageShouldContain("Transaction details of Deposit for Account "+accountNo)
				&& getTextOfElement(lbelAccountNo).equals(accountNo)
				&& getTextOfElement(lbelAmountCredited).equals(amountcredit)
				&& getTextOfElement(lbelTransactionType).equals(transactionType)
				&& getTextOfElement(lbelDescription).equals(description)
				&& getTextOfElement(lbelCurrentBalance).equals(currentBalance)		
				) {
			return true;
		}
		else {
			return false;
		}
	}

}
