package com.splitwise.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.splitwise.exceptions.UserNotFoundException;
import com.splitwise.model.expense.Expense;
import com.splitwise.model.expense.ExpenseFactory;
import com.splitwise.model.split.SplitFactory;
import com.splitwise.model.split.split;

public class BookKeaper {
	
	private Map<Long,User> users;
	private Map<Long,Expense> expenses;
	
	private static BookKeaper INSTANCE;
	
	private BookKeaper() {
		this.users = new HashMap<>();
		this.expenses = new HashMap<>();
	}
	
	public static BookKeaper getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new BookKeaper();
		}
		return INSTANCE;
	}
	
	//AddExpense
	public void addExpense(String name,Date date,User addedBy,User paidBy,double totalAmount,String type,List<User> users) throws UserNotFoundException {
		if(!this.users.containsKey(addedBy.getUserId()) && !this.users.containsKey(paidBy.getUserId())) {
			throw new UserNotFoundException("User not found!");
		}
		List<split> splits = new ArrayList<>();
		for(User user:users) {
			if(!this.users.containsKey(user.getUserId())) {
				throw new UserNotFoundException("User with id: "+user.getUserId() +" Not found.");
			}
			splits.add(SplitFactory.getSplit(user, type));
		}
		Expense e =  ExpenseFactory.getExpense(name, date, addedBy, paidBy, totalAmount, type);
		e.updateBalance();
		for(User user:users) {
			user.getExpenses().add(e);
		}
		expenses.put(e.getExpenseId(), e);
	}
	//AddUser
	public void addUser(String name, String emailId, String phoneNo) {
		User u = new User(name,emailId,phoneNo);
		users.put(u.getUserId(), u);
	}
	//GetUser
	public User getUser(long id) throws UserNotFoundException {
		if(!users.containsKey(id)) {
			throw new UserNotFoundException("User with id: " + id + " Not Found");
		}
		return users.get(id);
	}
	//ShowBalances
	public Map<User,Double> showBalances(){
		Map<User,Double> balanceMap = new HashMap<>();
		for(Map.Entry<Long,User> user:this.users.entrySet()) {
			balanceMap.put(user.getValue(),user.getValue().getBalance());
		}
		return balanceMap;
	}
	//ShowBalance(User)
	public double showBalance(User u) throws UserNotFoundException {
		if(!this.users.containsKey(u.getUserId())) {
			throw new UserNotFoundException("Could not find the given User with id: "+u.getUserId());
		}
		return u.getBalance();
	}
	//SimplifyExpense
}
