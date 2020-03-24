package com.splitwise.model.expense;

import java.util.Date;
import java.util.List;

import com.splitwise.model.User;
import com.splitwise.model.split.split;

public class EqualExpense extends Expense {

	public EqualExpense(String name, Date date, User addedBy, User paidBy, double totalAmount) {
		super(name, date, addedBy, paidBy, totalAmount);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean validateExpense() {
		if(super.validateExpense()) {
			return true;
		}
		return false;
	}
	@Override
	public void updateBalance() {
		// TODO Auto-generated method stub
		List<split> splits = getSplits();
		int size = splits.size();
		for(split s : splits) {
			s.setBalance(getTotalAmount()/size);
			s.getUser().setBalance(getTotalAmount()/size);
		}
	}

}
