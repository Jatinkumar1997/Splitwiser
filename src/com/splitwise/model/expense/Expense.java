package com.splitwise.model.expense;
import com.splitwise.model.User;
import com.splitwise.model.split.*;
import com.splitwise.model.util.Util;

import java.util.Date;
import java.util.List;

public abstract class Expense {
	
	private static long uId = 0;
	private long expenseId;
	private String name;
	private Date date;
	private User addedBy;
	private User paidBy;
	// Image
	// Location
	private enum category{
		trip,
		grocery;
	}
	private double totalAmount;
	
	private List<split> splits;
	
	
	public boolean validateExpense() {
		// Common Logic : Sum of all amounts should be equal to total Amount
		double sum = 0;
		for(split s:splits) {
			sum += s.getBalance();
		}
		if(Util.isApproxEqual(sum,this.getTotalAmount()))  // todo : 
		{
			return true;
		}
		return false;
	}
	//After adding/removing splits we will have to recalculate the amount of each split.
	//the amount would depend on what type of split is it
	public abstract void updateBalance();
	
	public Expense(String name, Date date, User addedBy, User paidBy, double totalAmount) {
		// todo => Use Builder Pattern here
		this.expenseId = ++uId;
		this.name = name;
		this.date = date;
		this.addedBy = addedBy;
		this.paidBy = paidBy;
		this.totalAmount = totalAmount;
	}
	
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<split> getSplits() {
		return splits;
	}
	public void setSplits(List<split> splits) {
		this.splits = splits;
		// validate the split
	}
	public void removeSplit(split s) {
		splits.remove(s);
		updateBalance();
	}
	public long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}
	public User getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	};
	
	
}
