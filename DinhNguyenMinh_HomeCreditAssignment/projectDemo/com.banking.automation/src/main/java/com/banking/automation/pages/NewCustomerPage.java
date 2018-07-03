package com.banking.automation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends Dashboard {
	
	@FindBy(name="name")
	WebElement txtCustomeName;

	@FindBy(xpath="//input[@value='m']")
	WebElement ckboxMale;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement ckboxFeMale;
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement txtDoB;
	
	@FindBy(name = "addr")
	WebElement txtAddr;

	@FindBy(name = "city")
	WebElement txtCity;
	
	@FindBy(name = "state")
	WebElement txtState;
	
	@FindBy(name = "pinno")
	WebElement txtPin;
	
	@FindBy(name = "telephoneno")
	WebElement txtTelephone;
	
	@FindBy(name = "emailid")
	WebElement txtEmail;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement btnSubmit;
	
	public NewCustomerPage(WebDriver driver) throws NumberFormatException, IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CustomerProfilePage createNewCustomer(String name, String gender, String dateOfBirth, String address, String city, String state, String pinNo, String telephone, String email, String password) throws NumberFormatException, IOException {
		enterTextOnElement(txtCustomeName, name);
		if(gender.equals("Male")) {
			clickOnElement(ckboxMale);
		}else {
			clickOnElement(ckboxFeMale);
		}
		enterTextOnElement(txtDoB, dateOfBirth);
		enterTextOnElement(txtAddr, address);
		enterTextOnElement(txtCity, city);
		enterTextOnElement(txtState, state);
		enterTextOnElement(txtPin, pinNo);
		enterTextOnElement(txtTelephone, telephone);
		enterTextOnElement(txtEmail, email);
		enterTextOnElement(txtPassword, password);
		clickOnElement(btnSubmit);
		return new CustomerProfilePage(driver);
	}
	
	

}
