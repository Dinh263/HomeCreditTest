package com.banking.automation.libs;

public class Account {
	String accountId;
	String customerId;
	String accountType;
	String dateOfOpening;
	String currentAmount;
	
	public Account() {
		
	}
	
	public Account(String accountId, String customerId, String accountType, String dateOfOpening,
			String currentAmount) {
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountType = accountType;
		this.dateOfOpening = dateOfOpening;
		this.currentAmount = currentAmount;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getDateOfOpening() {
		return dateOfOpening;
	}
	public void setDateOfOpening(String dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}
	public String getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(String currentAmount) {
		this.currentAmount = currentAmount;
	}
}
