//Sean Hinkle, Programming Assignment 3, Dr. Hollander

public class SavingsAccountTest {
	public static void main (String[] args) {
		//Initializing two savings account objects with different balances
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		
		SavingsAccount.modifyInterestRate(.04);
		System.out.printf("Interest at 4%%%n%n");
		
		//Prints out each savers values for 12 months
		System.out.printf("Saver 1: %n%n");
		for (int i = 1; i <= 12; i++) {
			saver1.calculateMonthlyInterest();
			System.out.printf("Month %-25d$%.02f%n", i, saver1.getSavingsBalance());	
		}
		
		System.out.printf("%nSaver 2: %n");
		for (int i = 1; i <= 12; i++) {
			saver2.calculateMonthlyInterest();
			System.out.printf("Month %-25d$%.02f%n", i, saver2.getSavingsBalance());
		}
		
		//Modifies interest rate to 5% and then prints out a new month for each saver
		SavingsAccount.modifyInterestRate(.05);
		System.out.printf("%nNew interest rate of 5%% set: %n%n");
		
		saver1.calculateMonthlyInterest();
		System.out.printf("Saver 1 extra Month %-25s$%.02f%n", "", saver1.getSavingsBalance());
		
		saver2.calculateMonthlyInterest();
		System.out.printf("Saver 2 extra Month %-25s$%.02f%n", "", saver2.getSavingsBalance());
	}
}
