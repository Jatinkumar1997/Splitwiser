package com.splitwise.model.util;

public class Util {
	public static boolean isApproxEqual(double sum,double total) {
		if((long)sum*100 == (long)total*100) {
			return true;
		}
		return false;
	}
}
