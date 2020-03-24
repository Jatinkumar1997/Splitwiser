package com.splitwise.model.split;

import com.splitwise.model.*;

public abstract class split {
	
	private User user;
	private double balance;
	private String note;
	private long uId;
	
	private static long NEW_UID = 0;
	
	
	public split(User user) {
		setUser(user);
		setuId();
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public long getuId() {
		return uId;
	}
	public void setuId() {
		this.uId = ++NEW_UID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
