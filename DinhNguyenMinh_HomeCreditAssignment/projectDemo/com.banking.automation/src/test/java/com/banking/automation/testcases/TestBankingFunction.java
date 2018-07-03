package com.banking.automation.testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.banking.automation.base.TestBase;
import com.banking.automation.enviroment.EnviromentUtils;
import com.banking.automation.libs.Account;
import com.banking.automation.libs.Customer;
import com.banking.automation.libs.ExcelUtils;
import com.banking.automation.libs.Transaction;
import com.banking.automation.libs.TransactionType;
import com.banking.automation.pages.NewCustomerPage;
import com.banking.automation.pages.TransactionDetailPage;
import com.banking.automation.pages.AccountDetailPage;
import com.banking.automation.pages.CustomerProfilePage;
import com.banking.automation.pages.DepositPage;
import com.banking.automation.pages.NewAccountPage;

public class TestBankingFunction extends TestBase {
	
	ExcelUtils excel;
	Customer customer;
	Account account;
	Transaction transaction;
	
	NewCustomerPage addNewCustomerObj;
	NewAccountPage addNewAccountObj;
	DepositPage depositObj;
	
	CustomerProfilePage customerprofileObj;
	AccountDetailPage accountdetaiObj;
	TransactionDetailPage transactiondetailObj;
	
	String amountDeposit ="";
	String description = "";
	
	
	@Test(priority=0)
	public void createNewCustomer() throws IOException {
		initiateDataForCreateNewCustomer();
		addNewCustomerObj = dbObj.selectMenuNewCustomer();
		customerprofileObj = addNewCustomerObj.createNewCustomer(customer.getCustomerName(), customer.getGender(), customer.getDateOfBirth(), customer.getAddress(), customer.getCity(), customer.getState(), customer.getPin(), customer.getMobile(), customer.getEmail(), customer.getPassword());
		customer.setCustomerId(customerprofileObj.getCustomerID());
		Assert.assertTrue(customerprofileObj.checkCustomerProfileIsCorrect(customer));
	}
	
	@Test(priority=1)
	public void createNewAccount() throws NumberFormatException, IOException {
		addNewAccountObj = customerprofileObj.selectMenuNewAccount();
		initiateDataForCreateNewAccount();
		accountdetaiObj = addNewAccountObj.createNewAccount(customer.getCustomerId(), account.getAccountType(), account.getCurrentAmount());
		account.setAccountId(accountdetaiObj.getAccountId());
		Assert.assertTrue(accountdetaiObj.checkAccountDetailCorrect(customer, account));
	}
	
	@Test(priority=2)
	public void deposit() throws NumberFormatException, IOException {
		initiateDataForDeposit();
		depositObj = accountdetaiObj.selectMenuDeposit();
		transactiondetailObj = depositObj.makeDeposit(account.getAccountId(), amountDeposit, description);
		int amountBefore = Integer.parseInt(account.getCurrentAmount());
		int amountIncrease = Integer.parseInt(amountDeposit);
		int amountTotal = amountBefore + amountIncrease;
		Assert.assertTrue(transactiondetailObj.checkTransactionCorrect(account.getAccountId(),amountDeposit,TransactionType.DEPOSIT,description,String.valueOf(amountTotal)));
	}
	
	
	
	private void initiateDataForCreateNewCustomer() throws IOException {
		excel = new ExcelUtils(EnviromentUtils.getTestResourcePath() + "/data.xlsx" , "CreateNewCustomer");
		customer = new Customer();
		customer.setCustomerName(excel.getValueAt("Customer_Name", 1));
		customer.setGender(excel.getValueAt("Gender", 1));
		customer.setDateOfBirth(excel.getValueAt("Date_of_Birth", 1));
		customer.setAddress(excel.getValueAt("Address", 1));
		customer.setCity(excel.getValueAt("City", 1));
		customer.setState(excel.getValueAt("State", 1));
		customer.setPin(excel.getValueAt("PIN", 1));
		customer.setMobile(excel.getValueAt("Mobile_Number", 1));
		long temp = System.currentTimeMillis() / 1000L;
		customer.setEmail("user"+ temp +"@gmail.com" );
		customer.setPassword(excel.getValueAt("Password", 1));
	}
	
	private void initiateDataForCreateNewAccount() throws IOException {
		excel = new ExcelUtils(EnviromentUtils.getTestResourcePath() + "/data.xlsx" , "CreateNewAccount");
		account = new Account();
		account.setCustomerId(customer.getCustomerId());
		account.setAccountType(excel.getValueAt("Account_Type", 1));
		account.setCurrentAmount(excel.getValueAt("Initial_Deposit", 1));
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		account.setDateOfOpening(formatter.format(calendar.getTime()));
	}
	
	private void initiateDataForDeposit() throws IOException {
		excel = new ExcelUtils(EnviromentUtils.getTestResourcePath() + "/data.xlsx" , "Deposit");
		amountDeposit = excel.getValueAt("Amount", 1);
		description = excel.getValueAt("Description", 1);
		
	}
	
	
	
	
	
	
	
	
}
