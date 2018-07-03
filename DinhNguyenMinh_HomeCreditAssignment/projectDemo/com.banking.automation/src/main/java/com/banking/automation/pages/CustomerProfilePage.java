package com.banking.automation.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.banking.automation.libs.Customer;

public class CustomerProfilePage extends Dashboard {

	@FindBy(xpath = "//td[text()='Customer ID']/../td[2]")
	WebElement lbelCustomerId;
	
	String table = "//table[@id='customer']/tbody/tr[";
	String columnNumber = "]/td[2]";
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[5]/td[2]")
	WebElement lbelCustomerName;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[6]/td[2]")
	WebElement lbelGender;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[7]/td[2]")
	WebElement lbelBirthDate;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[8]/td[2]")
	WebElement lbelAddress;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[9]/td[2]")
	WebElement lbelCity;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[10]/td[2]")
	WebElement lbelState;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[11]/td[2]")
	WebElement lbelPin;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[12]/td[2]")
	WebElement lbelMobile;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[13]/td[2]")
	WebElement lbelEmail;
	
	public CustomerProfilePage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getCustomerID() {
		return getTextOfElement(lbelCustomerId);
	}
	
	public boolean checkCustomerProfileIsCorrect(Customer cus) {
		String temp = cus.getDateOfBirth();
		String dob = temp.substring(4)+"-"+temp.substring(0,2)+"-"+temp.substring(2,4);
		if(pageShouldContain("Customer Registered Successfully!!!") 
				&& getTextOfElement(lbelCustomerName).equals(cus.getCustomerName())  
				&& getTextOfElement(lbelGender).equalsIgnoreCase(cus.getGender())
				&& getTextOfElement(lbelBirthDate).equals(dob) 
				&& getTextOfElement(lbelAddress).equals(cus.getAddress())
				&& getTextOfElement(lbelCity).equals(cus.getCity()) 
				&& getTextOfElement(lbelState).equals(cus.getState())
				&& getTextOfElement(lbelPin).equals(cus.getPin()) 
				&& getTextOfElement(lbelMobile).equals(cus.getMobile())
				&& getTextOfElement(lbelEmail).equals(cus.getEmail())) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	
}
