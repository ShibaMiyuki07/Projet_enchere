package com.example.enchere.ModelClient;

public class Commission {
	private static int commission = 10;

	public static int getCommission() {
		return commission;
	}

	public static void setCommission(int commission) {
		Commission.commission = commission;
	}
	
}
