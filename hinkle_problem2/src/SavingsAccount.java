//Sean Hinkle, Programming Assignment 3, Dr. Hollander

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	
	public SavingsAccount(double balance) {
		this.setSavingsBalance(balance);
	}
	
	public void setSavingsBalance(double balance) {
		if (balance > 0) {
			savingsBalance = balance;
		}
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	//Calculates monthly interest, then adds it to the savings balance
	public void calculateMonthlyInterest() {
		double monthlyInterest = new BigDecimal(savingsBalance).multiply(new BigDecimal(annualInterestRate)).divide(new BigDecimal(12), RoundingMode.HALF_UP).doubleValue();
		savingsBalance += monthlyInterest;
	}
	
	public static void modifyInterestRate(double rate) {
		if (rate > 0) {
			annualInterestRate = rate;
		}
	}
}
	
