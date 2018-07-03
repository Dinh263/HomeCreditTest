package com.banking.automation.libs;

public class Transaction {
	
	
	String transactionId;
	String accountNo;
	String amoutCredit;
	String typeOfTransaction;
	String discription;
	String currentbalance;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAmoutCredit() {
		return amoutCredit;
	}
	public void setAmoutCredit(String amoutCredit) {
		this.amoutCredit = amoutCredit;
	}
	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}
	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(String currentbalance) {
		this.currentbalance = currentbalance;
	}
	public Transaction() {
		
	}
	public Transaction(String transactionId, String accountNo, String amoutCredit, String typeOfTransaction,
			String discription, String currentbalance) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.amoutCredit = amoutCredit;
		this.typeOfTransaction = typeOfTransaction;
		this.discription = discription;
		this.currentbalance = currentbalance;
	}
}
