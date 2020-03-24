package com.splitwise.model;

import java.util.ArrayList;
import java.util.List;

import com.splitwise.model.expense.Expense;

public class User {
	private String name;
	private String emailId;
	private String phoneNo;
	private long userId;
	private double balance;
	private List<Expense> expenses;
	
	private static long uId = 0;
	
	public User(String name, String emailId, String phoneNo) {
		setName(name);
		setEmailId(emailId);
		setPhoneNo(phoneNo);
		setBalance(0);
		this.expenses = new ArrayList<>();
		this.userId = ++uId;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = getBalance()+balance;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}
	
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		// add validations
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		// add validations
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		// add validations
		this.phoneNo = phoneNo;
	}
	public long getUserId() {
		return userId;
	}
}
