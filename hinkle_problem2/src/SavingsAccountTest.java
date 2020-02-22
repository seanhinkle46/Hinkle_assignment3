
public class SavingsAccountTest {
	public static void main (String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		
		SavingsAccount.modifyInterestRate(.04);
		
		System.out.println("Saver 1: ");
		for (int i = 1; i <= 12; i++) {
			saver1.calculateMonthlyInterest();
			System.out.printf("Month %-40d$%.02f%n", i, saver1.getSavingsBalance());
		}
		
		System.out.println("Saver 2: ");
		for (int i = 1; i <= 12; i++) {
			saver2.calculateMonthlyInterest();
			System.out.printf("Month %-40d$%.02f%n", i, saver2.getSavingsBalance());
		}
		
		SavingsAccount.modifyInterestRate(.05);
		saver1.calculateMonthlyInterest();
		System.out.printf("Saver 1 extra Month %-40s$%.02f%n", "", saver1.getSavingsBalance());
		
		saver2.calculateMonthlyInterest();
		System.out.printf("Saver 2 extra Month %-40s$%.02f%n", "", saver2.getSavingsBalance());
	}
}
