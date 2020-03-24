package com.splitwise.model.split;

import com.splitwise.model.User;

public class SplitFactory {
	
	public static split getSplit(User user,String type) {
		switch(type) {
		case "EQUAL":
			return new EqualSplit(user);
		case "EXACT":
			return new ExactAmountSplit(user);
		case "PERCENT":
			return new PercentSplit(user);
		}
		return null;
	}
}
