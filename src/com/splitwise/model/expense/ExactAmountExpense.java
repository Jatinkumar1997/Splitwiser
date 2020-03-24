package com.splitwise.model.expense;

import java.util.Date;

import com.splitwise.model.User;

public class ExactAmountExpense extends Expense {

	public ExactAmountExpense(String name, Date date, User addedBy, User paidBy, double totalAmount) {
		super(name, date, addedBy, paidBy, totalAmount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateBalance() {
		// TODO Auto-generated method stub

	}

}
