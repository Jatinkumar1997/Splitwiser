package com.splitwise.model.expense;

import java.util.Date;

import com.splitwise.model.User;

public class ExpenseFactory {
	public static Expense getExpense(String name, Date date, User addedBy, User paidBy, double totalAmount,String type) {
		
		switch(type) {
		case "EQUAL": 
			return new EqualExpense(name,date,addedBy,paidBy,totalAmount);
		case "EXACT":
			return new ExactAmountExpense(name,date,addedBy,paidBy,totalAmount);
		case "PERCENT":
			return new PercentExpense(name,date,addedBy,paidBy,totalAmount);
		}
		
		return null;
			
	}
}
