package com.splitwise.model.expense;

import java.util.Date;

import com.splitwise.model.User;

public class PercentExpense extends Expense {

	public PercentExpense(String name, Date date, User addedBy, User paidBy, double totalAmount) {
		super(name, date, addedBy, paidBy, totalAmount);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void updateBalance() {
		// TODO Auto-generated method stub
		
	}

}
