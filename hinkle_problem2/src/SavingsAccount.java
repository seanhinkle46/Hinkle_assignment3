import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount {
	static double annualInterestRate;
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
	public void calculateMonthlyInterest() {
		double monthlyInterest = new BigDecimal(savingsBalance).multiply(new BigDecimal(annualInterestRate)).divide(new BigDecimal(12), RoundingMode.HALF_UP).doubleValue();
		savingsBalance += monthlyInterest;
	}
	
	public static void modifyInterestRate(double rate) {
		if (rate > 0) {
			annualInterestRate = rate;
		}
	}
	
//	public String displayBalance() {
//		return this.savingsBalance();
//	}
	
}
	
