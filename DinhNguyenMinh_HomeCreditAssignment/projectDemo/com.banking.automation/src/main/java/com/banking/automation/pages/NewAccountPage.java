package com.banking.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.banking.automation.libs.DropDownListUtils;

public class NewAccountPage extends Dashboard {

	@FindBy(name="cusid")
	WebElement txtCustomerId;	
	
	@FindBy(name="selaccount")
	WebElement ddListAccountType;
	
	@FindBy(name="inideposit")
	WebElement txtInitialDeposite;
	
	@FindBy(xpath="//input[@value='submit']")
	WebElement btnSubmit;
	
	public NewAccountPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public AccountDetailPage createNewAccount(String customerId, String accountType, String deposit) throws NumberFormatException, IOException {
		enterTextOnElement(txtCustomerId, customerId);
		DropDownListUtils ddList = new DropDownListUtils(driver);
		ddList.selectUsingVisibleText(ddListAccountType, accountType);
		enterTextOnElement(txtInitialDeposite, deposit);
		clickOnElement(btnSubmit);
		return new AccountDetailPage(driver);
	}
	
	
	
	
	
}
